package day36;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OpeenLinkInNewTab {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions act = new Actions(driver);

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement OpenThisLink = driver.findElement(By.xpath("//a[normalize-space()='Udemy Courses']"));
        act.keyDown(Keys.CONTROL).click(OpenThisLink).keyUp(Keys.CONTROL).perform(); //here click id from actions class that takes parameter. click from webelement do not accept any parameter

        //switching driver to another page
        //we need window ids for it
        //Set<String> ids = driver.getWindowHandles(); // we need to convert it into List to access the ids since indexing is not present in set
        //we can pass thin in ArrayList
        List<String> ids = new ArrayList(driver.getWindowHandles());
        //ids.get(1)
        driver.switchTo().window(ids.get(1)); //switch to other page

        //now do some actions in new page
        System.out.println(driver.getTitle());

        //now to swtich back to og page
        driver.switchTo().window(ids.get(0));
        System.out.println(driver.getTitle());
    }
}
