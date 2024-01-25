package CommentAppTestPage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Loginpagetest {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css="#root > div > div > div > img")
    public WebElement imagevisible;
    @FindBy(css="h1[class='app-heading']")
    public WebElement Heading;
    @FindBy(css="p[class='form-description']")
    public WebElement Description;
    @FindBy(css="p[class='heading']")
    public WebElement comments0;
    @FindBy(css="input[class='name-input']")
    public WebElement inputEl;
    @FindBy(css="textarea[class='comment-input']")
    public WebElement commentEl;
    @FindBy(css="button[class='add-button']")
    public WebElement addel;
    @FindBy(css="span[class='comments-count']")
    public WebElement Count;
    @FindBy(css="p[class='initial']")
    public WebElement Character;
    @FindBy(css="p[class='username']")
    public List<WebElement> UsernameEl;
    @FindBy(css="p[class='comment']")
    public List<WebElement> CommentEl;
    @FindBy(css="div[class='buttons-container']>div>button")
    public List<WebElement>likesbutton;
    @FindBy(css="#root > div > div > ul > li:nth-child(1) > div.buttons-container > button > img")
    public List<WebElement>delete;
    public  Loginpagetest(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
    public boolean Getimage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > div > div > div > img")));
        return imagevisible.isDisplayed();
    }
    public String Getheading(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[class='app-heading']")));
        return Heading.getText();
    }
    public String GetDescription(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[class='form-description']")));
        return Description.getText();
    }
    public String zerocomment(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[class='heading']")));
        return comments0.getText();
    }
    public void Entername(String name){
        inputEl.sendKeys(name);
    }
    public void Entercomment(String comment){
        commentEl.sendKeys(comment);
    }
    public void clickadd(){
        addel.click();
    }
 public void loginapllication(String name,String comment){
        Entername(name);
        Entercomment(comment);
       clickadd();
 }
 public int  getnumber(){
        return Integer.parseInt(Count.getText());
 }
  public char getchar(){
        return Character.getText().charAt(0);
  }

public String getusername(int index){
        return UsernameEl.get(index).getText();
}
public String getcomment(int index){
        return CommentEl.get(index).getText();
}

public void getlike(int index){
likesbutton.get(index).click();
}
public int getdelete(){
        delete.get(0).click();
        return 0;
}
}
