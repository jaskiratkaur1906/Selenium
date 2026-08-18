package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CheckboxsDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        //1) select specific checkbox
        //driver.findElement(By.xpath("//label[@for='sunday']")).click();

        //2) select all the checkboxs

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
        /*
        for(WebElement checkbox:checkboxes){
            checkbox.click();
        }
        */

        //3) selelct last 3 checkboxes
        //total no of checkboxes - how many checkboxes wat to select = starting index
        //7-3=4
        //for(int i =4; i<checkboxes.size(); i++){
        //    checkboxes.get(i).click();
        //}

        //4) select first 3 checkboxes
        //for(int i=0; i<3; i++){
        //    checkboxes.get(i).click();
        //}

        //5) unselect selected checkbox
        for (int i = 0; i <3 ; i++) {
            checkboxes.get(i).click();
        }

        Thread.sleep(5000);

        for (int i = 0; i < checkboxes.size(); i++) {
            if (checkboxes.get(i).isSelected()) {
               checkboxes.get(i).click();
            }
        }

    }
}
