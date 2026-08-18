package day29;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 there are 3 types of pop up windows or alerts:
 1-> JS Alert (not a web elements)
 2-> JS Confirm (not a web elements)
 3-> JS Prompt
 */
public class AlertsPopUpDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        //Normal alert with ok button
        /*driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(5000);
        //driver.switchTo().alert().accept();
        Alert myalert = driver.switchTo().alert();
        System.out.println(myalert.getText());
        myalert.accept();
        */

        // confirmation Alert - OK & Cancel
        /*driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        //driver.switchTo().alert().accept(); //close alert using OK button
        driver.switchTo().alert().dismiss(); //close alert using cancel button
        */

        //Promt alert - input box
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert myalert = driver.switchTo().alert();
        myalert.sendKeys("Welcome");
        myalert.accept();




    }
}
