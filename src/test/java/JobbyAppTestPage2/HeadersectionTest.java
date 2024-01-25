package JobbyAppTestPage2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.io.IO;
import org.testng.Assert;
import org.testng.SuiteRunState;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import JobbyAppTestPage1.HeaderSection;

import java.io.IOException;

public class HeadersectionTest {
    WebDriver driver;
    HeaderSection headerSection;
    @BeforeMethod
    public void OpenBrowser()  {
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qajobbyapp.ccbp.tech/login");
        driver.manage().window().maximize();
        headerSection=new HeaderSection(driver);
    }
    @Test(priority=1)
    public void AppLogodisplayed(){
     headerSection.loginApplication();
     headerSection.url();
     headerSection.image();
    }
    @Test(priority = 2)
    public void Navbarjoblink()  {
        headerSection.loginApplication();
        headerSection.url();
        headerSection.jobs();
        String str2="https://qajobbyapp.ccbp.tech/jobs";
        String str3= driver.getCurrentUrl();
        Assert.assertEquals(str2,str3,"URLs do not match");
    }
@Test(priority = 3)
public void ClickingAppLogo(){
    headerSection.loginApplication();
    headerSection.url();
    headerSection.jobs();
    headerSection.logoclick();
    String str3="https://qajobbyapp.ccbp.tech/";
    String str4=driver.getCurrentUrl();
    Assert.assertEquals(str3,str4,"URLs do not match");
}
@Test(priority = 4)
public void NavbarlinkHome(){
    headerSection.loginApplication();
    headerSection.url();
    headerSection.jobs();
    headerSection.clickhome();
    String str5="https://qajobbyapp.ccbp.tech/";
    String str6= driver.getCurrentUrl();
    Assert.assertEquals(str5,str6,"URLs do not match");
}
@Test(priority = 5)
public void LogoutFuncationality(){
    headerSection.loginApplication();
    headerSection.url();
    headerSection.LOGOUT();
    String str7="https://qajobbyapp.ccbp.tech/login";
    String str8= driver.getCurrentUrl();
    Assert.assertEquals(str7,str8,"URLs do not match");
}
    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}
