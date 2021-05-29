package Skillrray.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmpDetailsPage {
	
	@FindBy(id="firstname")
	private WebElement fn;
	
	@FindBy(id="lastname")
	private WebElement ln;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="contact")
	private WebElement contact;
	
	@FindBy(xpath="//input[@type='file']")
	private WebElement uploadphoto;
	
	public EmpDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	

	
	public void emploginDetails(String fname,String lname,String emailid,String pass,String contactnum) {
		fn.sendKeys(fname);
		ln.sendKeys(lname);
		email.sendKeys(emailid);
		password.sendKeys(pass);
		contact.sendKeys(contactnum);
		
	}

	public WebElement getFn() {
		return fn;
	}

	public WebElement getLn() {
		return ln;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getContact() {
		return contact;
	}

	public WebElement getUploadphoto() {
		return uploadphoto;
	}
	
	
	public void upload(String data) {
		uploadphoto.sendKeys(data);
	}
	

}
