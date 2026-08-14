package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static constants.Constants.*;

public class LoansPage {
    public SelenideElement forMeTab = $(byText(FOR_ME_TEXT));
    public SelenideElement consumerLoansLink = $("a[href*='/loans/consumer-loan']");
    public SelenideElement conditionsBtn = $("a[href*='/loans/consumer-loan/digital']");

    public SelenideElement burgerMenuBtn = $("button.tbcx-pw-hamburger-menu__button");
    public SelenideElement loansAccordion = $$(".tbc-accordion__toggle")
            .findBy(Condition.visible);
    public SelenideElement mobileConsumerLoanLink = $$x("//a[contains(@href,'/loans/consumer-loan')]//button").findBy(Condition.visible);

    public SelenideElement amountInput = $x(String.format(
            "//input[@placeholder='%1$s'] | //label[contains(text(),'%1$s')]/ancestor::tbcx-slider-input//input",
            LOAN_AMOUNT_TEXT
    ));

    public SelenideElement periodInput = $x(String.format(
            "//input[@placeholder='%1$s'] | //label[contains(text(),'%1$s')]/ancestor::tbcx-slider-input//input",
            LOAN_PERIOD_TEXT));

    public SelenideElement calculatorSummary = $(".tbcx-pw-calculator-form");
    public SelenideElement monthlyPaymentText = $(".tbcx-pw-calculated-info__number--new");
}