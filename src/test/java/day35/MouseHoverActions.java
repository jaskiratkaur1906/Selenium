package day35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseHoverActions {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/hovers");
        driver.manage().window().maximize();

        WebElement img1 = driver.findElement(By.xpath("//div[@class='example']//div[1]//img[1]"));
        WebElement profileLink = driver.findElement(By.xpath("//div[@class='example']//div[1]//div[1]//a[1]"));

        Actions act = new Actions(driver); // always add driver as parameter here

        //Mouse Hover
        //act.moveToElement(img1).moveToElement(profileLink).click().build().perform();
        act.moveToElement(img1).moveToElement(profileLink).click().perform(); // perform also internally builds the action


    }
}
/*
4 Actions:
    - Mouse hover
    - Right click
    - Double click
    - Drag and Drop

Actions: pre-defined class provided in selenium
build() -> create an action
perform() -> complete an action (it is capable of both building an action and performing an action, therefore we can skip build())

Practice : https://dummy-tickets.com/
 */