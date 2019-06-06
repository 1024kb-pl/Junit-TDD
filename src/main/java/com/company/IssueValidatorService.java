package com.company;

import org.apache.commons.validator.routines.EmailValidator;

import java.time.LocalDate;

public class IssueValidatorService {
    void validateIssue(Issue issue) {
        if (titleIsEmpty(issue)) {
            throw new IssueValidatorException("Issue's title can't be empty.");
        }

        if (createDateIsNotToday(issue)) {
            throw new IssueValidatorException("Create date should today's date.");
        }

        if (issueTypeIsNotAssign(issue)) {
            throw new IssueValidatorException("Issue type is not assign.");

        }

        if (isIncorrectEmailFormat(issue)) {
            throw new IssueValidatorException("Incorrect email format.");
        }
    }

    private boolean isIncorrectEmailFormat(Issue issue) {
        return !EmailValidator.getInstance().isValid(issue.getReporterEmail());
    }

    private boolean issueTypeIsNotAssign(Issue issue) {
        return issue.getType() == null;
}

    private boolean createDateIsNotToday(Issue issue) {
        return !LocalDate.from(issue.getCreateDate()).isEqual(LocalDate.now());
    }

    private boolean titleIsEmpty(Issue issue) {
        return issue.getTitle().isEmpty();
    }
}
