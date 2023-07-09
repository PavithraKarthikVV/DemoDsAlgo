package dsAlgo_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DLoginPage {
	public WebDriver driver;
	public DLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name = "username")private WebElement username;
	@FindBy(name = "password")private WebElement password;
	@FindBy(xpath ="//input[@type='submit']")private WebElement loginBtn ;
	
	public void login(String usernme,String pasword)
	{
		username.sendKeys(usernme);
		password.sendKeys(pasword);
		
	}
	public BHomePage cliksignin() {
		loginBtn.click();
		return new BHomePage(driver);
	}
	
	
}
