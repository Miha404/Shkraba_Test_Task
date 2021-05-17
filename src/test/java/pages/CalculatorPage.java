package pages;

import com.andersen.shkraba.baseModels.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.commands.GetInnerText;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CalculatorPage extends BasePage {

    private final String exchangeLoaderLocator = "//div[@class='text-center']";
    private final String buyInputLocator = "//input[@data-ng-model='currencyExchangeVM.filter.to_amount']";
    private final String sellInputLocator = "//input[@data-ng-model='currencyExchangeVM.filter.from_amount']";
    private final String countryDropdownElementLocator = "countries-dropdown";
//    private final String locationInputLocator = "//input[@data-ng-model='currencyExchangeVM.filter.from_amount']";
    private final String chooseLocationButton = "//span[@class='js-localization-popover']";
    private final String defaultCurrencyDropdownLocator = "//form/div[contains(.,'Sell')]//span[@class='ng-binding ng-scope']";
    private final String selectCountryLocator = "//a[contains(.,'%s')]";

    @Override
    public CalculatorPage isPageOpened() {
        $(By.xpath(exchangeLoaderLocator)).shouldBe(Condition.hidden);
        return this;
    }

    public CalculatorPage clearBuyField() {
        $(By.xpath(buyInputLocator)).clear();
        return this;
    }

    public CalculatorPage clearSellField() {
        $(By.xpath(sellInputLocator)).clear();
        return this;
    }

    public CalculatorPage setValueToBuyField(String value) {
        $(By.xpath(buyInputLocator)).setValue(value);
        return this;
    }

    public CalculatorPage setValueToSellField(String value) {
        $(By.xpath(sellInputLocator)).setValue(value);
        return this;
    }

    public String getSellInputValue() {
        return $(By.xpath(sellInputLocator)).getValue();
    }

    public String getBuyInputValue() {
        return $(By.xpath(buyInputLocator)).getValue();
    }

    public CalculatorPage clickLocationButton(){
        $(By.xpath(chooseLocationButton)).click();
        return this;
    }

    public CalculatorPage clickCountryDropdown() {
        $(By.id(countryDropdownElementLocator)).click();
        return this;
    }

    public CalculatorPage selectCountry(String countryName) {
        $(By.xpath(String.format(selectCountryLocator, countryName))).click();
        return this;
    }

    public String getDefaultCurrencyDropdownValue(){
       String letterDesignation = $(By.xpath(defaultCurrencyDropdownLocator)).getText();
        return letterDesignation;
    }


}
