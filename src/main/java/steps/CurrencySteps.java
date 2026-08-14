package steps;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverConditions;
import org.testng.Assert;
import pages.CurrencyPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.webdriver;
import static constants.Constants.*;

public class CurrencySteps {

    private final CurrencyPage currencyPage = new CurrencyPage();

    // Step 1: ვალუტის გვერდზე გადასვლა
    public CurrencySteps openCurrencyPage() {
        currencyPage.getCurrencyNavLink()
                .scrollIntoView("{block: 'center'}")
                .shouldBe(Condition.visible)
                .click(ClickOptions.usingJavaScript());

        webdriver().shouldHave(WebDriverConditions.urlContaining(CURRENCY_TEXT_LATIN), Duration.ofSeconds(10));

        currencyPage.getPageHeader()
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .shouldHave(Condition.text(CURRENCY_RATE_TEXT));

        return this;
    }

    // Step 2: საწყისი ვალუტისა და თანხის არჩევა
    public CurrencySteps setSourceCurrencyAndAmount(String currency, String amount) {
        currencyPage.getSourceCurrencyDropdown().click();
        currencyPage.getCurrencyOptions().findBy(Condition.text(currency)).click();

        currencyPage.getSourceAmountInput().clear();
        currencyPage.getSourceAmountInput().setValue(amount);
        currencyPage.getSourceAmountInput().shouldHave(Condition.value(amount));
        return this;
    }

    // Step 3: სამიზნე ვალუტის არჩევა და გამოანგარიშების შემოწმება
    public CurrencySteps setTargetCurrencyAndVerifyCalculation(String currency) {
        currencyPage.getTargetCurrencyDropdown().shouldBe(Condition.visible).click();
        currencyPage.getCurrencyOptions().findBy(Condition.text(currency)).shouldBe(Condition.visible).click();

        currencyPage.getTargetAmountInput()
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .shouldNotBe(Condition.empty)
                .shouldNotHave(Condition.value("0"));
        return this;
    }

    // Step 4: ვალუტების გადაცვლა ისრების იკონკით
    public CurrencySteps swapCurrenciesAndVerifyRecalculation() {
        String initialSourceText = currencyPage.getSourceCurrencyDropdown().getText();

        currencyPage.getSwapButton().shouldBe(Condition.visible).click();

        // ქვედა დროპდაუნში გადავიდა თუ არა ზედა ვალუტა
        currencyPage.getTargetCurrencyDropdown().shouldHave(Condition.text(initialSourceText));

        currencyPage.getTargetAmountInput()
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .shouldNotBe(Condition.empty);

        return this;
    }

    public CurrencySteps verifyDynamicConversionCalculation() {
        String rateText = currencyPage.getRateDescription()
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .getText();

        String[] parts = rateText.split("=");
        double dynamicRate = Double.parseDouble(parts[1].replaceAll("[^0-9.]", "").trim());

        String sourceValRaw = currencyPage.getSourceAmountInput()
                .shouldBe(Condition.visible)
                .getValue();
        double sourceAmount = Double.parseDouble(sourceValRaw.replaceAll("[^0-9.]", ""));

        String targetValRaw = currencyPage.getTargetAmountInput()
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .shouldNotBe(Condition.empty)
                .getValue();
        double actualTargetAmount = Double.parseDouble(targetValRaw.replaceAll("[^0-9.]", ""));
        double expectedTargetAmount = sourceAmount * dynamicRate;

        Assert.assertEquals(actualTargetAmount, expectedTargetAmount, 0.01,
                "კალკულატორის შედეგი არ ემთხვევა ეკრანიდან დინამიურად წაკითხული კურსით დათვლილს");

        return this;
    }


}