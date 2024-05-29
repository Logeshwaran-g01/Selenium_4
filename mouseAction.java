package Project_Sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class mouseAction {
    WebDriver driver;
    String url = "https://jqueryui.com/droppable/";

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


    }


    @Test
    public void test1() throws InterruptedException {
        //switching to frame
        driver.switchTo().frame(0);
        //Dragging the element
        WebElement source = driver.findElement(By.id("draggable"));
        //Dropping the element
        WebElement target = driver.findElement(By.id("droppable"));
        //Actions class creations
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
        String str = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText();
        Assert.assertEquals(str, "Dropped!");
        System.out.println(str);

    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }

}
