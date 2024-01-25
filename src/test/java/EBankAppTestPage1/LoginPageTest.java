package EBankAppTestPage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageTest {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css="img[class='login-ebank-image']")
    public WebElement isdiplayed;
    @FindBy(css="div[class='input-container']:nth-child(2)>label")
    public WebElement usertext;
    @FindBy(css="div[class='input-container']:nth-child(3)>label")
    public WebElement pintext;
    @FindBy(css="button[class='login-button']")
    public WebElement login;
    @FindBy(css="p[class='error-message-text']")
    public WebElement Text;
    @FindBy(css="div[class='input-container']:nth-child(3)>input")
    public WebElement InputPin;
    @FindBy(css="div[class='input-container']:nth-child(2)>input")
    public WebElement Inputuserid;
    @FindBy(css="img[class='ebank-logo']")
    public WebElement verfiyebank;
    @FindBy(css="h1[class='heading']")
    public WebElement flexibility;
    @FindBy(css="img[class*='digital']")
    public WebElement Card;
    @FindBy(css="button[class='logout-button']")
    public WebElement logout;
    public LoginPageTest(WebDriver driver) {
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
   public boolean visibleimage(){
        return isdiplayed.isDisplayed();
   }
   public String textuser(){
        return usertext.getText();
   }
   public String textpin(){
        return pintext.getText();
   }
   public void Loginbutton(){
        login.click();
   }
   public String Geterror(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[class='error-message-text']")));
        return Text.getText();
   }
   public void Enterpin(){
        InputPin.sendKeys("231225");
   }
   public void Enteruserid(){
        Inputuserid.sendKeys("142420");
   }
   public void ENTERUSERID(){
        Inputuserid.sendKeys("142420");
   }
   public void ENTERPINID(){
        InputPin.sendKeys("123456");
   }
   public void loginappliactionsuccesfully(){
        Inputuserid.sendKeys("142420");
        InputPin.sendKeys("231225");
        login.click();
   }
   public String gotourl(){
        String str1="https://qaebank.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(str1));
        return str1;
   }

    public boolean logo(){
        return verfiyebank.isDisplayed();
    }
    public String Verifyheading(){
        return flexibility.getText();
    }
    public boolean CARD(){
        return Card.isDisplayed();
    }
    public void logoutbutton(){
        logout.click();
    }
    public String verifyURl(){
        String str="https://qaebank.ccbp.tech/ebank/login";
        wait.until(ExpectedConditions.urlToBe(str));
        return str;
    }
}
