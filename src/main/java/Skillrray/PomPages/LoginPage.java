package Skillrray.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	@FindBy(xpath="//a[text()=' GEARS ']")
	private WebElement gearsBtn;
	
	@FindBy(xpath="(//a[text()=' SkillRary Demo APP'])[2]")
	private WebElement skillrarydemoapp;
	
	@FindBy(xpath="//a[text()='Contact Us']")
	private WebElement contactusbtn;
	
	public WebElement getContactusbtn() {
		return contactusbtn;
	}

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public  SkillDemoAppPage skillraryDemoapp() {
		gearsBtn.click();
		skillrarydemoapp.click();
		return new SkillDemoAppPage(driver);
	}

	public WebElement getGearsBtn() {
		return gearsBtn;
	}

	public WebElement getSkillrarydemoapp() {
		return skillrarydemoapp;
	}
	

}
