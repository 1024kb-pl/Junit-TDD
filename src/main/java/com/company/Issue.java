package com.company;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@ToString
public class Issue {
    private String title;
    private String description;
    private LocalDateTime createDate;
    private String reporterEmail;
    private IssueType type;
}
