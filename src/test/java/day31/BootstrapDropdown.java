package day31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BootstrapDropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://davidstutz.github.io/bootstrap-multiselect/");
        driver.manage().window().maximize();

        //opens dropdown options
        driver.findElement(By.xpath("//span[@class=\"multiselect-selected-text\"]")).click();

        // Select single option
        //driver.findElement(By.xpath("//li[@title='Alaska']")).click(); //opens dropdown options

        // capture all options and find out size --> important
        // refer to this youtube video: https://www.youtube.com/watch?v=Ei9-O1p5E_4&t=2493s
        // 1-> find the xpath that represents all the elements in the dropdown
        //2-> save it in webelement list
        //3-> use .size() to find number of elements

        // printing options from dropdown
        //1-> create a for loop to iterate over the list of webelements in dropdown
        //2-> use option.getText() method inside sout statement to print list

        //select multiple options
        //1-> use same for loop to iterate over the list of webelement in dropdown
        //2-> if (option.getText().equals("you option 1") || option.getText().equals("you option 2") || option.getText().equals("you option 3"));
        //3-> option.click()







    }
}
