package com.microapp.authmicroservice.security;

import com.microapp.authmicroservice.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static User getLoggedInUser() {
        return getValidUserFromPrincipal();
    }

    private static User getValidUserFromPrincipal() {
        Object principal = SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        if (principal.equals("anonymousUser")) {
            throw new SecurityException("You are not logged in");
        }
        return (User) principal;
    }
}
