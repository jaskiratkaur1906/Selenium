package day36;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class SliderDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions act = new Actions(driver);

        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();

        //min slider
        WebElement minSlider = driver.findElement(By.xpath("//span[1]"));
        minSlider.getLocation();
        System.out.println(minSlider.getLocation()); //(59, 249)-->(x,y)
        act.dragAndDropBy(minSlider,100,0).perform();
        System.out.println(minSlider.getLocation()); //(158, 249)-->(x,y)

        //max slider
        WebElement maxSlider = driver.findElement(By.xpath("//span[2]"));
        maxSlider.getLocation();
        System.out.println(maxSlider.getLocation()); //(510, 249)-->(x,y)
        act.dragAndDropBy(maxSlider,-100,0).perform();
        System.out.println(maxSlider.getLocation()); //(411, 249)-->(x,y)

    }
}

/*
dragAndDropBy(Element, x , y)
 */