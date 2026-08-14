package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static constants.Constants.TBC_URL;

public class BaseTest {

    @BeforeClass
    @Parameters({"deviceProfile"})
    public void setUp(@Optional("desktop") String deviceProfile) {
        Configuration.browser = "chrome";
        Configuration.baseUrl = TBC_URL;
        Configuration.timeout = 10000;

        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.geolocation", 2); // 2 = Block
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);

        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36");

        options.addArguments("--deny-permission-prompts");
        options.addArguments("--disable-features=OneTimePermission");
        options.addArguments("--disable-notifications");

        Configuration.browserCapabilities = options;

        if (deviceProfile.equalsIgnoreCase("mobile")) {
            Configuration.browserSize = "390x844";
        } else {
            Configuration.browserSize = "1440x900";
        }

        Selenide.open("/");
        acceptCookiesIfPresent();
    }

    @BeforeMethod
    private void acceptCookiesIfPresent() {
        SelenideElement acceptCookieBtn = $("app-cookie-consent button.primary");
        try {
            if (acceptCookieBtn.is(Condition.visible, Duration.ofSeconds(4))) {
                acceptCookieBtn.click();
            }
        } catch (Throwable ignored) {
        }
    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}