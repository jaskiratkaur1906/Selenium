package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static java.lang.Thread.sleep;

public class LocatorsDemo {
    public static void main(String[] args){
        WebDriver driver= new ChromeDriver();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.manage().window().maximize();
        //Thread.sleep(3000);
        //Locator id
        //WebElement login = driver.findElement(By.id("login1"));
        //login.sendKeys("admin");

        //Locator names
        //boolean processButtonDisplayStatus = driver.findElement(By.name("proceed")).isDisplayed();
        //System.out.println(processButtonDisplayStatus);

        //Linktext
        //driver.findElement(By.linkText("Home")).click();
        //driver.findElement(By.linkText("BusinessEmail")).click();

        //Partial LinkText
        //driver.findElement(By.partialLinkText("Ho")).click();
        //driver.findElement(By.partialLinkText("Email")).click();

        //Class and tagname are used whenever we need to capture group of element
        //I want to capture all header links in the page

        //className
        //List<WebElement> ImagesLinks= driver.findElements(By.className("imgthumb"));
        //System.out.println(ImagesLinks.size());

        //tagName
        //List<WebElement> NoOfAllLinks= driver.findElements(By.tagName("a"));
        //System.out.println("Number of all links " +NoOfAllLinks.size());

        List<WebElement> NoOfAllImages= driver.findElements(By.tagName("img"));
        System.out.println("Number of all images " +NoOfAllImages.size());

        driver.quit();




    }
}
