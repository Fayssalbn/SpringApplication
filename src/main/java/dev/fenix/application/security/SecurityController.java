package dev.fenix.application.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("security")
public class SecurityController {
    @Value("${message}")
    private String message;


        @RequestMapping("edit")
        public ModelAndView edit(@RequestParam(value = "id", required = false) Long id, Map<String, Object> model) {
            var mav = new ModelAndView();
            mav.addObject("message",message );
            mav.setViewName("show");
            return mav;
        }

}
