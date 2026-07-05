package com.Livraria.livraria.objectvalue;

public enum RoleEnum {
    ADMIN("admin"),
    AUTHOR("author"),
    USER("user");

    private String role;

    RoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}
