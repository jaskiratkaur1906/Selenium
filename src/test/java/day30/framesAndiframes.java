package day30;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class framesAndiframes {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();

        //Frame1
        WebElement frame1 = driver.findElement(By.xpath("//frame[@src=\"frame_1.html\"]"));
        driver.switchTo().frame(frame1); //passes fram as a web element // switch to frame one
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("welcome");

        //go back to default page
        driver.switchTo().defaultContent();

        //Frame2
        WebElement frame2 = driver.findElement(By.xpath("//frame[@src=\"frame_2.html\"]"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Selenium");

        //go back to default page
        driver.switchTo().defaultContent();

        //Frame3
        WebElement frame3 = driver.findElement(By.xpath("//frame[@src=\"frame_3.html\"]"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Java");

        //inner iframe -- part of frame3
        driver.switchTo().frame(0); //switching to frame using index // index is zero because by default if page have only one frame it's index will be zero
        driver.findElement(By.xpath("//span[normalize-space()='I am a human']")).click();

        //go back to default page
        driver.switchTo().defaultContent();
    }
}

/*

        driver.switchTo().frame(name);
        driver.switchTo().frame(id);
        driver.switchTo().frame(Webelement);
        driver.switchTo().frame(index);

        driver.switchTo().defaultContent();

 */


/*
3 types of switching methods:

1) browser windows
    driver.switchTo().window(windowID/window handle)

2) alerts
    driver.switchTo().alert()
    driver.switchTo().accept()
    driver.switchTo().dismiss()

3) frames
    driver.switchTo().frame(id)
    .
    .
    .
 */