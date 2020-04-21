package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage
{
    private WebDriver driver;
    @FindBy(partialLinkText="username")
    private WebElement firstLevelMenu;

    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(linkText = "Transfer Funds")
    private WebElement menuTransferFunds;

    @FindBy(linkText = "Pay Bills")
    private WebElement menuPayBills;

    public MainPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void doLogOut()
    {
        firstLevelMenu.click();
        logoutLink.click();
    }

    public void clickTransferFunds()
    {
        menuTransferFunds.click();
    }

    public void clickPayBills()
    {
        menuPayBills.click();
    }
}
