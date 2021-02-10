package dev.fenix.application.resume;

import dev.fenix.application.resume.model.Item;
import dev.fenix.application.resume.repository.ItemRepository;
import dev.fenix.application.template.TemplateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/resume/item")
public class ItemController {


    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/index")
    public String showItemList(@PageableDefault(size = 50) Pageable pageable, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        Page<Item> page = itemRepository.findAll(pageable);
        model.addAttribute("page", page);
        //model.addAttribute("items", itemRepository.findAll());
        return "resume/item/index";
    }

    // add user
    @GetMapping("/add")
    public String showAddForm(Item item, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        return "resume/item/add-item";
    }

    @PostMapping("/additem")
    public String addItem(@Valid Item item, BindingResult result, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);

        if (result.hasErrors()) {
            return "resume/item/add-item";
        }

        itemRepository.save(item);
        return "redirect:/resume/item/index";
    }


    // edit user
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + id));
        model.addAttribute("item", item);
        return "resume/item/update-item";
    }


    @PostMapping("/update/{id}")
    public String updateItem(@PathVariable("id") Long id, @Valid Item item, BindingResult result, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        if (result.hasErrors()) {
            item.setId(id);

            return "resume/item/update-item";
        }

        itemRepository.save(item);
        return "redirect:/resume/item/index";
    }


    /// delete
    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") Long id, Model model) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        itemRepository.delete(item);
        return "redirect:resume/item/index";
    }


}





