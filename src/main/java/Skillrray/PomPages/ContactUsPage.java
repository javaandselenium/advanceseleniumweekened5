package Skillrray.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	public WebDriver driver;
	@FindBy(name="name")
	private WebElement nametb;
	
	@FindBy(name="sender")
	private WebElement emailtb;
	
	@FindBy(name="subject")
	private WebElement subjecttb;
	
	@FindBy(name="message")
	private WebElement messagetb;
	
	@FindBy(xpath="//button[text()='Send us mail']")
	private WebElement sendusemail;
	
	
	@FindBy(xpath="//i[@class='fa fa-facebook']")
	private WebElement facebookbtn;
	
	public WebElement getFacebookbtn() {
		return facebookbtn;
	}

	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public FacebookPage contactDetails(String name,String email,String subject,String msg) {
		nametb.sendKeys(name);
		emailtb.sendKeys(email);
		subjecttb.sendKeys(subject);
		messagetb.sendKeys(msg);
		sendusemail.click();
		return new FacebookPage(driver);
	}

	public WebElement getNametb() {
		return nametb;
	}

	public WebElement getEmailtb() {
		return emailtb;
	}

	public WebElement getSubjecttb() {
		return subjecttb;
	}

	public WebElement getMessagetb() {
		return messagetb;
	}

	public WebElement getSendusemail() {
		return sendusemail;
	}
	
	

}
