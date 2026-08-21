package day39;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinksHandler {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total no of links " + links.size());
        int noOfBrokenLinks = 0;
        for(WebElement linkElement:links) {
            String hrefAttValue = linkElement.getAttribute("href");
            if (hrefAttValue == null || hrefAttValue.isEmpty()) {
                System.out.println(" href attribute value is null or empty. So not possible to check");
                continue;
            }
            // hit url to server
            try{
                URL linkURL = new URL(hrefAttValue); //convert string type url to URL type
                HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection(); //open connection to the server
                conn.connect(); // connect to server and sent request the server

                if (conn.getResponseCode() >= 400) {
                    System.out.println("Broken link  ====>" +  hrefAttValue);
                    noOfBrokenLinks++;

                } else {
                    System.out.println(" Not a broken link ====>" +hrefAttValue);
                }
            }
            catch (Exception e){

            }
        }
        System.out.println("Number of Broken Links"+ noOfBrokenLinks); //42
    }
}
/*
3 conditions to verify if link is broken or not:
- Link should have --> href ="https://xyz.com"
- capture url and hit it to the server , then get status code
    url ---> server ---> status code
- Status code>=400 ---> broken link
    Status code<400 ---> not a broken link

What is a broken link?
A link which does not have resources in server
 */