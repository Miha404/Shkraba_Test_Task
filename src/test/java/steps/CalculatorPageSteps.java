package steps;

import io.qameta.allure.Step;
import pages.CalculatorPage;

public class CalculatorPageSteps {
    CalculatorPage calculatorPage;

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


}
