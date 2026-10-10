package com.buildlog.domain;

import org.junit.jupiter.api.Test;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    // ---------- Test fixture ----------
    // Builds a valid Project. Only title and stack are parameters because those are
    // the two values these tests change. Everything else gets a valid default.
    private Project projectWith(String title, List<String> stack) {
        return new Project(
                UUID.randomUUID(),                                          // id
                title,                                                      // title (varies per test)
                "Acme Ltd",                                                 // client
                "Developer",                                                // role
                ProjectType.WEBSITE,                                        // type
                Status.LIVE,                                                // status
                Visibility.PUBLIC,                                          // visibility
                new DateRange(YearMonth.of(2026, 3), YearMonth.of(2026, 6)), // period
                "https://example.com",                                      // url
                stack,                                                      // stack (varies per test)
                "Summary",                                                  // summary
                "Outcome",                                                  // outcome
                "Went well",                                                // whatWentWell
                "Would change"                                              // wouldChange
        );
    }

    // ---------- Tests ----------

    // 1. A blank title (only spaces) must be rejected
    @Test
    void blankTitleThrowsIllegalArgumentException() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> projectWith(" ", List.of("WordPress"))
        );
        assertEquals("title is blank", e.getMessage());
    }

    // 2. A null stack becomes an empty list
    @Test
    void nullStackBecomesEmptyList() {
        Project project = projectWith("Client Site", null);

        assertNotNull(project.stack());
        assertTrue(project.stack().isEmpty());
    }

    // 3. Changing the original list afterwards must not change the project's stack
    @Test
    void defensiveCopyIsNotAffectedByChangesToOriginalList() {
        List<String> original = new ArrayList<>(List.of("WordPress", "Elementor"));
        Project project = projectWith("Client Site", original);

        original.add("Sneaky");

        assertEquals(List.of("WordPress", "Elementor"), project.stack());
    }

    // 4. The project's stack cannot be modified from outside
    @Test
    void stackIsUnmodifiable() {
        Project project = projectWith("Client Site", List.of("WordPress"));

        assertThrows(
                UnsupportedOperationException.class,
                () -> project.stack().add("X")
        );
    }
}