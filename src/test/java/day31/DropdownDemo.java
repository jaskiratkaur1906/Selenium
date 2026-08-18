package day31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;


//Select dropdown (using Select class)
public class DropdownDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement dropdownElement= driver.findElement(By.xpath("//select[@id='country']"));
        Select dropdown = new Select(dropdownElement);

        //select option from the dropdown(3 methods)
        //dropdown.selectByVisibleText("France");
        //dropdown.selectByValue("japan");
        //dropdown.selectByIndex(2); //you have to count this manually (0 is starting index)

        //capture the options from the dropdown
        // no need to find a common locator or xpath for it
        // it can be done using getoptions() method
        // this method returns options from thr dropdown as a webelement
        List<WebElement> options  = dropdown.getOptions();
        System.out.println("Number of options in the dropdown: "+ options.size());

        //printing the options
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }
        //enhanced for loop
        for(WebElement op: options){
            System.out.println(op.getText());
        }

    }
}

/*
Types of dropdowns:
1- Select dropdown (this file)
2- Bootstrap dropdown
3- hidden dropdown
 */

/*
every option is a web element
 */