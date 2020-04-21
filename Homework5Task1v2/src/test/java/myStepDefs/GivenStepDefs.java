package myStepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;

public class GivenStepDefs
{
    private WebDriver driver;
    private final String URL = "http://zero.webappsecurity.com/";
    private final String USERNAME = "username";
    private final String PASSWORD = "password";
    private LoginPage loginPage;
    private LogoutPage logoutPage;


    public GivenStepDefs(InitializeDriver initializeDriver)
    {
        driver = initializeDriver.getDriver();
        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);
    }

    @Given("^Login to the app with credentials$")
    public void loginToTheAppWithCredentials()
    {
        driver.get(URL);
        loginPage.doLogin(USERNAME, PASSWORD);
    }

    @Then("^User logs out$")
    public void userLogsOut()
    {
        logoutPage.doLogout();
    }
}
