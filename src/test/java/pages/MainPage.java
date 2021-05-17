package pages;

import com.andersen.shkraba.core.BasePage;
import com.codeborne.selenide.Condition;
import com.andersen.shkraba.utils.PropertyReader;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class MainPage extends BasePage {
    private final String bottomBar = "//div/*[@class='container']";

    @Override
    protected MainPage waitForPageLoad() {
        $(bottomBar).shouldBe(Condition.visible);
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
