package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        setSelenideConfiguration();
    }

    @AfterAll
    public static void tearDown() {
        WebDriverRunner.getWebDriver().close();
    }

    @AfterEach
    public void clean() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    private static void setSelenideConfiguration() {
        Configuration.baseUrl = "http://todomvc.com/examples/react/";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }
}
