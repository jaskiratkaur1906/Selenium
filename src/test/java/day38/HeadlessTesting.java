package day38;
/*
Test case:
1)launch browser(chrome)
2)open url https://demo.opencart.com/
3)validate title should be "your store"
4)close browser
 */

//Headless - execution is done in backend
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class HeadlessTesting {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();

        //for adding extention to browser during runtime
        //File file = new File("C:\\Users\\15147\\Downloads\\uBlock.crx");
        //options.addExtensions(file);

        //for headless implementation
        options.addArguments("--headless=new"); //setting for headless mode of execution

        // 1)Launch browser
        WebDriver driver= new ChromeDriver(options); //add options as argument here for headless execution
        //driver.get("https://text-compare.com/");

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
        //driver.close();



    }
}
/*
Use of ChromeOptions:
1- Headless testing using ChromeOptions
2- SSL Handling (Privacy error) using ChromeOptions
    - options.setAcceptInsecureCerts(true) // accepts SSL certificates
3- To remove "Chrome is being controlled by automated test software"
    - options.setExperimentalOptions("excludeSwitches", new String[] {"enable-automation"});
4- To run the test in incognito mode
    - options.addArguments("--incognito");
5- To enable extensions in browser during runtime(4 steps):
    - step1 : Add CRX Extractor/Downloader to Chrome Browser (manually)
    - step2 : Add selectorsHub pugin to Chrome browser (manually)
    - step3 : Capture crx file for selectorHub extention
    - step4 : pass crx file path in automation script in chrome options

Adv of Headless testing:
1- we can do multiple tasks(since execution happened backend)
2- faster execution

DisAdv of Headless testing:
1- user cannot see the actions on the page. So he cannot understand flow/functionality of the test.




 */