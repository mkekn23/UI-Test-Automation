package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static constants.Constants.CURRENCY_TEXT;

public class CurrencyPage {
    private final SelenideElement currencyNavLink = $$("a[href*='valutis-kursi']").findBy(text(CURRENCY_TEXT));
    private final SelenideElement pageHeader = $("h1, .exchange-rates-calculator");

    private final SelenideElement sourceCurrencyDropdown = $("app-currency-dropdown[formcontrolname='sellCurrency'] .currency-dropdown__trigger");
    private final SelenideElement targetCurrencyDropdown = $("app-currency-dropdown[formcontrolname='buyCurrency'] .currency-dropdown__trigger");

    private final SelenideElement sourceAmountInput = $$("app-currency-calculator input").first();
    private final SelenideElement targetAmountInput = $$("app-currency-calculator input").last();

    private final ElementsCollection currencyOptions = $$(".cdk-overlay-container button, .cdk-overlay-container .currency-dropdown__item, .cdk-overlay-container li");

    private final SelenideElement swapButton = $(".currency-calculator__swap__button");

    private final SelenideElement rateDescription = $(".exchange-rates-calculator__description");


    // Getters
    public SelenideElement getPageHeader() { return pageHeader; }
    public SelenideElement getSourceCurrencyDropdown() { return sourceCurrencyDropdown; }
    public SelenideElement getTargetCurrencyDropdown() { return targetCurrencyDropdown; }
    public SelenideElement getSourceAmountInput() { return sourceAmountInput; }
    public SelenideElement getTargetAmountInput() { return targetAmountInput; }
    public ElementsCollection getCurrencyOptions() { return currencyOptions; }
    public SelenideElement getSwapButton() { return swapButton; }
    public SelenideElement getCurrencyNavLink() { return currencyNavLink; }
    public SelenideElement getRateDescription() {return rateDescription;}

}