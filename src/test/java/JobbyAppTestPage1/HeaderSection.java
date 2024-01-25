package JobbyAppTestPage1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderSection {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css="input[id*='user']")
    public WebElement username;
    @FindBy(css="input[id*='password']")
    public WebElement password;
    @FindBy(css="button[class*='login']")
    public WebElement login;
    @FindBy(css="div[class='nav-bar-large-container']>a>img")
    public WebElement applogodisplayed;
    @FindBy(css="ul[class='nav-menu']>li:nth-child(2)")
    public WebElement ul;
    @FindBy(css="#root > div > nav > div > div.nav-bar-large-container > a > img")
    public WebElement logopageclick;
    @FindBy(css="#root > div > nav > div > div.nav-bar-large-container > ul > li:nth-child(1) > a")
    public WebElement Homelink;
    @FindBy(css="#root > div > nav > div > div.nav-bar-large-container > button")
    public WebElement logout;

    public HeaderSection(WebDriver driver) {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
    public void loginApplication(){
        username.sendKeys("rahul");
        password.sendKeys("rahul@2021");
        login.click();
    }
    public String url(){
        String str1="https://qajobbyapp.ccbp.tech/";
         wait.until(ExpectedConditions.urlToBe(str1));
         return str1;
    }
    public boolean image(){
        return applogodisplayed.isDisplayed();
    }
    public void jobs(){
        ul.click();
    }
    public void logoclick(){
        logopageclick.click();
    }

    public void clickhome(){
        Homelink.click();
    }
    public void LOGOUT(){
        logout.click();
     Alert ac=driver.switchTo().alert();
        ac.accept();
    }
}
