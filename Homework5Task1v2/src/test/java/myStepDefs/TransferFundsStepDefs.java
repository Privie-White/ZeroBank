package myStepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.AccountSummaryPage;
import pageObjects.LogoutPage;
import pageObjects.TransferFundsPAge;

public class TransferFundsStepDefs
{
    private WebDriver driver;
    private TransferFundsPAge transferFundsPAge;
    private AccountSummaryPage accountSummaryPage;
    public static final String expectedSuccessMessage = "You successfully submitted your transaction.";

    public TransferFundsStepDefs(InitializeDriver initializeDriver)
    {
        driver = initializeDriver.getDriver();
        transferFundsPAge = new TransferFundsPAge(driver);
        accountSummaryPage = new AccountSummaryPage(driver);

    }
    @When("^User goes to transfer funds$")
    public void userGoesToTransferFunds()
    {
        accountSummaryPage.clickTransferFunds();
    }

    @And("^Select from account$")
    public void selectFromAccount()
    {
        transferFundsPAge.selectRandomFromAccount();
    }

    @And("^Select to account$")
    public void selectToAccount()
    {
        transferFundsPAge.selectRandomToAccount();
    }

    @And("^fill amount$")
    public void fillAmount()
    {
        transferFundsPAge.setAmount("1000");
    }

    @And("^fill description$")
    public void fillDescription()
    {
        transferFundsPAge.setDescription("Test description");
    }

    @And("^user submits$")
    public void userSubmits()
    {
        transferFundsPAge.clickContinueBtn();
        transferFundsPAge.clickSubmitBtn();
    }

    @And("^success message is shown$")
    public void successMessageIsShown()
    {
        String alertText = transferFundsPAge.getMessageText();
        Assert.assertEquals(alertText, expectedSuccessMessage);
    }


}
