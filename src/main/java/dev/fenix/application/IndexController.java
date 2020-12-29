package dev.fenix.application;

import dev.fenix.application.Security.model.Person;
import dev.fenix.application.Security.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Hashtable;

@Controller
@RequestMapping("/persons")
public class IndexController {

    @Autowired
    PersonService ps;

    @RequestMapping("/all")
    @ResponseBody
    public Hashtable<String, Person> getAll() {
        return ps.getAll();
    }

    @RequestMapping("{id}")
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


    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }
}

