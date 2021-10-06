package guru.qa;

import org.junit.jupiter.api.Test;

public class IssueAnnotatedStep {
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static String NAME = "69 nice";
    WebSteps webSteps = new WebSteps();

    @Test

    public void IssueGitHubWithAnnotated() {
        webSteps.openMainPage();
        webSteps.searchForRepository(REPOSITORY);
        webSteps.goToRepository(REPOSITORY);
        webSteps.openIssueTab();
        webSteps.shouldSeeIssueWithNumber(NAME);
    }
}
