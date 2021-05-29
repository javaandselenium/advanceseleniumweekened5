package Skillrary.genericLibraries;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author QSP
 *
 */
public class BaseClass {
	public WebDriver driver;
	public FileUtilies fu=new FileUtilies();
	public WebDriverUtilies utilies=new WebDriverUtilies();
	public static ExtentHtmlReporter htmlreports;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	
	@BeforeSuite
	public void configBS() throws SQLException {
		FileUtilies.getdatabd();
		htmlreports=new ExtentHtmlReporter(AutoConstant.reportPath);
		reports=new ExtentReports();
		reports.attachReporter(htmlreports);
	}
	
	
	
	/**
	 * Open the browser and eneter the url
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	@BeforeMethod
	public void openApp() throws FileNotFoundException, IOException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(fu.getPropertyData("url"));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	/**
	 * It is used to close the application
	 * @throws IOException 
	 */
	@AfterMethod
	public void closeApp(ITestResult r) throws IOException {
		int result = r.getStatus();
		String name = r.getName();
		if(result==ITestResult.FAILURE) {
			//utilies.screenShot(driver, name);
			test.log(Status.FAIL,r.getThrowable()+"Test case is failed");
		}
		else if(result==ITestResult.SUCCESS) {
			test.log(Status.PASS,r.getName()+"Test case is passed");
		}
		else if(result==ITestResult.SKIP) {
			test.log(Status.SKIP,r.getName()+"Test case is skipped");
		}
		driver.quit();
	}
	
	@AfterSuite
	public void configAS() throws SQLException {
		htmlreports.flush();
		reports.flush();
		FileUtilies.closedab();
	}

}
