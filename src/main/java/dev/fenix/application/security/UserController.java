package dev.fenix.application.security;

import dev.fenix.application.security.model.User;
import dev.fenix.application.security.repository.UserRepository;
import dev.fenix.application.template.TemplateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("security")
public class UserController {

    @Autowired
    private UserRepository userRepository;
      /// TODO
     //// LINK https://www.baeldung.com/spring-boot-crud-thymeleaf
    @GetMapping("/signup")
    public String showSignUpForm(User user ,Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        model.addAttribute("message","message" );
        return "security/add-user";
    }



    @GetMapping("/index")
    public String showUserList(Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        model.addAttribute("message","message" );
        model.addAttribute("users", userRepository.findAll());

        System.out.println(userRepository.findAll());
        return "security/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        model.addAttribute("message","message" );
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "security/update-user";
    }
    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        model.addAttribute("message","message" );
        if (result.hasErrors()) {
            return "security/add-user";
        }
        user.CryptPassword();
        userRepository.save(user);
        return "redirect:/security/index";
    }

    @PostMapping("/update/{id}")
    public String updateUser( @PathVariable("id") int id ,@Valid User user, BindingResult result, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        model.addAttribute("message","message" );
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }
        System.out.println(user.getUserpassword());
        user.CryptPassword();
        System.out.println(user.getPassword());
        userRepository.save(user);
        return "redirect:/security/index";
    }





    /* @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        userRepository.save(user);
        return "redirect:/security/index";
    }*/



 /*   @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        return "redirect:/index";
    }*/



   /* @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        return "redirect:/security/index";
    }*/
}
