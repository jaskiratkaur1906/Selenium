package day34;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DatePickerDemoGeneralised {
    //selecting future date
    static void selectFutureDates(WebDriver driver, String year, String month, String date){
        while (true){
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText(); //actual month
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText(); //actual year
            if(currentMonth.equals(month) && currentYear.equals(year) ){
                break;
            }
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //next
            //driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //previous
        }
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

    //selecting future date
    static  void selectPastDates(WebDriver driver, String year, String month, String date){
        while (true){
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText(); //actual month
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText(); //actual year
            if(currentMonth.equals(month) && currentYear.equals(year) ){
                break;
            }
            //driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //next
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //previous
        }
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

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        //switch to frame
        driver.switchTo().frame(0);

        //Method1 : using sendKeys()
        //driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("04/05/2024"); //mm/yy/yyyy

        //Method2 : using datepicker element --> important
        //expected data
        //String year = "2027";
        //String month = "June";
        //String date = "19";

        driver.findElement(By.xpath("//input[@id='datepicker']")).click(); //open date picker

        selectFutureDates(driver,"2027", "June","19");
        //selectPastDates(driver, year,month,date);




    }
}
