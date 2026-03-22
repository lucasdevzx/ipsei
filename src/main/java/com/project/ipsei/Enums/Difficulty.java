package com.project.ipsei.Enums;

import lombok.Getter;

@Getter
public enum Difficulty {

    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("Hard"),
    EXTREME("Extreme");

    private final String label;

    Difficulty(String label) {
        this.label = label;
    }

}