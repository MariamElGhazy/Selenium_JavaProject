package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    //constructor that takes webdriver
    HomePage homePage;
    public HomePage(WebDriver driver){
        this.driver=driver;}
    private By LoginIcon= By.id("Account_Icon");
    private By BloomIcon= By.cssSelector("img[alt='Bloom Pharmacy']");
    private By MenuIcon= By.xpath("//span[text()='Menu']");
    private By ShopHealthAndWellness= By.xpath("//button[@aria-controls='mobile-panel-1']");
    private By HairCareMenu= By.xpath("//button[contains(text(), 'Hair Care')]");

    private By AllHairCareLink= By.xpath("//a[text()='Hair Care' and contains(@class, 'mobile-menu__nav-link')]");
    public LoginPage ClickLoginIcon(){
        driver.findElement(LoginIcon).click();
        //pass driver to LoginPage
        return new LoginPage(driver);
    }

    public AccountPage SignedInUser(){
        driver.findElement(LoginIcon).click();
        //pass driver to account page
        return new AccountPage(driver);
    }
public void ClickBloomIcon(){
        driver.findElement(BloomIcon).click();
}
public void ClickMenuIcon(){
        driver.findElement(MenuIcon).click();
}

public void ClickHealthAndWellness(){

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    wait.until(ExpectedConditions.elementToBeClickable(ShopHealthAndWellness)).click();
}
public void ClickHairCareFromMenu(){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    wait.until(ExpectedConditions.elementToBeClickable(HairCareMenu)).click();

}

public void ClickAllHairCare(){
        driver.findElement(AllHairCareLink).click();
}

public HairCarePage GoToHairCarePage(){
    ClickBloomIcon();
    ClickMenuIcon();
    ClickHealthAndWellness();
    ClickHairCareFromMenu();
    ClickAllHairCare();
    return new HairCarePage(driver);
}


}