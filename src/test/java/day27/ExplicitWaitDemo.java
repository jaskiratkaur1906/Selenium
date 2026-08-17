package day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitDemo {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();

        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        //this condition makes it wait until this element is located
        //when until is true -> it will return the web element for us
        WebElement txtusername = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        txtusername.sendKeys("Admin");

        WebElement txtpassword = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
        txtpassword.sendKeys("admin123");

        WebElement loginbtn = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginbtn.click();
        // driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(("Admin")); //this statement is not needed

        //driver.close();
    }
}

/*
2 steps:
declaration
use
explicit wait -> it works on condition

adv of explicit wait :
1-> conditional based , it will work more effectively
2-> finding element is inclusive (for some conditions)
3->it will wait for condition to be true, then consider the time
4-> we need to write multiple statements for multiple elements

dis-adv  :
1-> if the time is not sufficient then you with get exception (hard coded time can cause this issue)

 */