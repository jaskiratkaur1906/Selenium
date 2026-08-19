package day32;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

//static table
public class WebTablesDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // find total no of rows (2 methods)
        //Method 1
         int rows = driver.findElements(By.xpath("//table[@name = 'BookTable']//tr")).size();
        //System.out.println(rows); //7
        //Method 2
        //int rows = driver.findElements(By.tagName("tr")).size();
        //System.out.println(rows); //19 //because there are other tables and they might have tag tr // therefor if single table use this method ow use exact path as in method 1

        //find no of col
        int col = driver.findElements(By.xpath("//table[@name = 'BookTable']//th")).size();
        //int col = driver.findElements(By.tagName("th")).size(); //multiple tables
        //System.out.println(col);

        //read data from specific row and column(ex: 5th row 1st col)
        String bookname = driver.findElement(By.xpath("//table[@name = 'BookTable']//tr[5]//td[1]")).getText();
        //System.out.println(bookname);

        //read data from all rows and columns (i = row, j= col)
        for (int i = 2; i <= rows ; i++) {
            for (int j = 1; j <= col ; j++) {
                //syntax to pass parameters in xpath
                String value= driver.findElement(By.xpath("//table[@name = 'BookTable']//tr["+i+"]//td["+j+"]")).getText();
                //System.out.print(value+"\t");
            }
            //System.out.println();
        }
        
        //print book names whose author is Mukesh
        for (int r = 2; r <= rows; r++) {
            String authorname = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
            //System.out.println(authorname);
            if (authorname.equals("Mukesh")){
                String BooksOfMukesh = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
                //System.out.println(BooksOfMukesh+"\t"+authorname);
            }
        }

        // find total price of all the books
        int total=0;
        for (int r = 2; r <= rows; r++) {
            String prices = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
            total=total+Integer.parseInt(prices); //converts string to int to find the total
        }
        System.out.println(total);


    }
}
/*
3 types of web tables:
    1-> static web table (data fixed)
    2-> Dynamic web table (data changes , it's not fixed , no of col is fixed but no of rows is not fixed and content can change as well)
    3-> table with pagination(few records in page 1 , some more records in other pages)

 --> in dynamic web table you can add pagination and it becomes dynamic table with pagination
 --> hierarchy of table in general is table->tbody->tr(1)->th
                                                 ->tr(restof them )->td
 -->
 */