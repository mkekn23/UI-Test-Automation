package steps;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import pages.LoansPage;

import java.time.Duration;

public class LoansSteps {

    private final LoansPage loansPage = new LoansPage();

    private boolean isMobile() {
        return Selenide.executeJavaScript("return window.innerWidth <= 768;");
    }

    public LoansSteps navigateToConsumerLoans() {
        if (isMobile()) {
            loansPage.burgerMenuBtn
                    .shouldBe(Condition.visible)
                    .click();

            loansPage.loansAccordion
                    .shouldBe(Condition.visible)
                    .click();

            loansPage.mobileConsumerLoanLink
                    .shouldBe(Condition.visible)
                    .click(ClickOptions.usingJavaScript());
        } else {
            loansPage.forMeTab.hover();
            loansPage.consumerLoansLink
                    .shouldBe(Condition.visible, Duration.ofSeconds(5))
                    .scrollIntoView("{block: 'center'}")
                    .click(ClickOptions.usingJavaScript());
        }
        return this;
    }


    public LoansSteps clickConditionsButton() {
        loansPage.conditionsBtn
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .click();
        return this;
    }
    public LoansSteps enterLoanAmount(String amount) {
        loansPage.amountInput.clear();
        loansPage.amountInput.setValue(amount);
        return this;
    }

    public LoansSteps verifyLoanAmount(String expectedAmount) {
        loansPage.amountInput.shouldHave(Condition.value(expectedAmount));
        return this;
    }

    public LoansSteps enterLoanPeriod(String months) {
        loansPage.periodInput.clear();
        loansPage.periodInput.setValue(months);
        return this;
    }
    public LoansSteps verifyLoanPeriod(String expectedMonths) {
        loansPage.periodInput.shouldHave(Condition.value(expectedMonths));
        return this;
    }

    public LoansSteps verifyMonthlyPaymentText(String expectedPayment) {
        loansPage.monthlyPaymentText
                .shouldHave(Condition.attributeMatching("textContent", ".*" + expectedPayment + ".*"));
        return this;
    }
}