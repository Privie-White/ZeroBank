package pageObjects;

import org.openqa.selenium.WebDriver;

public class PayBillsPage extends MainPage
{
    WebDriver driver;
    public PayBillsPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }
}
