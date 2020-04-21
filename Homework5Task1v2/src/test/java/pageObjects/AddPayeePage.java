package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPayeePage
{
    @FindBy(linkText="Pay Bills")
    private WebElement payBills;
    @FindBy(linkText="Add New Payee")
    private WebElement addNewPayee;
    @FindBy(id="np_new_payee_name")
    private WebElement payeeName;
    @FindBy(id="np_new_payee_address")
    private WebElement payeeAddress;
    @FindBy(id = "np_new_payee_account")
    private WebElement payeeAccount;
    @FindBy(id ="np_new_payee_details")
    private WebElement payeeDetails;
    @FindBy(id = "alert_content")
    private WebElement alertMessage;
    @FindBy(id="add_new_payee")
    private WebElement addPayeeButton;

    WebDriver driver;

    public AddPayeePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickPayBills()
    {
        payBills.click();
    }

    public void addNewPayee()
    {
        addNewPayee.click();
    }

    public void setPayeeNameInput(String payeeName)
    {
        this.payeeName.clear();
        this.payeeName.sendKeys(payeeName);
    }

    public void setPayeeAccountInput(String payeeAccount)
    {

        this.payeeAccount.clear();
        this.payeeAccount.sendKeys(payeeAccount);
    }

    public void setPayeeAddressInput(String payeeAddress)
    {
        this.payeeAddress.clear();
        this.payeeAddress.sendKeys(payeeAddress);
    }

    public void setPayeeDetailsInput(String payeeDetails)
    {
        this.payeeDetails.clear();
        this.payeeDetails.sendKeys(payeeDetails);
    }

    public void clickAddButton()
    {
        addPayeeButton.click();
    }

    public String getMessageText()
    {
        WebElement successMessageDiv = alertMessage;
        return successMessageDiv.getText();
    }
}
