package com.buildlog.domain;

import java.time.YearMonth;
import java.util.Objects;

public record DateRange(YearMonth start, YearMonth end)  {
    public DateRange {
        // Reject missing start
        Objects.requireNonNull(start, "Start date is null");

        // end may be null (ongoing project), so only compare when it exists
        if (end != null && end.isBefore(start)) {
            throw new IllegalArgumentException("End date cannot be before start date");
        }
    }

    // Check if a project is ongoing
    public boolean isOngoing() {
        return end == null;
    }
}
