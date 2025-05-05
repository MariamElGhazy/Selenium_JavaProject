package Pages;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class AccountPage {

    private WebDriver driver;

    //constructor that takes webdriver
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By MyAdresses = By.linkText("My addresses");
    private By Edit = By.xpath("//button[normalize-space()='Edit']");

    private By FirstName = By.cssSelector("input[id='address-[first_name]']");
    private By LastName = By.cssSelector("input[id='address-[last_name]']");
    private By SaveButton = By.xpath("//button[normalize-space()='Edit address']");
    private By EditedName = By.xpath("//p[normalize-space()='Mariam ElGhazyCEgypt']");

    private By Logout= By.linkText("Logout");

    private By MyAccount= By.linkText("My account");

    public void ClickMyAdresses() {
        driver.findElement(MyAdresses).click();
    }

    public void ClickEditAdress() {
        driver.findElement(Edit).click();
    }

    public void ClickSaveButton() {
        driver.findElement(SaveButton).click();
    }

    public void ClickLogout() {
        driver.findElement(Logout).click();
    }
    public void SetFirstName(String Name) {
        driver.findElement(FirstName).clear();
        driver.findElement(FirstName).sendKeys(Name);
    }

    public void SetLastName(String Name) {
        driver.findElement(LastName).clear();
        driver.findElement(LastName).sendKeys(Name);

    }
    public void ResetUsernameAndPasswordAndLogout(){
        ClickMyAdresses();
        ClickEditAdress();
        driver.findElement(FirstName).clear();
        driver.findElement(FirstName).sendKeys("Testing");
        driver.findElement(LastName).clear();
        driver.findElement(LastName).sendKeys("User");
        ScrollToSave();
        ClickSaveButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement productLink = wait.until(ExpectedConditions.visibilityOfElementLocated(Logout));
        ClickLogout();
    }
    public void ScrollToSave() {
        WebElement saveButton= driver.findElement(SaveButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", saveButton);
    }

    public void AssertOnEditedName(String Username){
        WebElement editedName= driver.findElement(EditedName);
        String editedNameText=editedName.getText();
        boolean UserNameIsEdited=editedNameText.contains(String.valueOf(Username));
        assertTrue(UserNameIsEdited);


    }
    public boolean isMyAccountDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(MyAccount));
        return myAccount.isDisplayed();

    }


}
