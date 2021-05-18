package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BuySellFieldsTest extends BaseCalculatorTest {

    @BeforeClass
    public void openCalculatorPage() {
        mainPage.openPage().openCalculatorPage().waitForPageLoad();
    }

    @DataProvider(name = "input-values")
    public Object[][] dataGenerator() {
        return new Object[][]{{"100", "200"}, {"one", "two"}};
    }

    @Test(dataProvider = "input-values")
    public void BuySellFieldsInteractionTest(String sellValue, String buyValue) {
        SoftAssert softAssertion = new SoftAssert();
        String buyFieldValue = calculatorPageSteps
                .setBuyValueStep(buyValue)
                .setSellValueStep(sellValue)
                .getBuyValueStep();
        softAssertion.assertTrue(buyFieldValue.isEmpty(), "Field BUY is not empty:");
        String sellFieldValue = calculatorPageSteps
                .setSellValueStep(sellValue)
                .setBuyValueStep(buyValue)
                .getSellValueStep();
        softAssertion.assertTrue(sellFieldValue.isEmpty(), "Field SELL is not empty:");
        softAssertion.assertAll();
    }
}
