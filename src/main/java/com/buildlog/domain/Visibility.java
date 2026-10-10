package com.buildlog.domain;

public enum Visibility {
    PRIVATE("Private"),
    UNLISTED("Unlisted"),
    PUBLIC("Public");

    private final String label;

    Visibility(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

    public String getLabel() {
        return label;
    }
}
