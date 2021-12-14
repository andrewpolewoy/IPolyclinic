package com.it_academy.jd2.model.user.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    DOCTOR,
    PATIENT;

    @Override
    public String getAuthority() {
        return name();
    }
}