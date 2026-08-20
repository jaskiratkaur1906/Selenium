package day37;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ZoomInAndZoomOut {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        //Thread.sleep(3000);
        //driver.manage().window().minimize();
        //Thread.sleep(3000);
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '50%'");//set zoom level 50%
        Thread.sleep(3000);
        js.executeScript("document.body.style.zoom = '80%'");//set zoom level 80%
        Thread.sleep(3000);

    }
}
