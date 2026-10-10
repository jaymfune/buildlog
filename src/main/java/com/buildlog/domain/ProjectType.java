package com.buildlog.domain;

public enum ProjectType {
    WEBSITE("Website"),
    WEB_APP("Web app"),
    MOBILE_APP("Mobile app"),
    COURSEWORK("Course work"),
    DESIGN("Design"),
    OTHER("Other");

    private final String label;

    ProjectType(String label) {
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
