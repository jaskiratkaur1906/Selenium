package day34;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DatePickerDemo2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        //expected data
        String year = "2027";
        String month = "Jun";
        String date = "19";
        driver.findElement(By.xpath("//input[@id='txtDate']")).click(); //open date picker 2

        //select year
        WebElement yearDropdown = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText(year);

        //select month
        WebElement monthDropdown = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText(month);
        //String currentMonth = driver.findElement(By.xpath("//select[@aria-label='Select month']")).getText();

        //get all dates first and save in list
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td/a"));
        //then compare with expected date
        for(WebElement dt:allDates){
            if(dt.getText().equals(date)){
                dt.click();
                break;
            }
        }
    }
}

// practice : https://dummy-tickets.com/
