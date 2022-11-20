package io.github.qaguru.allure;

import io.github.qaguru.allure.steps.WebSteps;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE_NUMBER = 68;

    private final WebSteps steps = new WebSteps();

    @Test
    public void testGithub() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }

    @Test
    public void testGithub2() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.shouldNotSeeIssueWithNumber(ISSUE_NUMBER);
    }
}