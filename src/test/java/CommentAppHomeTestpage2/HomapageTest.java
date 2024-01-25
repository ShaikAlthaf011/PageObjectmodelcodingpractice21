package CommentAppHomeTestpage2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import CommentAppTestPage1.Loginpagetest;

import javax.xml.crypto.Data;

public class HomapageTest {
    WebDriver driver;
    Loginpagetest loginpagetest;
    int CommentData;
    public Object[][]Dataset={
            {"John","Innovative and interconnected systems."},
            {"Alice","Smart factories, improved efficiency."},
            {"Robert","AI-powered automation, limitless potential."},
            {"Harry","Data-driven decision-making, game-changer."},
            {"Bob","IoT revolutionizing daily life."}
    };
    @BeforeMethod
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        driver=new ChromeDriver();
        driver.navigate().to("https://qacommentsapp.ccbp.tech/");
        driver.manage().window().maximize();
        loginpagetest=new Loginpagetest(driver);
        CommentData=0;
    }
    @DataProvider
    public Object[][]addcomments(){
        return Dataset;
    }
    public void Addcommentdata(){
        for(Object[]Data:Dataset){
            String name=String.valueOf(Data[0]);
            String comment=String.valueOf(Data[1]);
            loginpagetest.loginapllication(name,comment);
            CommentData++;
        }
    }
    @Test(priority = 1)
    public void CommentsAppUI(){
        Assert.assertTrue(loginpagetest.Getimage(),"App image is not displayed");
        Assert.assertEquals(loginpagetest.Getheading(),"Comments","Heading text does not match");
        Assert.assertEquals(loginpagetest.GetDescription(),"Say something about 4.0 Technologies","Description text does not match");
        Assert.assertEquals(loginpagetest.zerocomment(),"0Comments","Comments count text does not match");
    }
    @Test(priority = 2)
    public void commentcounter(){
        for(Object[]Data:Dataset){
            String name=String.valueOf(Data[0]);
            String comment=String.valueOf(Data[1]);
            loginpagetest.loginapllication(name,comment);
            CommentData++;
            int actual=loginpagetest.getnumber();
            Assert.assertEquals(actual,CommentData,"Comments count do not match");
        }
    }

    @Test(priority = 3,dataProvider = "addcomments")
        public void Commentsinitial(String name,String comment){
        loginpagetest.loginapllication(name,comment);
        int actual= loginpagetest.getchar();
        Assert.assertEquals(actual,name.charAt(0),"Initial do not match");
        }
   @Test(priority = 4)
   public void Commentorder(){
        Addcommentdata();
        for(int i=0;i<Dataset.length;i++){
            Object Data[] = Dataset[i];
            String name=String.valueOf(Data[0]);
            String comment=String.valueOf(Data[1]);
            Assert.assertEquals(loginpagetest.getusername(i),name,"Order does not match");
            Assert.assertEquals(loginpagetest.getcomment(i),comment,"Comment does not correspond to the username");
        }
   }
   @Test(priority = 5)
   public void Likes(){
        Addcommentdata();
        int likescount=0;
        for(int i=0;i<Dataset.length;i++){
            loginpagetest.getlike(i);
             likescount++;
        }
   }
   @Test(priority = 6)
   public void Deletefuncationallity(){
        Addcommentdata();
        for(int i=0;i<Dataset.length;i++){
            loginpagetest.getdelete();
        }
   }

    @AfterMethod
    public void Closebrowser(){
        driver.quit();
    }
}
