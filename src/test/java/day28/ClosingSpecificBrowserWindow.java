package day28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class ClosingSpecificBrowserWindow {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.findElement((By.xpath("//a[normalize-space()='OrangeHRM, Inc']"))).click();
        Set<String> windowIds = driver.getWindowHandles();

        //will capture all the ids and print there titles
        for(String winID:windowIds)
        {
            String title= driver.switchTo().window(winID).getTitle();
            System.out.println(title);

            //now to close specific browser window
            if(title.equals("OrangeHRM") || title.equals("some other window to close multiple windows , but then you cannot use breah with or operator ")){
               driver.close();
               //break;
            }
        }
    }
}
