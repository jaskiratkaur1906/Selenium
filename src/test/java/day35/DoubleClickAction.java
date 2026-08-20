package day35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DoubleClickAction {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.w3schools.com/TAgs/tryit.asp?filename=tryhtml5_ev_ondblclick3");
        driver.manage().window().maximize();

        //got all three xpath together from selector hub feature
        //input[@id='field1']
        //input[@id='field2']
        //button[normalize-space()='Copy Text']

        //switch to frame
        driver.switchTo().frame("iframeResult");

        WebElement box1 = driver.findElement(By.xpath("//input[@id='field1']"));
        WebElement box2 = driver.findElement(By.xpath("//input[@id='field2']"));
        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

        //clear box1
        box1.clear();
        //send input
        box1.sendKeys("Welcome");

        //Double click action on button
        Actions act = new Actions(driver);
        act.doubleClick(button).perform();

        //Verify if same text copied in the second box
        //String text = box2.getText();
        //System.out.println("captured value is :"+ text); // nothing is capture
        String text = box2.getAttribute("value");
        System.out.println("captured value is :"+ text); // this works because welcome was stored in value attribute

        if(text.equals("Welcome")){
            System.out.println("text copied...");
        } else{
            System.out.println("not copied properly...");
        }
    }
}

/*

get text is not working because it always gets inner text of the field but it is empty

diff bw getText() and getAttribute(attribute):
    eg- <input id = "xyz" > welcome </input>
        - getText() --> returns the inner text ---> welcome
        - getAttribute("id) --> returns teh value of attribute --->xyz
    eg- <input value = "welcome" </input>
        -getAttribute("value") ---> welcome



 */