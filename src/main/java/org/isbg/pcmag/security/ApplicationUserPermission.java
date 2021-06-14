package org.isbg.pcmag.security;

public enum ApplicationUserPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    PARTS_READ("parts:read"),
    PARTS_WRITE("parts:write"),
    PERIPHERALS_READ("peripherals:read"),
    PERIPHERALS_WRITE("peripherals:write"),
    PCS_READ("pcs:read"),
    PCS_WRITE("pcs:write");

    private final String permission;

    ApplicationUserPermission(String permission){
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
