package Base;

import Pages.AccountPage;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.List;

public class Base_Tests {
    private WebDriver driver;
    protected HomePage homePage;
    protected AccountPage accountPage;
    @BeforeClass
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.bloompharmacy.com/");
        //maximize the chrome window
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

   @AfterClass
    public void TearDown(){
        homePage.ClickLoginIcon();
        accountPage=new AccountPage(driver);
        accountPage.ResetUsernameAndPasswordAndLogout();
        driver.quit();
   }





}
