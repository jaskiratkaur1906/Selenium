package day21;
/*
Test case:
1)launch browser(chrome)
2)open url https://demo.opencart.com/
3)validate title should be "your store"
4)close browser
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {
    public static void main(String[] args) {
        // 1)Launch browser
        //ChromeDriver driver = new ChromeDriver(); or both are correct
        WebDriver driver= new ChromeDriver(); //but this is prefered

        //2)open url https://demo.opencart.com/(bot issue.....not working)
        driver.get("https://www.saucedemo.com/");

        //3)validate title should be "your store"
        String actual_title= driver.getTitle();
        if(actual_title.equals("Swag Labs")){
            System.out.println("Test passed");
        }
        else{
            System.out.println("Test Failed");
        }

        //4)close browser
        driver.close();

    }
}
