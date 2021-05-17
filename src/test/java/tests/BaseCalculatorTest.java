package tests;

import com.andersen.shkraba.core.BaseTest;
import org.testng.annotations.BeforeClass;
import pages.MainPage;
import steps.CalculatorPageSteps;

public abstract class BaseCalculatorTest extends BaseTest {
    CalculatorPageSteps calculatorPageSteps;
    MainPage mainPage;

    @BeforeClass
    @Override
    protected void createPage() {
        mainPage = new MainPage();
        calculatorPageSteps = new CalculatorPageSteps();
        mainPage.openCalculatorPage().waitForPageLoad();
    }
}
