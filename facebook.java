package Project_Sel;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class facebook {
    WebDriver fb;
    String url = "https://www.facebook.com/";

    @BeforeTest
    public void setUp(){
        fb = new ChromeDriver();
        fb.get(url);
        //Maximize the window
        fb.manage().window().maximize();
        // Using Implicit wait
        fb.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        String str = fb.getCurrentUrl();
        System.out.println("The current url is " + str);

    }
    @AfterTest
    public void tearDown(){
        fb.close();

    }
    @Test
    public void test1() throws InterruptedException {
        fb.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //Sending FirstName
        fb.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']")).sendKeys("Lokesh");
        Thread.sleep(2000);
        //Sending LastName
        fb.findElement(By.name("lastname")).sendKeys("Dhara");
        //Sending Email
        fb.findElement(By.name("reg_email__")).sendKeys("testuser@grttest.com");
        //Re-entering Email
        fb.findElement(By.name("reg_email_confirmation__")).sendKeys("testuser@grttest.com");
        //Sending password
        fb.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Lokki@0412");
        //Using dropdown
        //Day
        WebElement dd = fb.findElement(By.xpath("//select[@id='day']"));
        Select dropDown = new Select(dd);
        dropDown.selectByVisibleText("11");
        Thread.sleep(2000);

        //Month
        WebElement dd1 = fb.findElement(By.xpath("//select[@id='month']"));
        Select dropDown1 = new Select(dd1);
        dropDown1.selectByIndex(4);
        Thread.sleep(2000);

        //Year
        WebElement dd2 = fb.findElement(By.xpath("//select[@id='year']"));
        Select dropDown3 = new Select(dd2);
        dropDown3.selectByVisibleText("1985");
        Thread.sleep(2000);

        //Selecting the gender
       WebElement element = fb.findElement(By.xpath("//input[@value='2']"));
       element.click();

       //Click on sign up button
        fb.findElement(By.xpath("//button[@class='_6j mvm _6wk _6wl _58mi _3ma _6o _6v']")).click();

        //Verify your email
        String str = fb.findElement(By.xpath("//span[@class='x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lliihq x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x x14z4hjw x3x7a5m xngnso2 x1qb5hxa x1xlr1w8 xzsf02u x1yc453h']")).getText();
        Assert.assertEquals(str, "We need more information");
        System.out.println(str);
    }
}
