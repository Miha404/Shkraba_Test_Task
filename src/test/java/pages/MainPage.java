package pages;

import com.andersen.shkraba.baseModels.BasePage;
import com.codeborne.selenide.Condition;
import com.andersen.shkraba.utils.PropertyReader;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class MainPage extends BasePage {
    public static final String BOTTOM_BAR = "//div/*[@class='container']";

    @Override
    protected MainPage isPageOpened() {
        $(BOTTOM_BAR).shouldBe(Condition.visible);
        return this;
    }

    public MainPage openPage() {
        open(PropertyReader.getProperty("base.url"));
        return this;
    }

    public CalculatorPage openCalculatorPage() {
        open(PropertyReader.getProperty("calculator.page.url"));
        return new CalculatorPage();
    }
}
