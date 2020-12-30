package dev.fenix.application;

import dev.fenix.application.template.TemplateData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(   "/"   )
public class IndexController {
    @Value("${message}")
    private String message;


    @RequestMapping(value = { "/", "home" })
    public ModelAndView edit(@RequestParam(value = "id", required = false) Long id, Map<String, Object> model) {
        TemplateData data = new TemplateData();
        var mav = new ModelAndView();
        mav.addObject("message",message );
        mav.addObject("data",data );
        mav.setViewName("index/index");
        return mav;
    }

    @RequestMapping("admin")
    public ModelAndView admin(@RequestParam(value = "id", required = false) Long id, Map<String, Object> model) {
        var mav = new ModelAndView();
        mav.addObject("message",message );
        mav.setViewName("show");
        return mav;
    }

    @RequestMapping("user")
    public ModelAndView user(@RequestParam(value = "id", required = false) Long id, Map<String, Object> model) {
        var mav = new ModelAndView();
        mav.addObject("message ",message );
        mav.setViewName("show");
        return mav;
    }


}

    /*@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMessge = null;
        if(error != null) {
            errorMessge = "Username or Password is incorrect !!";
        }
        if(logout != null) {
            errorMessge = "You have been successfully logged out !!";
        }
        model.addAttribute("errorMessge", errorMessge);
        return "login";
    }*/




    /*@RequestMapping("{id}")
    public String getPerson(Model model, @PathVariable("id") String id) {
        Person p =  ps.getPerson(id);
        model.addAttribute("person", p);
        return "personview";
    }



    @RequestMapping("addformsave")
    public String getPerson(Model model,Person p) {
        System.out.println("Updated first name is "+p.getFirstName());
        System.out.println("Updated last name is "+p.getLastName());
        return "personview";
    }
*/





