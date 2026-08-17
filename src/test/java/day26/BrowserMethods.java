package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("login");
        Thread.sleep(5000);
        driver.quit();

    }
}
