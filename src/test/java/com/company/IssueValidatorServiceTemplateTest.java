package com.company;

import org.junit.Test;

public class IssueValidatorServiceTemplateTest {
    private final IssueValidatorService issueValidatorService = new IssueValidatorService();

    @Test
    public void shouldPassValidation() {
    }

    @Test(expected = IssueValidatorException.class)
    public void shouldThrowExceptionWhenCreateDateIsDeprecated() {
    }


    @Test(expected = IssueValidatorException.class)
    public void shouldThrowExceptionWhenCreateDateIsTomorrow() {
    }

    @Test(expected = IssueValidatorException.class)
    public void shouldThrowExceptionWhenIssueTypeIsNotAssign() {
    }

    @Test(expected = IssueValidatorException.class)
    public void shouldThrowExceptionWhenEmailFormatIsIncorrect() {
    }
}
