package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement inputbox = driver.findElement(By.xpath("//input[@id='name']"));

        //passing the text into input -- alternative of sendKeys()
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value', 'John')", inputbox);

        //clicking on element -- alternative of click()
        WebElement radiobtn = driver.findElement(By.xpath("//input[@id='male']"));
        js.executeScript("arguments[0].click()", radiobtn);

    }
}
/*

--> all the methods like .click, .sendkeys , (Action methods) , Webelement Methods etc all execute a javascript script. but sometime these methods don't work and cause 'element intercepted exception'.
Therefore, we can use executeScript() method directly to execute these scripts

-->  executeScript() - we can execute JavaScript statements directly in Webdriver script

 */