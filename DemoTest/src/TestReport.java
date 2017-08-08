import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Before;
import org.junit.Test;

public class TestReport {

	private ExtentReports report;
    private ExtentTest test;
    private String reportFilePath = "report.html";
    
    @Before
    public void setUp(){
        report = new ExtentReports();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("TestReport");
        extentHtmlReporter.config().setDocumentTitle("Report");
        report.attachReporter(extentHtmlReporter);
        test = report.createTest("TestName");
    }

    public void myTestMethod(){
        test.log(Status.INFO,"Info level");
        test.pass("hello");
        report.flush();
    }
}
