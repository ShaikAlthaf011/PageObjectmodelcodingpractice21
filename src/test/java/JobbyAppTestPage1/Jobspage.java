package JobbyAppTestPage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Jobspage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css="input[id='userNameInput']")
    public WebElement username;
    @FindBy(css="input[id='passwordInput']")
    public WebElement password;
    @FindBy(css="button[class='login-button']")
    public WebElement login;
    @FindBy(css="#root > div > div > div > a > button")
    public WebElement findjob;
    @FindBy(css="#root > div > div > div > div.profile-and-filters-container > div.profile-container > img")
    public WebElement visibileimage;
    @FindBy(css="h1[class='profile-name']")
    public WebElement Heading;
    @FindBy(css="p[class='short-bio']")
    public WebElement Description;
    @FindBy(css="#root > div > div > div > div.jobs-list-container > div > div > div > input")
    public WebElement Searchinput;
    @FindBy(css="div[class='desktop-search-bar']>div>div>button")
    public WebElement SearchText;
    @FindBy(css="ul[class='jobs-list']>a>li")
    public List<WebElement> list;
    @FindBy(css="img[class='jobs-not-found-img']")
    public WebElement image;
    @FindBy(css="h1[class*='jobs']")
    public WebElement Mainheading;
    @FindBy(css="p[class*='jobs']")
    public WebElement Paragraph;
    public Jobspage(WebDriver driver) {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
    public void LogintoApplication(){
        username.sendKeys("rahul");
        password.sendKeys("rahul@2021");
        login.click();
    }
    public String URL(){
        String str1="https://qajobbyapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(str1));
        return str1;
    }
    public void job(){
        findjob.click();
    }
    public boolean image(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > div > div > div > div.profile-and-filters-container > div.profile-container > img")));
        return visibileimage.isDisplayed();
    }
    public String HeadingText(){
        return Heading.getText();
    }
    public String DescriptionText(){
        return Description.getText();
    }
    public void Textsearch(String searchtext){
        Searchinput.sendKeys(searchtext);
    }
    public void clicksearchinput(){
        SearchText.click();
    }
    public int count(){
        return list.size();
    }
    public void textenter(){
        Searchinput.sendKeys("Netflix");
        SearchText.click();
    }
    public boolean Verifyimagevisibile(){
     wait.until(ExpectedConditions.visibilityOf(image));
     return image.isDisplayed();
    }
    public String  notheading(){
        return Mainheading.getText();
    }
    public String textparagraph(){
        return Paragraph.getText();
    }
}
