package com.buildlog;

import com.buildlog.domain.Project;
import com.buildlog.domain.ProjectType;
import com.buildlog.domain.Status;
import com.buildlog.domain.Visibility;

import java.time.YearMonth;
import java.util.List;
import java.util.UUID;

public class Main {
    static void main(String[] args) {
        Project project_1 = new Project(
                UUID.randomUUID(),
                "Rhodes Run",
                "Rhodes Run",
                "Developer and Designer",
                ProjectType.WEBSITE,
                Status.LIVE,
                Visibility.PUBLIC,
                YearMonth.of(2026, 9),
                YearMonth.of(2026, 9),
                "https://rhodesrun.co.za/",
                List.of("WordPress", "Elementor", "Astra", "HTML", "JavaScript"),
                "Rhodes run, is a site for breathtaking trail run, is staged in the tranquil beauty of the southern Drakensberg mountains in the Eastern Cape Highlands, surrounding the Victorian era village of Rhodes.",
                "Client was very delighted with the website and left a very good review on google",
                "The design and development process was good.",
                "Adding more colour to the site"
        );

        Project project_2 = new Project(
                UUID.randomUUID(),
                "SOMA",
                "SOMA",
                "Developer",
                ProjectType.WEBSITE,
                Status.LIVE,
                Visibility.PUBLIC,
                YearMonth.of(2026, 4),
                YearMonth.of(2026, 10),
                "https://somafranschhoek.com/",
                List.of("WordPress", "Elementor", "Astra", "HTML", "JavaScript"),
                "SOMA exists to redefine luxury hospitality for those who seek a slower, richer way of living — where restored energy, quieted minds and the luxury of time are not an indulgence, but a new rhythm of life.",
                "Client was very delighted with the website and left a very good review on google",
                "I really enjoyed developing the site, it was very interesting to work with a designer and have constant feedback about my work",
                "Pay more attention to the little details"
        );

        Project project_3 = new Project(
                UUID.randomUUID(),
                "Social Blossom",
                "Social Blossom",
                "Developer",
                ProjectType.WEBSITE,
                Status.LIVE,
                Visibility.PUBLIC,
                YearMonth.of(2026, 4),
                YearMonth.of(2026, 4),
                "https://socialblossom.co.za/",
                List.of("WordPress", "Elementor", "Astra", "HTML", "JavaScript"),
                "Social Blossom is a small, sharp studio building bold identities, beautiful websites and social content that actually gets noticed.",
                "Client was very delighted with the website",
                "The design was really good as the client didn't have too much requested changes when presented",
                "The use of black, could've gone with a more opacity low version of black"
        );

        System.out.println(project_1);
        System.out.println(project_2);
        System.out.println(project_3);
    }
}
