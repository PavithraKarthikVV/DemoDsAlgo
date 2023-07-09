package stepdefinition;

import org.jsoup.select.Evaluator.ContainsText;
import org.testng.Assert;

import dsAlgo_Driverfactory.DriverFactory;
import dsAlgo_PageObject.ALandingPage;
import dsAlgo_PageObject.BHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ALandingPage_SD {
	private BHomePage home;
	private ALandingPage landingpage;
	@Given("The user opens DS Algo portal link")
	public void user_in_landingpage() {
	    System.out.println(DriverFactory.getDriver().getTitle());
	    
	}

	@When("The user clicks the Get Started button")
	public void click_on_getstart() {
		landingpage=new ALandingPage(DriverFactory.getDriver());
		landingpage.click_Btn();
	  
	}
}
