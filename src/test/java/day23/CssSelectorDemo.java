package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorDemo {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.manage().window().maximize();

        //tag#id
        //You can skip tag name but hashtag must be there
        //driver.findElement(By.cssSelector("input#login1")).sendKeys("test");
        //driver.findElement(By.cssSelector("#login1")).sendKeys("test");

        //tag.className
        //Here also you can skip the tag name but . must be there
        //driver.findElement(By.cssSelector("input.email-input")).sendKeys("test2");
        //driver.findElement(By.cssSelector(".email-input")).sendKeys("test2");


        //tag[attribute="value"]
        //placeholder="Password"
        //boolean checkingInput = driver.findElement(By.cssSelector("input[value=\"Chrome\"]")).isDisplayed();
        //boolean checkingInput = driver.findElement(By.cssSelector("[value=\"Chrome\"]")).isDisplayed();
        //System.out.println(checkingImage);

        //tag.classname[attribute="value"]
        //boolean checkingEmailSection = driver.findElement(By.cssSelector("input.email-input[name=\"login\"]")).isDisplayed();
        //boolean checkingEmailSection = driver.findElement(By.cssSelector(".email-input[name=\"login\"]")).isDisplayed();
        //System.out.println(checkingEmailSection);


        //driver.quit();

    }
}
