package day29;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//injecting user information (username and password) with url
public class AuthenticatedPopUp {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        //driver.get("https://the-internet.herokuapp.com/basic_auth");
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
