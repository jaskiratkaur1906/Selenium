package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        //driver.get("https://orangehrm.com/");
        //driver.get("https://demo.nopcommerce.com/register");
        //driver.manage().window().maximize();

        //is Displayed
        //WebElement logo = driver.findElement(By.xpath("//img[@src='/public/_resources/themes/orangehrm/dist/images/OrangeHRM_Logo.svg']"));
        //System.out.println(logo.isDisplayed());

        //is enabled
        driver.get("https://demoqa.com/radio-button");
        //boolean status= driver.findElement(By.xpath("//span[@class='rc-tree-title']")).isEnabled();
        //System.out.println("status is "+status);

        // is selected
        WebElement yesRadio = driver.findElement(By.id("yesRadio"));

        System.out.println("Before: " + yesRadio.isSelected());
        System.out.println("Before: " + yesRadio.isEnabled());


        yesRadio.click();

        System.out.println("After: " + yesRadio.isSelected());
        System.out.println("After: " + yesRadio.isEnabled());



    }
}
