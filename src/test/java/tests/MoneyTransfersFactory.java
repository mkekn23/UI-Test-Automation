package tests;

import org.testng.annotations.Factory;

public class MoneyTransfersFactory {

    @Factory
    public Object[] createInstances() {
        return new Object[] {
                new MoneyTransfersTest("100", "USD", "Greece"),
                new MoneyTransfersTest("200", "EUR", "Germany"),
                new MoneyTransfersTest("500", "GEL", "Italy")
        };
    }
}