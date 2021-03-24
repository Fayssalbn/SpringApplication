package dev.fenix.application.business;


import dev.fenix.application.business.module.Staff;
import dev.fenix.application.business.repository.StaffRepository;
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
@RequestMapping("business/staff")
public class StaffController {


    @Autowired
    private StaffRepository staffRepository;

    @GetMapping("/index")
    public String showStaffList(@PageableDefault(size = 50) Pageable pageable, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        Page<Staff> page = staffRepository.findAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("count", staffRepository.count());

        //model.addAttribute("staffs", staffRepository.findAll());
        return "business/staff/index";
    }

    // add user
    @GetMapping("/add")
    public String showAddForm(Staff staff, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        return "staff/add-staff";
    }

    @PostMapping("/addstaff")
    public String addStaff(@Valid Staff staff, BindingResult result, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);

        if (result.hasErrors()) {
            return "staff/add-staff";
        }

        staffRepository.save(staff);
        return "redirect:staff/index";
    }


    // edit user
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        Staff staff = staffRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid staff Id:" + id));
        model.addAttribute("staff", staff);
        return "staff/update-staff";
    }


    @PostMapping("/update/{id}")
    public String updateStaff(@PathVariable("id") Long id, @Valid Staff staff, BindingResult result, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        if (result.hasErrors()) {
            staff.setId(id);

            return "staff/update-staff";
        }

        staffRepository.save(staff);
        return "redirect:/staff/index";
    }


    /// delete
    @GetMapping("/delete/{id}")
    public String deleteStaff(@PathVariable("id") Long id, Model model) {
        Staff staff = staffRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        staffRepository.delete(staff);
        return "redirect:staff/index";
    }


}





