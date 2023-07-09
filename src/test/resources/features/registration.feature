#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature:Registration
Background:
		When The user clicks the Get Started button

  @Scenario1
  Scenario: The user is presented with error message for empty fields below Username textbox
    Given The user opens Register Page
    When  The user clicks Register button with all fields empty
    And  It should display an error "Please fill out this field." below Username textbox
  
   @Scenario2
   Scenario Outline: The user is presented with error message for empty fields below Password  textbox
   Given The user opens Register Page
   When The user clicks Register button after entering username with other fields empty
      | username     |
      | Numpy@sdet116_2 |
   Then It should display an error "Please fill out this field." below Password textbox
   
   @Scenario3
   Scenario Outline: The user is presented with error message for empty fields below Password Confirmation textbox
		Given The user opens Register Page
		When The user clicks Register button after entering username and password with Password Confirmation field empty
      | username     | password     |
      | Numpy@sdet116_2 | testpassword |
    Then It should display an error "Please fill out this field." below Password Confirmation textbox
      
   @Scenario4
   Scenario Outline: The user is presented with error message for invalid username
   Given The user opens Register Page
   When  The user enters a username with characters other than Letters, digits and @/./+/-/_
      | username | password     | password confirmation |
      | &**&&** | testpassword          |testpassword|
   Then It should display an error message "password_mismatch:The two password fields didn’t match."
   
  @Scenario5
  Scenario Outline: The user is presented with error message for username already exists
  Given The user opens Register Page
  When  The user enters a valid existing username with password and password confirmation
      | username     | password  | password confirmation |
      | Numpy@sdet116_1 | pass_123 | pass_123 |
  Then It should display an error message "password_mismatch:The two password fields didn’t match."
  
   
   @Scenario7
  Scenario Outline: The user is presented with error message for password with characters less than 8
  Given The user opens Register Page
  When  The user enters a valid usernameand password with characters less than 8
      | username     | password | password confirmation |
      | Numpy@sdet84_1 | a1b2c3d  | a1b2c3d            |
  Then It should display an error message "password_mismatch:The two password fields didn’t match."
   
   @Scenario8
  Scenario Outline: The user is presented with error message for password with only numbers
  Given The user opens Register Page
  When  The user enters a valid username and password with only numbers
      | username     | password | password confirmation |
      | Numpy@sdet84_1 | 12345678 |              12345678 |
  Then It should display an error message "password_mismatch:The two password fields didn’t match."
  
 
  @Scenario6 
  Scenario Outline: The user is presented with error message for password mismatch
  Given The user opens Register Page
  When  The user clicks Register button after entering valid username and different passwords in password and password confirmation fields
      | username     | password     | password confirmation |
      | Numpy@sdet84_1 | testpassword | testpassword1   |   
  Then It should display an error message "password_mismatch:The two password fields didn’t match."
  
   @Scenario9
  Scenario Outline: The user is succesfully able to register 
  Given The user opens Register Page
  When  The user enters a valid username and password and password confirmation
      | username     | password  | password confirmation |
      | Numpy@sdet116_2 | pass_123 | pass_123       |
  Then The user should be redirected to Homepage with the message "New Account Created. You are logged in as" "<username>"
   Examples:
   |username|
   | Numpy@sdet116_2 |	