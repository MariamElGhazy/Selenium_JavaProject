package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HairCarePage {

    private WebDriver driver;

    //constructor that takes webdriver
    public HairCarePage(WebDriver driver) {
        this.driver = driver;
    }

    private By BrandFilter = By.xpath("//button[contains(text(),'Brand')]");

    private  By ACMCheckbox= By.xpath("//input[@id='filter.p.m.global.brand-ACM']");

    private By FilterResultTxt= By.xpath("//p[@class='collection__products-count collection__products-count-showing text--small hidden-pocket hidden-desk']");

    public void ClickBrandFilter(){
        driver.findElement(BrandFilter).click();
    }
    public void SelectACMCheckBox(){
        driver.findElement(ACMCheckbox).click();
    }

    public int  ProductsListCount(){
        List<WebElement> ProductList= driver.findElements(By.xpath("//div[@class='product-list product-list--collection product-list--with-sidebar']"));
        return ProductList.size();
    }

    public boolean VerifyFilterResultText(){
        int NumOfRes=ProductsListCount();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //Wait until product is displayed
        WebElement productLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='acm-novophane-ds-anti-dandruff-shampoo-125ml']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement productCount = driver.findElement(By.cssSelector("p.collection__products-count-total"));
        String text = (String) js.executeScript("return arguments[0].textContent;", productCount);
         boolean CorrectNumOIsDisplayed=text.contains(String.valueOf(NumOfRes));
        return CorrectNumOIsDisplayed;

    }

}
