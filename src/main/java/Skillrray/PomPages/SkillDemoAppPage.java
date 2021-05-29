package Skillrray.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillDemoAppPage {
@FindBy(name="addresstype")
public WebElement coursedd;

public SkillDemoAppPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

public WebElement getCoursedd() {
	return coursedd;
}





}
