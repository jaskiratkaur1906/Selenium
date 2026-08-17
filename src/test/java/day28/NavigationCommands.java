package day28;

/*
navigate().to(url) --> similar to get command
navigate().back()
navigate().forward()
navigate().refresh()
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class NavigationCommands {
    public static void main(String[] args) throws MalformedURLException {
        WebDriver driver= new ChromeDriver();

        // accepts URL only in string format
        //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //URL myurl = new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //driver.navigate().to(myurl);
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.navigate().to("https://demoqa.com/checkbox");

        driver.navigate().back();
        System.out.println(driver.getCurrentUrl()); //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl()); //"https://demoqa.com/checkbox"

        driver.navigate().refresh();
    }
}

/*
diff bw navigate to and get method :
-> driver.get() ---> accepts URL in string format
-> drinver.navigate.to  ---> accepts URL in teh string format & URL object format
                        ---> internally calling get method only but get method only excepts string and not object?
                        ---> it will check/validate if it is in string or object format
                        ---> if it is string --> it will pass it in get method
                        ---> if it is object --> it will convert it in string format then pass it to get method
Functionality is same diff is just in parameters.
 */

