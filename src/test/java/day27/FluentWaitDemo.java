package day27;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();

        // Fluent wait declaration
        Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(5))
                                .ignoring(NoSuchElementException.class);


        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        //Usage
        WebElement txtusername = mywait.until(new Function<WebDriver, WebElement>(){
            public WebElement apply(WebDriver driver){
                return driver.findElement(By.xpath("//input" + "[@placeholder='Username']"));
            }
        });

        txtusername.sendKeys("Admin");

        //driver.close();
    }

}

/*
    .pollingEvery(Duration.ofSeconds(5))
    this statement make fluent different from  explicit
    every 5 sec it will check the element
    and continue till 30 sec and keep ignoring the element not found exception

*/