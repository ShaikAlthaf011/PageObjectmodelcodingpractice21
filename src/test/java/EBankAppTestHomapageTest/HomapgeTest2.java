package EBankAppTestHomapageTest;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import EBankAppTestPage1.LoginPageTest;

import java.nio.file.WatchEvent;

public class HomapgeTest2 {
    WebDriver driver;
    WebDriverWait wait;
    LoginPageTest loginPageTest;
    @BeforeMethod
    public void SetUP(){
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qaebank.ccbp.tech/ebank/login");
        driver.manage().window().maximize();
        loginPageTest=new LoginPageTest(driver);
    }
    @Test(priority = 1)
    public void HomepageUi(){
        loginPageTest.loginappliactionsuccesfully();
        loginPageTest.gotourl();
        Assert.assertTrue("App logo is not displayed", loginPageTest.logo());
        Assert.assertEquals(loginPageTest.Verifyheading(),"Your Flexibility, Our Excellence");
        Assert.assertTrue("Digital card image is not displayed", loginPageTest.CARD());
    }
    @Test(priority = 2)
    public void LogoutFuncationality(){
        loginPageTest.loginappliactionsuccesfully();
        loginPageTest.gotourl();
        loginPageTest.logoutbutton();
        loginPageTest.verifyURl();
    }
    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}
