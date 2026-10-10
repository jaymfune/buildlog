package com.buildlog.domain;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public record Project(
        UUID id,
        String title,
        String client,
        String role,
        ProjectType type,
        Status status,
        Visibility visibility,
        DateRange period,
        String url,
        List<String> stack,
        String summary,
        String outcome,
        String whatWentWell,
        String wouldChange) {

    public Project {
        // Required fields: reject null with a clear message
        Objects.requireNonNull(id, "id is null");
        Objects.requireNonNull(type, "type is null");
        Objects.requireNonNull(status, "status is null");
        Objects.requireNonNull(visibility, "visibility is null");
        Objects.requireNonNull(period, "period is null");

        // Title: null check first, then blank check
        Objects.requireNonNull(title, "title is null");
        if (title.isBlank()) {
            throw new IllegalArgumentException("title is blank");
        }

        // Defensive copy: null becomes an empty list, otherwise an unmodifiable copy
        stack = (stack == null) ? List.of() : List.copyOf(stack);
    }
}