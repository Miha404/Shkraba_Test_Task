package tests;

import com.andersen.shkraba.baseModels.BaseTest;
import org.testng.annotations.BeforeClass;
import pages.MainPage;
import steps.CalculatorPageSteps;

public class BaseCalculatorTest extends BaseTest {
    CalculatorPageSteps calculatorPageSteps;
    MainPage mainPage;

    @BeforeClass
    @Override
    protected void createPages() {
        mainPage = new MainPage();
        calculatorPageSteps = new CalculatorPageSteps();
        mainPage.openPage().openCalculatorPage().isPageOpened();
    }
}
