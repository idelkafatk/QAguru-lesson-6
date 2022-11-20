package io.github.qaguru.allure;

import com.codeborne.selenide.WebDriverRunner;
import io.github.qaguru.allure.steps.WebSteps;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AttachmentTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";

    private final WebSteps steps = new WebSteps();

    @Test
    public void testLambda() {
        AllureLifecycle lifecycle = Allure.getLifecycle();

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
            lifecycle.addAttachment("Screenshot", "image/png", "png", getScreenshot());
        });
    }

    @Test
    public void testAnnotated() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.takeScreenshot();
    }

    private byte[] getScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}