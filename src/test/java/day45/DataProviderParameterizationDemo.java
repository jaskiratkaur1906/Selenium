package day45;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderParameterizationDemo {
    WebDriver driver;
    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test(dataProvider = "dp")
    void testLogin(String email, String password) throws InterruptedException
    {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        boolean logoCheck = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).isDisplayed();
        if(logoCheck==true)
        {
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }
    @AfterClass
    void tearDown(){
        driver.close();
    }

    @DataProvider(name = "dp", indices = {0,1})
    Object[][] loginData(){
        Object data[][]={
                {"abc@gmail.com", "test1"},
                {"xyz@gmail.com", "test2"},
                {"jask@gmail.com", "test3"},
        };
        return data;
    }



}
/*
data provider method always return 2-dimensional array it can be of type String , object or anything required.
name attribute must be provided (useful to identify in case of multiple data provider)
indices can be used incase we do not want to pass all the testdata. we can specify which test data should be used to test the feature
indices does not specify the range but specify the rows
usually we define all the data providers in one single class, all having unique names
*/



/*
2 ways to pass parameters:
    1- @DataProvider Annotation (data driven testing)
    2- using xml file we can pass parameters to the test methods (parallel testing)
Both are very different
 */
