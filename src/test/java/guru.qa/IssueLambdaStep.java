package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class IssueLambdaStep {
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static String NAME = "69 nice";

    @Test

    public void IssueGitHub() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем раздел Issues", () -> {
            $(partialLinkText("Issues")).click();
        });

        step("Проверяем наличие Issue " + NAME, () -> {
            $(byText(NAME)).should(Condition.visible);
        });
    }
}
