package io.github.qaguru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {
    @Test
    void testGit() {
        open("https://github.com/"); //open Git

        $("[data-test-selector=nav-search-input]")
                .setValue("eroshenkoam/allure-example")
                .pressEnter(); // find repo

        $(linkText("eroshenkoam/allure-example")).click();
        Selenide.sleep(3000);
        $(partialLinkText("Issues")).click();
        Selenide.sleep(3000);
        $(withText("#80")).shouldBe(Condition.visible);
    }
}
