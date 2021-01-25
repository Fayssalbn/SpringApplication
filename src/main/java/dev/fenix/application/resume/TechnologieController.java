/*
package dev.fenix.application.resume;

import dev.fenix.application.resume.model.Technologie;
import dev.fenix.application.resume.repository.TechnologieRepository;
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
@RequestMapping("/resume/technologie")
public class TechnologieController {


    @Autowired
    private TechnologieRepository technologieRepository;

    @GetMapping("/index")
    public String showTechnologieList(Model model) {

        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        model.addAttribute("technologies", technologieRepository.findAll());
        return "resume/technologie/index";
    }

    // add technologie
    @GetMapping("/add")
    public String showAddForm(Technologie technologie, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        return "resume/technologie/add-technologie";
    }

    @PostMapping("/addtechnologie")
    public String addTechnologie(@Valid Technologie technologie, BindingResult result, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        if (result.hasErrors()) {
            return "resume/technologie/add-technologie";
        }

        technologieRepository.save(technologie);
        return "redirect:/resume/technologie/index";
    }


    // edit technologie
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        Technologie technologie = technologieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid technologie Id:" + id));
        model.addAttribute("technologie", technologie);
        return "resume/technologie/update-technologie";
    }


    @PostMapping("/update/{id}")
    public String updateTechnologie(@PathVariable("id") int id, @Valid Technologie (technologie, BindingResult result, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        if (result.hasErrors()) {
            (technologie.setId(id);

            return "resume/technologie/update-technologie";
        }

        technologieRepository.save(technologie);
        return "redirect:/resume/technologie/index";
    }


    /// delete
    @GetMapping("/delete/{id}")
    public String deleteTechnologie(@PathVariable("id") int id, Model model) {
        Technologie technologie = technologieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid technologie Id:" + id));
        technologieRepository.delete(technologie);
        return "redirect:/resume/technologie/index";
    }


}





*/
