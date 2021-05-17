package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.andersen.shkraba.core.BasePage;

public class CalculatorPage extends BasePage {

    private final String exchangeLoaderLocator = "//div[@class='text-center']";
    private final String buyInputLocator = "//input[@data-ng-model='currencyExchangeVM.filter.to_amount']";
    private final String sellInputLocator = "//input[@data-ng-model='currencyExchangeVM.filter.from_amount']";
    private final String countryDropdownElementLocator = "countries-dropdown";
    private final String chooseLocationButton = "//span[@class='js-localization-popover']";
    private final String defaultCurrencyDropdownLocator = "//form/div[contains(.,'Sell')]//span[@class='ng-binding ng-scope']";
    private final String selectCountryLocator = "//a[contains(.,'%s')]";

    @Override
    public CalculatorPage waitForPageLoad() {
        $x(exchangeLoaderLocator).shouldBe(Condition.hidden);
        return this;
    }

    public CalculatorPage clearBuyField() {
        $(By.xpath(buyInputLocator)).clear();
        return this;
    }

    public CalculatorPage clearSellField() {
        $x(sellInputLocator).clear();
        return this;
    }

    public CalculatorPage setValueToBuyField(String value) {
        $x(buyInputLocator).setValue(value);
        return this;
    }

    public CalculatorPage setValueToSellField(String value) {
        $x(sellInputLocator).setValue(value);
        return this;
    }

    public String getSellInputValue() {
        return $x(sellInputLocator).getValue();
    }

    public String getBuyInputValue() {
        return $x(buyInputLocator).getValue();
    }

    public CalculatorPage clickLocationButton(){
        $x(chooseLocationButton).click();
        return this;
    }

    public CalculatorPage clickCountryDropdown() {
        $(By.id(countryDropdownElementLocator)).click();
        return this;
    }

    public CalculatorPage selectCountry(String countryName) {
        $x(String.format(selectCountryLocator, countryName)).click();
        return this;
    }

    public String getDefaultCurrencyDropdownValue(){
        return $x(defaultCurrencyDropdownLocator).getText();
    }


}
