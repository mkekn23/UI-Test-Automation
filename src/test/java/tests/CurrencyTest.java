package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.CurrencySteps;

import static constants.Constants.*;

@Test(description = "KAN-T3 ვალუტის კურსის კალკულაცია")
public class CurrencyTest extends BaseTest {

    private CurrencySteps currencySteps;

    @BeforeClass
    public void innerSetup() {
        currencySteps = new CurrencySteps();
    }

    @Test(priority = 1, description = "სტეპი 1: ვალუტის გვერდზე გადასვლა")
    public void openCurrencyPage() {
        currencySteps
                .openCurrencyPage();
    }

    @Test(priority = 2, description = "სტეპი 2: საწყისი ვალუტისა და თანხის არჩევა")
    public void selectSourceCurrencyAndAmount() {
        currencySteps
                .setSourceCurrencyAndAmount(STARTING_CURRENCY, STARTING_MONEY);
    }

    @Test(priority = 3, description = "სტეპი 3: სამიზნე ვალუტის არჩევა და თანხის გამოანგარიშება")
    public void selectTargetCurrencyAndVerify() {
        currencySteps
                .setTargetCurrencyAndVerifyCalculation(TARGET_CURRENCY)
                .verifyDynamicConversionCalculation();;
    }

    @Test(priority = 4, description = "სტეპი 4: საწყისი და სამიზნე ვალუტების გადაცვლა (Swap)")
    public void swapCurrenciesAndVerify() {
        currencySteps
                .swapCurrenciesAndVerifyRecalculation()
                .verifyDynamicConversionCalculation();;
    }

}