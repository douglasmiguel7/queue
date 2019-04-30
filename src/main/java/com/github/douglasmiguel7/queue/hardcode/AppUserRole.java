package com.github.douglasmiguel7.queue.hardcode;

public enum AppUserRole {

    CUSTOMER("ROLE_CUSTOMER"),
    ADMIN("ROLE_ADMIN"),
    EMPLOYEE("ROLE_EMPLOYEE");

    private final String name;

    AppUserRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
