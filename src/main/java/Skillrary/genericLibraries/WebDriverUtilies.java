package Skillrary.genericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;



public class WebDriverUtilies {
	/**
	 * Handle the dropdown
	 * @param ele
	 * @param text
	 */
	public void select(WebElement ele,String text) {
		Select s=new Select(ele);
		s.selectByVisibleText(text);
	}
	/**
	 * Mouse hover
	 * @param driver
	 * @param ele
	 */
	public void mouseHover(WebDriver driver,WebElement ele) {
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
	/**
	 * Doule click
	 * @param driver
	 * @param ele
	 */
	public void doubleClick(WebDriver driver,WebElement ele) {
		Actions a=new Actions(driver);
		a.doubleClick(ele).perform();
	}
	
	/**
	 * drag and drop 
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void draganddrop(WebDriver driver,WebElement source,WebElement target) {
		Actions a=new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}
	/**
	 * Switch the control to frame
	 * @param driver
	 */
	
	public void switchFrame(WebDriver driver) {
		driver.switchTo().frame(0);
	}
	/**
	 * switch control back from the frame
	 * @param driver
	 */
	public void switchbackFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * alert popup
	 * @param driver
	 */
	public void alertpopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * switch the tabs
	 * @param driver
	 */
	public void switchTabs(WebDriver driver) {
		 Set<String> child = driver.getWindowHandles();
		 for(String b:child) {
			 driver.switchTo().window(b);
		 }
	}
	/**
	 * scroll bar
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollBar(WebDriver driver,int x,int y) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	/**
	 * Screenshot
	 * @param driver
	 * @param name
	 * @throws IOException
	 */
	public void screenShot(WebDriver driver,String name) throws IOException {
		Date d=new Date();
		String date = d.toString().replaceAll(":","-");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(AutoConstant.photoPath+date+name+".png");
		FileUtils.copyFile(src,dest);
	}
	
	/**
	 * AutoIT
	 * @param command
	 * @return 
	 * @throws IOException
	 */
	public String autoIt(String command) throws IOException {
		Runtime.getRuntime().exec(command);
		return command;
	}
	/**
	 * Verification
	 * @param actual
	 * @param expected
	 * @param Page
	 */
	
	public void verify(String actual,String expected,String Page) {
		Assert.assertEquals(actual, expected);
		Reporter.log(Page+"is displayed",true);
	}
	
	
	
	
	

}
