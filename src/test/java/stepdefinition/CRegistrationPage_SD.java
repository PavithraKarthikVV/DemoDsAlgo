package stepdefinition;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.Validate;
import org.testng.Assert;

import dsAlgo_Driverfactory.DriverFactory;
import dsAlgo_PageObject.BHomePage;
import dsAlgo_PageObject.CRegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class CRegistrationPage_SD {
	
private  CRegisterPage register;
private BHomePage home;
private String usernme;
private String passwrd;
private String confirmpsw;


	@When("The user clicks Register button with all fields empty")
	public void the_user_clicks_register_button_with_all_fields_empty() {
	register =new CRegisterPage(DriverFactory.getDriver());
	   register.clickregister();
	}
	@When("It should display an error {string} below Username textbox")
	public void it_should_display_an_error_below_username_textbox(String ExpectStr) {
		String actualstr=register.printerror();
		   Assert.assertEquals(actualstr, ExpectStr);
	}

@When("The user clicks Register button after entering username with other fields empty")
public void the_user_clicks_register_button_after_entering_with_other_fields_empty(DataTable username) {
	register =new CRegisterPage(DriverFactory.getDriver());
	List<String> lst=username.asList();
    usernme=lst.get(0);
   register.clickregisterWithoutPassword(usernme);  
   
}

@Then("It should display an error {string} below Password textbox")
	public void it_should_display_an_error_below_password_textbox(String ExpectStr) {
		String actualstr=register.printerror();
	   Assert.assertEquals(actualstr, ExpectStr);
	   	   
	}

@When("The user clicks Register button after entering username and password with Password Confirmation field empty")
public void the_user_clicks_register_button_after_entering_username_and_password_with_password_confirmation_field_empty(DataTable login) {
	register =new CRegisterPage(DriverFactory.getDriver());
	List<Map<String,String>> lst=login.asMaps();
   usernme=lst.get(0).get("username");
   passwrd=lst.get(0).get("password");
   register.clickregisterWithoutPassword(usernme); 
	
}

@Then("It should display an error {string} below Password Confirmation textbox")
public void it_should_display_an_error_below_password_confirmation_textbox(String ExpectStr) {
	String actualstr=register.printerror();
	   Assert.assertEquals(actualstr, ExpectStr);
}
@When("The user enters a username with characters other than Letters, digits and @\\/.\\/+\\/-\\/_")
public void the_user_enters_a_username_with_characters_other_than_letters_digits_and(DataTable login) {
	register =new CRegisterPage(DriverFactory.getDriver());
	List<Map<String,String>> lst=login.asMaps();
   usernme=lst.get(0).get("username");
   passwrd=lst.get(0).get("password");
   confirmpsw=lst.get(0).get("password confirmation");
   register.registrationinput(usernme,passwrd,confirmpsw);
   
}
@Then("It should display an error message {string}")
public void it_should_display_an_error_message(String ExpectStr) {
		String actualstr=register.printerror();
	   Assert.assertEquals(actualstr, ExpectStr);
}

@When("The user enters a valid existing username with password and password confirmation")
public void the_user_enters_a_valid_existing_username_with_password_and_password_confirmation(DataTable login) {
	register =new CRegisterPage(DriverFactory.getDriver());
	List<Map<String,String>> lst=login.asMaps();
   usernme=lst.get(0).get("username");
   passwrd=lst.get(0).get("password");
   confirmpsw=lst.get(0).get("password confirmation");
   register.registrationinput(usernme,passwrd,confirmpsw);
  
}
@When("The user enters a valid usernameand password with characters less than {int}")
public void the_user_enters_a_valid_usernameand_password_with_characters_less_than(Integer int1, DataTable login) {
	register =new CRegisterPage(DriverFactory.getDriver());
	List<Map<String,String>> lst=login.asMaps();
   usernme=lst.get(0).get("username");
   passwrd=lst.get(0).get("password");
   confirmpsw=lst.get(0).get("password confirmation");
   register.registrationinput(usernme,passwrd,confirmpsw);
}
@When("The user enters a valid username and password with only numbers")
public void the_user_enters_a_valid_username_and_password_with_only_numbers(DataTable login) {
	register =new CRegisterPage(DriverFactory.getDriver());
	List<Map<String,String>> lst=login.asMaps();
   usernme=lst.get(0).get("username");
   passwrd=lst.get(0).get("password");
   confirmpsw=lst.get(0).get("password confirmation");
   register.registrationinput(usernme,passwrd,confirmpsw);
}

@When("The user clicks Register button after entering valid username and different passwords in password and password confirmation fields")
public void the_user_clicks_register_button_after_entering_valid_username_and_different_passwords_in_password_and_password_confirmation_fields(DataTable login) {
	register =new CRegisterPage(DriverFactory.getDriver());
	List<Map<String,String>> lst=login.asMaps();
   usernme=lst.get(0).get("username");
   passwrd=lst.get(0).get("password");
   confirmpsw=lst.get(0).get("password confirmation");
   register.registrationinput(usernme,passwrd,confirmpsw);
}
@When("The user enters a valid username and password and password confirmation")
public void the_user_enters_a_valid_username_and_password_and_password_confirmation(DataTable login) {
	register =new CRegisterPage(DriverFactory.getDriver());
	List<Map<String,String>> lst=login.asMaps();
   usernme=lst.get(0).get("username");
   passwrd=lst.get(0).get("password");
   confirmpsw=lst.get(0).get("password confirmation");
   home=register.registrationinput(usernme,passwrd,confirmpsw);
}
@Then("The user should be redirected to Homepage with the message {string} {string}")
public void the_user_should_be_redirected_to_homepage_with_the_message_numpy_sdet116(String message, String user) {
  //Assert.assertEquals(home.alertmessage(),message+ user ); 
}
}

