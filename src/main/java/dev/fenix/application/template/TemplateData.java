package dev.fenix.application.template;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

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

    public Boolean isAllow(){

        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        System.out.println(authorities);
        return true;

    }



}
