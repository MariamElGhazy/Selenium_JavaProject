package Login;

import Base.Base_Tests;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTests extends Base_Tests {
    AccountPage accountPage;
    HairCarePage hairCarePage;

//Sucessful Login scenario
    @Test(priority = 1)
    public void testSuccessfulLogin(){
        LoginPage loginPage= homePage.ClickLoginIcon();
        loginPage.SetUsername("mariamelghazy95@gmail.com");
        loginPage.SetPassword("Test@1234");
        accountPage=loginPage.ClickLoginButton();


    }
//Editing User's First and Last name, includes scrolling function to save the edits
    @Test(priority = 2)
    public void testEditAdress(){
        accountPage.ClickMyAdresses();
        accountPage.ClickEditAdress();
        accountPage.SetFirstName("Mariam");
        accountPage.SetLastName("ElGhazy");
        accountPage.ScrollToSave();
        accountPage.ClickSaveButton();
        accountPage.AssertOnEditedName("Mariam ElGhazy");

    }
//Filtering products and making sure that count is displayed correctly
    @Test (priority = 3)
    public void testFiltering(){
        hairCarePage=homePage.GoToHairCarePage();
        hairCarePage.ClickBrandFilter();
        hairCarePage.SelectACMCheckBox();
        Boolean ActualVsExpected=hairCarePage.VerifyFilterResultText();
        Assert.assertTrue(ActualVsExpected);

    }
}
