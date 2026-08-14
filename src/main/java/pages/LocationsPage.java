package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static constants.Constants.*;

public class LocationsPage {
    private final SelenideElement locationsNavLink = $$("a[href*='atms&branches']").findBy(Condition.visible);

    private final SelenideElement atmFilterButton = $$(".tbcx-pw-tab-menu__item").findBy(text(ATMS_FILTER));
    private final SelenideElement branchFilterButton = $$(".tbcx-pw-tab-menu__item").findBy(text(BRANCHES_FILTER));
    private final SelenideElement allFilterButton = $$(".tbcx-pw-tab-menu__item").findBy(text(ALL_FILTER));

    private final SelenideElement mapContainer = $("google-map[mapid='ATM_BRANCHES_MAP']");
    private final ElementsCollection mapMarkers = $$("map-advanced-marker, map-marker-clusterer");

    ///
    private final SelenideElement cityDropdown = $(".tbcx-dropdown-selector");
    private final ElementsCollection cityOptions = $$(".tbcx-dropdown-popover-item__title");

    private final SelenideElement searchInput = $("input[placeholder*='ლოკაცია'], input[type='text']");

    private final ElementsCollection searchResultItems = $$(".tbcx-pw-atm-branches-section__list-item-title");

    public SelenideElement getCityDropdown() {
        return cityDropdown;
    }

    public ElementsCollection getCityOptions() {
        return cityOptions;
    }

    public SelenideElement getSearchInput() {
        return searchInput;
    }

    public ElementsCollection getSearchResultItems() {
        return searchResultItems;
    }

    public SelenideElement getLocationsNavLink() {
        return locationsNavLink;
    }

    public SelenideElement getMapContainer() {
        return mapContainer;
    }

    public SelenideElement getAtmFilterBtn() {
        return atmFilterButton;
    }

    public SelenideElement getBranchFilterBtn() {
        return branchFilterButton;
    }

    public SelenideElement getAllFilterBtn() {
        return allFilterButton;
    }

    public ElementsCollection getMapMarkers() {
        return mapMarkers;
    }
}