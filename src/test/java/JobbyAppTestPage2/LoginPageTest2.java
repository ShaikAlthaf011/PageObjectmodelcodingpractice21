package JobbyAppTestPage2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import JobbyAppTestPage1.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTest2 {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    @BeforeMethod
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        driver=new ChromeDriver();
        driver.navigate().to("https://qajobbyapp.ccbp.tech/login");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
    }
    @Test(priority = 1)
    public void Loginpageurl(){
        Assert.assertTrue(loginPage.visibleimage(),"App logo is not displayed");
        Assert.assertEquals(loginPage.Getuser(),"USERNAME","Username label text does not match");
        Assert.assertEquals(loginPage.Getpassword(),"PASSWORD","Password label text does not match");
    }
    @Test(priority = 2)
    public void EmptyInputfield(){
        loginPage.Clickonbutton();
        Assert.assertEquals(loginPage.Getmessage(),"*Username or password is invalid");
    }
    @Test(priority = 3)
    public void EmptyUsernamefiel(){
        loginPage.PASSWORD();
        loginPage.Clickonbutton();
        Assert.assertEquals(loginPage.Getmessage(),"*Username or password is invalid","Error text with empty input field do not match");
    }
    @Test(priority = 4)
    public void PasswordEmptyfiel(){
         loginPage.USERNAME();
         loginPage.Clickonbutton();
         Assert.assertEquals(loginPage.Getmessage(),"*Username or password is invalid","Error text with empty input field do not match");

    }
    @Test(priority = 5)
    public void Invalidcredentail(){
        loginPage.Wrongcredentail();
        Assert.assertEquals(loginPage.Getmessage(),"*username and password didn't match","Error text with invalid password do not match");
    }
    @Test(priority = 6)
    public void SUCCESFULLY(){
        loginPage.Sucessfullylogin();
        Assert.assertEquals(loginPage.url(),"https://qajobbyapp.ccbp.tech/","URLs do not match");
    }
    @AfterMethod
    public void Closebrowser(){
        driver.quit();
    }
}
