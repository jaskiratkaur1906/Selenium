package day46;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter; //UI of the report
    public ExtentReports extent; //populate common info on the report
    public ExtentTest test; //creating test case entries in the report and update status of test methods
    public void onStart(ITestContext context){

        sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/report/myReport.html");
        sparkReporter.config().setDocumentTitle("Automation Report"); //Title of report
        sparkReporter.config().setReportName("Functional Testing"); //name of the report
        sparkReporter.config().setTheme(Theme.DARK);

        extent= new ExtentReports();
        extent.attachReporter(sparkReporter); //combined UI with populated information

        extent.setSystemInfo("Computer Name", "localhost");
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("Tester Name", "Pavan");
        extent.setSystemInfo("os", "Windows10");
        extent.setSystemInfo("Browser name", "Chrome");
    }

    public void onTestSuccess(ITestResult result){
        test = extent.createTest(result.getName());
        test.log(Status.PASS, "Test case PASSED is:" + result.getName());
    }
    public void onTestFailure(ITestResult result){
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
        test.log(Status.FAIL, "Test case FAILED cause is:" + result.getThrowable());
    }

    public void onTestSkipped(ITestResult result){
        test=extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case SKIPPED is:"+ result.getName());
    }

    public void onFinish(ITestContext context){
        extent.flush();
    }

}
