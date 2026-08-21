package day39;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShadowDOMHandler {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://dev.automationtesting.in/shadow-dom");
        driver.manage().window().maximize();

    }
}
/*
xpath cannot handle shadow dom elements

only css selector can handle shadow dom elements

shadow host --> shadow root(shadow host --> shadow root --> shadow element)

//1)This Element is inside single shadow DOM.
SearchContext shadow = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot(); //shadow = s_host.s_root
Thread.sleep(1000);
shadow.findElement(By.cssSelector("#shadow-element")); //shadow.element // this is how we extracted element

//2)This Element is inside 2 nested shadow DOM.
String cssSelectorForHost1 = "#shadow-root";
String cssSelectorForHost2 = "#inner-shadow-dom";
Thread.sleep(1000);
SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
Thread.sleep(1000);
SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
Thread.sleep(1000);
shadow1.findElement(By.cssSelector("#nested-shadow-element"));

//3) This Element is inside 3 nested shadow DOM.
String cssSelectorForHost1 = "#shadow-root";
String cssSelectorForHost2 = "#inner-shadow-dom";
String cssSelectorForHost3 = "#nested-shadow-dom";
Thread.sleep(1000);
SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
Thread.sleep(1000);
SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
Thread.sleep(1000);
SearchContext shadow2 = shadow1.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
Thread.sleep(1000);
shadow2.findElement(By.cssSelector("#multi-nested-shadow-element"));

-----------------------------------------------------------------------

Example 2 :
https://stackoverflow.com/questions/74761830/how-to-automate-access-nested-shadow-dom-elements-using-selenium-python
 */