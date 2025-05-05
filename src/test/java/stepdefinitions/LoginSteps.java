package stepdefinitions;
import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginSteps {
    private WebDriver driver;
    protected HomePage homePage;
    protected AccountPage accountPage;
    protected LoginPage loginPage;

    @Given("I open the login page")
    public void openLoginPage() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.bloompharmacy.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        System.out.println("Login page opened");
    }

    @When("I enter valid credentials")
    public void enterValidCredentials() {
        LoginPage loginPage= homePage.ClickLoginIcon();
        loginPage.SetUsername("mariamelghazy95@gmail.com");
        loginPage.SetPassword("Test@1234");
        accountPage=loginPage.ClickLoginButton();
        System.out.println("Entered credentials");
    }

    @Then("I should be redirected to the account page")
    public void redirectedToMyAccount() {
        Boolean IsDisplayed=accountPage.isMyAccountDisplayed();
        Assert.assertTrue(IsDisplayed,"My Account is displayed");
        System.out.println("Redirected to account page");
    }
}
