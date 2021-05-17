package pages;

import com.andersen.shkraba.baseModels.BasePage;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CalculatorPage extends BasePage {

    private static final String EXCHANGE_LOADER = "//div[@class='text-center']";
    private static final String BUY_INPUT_LOCATOR =  "//input[@data-ng-model='currencyExchangeVM.filter.to_amount']";
    private static final String SELL_INPUT_LOCATOR =  "//input[@data-ng-model='currencyExchangeVM.filter.from_amount']";

    @Override
    public CalculatorPage isPageOpened() {
        $(By.xpath(EXCHANGE_LOADER)).shouldBe(Condition.hidden);
        return this;
    }

    public CalculatorPage clearBuyField(){
        $(By.xpath(BUY_INPUT_LOCATOR)).clear();
        return this;
    }

    public CalculatorPage clearSellField(){
        $(By.xpath(SELL_INPUT_LOCATOR)).clear();
        return this;
    }

    public CalculatorPage setValueToBuyField(String value){
        $(By.xpath(BUY_INPUT_LOCATOR)).setValue(value);
        return this;
    }
    public CalculatorPage setValueToSellField(String value){
        $(By.xpath(SELL_INPUT_LOCATOR)).setValue(value);
        return this;
    }

    public String getSellInputValue(){
       return $(By.xpath(SELL_INPUT_LOCATOR)).getValue();
    }

    public String getBuyInputValue(){
        return $(By.xpath(BUY_INPUT_LOCATOR)).getValue();
    }


}
