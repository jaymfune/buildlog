package com.buildlog.domain;

public enum Status {
    IN_PROGRESS("In progress"),
    LIVE("Live"),
    REDESIGNED("Redesigned"),
    OFFLINE("Offline"),
    ARCHIVED("Archived");

    private final String label;

    Status(String label) {
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
