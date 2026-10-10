package com.buildlog.domain;

import org.junit.jupiter.api.Test;

import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.*;

class DateRangeTest {

    // An end date before the start date must be rejected
    @Test
    void endBeforeStartThrowsIllegalArgumentException() {
        YearMonth start = YearMonth.of(2026, 6);
        YearMonth end = YearMonth.of(2026, 3);   // earlier than start

        // assertThrows runs the code and fails the test if the expected exception is not thrown
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new DateRange(start, end)
        );

        // Check the message too, so the error explains the problem correctly
        assertEquals("End date cannot be before start date", e.getMessage());
    }

    // A null end date means the project is ongoing
    @Test
    void nullEndMeansOngoing() {
        DateRange range = new DateRange(YearMonth.of(2026, 3), null);

        assertTrue(range.isOngoing());
    }

    // A real end date means the project is finished, so isOngoing() is false
    @Test
    void endDateMeansNotOngoing() {
        DateRange range = new DateRange(YearMonth.of(2026, 3), YearMonth.of(2026, 6));

        assertFalse(range.isOngoing());
    }

    // Same start and end month is valid (for example Rhodes Run: September 2026 to September 2026)
    @Test
    void sameStartAndEndMonthIsAllowed() {
        YearMonth september = YearMonth.of(2026, 9);

        // assertDoesNotThrow fails the test if the constructor throws anything
        DateRange range = assertDoesNotThrow(() -> new DateRange(september, september));

        // The values should be stored exactly as given
        assertEquals(september, range.start());
        assertEquals(september, range.end());
        assertFalse(range.isOngoing());
    }

    // A null start date must be rejected
    @Test
    void nullStartThrowsNullPointerException() {
        assertThrows(
                NullPointerException.class,
                () -> new DateRange(null, YearMonth.of(2026, 6))
        );
    }
}