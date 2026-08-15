package tests;

import org.testng.annotations.Test;
import steps.LoansSteps;

//KAN-T4 სამომხმარებლო სესხის კალკულაცია სესხის თანხით
public class LoansTest extends BaseTest {

    private final LoansSteps loansSteps = new LoansSteps();

    private final String amount;
    private final String months;
    private final String expectedPayment;

    public LoansTest(String amount, String months, String expectedPayment) {
        this.amount = amount;
        this.months = months;
        this.expectedPayment = expectedPayment;
    }

    @Test(
            priority = 1,
            description = "Step 1: სამომხმარებლო სესხების გვერდზე შესვლა"
    )
    public void testNavigateToConsumerLoans() {
        loansSteps
                .navigateToConsumerLoans();
    }

    @Test(
            priority = 2,
            description = "Step 2: სამომხმარებლო სესხის პირობების ნახვა"
    )
    public void testNavigateToCalculator() {
        loansSteps
                .clickConditionsButton();
    }

    @Test(
            priority = 3,
            description = "Step 3: სესხის თანხის შეყვანა"
    )
    public void testEnterAndVerifyLoanAmount() {
        loansSteps
                .enterLoanAmount(amount)
                .verifyLoanAmount(amount);
    }

    @Test(
            priority = 4,
            description = "Step 4: სესხის ვადის შეყვანა და ყოველთვიური შენატანის ოდენობის ვერიფიკაცია "
    )
    public void testEnterAndVerifyLoanPeriod() {
        loansSteps
                .enterLoanPeriod(months)
                .verifyLoanPeriod(months)
                .verifyMonthlyPaymentText(expectedPayment);
    }

}