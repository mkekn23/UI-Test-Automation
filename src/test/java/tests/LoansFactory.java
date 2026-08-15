package tests;

import org.testng.annotations.Factory;

public class LoansFactory {

    @Factory
    public Object[] createInstances() {
        return new Object[] {
                new LoansTest( "60000", "24", "2765.93" ),
                new LoansTest("200",   "3",  "67.77" ),
                new LoansTest( "80000", "48", "2025.17" )
        };
    }
}