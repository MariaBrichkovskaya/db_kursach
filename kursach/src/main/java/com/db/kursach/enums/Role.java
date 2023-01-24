package com.db.kursach.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_DIRECTOR,
    ROLE_MANAGER,
    ROLE_BARISTA,
    ROLE_WAITER,
    ROLE_ACCOUNTANT,
    ROLE_UPR,
    ROLE_CASHIER;

    @Override
    public String getAuthority() {
        return name();
    }
}
