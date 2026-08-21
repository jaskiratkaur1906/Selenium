package day40;
/*
1- open app
2-test logo presence
3-login
4-close
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMTest {

    WebDriver driver;

    @Test(priority = 1)
    void openapp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    void testlogo() throws InterruptedException {
        Thread.sleep(3000);
        boolean logoCheck = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
        System.out.println("logo displayed .."+logoCheck);
    }

    @Test(priority =3)
    void login(){
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }

    @Test(priority = 4)
    void close(){
        driver.close();
    }
}

/*
- We can execute test cases using testng xml file
-Test XML file(2 ways):
    - generate automatically
    - manually

Test Suite ---> Test cases ---> Test Steps
xml file ---> classes ----> Test methods (this is how these both are related)

2 things achived through xml:
    - executed group of test cases as a 1 suite
    - we can generate testing reports (default)
 */
