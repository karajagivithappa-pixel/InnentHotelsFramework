package genericUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerUtility implements ISuiteListener,ITestListener {
	
	ExtentReports report;
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	
	
	String time=new Date().toString().replace(" ","_").replace(":","_");
	@Override
	public void onStart(ISuite suite) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./advancereport/extentreport"+time+".html");
		spark.config().setDocumentTitle("hospitality project");
		spark.config().setReportName("suite results");
		spark.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("browser","chrome");
		report.setSystemInfo("operatingSystem","windows 11");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String method=result.getMethod().getMethodName();
		test.set(report.createTest(method));
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String method=result.getMethod().getMethodName();

		TakesScreenshot ts=(TakesScreenshot)BaseUtility.localDriver.get();
		String filepath=ts.getScreenshotAs(OutputType.BASE64);
		test.get().addScreenCaptureFromBase64String(filepath,method);
	}

	
	
	
	
}
