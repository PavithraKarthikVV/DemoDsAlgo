package dsAlgo_PageObject;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CRegisterPage {
	private WebDriver driver;
	private String error="";
	public CRegisterPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath ="//input[@value ='Register']")private WebElement registerBtn;
	@FindBy(name = "username")private WebElement username;
	@FindBy(name = "password1")private WebElement password;
	@FindBy(name = "password2")private WebElement confirmpassword;
	@FindBy(xpath = "//div[contains(@class,'alert ')]")private WebElement signinalert;
	
	//input[@name ='password1']
	
	public void clickregister()
	{ 	
		new WebDriverWait(driver,Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOf(registerBtn));
		registerBtn.click();
		error=username.getAttribute("validationMessage");		
	}
	public String registertitle()
	{
		return driver.getTitle();
	}
	public void clickregisterWithoutPassword(String usrnme)
	{ 	
		new WebDriverWait(driver,Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOf(registerBtn));
		username.sendKeys(usrnme);
		registerBtn.click();
		error=password.getAttribute("validationMessage");		
	}
	public String printerror() {
		System.out.println("Error Message #:"+error);
		return error;
	}
	public BHomePage registrationinput(String usrname,String passwrd,String Confirmpsw)
	{
		username.sendKeys(usrname);
		password.sendKeys(passwrd);
		confirmpassword.sendKeys(Confirmpsw);
		registerBtn.click();
		if(signinalert.isDisplayed())
		{
			error=signinalert.getText();
			return null;
		
		}
		else{return new BHomePage(driver);}
	
	} 
	
}
