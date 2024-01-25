package JobbyAppTestPage1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css="input[id='userNameInput']")
    public WebElement username;
    @FindBy(css="input[id='passwordInput']")
    public WebElement password;
    @FindBy(css="button[class='login-button']")
    public WebElement login;
    @FindBy(css="h1[class='home-heading']")
    public WebElement Heading;
    @FindBy(css="p[class*='description']")
    public WebElement Description;
    @FindBy(css="#root > div > div > div > a > button")
    public WebElement button;

    public HomePage(WebDriver driver) {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
public void logintiAppliocation(){
        username.sendKeys("rahul");
        password.sendKeys("rahul@2021");
        login.click();
}
public String Returnurl(){
        String str="https://qajobbyapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(str));
        return str;
}
public String headingtext(){
        return Heading.getText();
}
public String descriptiontext(){
        return Description.getText();
}
public void findjob(){
        button.click();
}
public String url(){
        String str1="https://qajobbyapp.ccbp.tech/jobs";
        wait.until(ExpectedConditions.urlToBe(str1));
        return str1;
}
}
