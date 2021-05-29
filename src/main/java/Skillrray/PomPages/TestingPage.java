package Skillrray.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestingPage {
	public WebDriver driver;
@FindBy(xpath="(//a[text()='Selenium Training'])[2]")
private WebElement seleniumtraining;

@FindBy(id="mycart")
private WebElement cartbtn;

public TestingPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
	this.driver=driver;
}



public WebElement getSeleniumtraining() {
	return seleniumtraining;
}

public void setSeleniumtraining(WebElement seleniumtraining) {
	this.seleniumtraining = seleniumtraining;
}

public WebElement getCartbtn() {
	return cartbtn;
}

public void setCartbtn(WebElement cartbtn) {
	this.cartbtn = cartbtn;
}

}
