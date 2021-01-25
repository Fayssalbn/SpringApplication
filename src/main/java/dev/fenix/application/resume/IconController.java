package dev.fenix.application.resume;

import dev.fenix.application.resume.model.Icon;
import dev.fenix.application.resume.repository.IconRepository;
import dev.fenix.application.template.TemplateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping(   "/resume/icon"   )
public class IconController {


    @Autowired
    private IconRepository iconRepository;

    @GetMapping("/index")
    public String showIconList(Model model) {

        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        model.addAttribute("icons", iconRepository.findAll());
        System.out.println(iconRepository.findAll().size());
        return "resume/icon/index";
    }

    // add user
    @GetMapping("/add")
    public String showAddForm(Icon icon , Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        return "resume/icon/add-icon";
    }
    @PostMapping("/addicon")
    public String addIcon(@Valid Icon icon, BindingResult result, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);

        if (result.hasErrors()) {
            return "resume/icon/add-icon";
        }

        iconRepository.save(icon);
        return "redirect:/resume/icon/index";
    }




    // edit user
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        Icon icon = iconRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid icon Id:" + id));
        model.addAttribute("icon", icon);
        return "resume/icon/update-icon";
    }


    @PostMapping("/update/{id}")
    public String updateIcon( @PathVariable("id") int id ,@Valid Icon icon, BindingResult result, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        if (result.hasErrors()) {
            icon.setId(id);

            return "resume/icon/update-icon";
        }

        iconRepository.save(icon);
        return "redirect:/resume/icon/index";
    }


    /// delete
    @GetMapping("/delete/{id}")
    public String deleteIcon(@PathVariable("id") int id, Model model) {
        Icon icon = iconRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        iconRepository.delete(icon);
        return "redirect:resume/icon/index";
    }


}





