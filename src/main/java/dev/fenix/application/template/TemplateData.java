package dev.fenix.application.template;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class TemplateData {
    private Authentication auth ;

    public TemplateData() {
        this.auth = SecurityContextHolder.getContext().getAuthentication();
    }


    public Authentication getAuth() {
        return auth;
    }

    public String getAuthName() {

        return auth.getName();
    }
    public Boolean isAuth() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") return true;
        return false;
    }



}
