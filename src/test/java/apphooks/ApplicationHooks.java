package apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import dsAlgo_Driverfactory.DriverFactory;
import dsAlgo_Utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
public class ApplicationHooks {

	private DriverFactory driverfact;
	private ConfigReader proper;
	private Properties brw;
	private WebDriver driver;
	
	@Before(order = 0)
	public void getproperty() 
	{
		proper=new ConfigReader();
		brw=proper.init_prop();
		
	}
	@Before(order = 1)
	public void getBrowser() 
	{
		driverfact =new DriverFactory() ;
		String browsername=brw.getProperty("browser");
		String urls=brw.getProperty("url");
		driver=driverfact.init_driver(browsername,urls);
	}
	/* after order 1 will execute and last 0*/
	@After(order= 0)
	public void QuitBrowser()
	{
		driver.quit();
	}
	
	@After(order= 1)
	public void screenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String screenshotName=scenario.getName();
			byte[] sourcepath=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotName);
		}
	}
}
