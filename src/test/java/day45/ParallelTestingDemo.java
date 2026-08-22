package day45;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParallelTestingDemo {
    WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    void setup(String br) throws InterruptedException {
        switch (br.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Invalid Browser");
                return;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //driver.manage().window().maximize();
        Thread.sleep(5000);
    }
    @Test(priority = 1)
    void testLogo(){
        boolean logoCheck = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
        Assert.assertEquals(logoCheck,true);
    }
    @Test(priority = 2)
    void testTitle(){
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }
    @Test(priority = 3)
    void testURL(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @AfterClass
    void tearDown(){
        driver.close();
    }
}
/*
parallel testing using xml file
-------------------
- Created test case
- Created xml file to run the test case (new thing added is parameter tag)
- Passed browser name parameter from xml file and received in setup() method
- Execute test case on chrome and firefox(serial execution by duplicating test and naming them different in xml file)
- Execute test case on chrome and firefox(parallel execution by adding parallel="tests in xml file)
 */