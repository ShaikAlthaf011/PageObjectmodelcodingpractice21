package JobbyAppTestPage2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import JobbyAppTestPage1.HomePage;

public class HomePageTest {
    WebDriver driver;
    HomePage homePage;
    @BeforeMethod
    public void Setup(){
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qajobbyapp.ccbp.tech/login");
        driver.manage().window().maximize();
        homePage=new HomePage(driver);
    }
    @Test(priority=1)
    public void HomeHeading(){
    homePage.logintiAppliocation();
    homePage.Returnurl();
    homePage.headingtext();
    homePage.descriptiontext();
    }
    @Test(priority = 2)
    public void JobsbuttonFucationality(){
        homePage.logintiAppliocation();
        homePage.Returnurl();
        homePage.findjob();
        Assert.assertEquals(homePage.url(),"https://qajobbyapp.ccbp.tech/jobs","URLs do not match");
    }
    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}
