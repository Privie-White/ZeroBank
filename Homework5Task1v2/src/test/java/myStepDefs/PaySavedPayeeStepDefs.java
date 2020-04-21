package myStepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.PayPayeePage;

public class PaySavedPayeeStepDefs
{
    WebDriver driver;
    PayPayeePage payPayeePage;
    WebDriverWait wait;
    public static final String expectedPayPayeeSuccessText = "The payment was successfully submitted.";

    public PaySavedPayeeStepDefs(InitializeDriver initializeDriver)
    {
        driver = initializeDriver.getDriver();
        payPayeePage = new PayPayeePage(driver);
        wait = new WebDriverWait(driver, 2);
    }

    @When("^user goes to pay bills tab$")
    public void userGoesToPayBillsTab()
    {
        payPayeePage.clickPayBills();
    }

    @And("^user selects random payee$")
    public void userSelectsRandomPayee()
    {
        payPayeePage.selectRandomPayee();
    }

    @And("^user selects random account$")
    public void userSelectsRandomAccount()
    {
        payPayeePage.selectRandomAccount();
    }

    @And("^user enters amount$")
    public void userEntersAmount()
    {
        payPayeePage.setAmount("500");
    }

    @And("^user enters date$")
    public void userEntersDate()
    {
        payPayeePage.setDate("2020-03-28");
    }

    @And("^user enters description$")
    public void userEntersDescription()
    {
        payPayeePage.setDescription("Pay Bills");
    }

    @And("^user hits pay$")
    public void userHitsPay()
    {
        payPayeePage.clickSubmit();
    }

    @And("^success text is shown$")
    public void successTextIsShown()
    {
        String actualText = payPayeePage.getMessageText();
        Assert.assertEquals(actualText, expectedPayPayeeSuccessText);
    }
}
