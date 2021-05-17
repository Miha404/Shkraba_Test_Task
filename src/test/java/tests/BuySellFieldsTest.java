package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BuySellFieldsTest extends BaseCalculatorTest {

    @BeforeClass
    public void openCalculatorPage(){
        mainPage.openPage().openCalculatorPage().isPageOpened();
    }

    @DataProvider(name = "input-values")
    public Object[][] dpMethod() {
        return new Object[][]{{"100", "200"}, {"one", "two"}};
    }

    @Test(dataProvider = "input-values")
    public void BuySellFieldsInteractionTest(String sellValue, String buyValue){
        String buyFieldValue = calculatorPageSteps
                .setBuyValueStep(buyValue)
                .setSellValueStep(sellValue)
                .getBuyValueStep();
        Assert.assertTrue(buyFieldValue.isEmpty());
        String sellFieldValue = calculatorPageSteps
                .setSellValueStep(sellValue)
                .setBuyValueStep(buyValue)
                .getSellValueStep();
        Assert.assertTrue(sellFieldValue.isEmpty());
    }
}
