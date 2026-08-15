package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.LocationsSteps;

@Test(description = "KAN-T1 რუკაზე ძებნა ფილიალებისა და ბანკომატების გაფილტვრით")
public class LocationsFilterTest extends BaseTest {
    private LocationsSteps locationsSteps;

    @BeforeClass
    public void innerSetup() {
        locationsSteps = new LocationsSteps();
    }

    @Test(priority = 1, description = "ლოკაციების გვერდზე გადასვლა და რუკის ჩატვირთვა")
    public void openLocationsPageAndVerify() {
        locationsSteps
                .openLocationsPage()
                .verifyMarkersExist();
    }

    @Test(priority = 2, description = "ბანკომატების ფილტრის არჩევა")
    public void filterByAtmAndVerify() {
        locationsSteps
                .filterByAtm()
                .verifyMarkersExist();
    }

    @Test(priority = 3, description = "ფილიალების ფილტრის არჩევა")
    public void filterByBranchAndVerify() {
        locationsSteps
                .filterByBranch()
                .verifyMarkersExist();
    }

    @Test(priority = 4, description = "ფილტრების გასუფთავება (ყველა)")
    public void resetFiltersAndVerify() {
        locationsSteps
                .resetFilters()
                .verifyMarkersExist();
    }
}