package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UploadingFiles {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
        driver.manage().window().maximize();

        //single file upload
        /*driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Users\\15147\\Desktop\\resume\\Jas_cover_letter.pdf");
        if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("Jas_cover_letter.pdf")){
            System.out.println("file uploaded successfully");
        }
        else{ System.out.println("uploading failed");
        }*/

        //multiple files uploading
        String file1 = "C:\\Users\\15147\\Desktop\\resume\\Jas_cover_letter.pdf";
        String file2 = "C:\\Users\\15147\\Desktop\\resume\\Jaskirat Student Record.pdf";
        driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);

        //validation 1 - nuimber of files uploaded
        int noOfFilesUploaded = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
        if(noOfFilesUploaded==2){
            System.out.println("all files uploaded");
        } else {
            System.out.println("All files are not uploaded or incorrect files uploaded");
        }

        //validate file names
        if(driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("Jas_cover_letter.pdf") && driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("Jaskirat Student Record.pdf")){
            System.out.println("Files are matching");
        }
        else {
            System.out.println("files name not matching");
        }





    }
}
