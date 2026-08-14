package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.LocationsSteps;

import static constants.Constants.*;

@Test(description = "KAN-T2 რუკაზე კონკრეტული ფილიალის მოძებნა")
public class LocationsSearchTest extends BaseTest {

    private LocationsSteps locationsSteps;

    @BeforeClass
    public void innerSetup() {
        locationsSteps = new LocationsSteps();
    }

    @Test(priority = 1, description = "სტეპი 1: ლოკაციების გვერდზე გადასვლა და რუკის ჩატვირთვა")
    public void openLocationsPageAndVerifyMap() {
        locationsSteps
                .openLocationsPage()
                .verifyMarkersExist();
    }

    @Test(priority = 2, description = "სტეპი 2: ქალაქის არჩევა (თბილისი)")
    public void selectCityTbilisi() {
        locationsSteps
                .selectCity(TBILISI);
    }

    @Test(priority = 3, description = "სტეპი 3: საძიებო ტექსტის შეყვანა ('რუსთაველი') და სიის დინამიური გაფილტვრა")
    public void searchByLocationName() {
        locationsSteps
                .enterSearchText(RUSTAVELI)
                .verifySearchResultsContain(RUSTAVELI);
    }

    @Test(priority = 4, description = "სტეპი 4: მისამართის არჩევა და რუკაზე პინის ნახვა")
    public void selectAddressAndVerifyMapPin() {
        locationsSteps
                .selectFirstAddress()
                .verifyMarkersExist();
    }
}