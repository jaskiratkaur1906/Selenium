package day38;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

public class ScreenshotDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        //1- capture full page (using TakesScreenshot interface)
        /*TakesScreenshot ts = (TakesScreenshot) driver;
        File sourseFile = ts.getScreenshotAs(OutputType.FILE); // here we do not know where the screenshot is saved , therefore we will copy it to target file
        File targetFile = new File("C:\\Users\\15147\\IdeaProjects\\Selenium\\screenshots\\fullpage.png"); //here we have to specify where we want to save file in project
        sourseFile.renameTo(targetFile); //copy source file to target file
        // HERE WE ARE CALLING getScreenshotAs FROM TakesScreenshot
         */

        //2- capture screenshot of specific section
        /*WebElement StaticTableScr= driver.findElement(By.xpath("//div[@id='HTML1']"));
        File sourceFile = StaticTableScr.getScreenshotAs(OutputType.FILE); // here we do not know where the screenshot is saved , therefore we will copy it to target file
        File targetFile = new File("C:\\Users\\15147\\IdeaProjects\\Selenium\\screenshots\\staticWebTable.png"); //here we have to specify where we want to save file in project
        sourceFile.renameTo(targetFile); //copy source file to target file
        //HERE WE ARE CALLING getScreenshotAs FROM WEB ELEMENT
        */


        //3 - capture screenshot of specific elemenet
        WebElement logo = driver.findElement(By.xpath("//h1[normalize-space()='Automation Testing Practice']"));
        File sourceFile = logo.getScreenshotAs(OutputType.FILE); // here we do not know where the screenshot is saved , therefore we will copy it to target file
        File targetFile = new File("C:\\Users\\15147\\IdeaProjects\\Selenium\\screenshots\\logo.png"); //here we have to specify where we want to save file in project
        sourceFile.renameTo(targetFile); //copy source file to target file

        driver.quit();
    }
}

/*
how to capture scr:
1- full page
2-specific area of page
3-web elemenet
 */