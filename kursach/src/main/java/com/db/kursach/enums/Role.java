package com.db.kursach.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_DIRECTOR,
    ROLE_ADMINISTRATOR,
    ROLE_WAITER,
    ROLE_ACCOUNTANT;

    @Override
    public String getAuthority() {
        return name();
    }
}
