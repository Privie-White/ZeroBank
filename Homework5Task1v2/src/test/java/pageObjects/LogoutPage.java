package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage
{
    WebDriver driver;
    @FindBy(partialLinkText = "username")
    private WebElement username;
    @FindBy(partialLinkText = "Logout")
    private WebElement logout;
    public LogoutPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void doLogout()
    {
        username.click();
        logout.click();
    }
}
