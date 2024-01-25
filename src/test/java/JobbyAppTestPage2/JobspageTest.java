package JobbyAppTestPage2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import JobbyAppTestPage1.Jobspage;

import java.lang.module.FindException;

public class JobspageTest {
    WebDriver driver;
    Jobspage jobspage;
    public Object[][] Dataset={
            {"Devops Engineer","9"},
            {"Backend Engineer","11"},
            {"Frontend Engineer","13"},
            {"Fullstack Developer","6"},
            {"Data Scientist","11"},
            {"ML Engineer","10"},
    };
    @BeforeMethod
    public void Openbrowser(){
      System.setProperty("webdriver.chrome.driver","C://chromedriver.exe") ;
      driver=new ChromeDriver();
      driver.navigate().to("https://qajobbyapp.ccbp.tech/login");
      driver.manage().window().maximize();
      jobspage=new Jobspage(driver);
    }
    @DataProvider
    public Object[][]Addlist(){
        return Dataset;
    }
    @Test(priority=1)
    public void ProfilecontainerUi(){
    jobspage.LogintoApplication();
    jobspage.URL();
    jobspage.job();
    jobspage.image();
    Assert.assertEquals(jobspage.HeadingText(),"Rahul Attluri","Profile name does not match");
    Assert.assertEquals(jobspage.DescriptionText(),"Lead Software Developer and AI-ML expert","Bio does not match");
    }
    @Test(priority = 2,dataProvider = "Addlist")
    public void SucessfullSearch(String searchtext,String Number) throws InterruptedException {
        jobspage.LogintoApplication();
        jobspage.URL();
        jobspage.job();
        jobspage.Textsearch(searchtext);
        jobspage.clicksearchinput();
        Thread.sleep(1000);
        Assert.assertEquals(jobspage.count(),Integer.parseInt(Number),"Jobs count does not match");
    }
    @Test(priority = 3)
    public void UnSuccesfullSearch() {
        jobspage.LogintoApplication();
        jobspage.URL();
        jobspage.job();
        jobspage.textenter();
        Assert.assertTrue(jobspage.Verifyimagevisibile(),"Jobs not found image is not displayed");
        Assert.assertEquals(jobspage.notheading(),"No Jobs Found","Jobs not found heading does not match");
        Assert.assertEquals(jobspage.textparagraph(),"We could not find any jobs. Try other filters.");
    }
    @AfterMethod
    public void CloseBrowser(){
       driver.quit();
    }
}
