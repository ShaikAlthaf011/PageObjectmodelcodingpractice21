package EBankAppTestHomapageTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import EBankAppTestPage1.LoginPageTest;

public class HomePageTest1 {
    WebDriver driver;
    LoginPageTest loginPageTest;
    @BeforeMethod
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qaebank.ccbp.tech/ebank/login");
        driver.manage().window().maximize();
        loginPageTest=new LoginPageTest(driver);
    }
    @Test(priority = 1)
    public void LoginPageUI(){
        Assert.assertTrue(loginPageTest.visibleimage(),"Login image is not displayed");
        Assert.assertEquals(loginPageTest.textuser(),"User ID","Pin label text does not match");
        loginPageTest.Loginbutton();
        Assert.assertEquals(loginPageTest.Geterror(),"Invalid user ID","Error text with empty input fields does not match");
    }
    @Test(priority = 2)
    public void EmptyInputField(){
        loginPageTest.Loginbutton();
        Assert.assertEquals(loginPageTest.Geterror(),"Invalid user ID","Error text with empty input fields does not match");
    }
    @Test(priority = 3)
    public void EmptyUserfield(){
        loginPageTest.Enterpin();
        loginPageTest.Loginbutton();
        Assert.assertEquals(loginPageTest.Geterror(),"Invalid user ID","Error text with empty input field do not match");
    }
    @Test(priority = 4)
    public void Emptypinfield(){
     loginPageTest.Enteruserid();
     loginPageTest.Loginbutton();
     Assert.assertEquals(loginPageTest.Geterror(),"Invalid PIN","Error text with empty input field do not match");
    }
    @Test(priority = 5)
    public void Invalidpin(){
        loginPageTest.ENTERUSERID();
        loginPageTest.ENTERPINID();
        loginPageTest.Loginbutton();
        Assert.assertEquals(loginPageTest.Geterror(),"User ID and PIN didn't match","Error text with invalid PIN do not match");
    }
    @Test(priority = 6)
    public void Succesfullylogin(){
        loginPageTest.loginappliactionsuccesfully();
        loginPageTest.gotourl();
    }
    @AfterMethod
    public void Closebrowser(){
        driver.quit();
    }
}
