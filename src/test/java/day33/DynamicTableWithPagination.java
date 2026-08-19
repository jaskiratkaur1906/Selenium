package day33;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DynamicTableWithPagination {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // not working ---> driver.get("https://demo.opencart.com/");

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
        driver.manage().window().maximize();

        //Login
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        //clicking on PIM
        driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();

        //https://www.youtube.com/watch?v=2P_4pacc9t0&list=PLUDwpEzHYYLtQzEEEldbjPAR-gnStv4sR&t=1063s

        //repeating pages
        for (int page = 1; page <= 4; page++) {
            // Find the page button
            WebElement pageButton = driver.findElement(By.xpath("//button[normalize-space()='" + page + "']"));
            pageButton.click();
            Thread.sleep(1000);
            System.out.println("========== PAGE " + page + " ==========");

            // Get all rows on this page
            List<WebElement> rows = driver.findElements(By.cssSelector(".oxd-table-body .oxd-table-row"));

            // Read each row
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.cssSelector(".oxd-table-cell"));
                for (WebElement cell : cells) {
                    System.out.print(cell.getText() + " | ");
                }
                System.out.println();
            }
        }



    }
}
