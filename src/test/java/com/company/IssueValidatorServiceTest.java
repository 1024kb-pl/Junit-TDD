package com.company;

import org.junit.Test;

import java.time.LocalDateTime;

public class IssueValidatorServiceTest {
    private final IssueValidatorService issueValidatorService = new IssueValidatorService();

    @Test
    public void shouldPassValidation() {
        // given:
        Issue issue = Issue.builder()
                .createDate(LocalDateTime.now())
                .title("Brak możliwości zalogowania")
                .description("Nie moge się zalogować na użytkownika z loginem: pablo")
                .reporterEmail("pablo@mail.com")
                .type(IssueType.BUG)
                .build();


        // then:
        issueValidatorService.validateIssue(issue);
    }

    @Test(expected = IssueValidatorException.class)
    public void shouldThrowExceptionWhenCreateDateIsDeprecated() {
        // given:
        Issue issue = Issue.builder()
                .createDate(LocalDateTime.now().minusDays(1))
                .title("Nowy wykres")
                .reporterEmail("user@mail.com")
                .type(IssueType.FEATURE)
                .build();


        // then:
        issueValidatorService.validateIssue(issue);
    }


    @Test(expected = IssueValidatorException.class)
    public void shouldThrowExceptionWhenCreateDateIsTomorrow() {
        // given:
        Issue issue = Issue.builder()
                .createDate(LocalDateTime.now().plusDays(1))
                .title("Nowy wykres")
                .reporterEmail("user@mail.com")
                .type(IssueType.FEATURE)
                .build();


        // then:
        issueValidatorService.validateIssue(issue);
    }

    @Test(expected = IssueValidatorException.class)
    public void shouldThrowExceptionWhenIssueTypeIsNotAssign() {
        // given:
        Issue issue = Issue.builder()
                .createDate(LocalDateTime.now().plusDays(1))
                .title("Nie wiem czego chce")
                .reporterEmail("user@mail.com")
                .build();


        // then:
        issueValidatorService.validateIssue(issue);
    }

    @Test(expected = IssueValidatorException.class)
    public void shouldThrowExceptionWhenEmailFormatIsIncorrect() {
        // given:
        Issue issue = Issue.builder()
                .createDate(LocalDateTime.now().plusDays(1))
                .title("Zróbcie to")
                .reporterEmail("useratmail.com")
                .type(IssueType.TASK)
                .build();


        // then:
        issueValidatorService.validateIssue(issue);
    }
}
