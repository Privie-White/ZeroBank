package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class TransferFundsPAge
{
    @FindBy(id = "tf_fromAccountId")
    private WebElement fromAccount;

    @FindBy(id="tf_toAccountId")
    private WebElement toAccount;

    @FindBy(name="amount")
    private WebElement amount;

    @FindBy(name = "description")
    private WebElement description;

    @FindBy(id="btn_submit")
    private WebElement submit;

    @FindBy(className = "alert-success")
    private WebElement alertMessage;

    WebDriver driver;
    Random randNum;
    public TransferFundsPAge(WebDriver driver)
    {
        this.driver = driver;
        this.randNum = new Random();
        PageFactory.initElements(driver, this);
    }

    public void selectRandomToAccount()
    {
        Select transferTo = new Select(toAccount);
        int countToAccountOptions = transferTo.getOptions().size();
        int randomToAccount = randNum.nextInt(countToAccountOptions);
        transferTo.selectByIndex(randomToAccount);
    }

    public void selectRandomFromAccount()
    {
        Select transferFrom = new Select(fromAccount);
        int countFromAccountOptions = transferFrom.getOptions().size();
        int randomForFromAccount = randNum.nextInt(countFromAccountOptions);
        transferFrom.selectByIndex(randomForFromAccount);
    }

    public void setAmount(String amount)
    {
        this.amount.clear();
        this.amount.sendKeys(amount);
    }

    public void setDescription(String description)
    {
        this.description.clear();
        this.description.sendKeys(description);
    }

    public void clickContinueBtn()
    {
        submit.click();
    }

    public void clickSubmitBtn()
    {
        submit.click();
    }

    public String getMessageText()
    {
        WebElement successMessageDiv = alertMessage;
        return successMessageDiv.getText();
    }
}
