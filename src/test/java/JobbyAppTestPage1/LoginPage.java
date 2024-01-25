package JobbyAppTestPage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css="img[class='login-website-logo']")
    public WebElement isdisplayed;
    @FindBy(css="div[class='input-container']:nth-child(2)>label")
    public WebElement usertext;
    @FindBy(css="div[class='input-container']:nth-child(3)>label")
    public WebElement passwordtext;
    @FindBy(css="button[class='login-button']")
    public WebElement Login;
    @FindBy(css="p[class*='error']")
    public WebElement errormessage;
    @FindBy(css="#passwordInput")
    public WebElement Enterpassword;
    @FindBy(css="#userNameInput")
    public WebElement EnterInput;
  public LoginPage(WebDriver driver){
      this.driver=driver;
      this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
      PageFactory.initElements(driver,this);
  }
  public boolean visibleimage(){
      return isdisplayed.isDisplayed();
  }
  public String Getuser(){
      return usertext.getText();
  }
  public String Getpassword(){
      return passwordtext.getText();
  }
  public void Clickonbutton(){
      Login.click();
  }
  public String Getmessage(){
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[class*='error']")));
      return errormessage.getText();
  }
  public void PASSWORD(){
      Enterpassword.sendKeys("rahul@2021");
  }
  public void USERNAME(){
      EnterInput.sendKeys("rahul");
  }
  public void Wrongcredentail(){
      EnterInput.sendKeys("rahul");
      Enterpassword.sendKeys("rahul");
      Login.click();
  }
public void Sucessfullylogin(){
      EnterInput.sendKeys("rahul");
      Enterpassword.sendKeys("rahul@2021");
      Login.click();
}
public String url(){
      String str="https://qajobbyapp.ccbp.tech/";
      wait.until(ExpectedConditions.urlToBe(str));
      return str;
}
}
