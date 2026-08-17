package day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Thread.sleep
//1-> Implicit wait
//2->Explicit wait
public class SleepCommand {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        //Thread.sleep(3000); //without this you will get No such elemnet exception //this will pause the execution
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(("Admin"));

    }
}

//no such element exception---> element is not present on the page. Synchronisation issue
//elementnotfoundexception-->Locator is in-correct


/*

adv of sleep :
1-> easy to use

dis-adv of sleep :
1-> if the time is not sufficient then you with get exception
2-> it will wait for max time out, this will reduce performance script
3-> multiple times

therefore will not use it and avoid it since it is hardcodded time and cause poor performance
it is not selenium web driver method

 */