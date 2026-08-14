package steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import pages.LocationsPage;

import java.time.Duration;

public class LocationsSteps {

    private final LocationsPage locationsPage = new LocationsPage();

    public LocationsSteps openLocationsPage() {
        locationsPage.getLocationsNavLink()
                .scrollIntoView("{block: 'center'}")
                .shouldBe(Condition.visible)
                .click();

        locationsPage.getMapContainer().shouldBe(Condition.visible);
        return this;
    }

    public LocationsSteps filterByAtm() {
        locationsPage.getAtmFilterBtn().shouldBe(Condition.visible).click();
        return this;
    }

    public LocationsSteps filterByBranch() {
        locationsPage.getBranchFilterBtn().shouldBe(Condition.visible).click();
        return this;
    }

    public LocationsSteps resetFilters() {
        locationsPage.getAllFilterBtn().shouldBe(Condition.visible).click();
        return this;
    }

    public LocationsSteps verifyMarkersExist() {
        locationsPage.getMapMarkers().shouldBe(CollectionCondition.sizeGreaterThan(0));
        return this;
    }

    public LocationsSteps selectCity(String cityName) {
        locationsPage.getCityDropdown().shouldBe(Condition.visible).click();
        locationsPage.getCityOptions().findBy(Condition.text(cityName)).shouldBe(Condition.visible).click();
        return this;
    }

    public LocationsSteps enterSearchText(String searchText) {
        locationsPage.getSearchInput().shouldBe(Condition.visible).setValue(searchText);
        return this;
    }

    public LocationsSteps verifySearchResultsContain(String expectedText) {
        locationsPage.getSearchResultItems()
                .shouldBe(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(10));

        locationsPage.getSearchResultItems()
                .first()
                .shouldHave(Condition.text(expectedText), Duration.ofSeconds(10));

        return this;
    }

    public LocationsSteps selectFirstAddress() {
        locationsPage.getSearchResultItems()
                .first()
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .click();

        return this;
    }
}