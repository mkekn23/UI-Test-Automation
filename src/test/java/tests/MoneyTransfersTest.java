package tests;

import org.testng.annotations.Test;
import steps.MoneyTransfersSteps;

//KAN-T5 ფულადი გზავნილების საკომისიოს შემოწმება
public class MoneyTransfersTest extends BaseTest {

    private final MoneyTransfersSteps transfersSteps = new MoneyTransfersSteps();

    private final String amount;
    private final String currency;
    private final String country;

    public MoneyTransfersTest(String amount, String currency, String country) {
        this.amount = amount;
        this.currency = currency;
        this.country = country;
    }

    @Test(
            priority = 1,
            description = "Step 1: მენიუდან ფულადი გზავნილების გვერდზე გადასვლა"
    )
    public void testNavigateToMoneyTransfers() {
        transfersSteps.navigateToMoneyTransfers();
    }

    @Test(
            priority = 2,
            description = "Step 2: 'გზავნილის გაგზავნის საკომისიო' ჩანართის გახსნა"
    )
    public void testOpenTransferFeeTab() {
        transfersSteps.openTransferFeeTab();
    }

    @Test(
            priority = 3,
            description = "Step 3: გადარიცხვის თანხის შეყვანა"
    )
    public void testEnterAmount() {
        transfersSteps.enterAmount(amount);
    }

    @Test(
            priority = 4,
            description = "Step 4: გადარიცხვის ვალუტის არჩევა"
    )
    public void testSelectCurrency() {
        transfersSteps.selectCurrency(currency);
    }

    @Test(
            priority = 5,
            description = "Step 5: მიმღები ქვეყნის არჩევა და საკომისიოების ვერიფიკაცია"
    )
    public void testSelectCountryAndVerify() {
        transfersSteps
                .selectCountry(country)
                .verifyResultsAreDisplayed();
    }
}