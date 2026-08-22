package day46;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

//@Listeners(day46.MyListeners.class)//we will have to add this line in every class therefore it is recommened to write listener tag in xml file instead (just once)
public class TestNGListenersDemo {
    WebDriver driver;

    @BeforeClass
    void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }
    @Test(priority = 1)
    void testLogo(){
        boolean logoCheck = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
        Assert.assertEquals(logoCheck,true);
    }

    @Test(priority = 2)
    void testURL(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login/DEMO");
    }

    @Test(priority = 3, dependsOnMethods = "testURL")
    void testTitle(){
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }
    @AfterClass
    void tearDown(){
        driver.close();
    }
}
/*
TestNG Listeners
------------------
- create test case
- create listener class
-create xml file and include both test case and listener class
 */

/*
2 ways to implements listener class:
----------------------------
Method 1
--------
class my Listener implements ITestListener
{
    //here also we have to write impementation of the methods
}
Method 2
--------
class myListener extends TestListenerAdapter
{
    //implementation of methods already exists
    //Even though you extend all methods from TestListenerAdapter to myListener , we will have to
    override those methods according to our own requirement , we have to modify them
}

---> we will use one listener class for all the test classes because main purpose of listener is to generate report,
and we want it to be consistent and one report for all the test. we do not want to maintain multiple reports for all the test
 */