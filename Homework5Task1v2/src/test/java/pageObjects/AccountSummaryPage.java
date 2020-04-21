package pageObjects;
import org.openqa.selenium.WebDriver;

public class AccountSummaryPage extends MainPage
{
    WebDriver driver;
    public AccountSummaryPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }
}
