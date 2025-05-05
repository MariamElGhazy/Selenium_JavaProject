package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    private By UsernameField= By.xpath("//*[@id=\"customer[email]\"]");
    private By PasswordField= By.xpath("//*[@id=\"customer[password]\"]");
    private By LoginButton= By.xpath("//*[@id=\"customer_login\"]/button");




    public void SetUsername(String username){
        driver.findElement(UsernameField).sendKeys(username);
    }
    public void SetPassword(String password){
        driver.findElement(PasswordField).sendKeys(password);
    }

    public AccountPage ClickLoginButton(){
        driver.findElement(LoginButton).click();
        return new AccountPage(driver);
    }

}
