package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static constants.Constants.*;

public class MoneyTransfersPage {
    public SelenideElement forMeTab = $(byText(FOR_ME_TEXT));
    public SelenideElement transferFeeTab = $$("button.tbcx-pw-tab-menu__item")
            .findBy(text(TRANSFER_FEE_TEXT));
    public SelenideElement transferAmountInput = $$(".tbcx-input-with-selector__text-input input")
            .findBy(visible);

    public SelenideElement currencyDropdown = $("tbcx-dropdown-selector button.tbcx-field");

    public SelenideElement countryDropdown = $$("tbcx-dropdown-selector")
            .findBy(text(SELECT_COUNTRY_TEXT))
            .find("button");

    public SelenideElement transferCardsContainer = $(".tbcx-pw-money-transfer-fee-calculator__cards");
    public ElementsCollection transferSystemCards = $$("tbcx-pw-money-transfer-system-card");

    public SelenideElement burgerMenuBtn = $("button.tbcx-pw-hamburger-menu__button");
    public SelenideElement otherProductsAccordion = $$(".tbcx-pw-mega-menu-sub-item__title")
            .findBy(text(OTHER_PRODUCTS_TEXT));

    public SelenideElement moneyTransfersLink = $$("a[href*='/other-products/money-transfers']")
            .findBy(visible);
}