package day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicitWaitDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit//max time should be 10 sec not more

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(("Admin"));

    }
}

/*



adv of implicit wait :
1-> single time/ one statement
2-> it will not wait till maximum time if the element is available (major diff bw sleep and implicit)
3-> Applicable for all the elements(default wait time is 0)
4-> easy  to use

dis-adv of sleep :
1-> if the time is not sufficient then you with get exception (hard coded time can cause this issue)

 */