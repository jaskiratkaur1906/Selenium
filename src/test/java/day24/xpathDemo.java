package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathDemo {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.manage().window().maximize();

        //xpath with single attribute
        //driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("login");

        //xpath with multiple attribute
        //driver.findElement(By.xpath("//input[@id='login1'][@class=\"email-input\"]")).sendKeys("login");

        //xpath with and or operator
        //driver.findElement(By.xpath("//input[@id='login1' or @class=\"email-input\"]")).sendKeys("login");
        //driver.findElement(By.xpath("//input[@id='login1' and @class=\"email-input\"]")).sendKeys("login");

        //xpath with inner text-- text()
        //boolean selected = driver.findElement((By.xpath("//*[text()='Sign in']"))).isDisplayed();
        //boolean selected = driver.findElement((By.xpath("//h2[text()='Sign in']"))).isDisplayed();
        //System.out.println(selected);
        //String textIs = driver.findElement(By.xpath("//h2[text()='Sign in']")).getText();
        //System.out.println(textIs);

        //xpath with contains()
        //driver.findElement(By.xpath("//input[contains(@class, \"email-input\")]")).sendKeys("login");

        //xpath with starts-with()
        //driver.findElement(By.xpath("//input[starts-with(@class, 'email-in')]")).sendKeys("admin");

        //chained xpath --> mix of both absolute and relative xpath
        //boolean selected = driver.findElement((By.xpath("//div[@class='top-bar']/div/img"))).isDisplayed();
        //System.out.println(selected);
        //boolean selected = driver.findElement(By.cssSelector("img[title='rediffmail']")).isDisplayed();

        //System.out.println(selected);

        //driver.close();
    }
}
