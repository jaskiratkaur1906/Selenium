package day36;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class KeyBoardActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();

        Actions act = new Actions(driver);

        driver.findElement(By.xpath("//textarea[@name='text1']")).sendKeys("WELCOME");

        //Ctrl+A - selects the text
        act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();

        //Ctrl+C - copy the text into clipboard
        act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();

        //TAB - shift to 2nd box
        act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

        //Ctrl+V - paste the same text
        act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

    }

}
/*

Ctrl+shift+A --> act.keyDown(keys.contrl).keyDown(keys.shift).sendkeys("A).keyup(keys.shift).keyup(keys.control).perform;
Enter --> act.keyDown(keys.ENTER).keyUp(keys.ENTER).perform();

 */
