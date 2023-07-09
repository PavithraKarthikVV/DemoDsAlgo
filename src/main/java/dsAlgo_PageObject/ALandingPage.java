package dsAlgo_PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ALandingPage {
	private WebDriver driver;
	public ALandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath ="//button[@class='btn']")private WebElement getstartbtn;
public BHomePage click_Btn()
{	
	new WebDriverWait(driver,Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOf(getstartbtn));
	getstartbtn.click();
	return new BHomePage(driver);
}
public String get_Title()
{
	return driver.getTitle();
}
}