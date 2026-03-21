package com.project.ipsei.Enums;

public enum Role {

    ADMIN_MASTER("Admin Master"),
    ADMIN_USER("Admin User"),
    ADMIN("Admin"),
    USER("User"),
    STUDENT("Student"), // Role
    PROFESSOR("Professor"),
    TEACHER("Teacher"),
    EMPLOYEE("Employee");

    private final String label;

    Role(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}