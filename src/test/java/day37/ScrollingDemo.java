package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ScrollingDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //1) scroll down page by pixel number
        //js.executeScript("window.scrollBy(0,1500)","");
        //System.out.println(js.executeScript("return window.pageYOffset;")); //1500 //to check how many pixel it have move

        //2) scroll till element is visible
        //WebElement element = driver.findElement(By.xpath("//h2[normalize-space()='Static Web Table']"));
        //System.out.println(element.getText());
        //js.executeScript("arguments[0].scrollIntoView();",element);
        //System.out.println(js.executeScript("return window.pageYOffset;")); //1874.6666259765625

        //3) scroll till end of document
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        System.out.println(js.executeScript("return window.pageYOffset;")); //3421.333251953125
        Thread.sleep(3000);
        //scrolling upto initial position
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

    }
}

/*

Scroll bar is not a web element
 */