package steps;

import io.qameta.allure.Step;
import pages.CalculatorPage;

public class CalculatorPageSteps {

    private CalculatorPage calculatorPage;

    public CalculatorPageSteps() {
        calculatorPage = new CalculatorPage();
    }

    @Step("Set value in sell field")
    public CalculatorPageSteps setSellValueStep(String value) {
        calculatorPage
                .clearSellField()
                .setValueToSellField(value);
        return this;
    }

    @Step("Set value in buy field")
    public CalculatorPageSteps setBuyValueStep(String value) {
        calculatorPage
                .clearBuyField()
                .setValueToBuyField(value);
        return this;
    }

    @Step("Get value from Sell field")
    public String getSellValueStep() {
        return calculatorPage
                .getSellInputValue();
    }

    @Step("Get value from Buy field")
    public String getBuyValueStep() {
        return calculatorPage
                .getBuyInputValue();
    }

    @Step("Select country {string}")
    public CalculatorPageSteps selectCountryStep(String countryName) {
        calculatorPage
                .clickLocationButton()
                .clickCountryDropdown()
                .selectCountry(countryName);
        return this;
    }

    @Step("Get letter designation from default currency dropdown")
    public String getDefaultCurrencyDropdownValueStep() {
        calculatorPage.waitForPageLoad();
        return calculatorPage
                .getDefaultCurrencyDropdownValue();
    }

}
