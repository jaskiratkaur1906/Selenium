package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class getMethods {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        //get(url)
        driver.get("https://orangehrm.com/");
        driver.manage().window().maximize();

        //get title
        System.out.println(driver.getTitle());

        //getCurrentURL
        System.out.println(driver.getCurrentUrl());

        //getpageSource()
        //System.out.println(driver.getPageSource());

        //getWindowHandle()
        //String windowid = driver.getWindowHandle();
        //System.out.println("Window Id:"+ windowid);

        //getWindowHandles() --> for multiple windows
        //driver.findElement(By.linkText("Pricing")).click(); //this will open new window

        //Set<String> windowids= driver.getWindowHandles();
        //System.out.println(windowids);
        driver.get("https://orangehrm.com/");

        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get("https://orangehrm.com/pricing");

        Set<String> windowIds = driver.getWindowHandles();

        System.out.println(windowIds);




    }
}
