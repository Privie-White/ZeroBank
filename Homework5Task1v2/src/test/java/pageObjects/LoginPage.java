package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    WebDriver driver;
    @FindBy(id="user_login")
    private WebElement loginInput;

    @FindBy(id="user_password")
    private WebElement loginPassword;
    @FindBy(id="signin_button")
    private WebElement signin;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setLogin(String username)
    {
        loginInput.clear();
        loginInput.sendKeys(username);
    }
    public void setPassword(String password)
    {
        loginPassword.clear();
        loginPassword.sendKeys(password);
    }

    public void clickSignInButton()
    {
        loginInput.submit();
    }

    public void doLogin(String username, String password)
    {
        signin.click();
        this.setLogin(username);
        this.setPassword(password);
        clickSignInButton();
    }
}
