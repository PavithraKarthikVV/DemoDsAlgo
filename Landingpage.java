package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Landingpage {
	private WebDriver driver;
	public Landingpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	@FindBy(xpath ="//button[@class='btn']")private WebElement getstartbtn;
public RegistrationPage getstartRegisteration()
{
	new WebDriverWait(driver,Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOf(getstartbtn));
	getstartbtn.click();
	return new RegistrationPage();
}

}
