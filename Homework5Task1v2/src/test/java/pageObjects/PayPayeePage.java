package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class PayPayeePage
{
    WebDriver driver;
    Random randNum;
    @FindBy(linkText = "Pay Bills")
    private WebElement payBills;
    @FindBy(id="sp_payee")
    private WebElement payee;
    @FindBy(id = "sp_account")
    private WebElement account;
    @FindBy(id = "sp_amount")
    private WebElement amount;
    @FindBy(id = "sp_date")
    private WebElement date;
    @FindBy(name = "description")
    private WebElement description;
    @FindBy(xpath = "//*[@id='alert_content']/span")
    private WebElement alert;
    @FindBy(id = "pay_saved_payees")
    private WebElement submit;

    public PayPayeePage(WebDriver driver)
    {
        this.driver = driver;
        this.randNum = new Random();
        PageFactory.initElements(driver, this);
    }

    public void clickPayBills()
    {
        payBills.click();
    }

    public void selectRandomPayee()
    {
        Select payeeSelect = new Select(payee);
        int countPayees = payeeSelect.getOptions().size();
        int randomPayee = randNum.nextInt(countPayees);
        payeeSelect.selectByIndex(randomPayee);
    }

    public void selectRandomAccount()
    {
        Select accountSelect = new Select(account);
        int countAccount = accountSelect.getOptions().size();
        int randomAccount = randNum.nextInt(countAccount);
        accountSelect.selectByIndex(randomAccount);
    }

    public void setAmount(String amount)
    {
        this.amount.clear();
        this.amount.sendKeys(amount);
    }

    public void setDate(String date)
    {
        this.date.clear();
        this.date.sendKeys(date);
    }

    public void setDescription(String description)
    {
        this.description.clear();
        this.description.sendKeys(description);
    }

    public void clickSubmit()
    {
        submit.click();
    }

    public String getMessageText()
    {
        WebElement successMessageDiv = alert;
        return successMessageDiv.getText();
    }
}
