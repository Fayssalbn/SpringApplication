package dev.fenix.application.resume;

import dev.fenix.application.resume.model.Resume;
import dev.fenix.application.resume.repository.ResumeRepository;
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
@RequestMapping("/resume")
public class ResumeController {


    @Autowired
    private ResumeRepository resumeRepository;

    @GetMapping("/index")
    public String showResumeList(@PageableDefault(size = 50) Pageable pageable, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        Page<Resume> page = resumeRepository.findAll(pageable);
        model.addAttribute("page", page);
        //model.addAttribute("resumes", resumeRepository.findAll());
        return "resume/resume/index";
    }

    // add user
    @GetMapping("/add")
    public String showAddForm(Resume resume, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        return "resume/resume/add-resume";
    }

    @PostMapping("/addresume")
    public String addResume(@Valid Resume resume, BindingResult result, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);

        if (result.hasErrors()) {
            return "resume/resume/add-resume";
        }

        resumeRepository.save(resume);
        return "redirect:/resume/resume/index";
    }


    // edit user
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        Resume resume = resumeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid resume Id:" + id));
        model.addAttribute("resume", resume);
        return "resume/resume/update-resume";
    }


    @PostMapping("/update/{id}")
    public String updateResume(@PathVariable("id") Long id, @Valid Resume resume, BindingResult result, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        if (result.hasErrors()) {
            resume.setId(id);

            return "resume/resume/update-resume";
        }

        resumeRepository.save(resume);
        return "redirect:/resume/resume/index";
    }


    /// delete
    @GetMapping("/delete/{id}")
    public String deleteResume(@PathVariable("id") Long id, Model model) {
        Resume resume = resumeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        resumeRepository.delete(resume);
        return "redirect:resume/resume/index";
    }


}





