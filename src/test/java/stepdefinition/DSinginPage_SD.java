package stepdefinition;

import org.testng.Assert;

import dsAlgo_Driverfactory.DriverFactory;
import dsAlgo_PageObject.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class DSinginPage_SD {
	private DLoginPage sigin;
	private BHomePage home;
	private String username;
	private String password;
	

	@Given("The user is in the Sign in page")
	public void the_user_is_in_the_sign_in_page() {
	   
	}
	
	@When("The user enters a valid {string} and {string}")
	public void the_user_enters_a_valid_and(String string, String string2) {
		sigin=new DLoginPage(DriverFactory.getDriver());
		sigin.login(username, password);
	}
	
	@When("click login button to verify")
	public void click_login_button_to_verify() {
		
		home=sigin.cliksignin();
	    
	}

	
	
	@When("Login with given username and password")
	public void login_with_given_username_and_password(DataTable logindata) {
		List<Map<String,String>> loglst=logindata.asMaps();
		username=loglst.get(0).get("username");
		password=loglst.get(0).get("password");
		sigin=new DLoginPage(DriverFactory.getDriver());
		sigin.login(username, password);
		   
	}

	@Then("Verify Successful login {string}")
	public void verify_successful_login(String string) {
	  // home.verifylogin();
	}


}
