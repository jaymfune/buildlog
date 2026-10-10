package com.buildlog.domain;

import java.time.YearMonth;
import java.util.List;
import java.util.UUID;

public record Project(
        UUID id,
        String title,
        String client,
        String role,
        ProjectType type,
        Status status,
        Visibility visibility,
        YearMonth start,
        YearMonth end,
        String url,
        List<String> stack,
        String summary,
        String outcome,
        String whatWentWell,
        String wouldChange) {

}
