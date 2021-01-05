package dev.fenix.application.security;

import dev.fenix.application.security.model.User;
import dev.fenix.application.security.repository.UserRepository;
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
@RequestMapping("security")
public class UserController {

    @Autowired
    private UserRepository userRepository;

      @GetMapping("/index")
      public String showUserList(Model model) {

          TemplateData data = new TemplateData();
          model.addAttribute("data", data);
          model.addAttribute("users", userRepository.findAll());
          return "security/index";
      }

    // add user
    @GetMapping("/signup")
    public String showSignUpForm(User user ,Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        return "security/add-user";
    }
    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);

        if (result.hasErrors()) {
            return "security/add-user";
        }
        user.CryptPassword();
        userRepository.save(user);
        return "redirect:/security/index";
    }




    // edit user
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "security/update-user";
    }


    @PostMapping("/update/{id}")
    public String updateUser( @PathVariable("id") int id ,@Valid User user, BindingResult result, Model model) {
        TemplateData data = new TemplateData();
        model.addAttribute("data", data);
        if (result.hasErrors()) {
            user.setId(id);

            return "security/update-user";
        }
        user.CryptPassword();
        userRepository.save(user);
        return "redirect:/security/index";
    }


   /// delete
   @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        return "redirect:/security/index";
    }




}
