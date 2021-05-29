package Skillrary.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Point;
import org.testng.annotations.Test;

import Skillrary.genericLibraries.BaseClass;
import Skillrray.PomPages.ContactUsPage;
import Skillrray.PomPages.FacebookPage;
import Skillrray.PomPages.LoginPage;
import Skillrray.PomPages.SkillDemoAppPage;
import Skillrray.PomPages.TestingPage;

public class Contactdeatilsandlike extends BaseClass{
@Test
public void testcase1() throws FileNotFoundException, IOException, InterruptedException {
	reports.createTest("testcase1");
	
	LoginPage l=new LoginPage(driver);
	l.skillraryDemoapp();
	
	utilies.switchTabs(driver);
	
	SkillDemoAppPage s=new SkillDemoAppPage(driver);
	utilies.select(s.getCoursedd(),fu.getPropertyData("coursename"));
	
	 TestingPage t = new TestingPage(driver);
	utilies.draganddrop(driver,t.getSeleniumtraining(),t.getCartbtn());
	
	driver.navigate().back();
	
	Point loc = l.getContactusbtn().getLocation();
	int x=loc.getX();
	int y=loc.getY();
	utilies.scrollBar(driver, x, y);
	
 l.getContactusbtn().click();
 
 ContactUsPage c=new ContactUsPage(driver);
 c.contactDetails(fu.getPropertyData("name"),fu.getPropertyData("email"),fu.getPropertyData("subject"),fu.getPropertyData("message"));
c.getFacebookbtn().click();
Thread.sleep(3000);

FacebookPage fb=new FacebookPage(driver);
fb.getLikebtn();
Thread.sleep(3000);
utilies.verify(driver.getTitle(),fu.getPropertyData("fbtitle") ,"FacebookLogin page");
 
	
	
	
	
	
	
}
}
