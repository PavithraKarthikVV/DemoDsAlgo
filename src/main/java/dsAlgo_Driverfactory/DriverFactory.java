package dsAlgo_Driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> ltdriver=new ThreadLocal();
	
	public WebDriver init_driver(String browser,String url)
{
	if(browser.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		ltdriver.set(new ChromeDriver());
		
	}
	else if(browser.equals("safari"))
	{
		WebDriverManager.safaridriver().setup();
		ltdriver.set(new SafariDriver());
	}
	else if(browser.equals("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		ltdriver.set(new FirefoxDriver());
	}
	getDriver().manage().deleteAllCookies();
	getDriver().manage().window().maximize();
	getDriver().get(url);
	return getDriver();
}
	public static synchronized WebDriver getDriver()
	{
		return ltdriver.get();
	}
	
}