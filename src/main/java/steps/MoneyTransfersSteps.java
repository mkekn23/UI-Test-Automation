package steps;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import pages.MoneyTransfersPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static constants.Constants.FEE_TEXT;

public class MoneyTransfersSteps {

    private MoneyTransfersPage transfersPage = new MoneyTransfersPage();

    public MoneyTransfersSteps navigateToMoneyTransfers() {
        if (transfersPage.burgerMenuBtn.isDisplayed()) {
            transfersPage.burgerMenuBtn.click();

            transfersPage.otherProductsAccordion
                    .scrollIntoView("{block: 'center'}")
                    .shouldBe(visible)
                    .click(ClickOptions.usingJavaScript());

            transfersPage.moneyTransfersLink
                    .scrollIntoView("{block: 'center'}")
                    .shouldBe(visible)
                    .click(ClickOptions.usingJavaScript());

        } else {
            transfersPage.forMeTab
                    .shouldBe(visible)
                    .click();

            transfersPage.moneyTransfersLink
                    .shouldBe(visible)
                    .click();
        }

        return this;
    }

    public MoneyTransfersSteps openTransferFeeTab() {
        transfersPage.transferFeeTab
                .scrollIntoView("{block: 'center'}")
                .shouldBe(visible)
                .click(ClickOptions.usingJavaScript());

        return this;
    }

    public MoneyTransfersSteps enterAmount(String amount) {
        transfersPage.transferAmountInput
                .scrollIntoView("{block: 'center'}")
                .shouldBe(visible)
                .setValue(amount);

        return this;
    }

    // 🔧 გასწორებული: ვალუტის არჩევა center-scroll-ით და JS Click-ით
    public MoneyTransfersSteps selectCurrency(String currency) {
        transfersPage.currencyDropdown
                .scrollIntoView("{block: 'center'}")
                .shouldBe(visible)
                .click(ClickOptions.usingJavaScript());

        $$(".tbcx-dropdown-popover-item__title")
                .findBy(Condition.exactText(currency))
                .shouldBe(visible)
                .click();

        return this;
    }

    // 🔧 გასწორებული: ქვეყნის არჩევა center-scroll-ით და JS Click-ით
    public MoneyTransfersSteps selectCountry(String countryName) {
        transfersPage.countryDropdown
                .scrollIntoView("{block: 'center'}")
                .shouldBe(visible)
                .click(ClickOptions.usingJavaScript());

        $$("tbcx-dropdown-popover-item")
                .findBy(text(countryName))
                .shouldBe(visible)
                .click();

        return this;
    }

    public MoneyTransfersSteps verifyResultsAreDisplayed() {
        transfersPage.transferCardsContainer
                .scrollIntoView("{block: 'center'}")
                .shouldBe(Condition.visible);

        transfersPage.transferSystemCards
                .shouldHave(CollectionCondition.sizeGreaterThan(0));

        transfersPage.transferCardsContainer
                .shouldHave(Condition.text(FEE_TEXT));

        return this;
    }
}