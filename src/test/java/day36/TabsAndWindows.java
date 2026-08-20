package day36;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TabsAndWindows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions act = new Actions(driver);

        driver.get("https://testautomationpractice.blogspot.com/");

        //SELENIUM4.X ONWARD AVAILABLE
        //driver.switchTo().newWindow(WindowType.TAB);// OPENS NEW TAB
        driver.switchTo().newWindow(WindowType.WINDOW);// OPENS NEW WINDOW

        driver.get("https://www.google.com/");

    }
}
