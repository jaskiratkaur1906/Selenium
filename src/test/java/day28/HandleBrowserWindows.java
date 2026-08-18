package day28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.findElement((By.xpath("//a[normalize-space()='OrangeHRM, Inc']"))).click();
        Set<String> windowIds = driver.getWindowHandles();

        //Approach1 (for 2-3 browser windows)
        /*List<String> windowList = new ArrayList(windowIds);
        String parentID= windowList.get(0);
        String childID = windowList.get(1);

        System.out.println(driver.getTitle()); // will give title of parent window even though it is on child window

        //switch to child window
        driver.switchTo().window(childID);
        System.out.println(driver.getTitle());

        //switch back to parent window
        driver.switchTo().window(parentID);
        System.out.println(driver.getTitle());
        */

        //Approach2 (for multiple window ids)
        for(String winID: windowIds ){
            String title = driver.switchTo().window(winID).getTitle();
            if(title.equals("OrangeHRM")){
                System.out.println(driver.getCurrentUrl());
                //some validations on the parent window
            }

        }




    }
}
