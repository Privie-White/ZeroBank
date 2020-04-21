package myStepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.AddPayeePage;

import java.util.concurrent.TimeUnit;

public class NewPayeeStepDefs {
    WebDriver driver;
    AddPayeePage addPayeePage;
    WebDriverWait wait;
    public static final String expectedSuccessText = "The new payee Riot Games was successfully created.";
    public NewPayeeStepDefs(InitializeDriver initializeDriver)
    {
        driver = initializeDriver.getDriver();
        addPayeePage = new AddPayeePage(driver);
    }
    @When("^User goes to pay bills tab$")
    public void userGoesToPayBillsTab()
    {
        addPayeePage.clickPayBills();
    }

    @And("^user clicks Add New Payee$")
    public void userClicksAddNewPayee()
    {
        addPayeePage.addNewPayee();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("^User enters payee name$")
    public void userEntersPayeeName()
    {
        addPayeePage.setPayeeNameInput("Riot Games");
    }

    @And("^User enters payee address$")
    public void userEntersPayeeAddress()
    {
        addPayeePage.setPayeeAddressInput("123 Fake street, fake town, Illinois, 60060");
    }

    @And("^User enters Account$")
    public void userEntersAccount()
    {
        addPayeePage.setPayeeAccountInput("Checking");
    }

    @And("^user enters payee details$")
    public void userEntersPayeeDetails()
    {
        addPayeePage.setPayeeDetailsInput("Test Details");
    }

    @And("^user hits add$")
    public void userHitsAdd()
    {
        addPayeePage.clickAddButton();
    }

    @And("^Success message is shown$")
    public void successMessageIsShown()
    {
        String actualMessage = addPayeePage.getMessageText();
        Assert.assertEquals(actualMessage, expectedSuccessText);
    }
}
