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
Feature: Title of your feature
  I want to use this template for my feature file
Background:
	    Given The user opens DS Algo portal link
   		When The user clicks the Get Started button
   		Given The user is in the Sign in page
   		When  The user enters a valid "<username>" and "<password>" 
			And  click login button to verify
 		  |username|password|
		  |Numpy@sdet116_1|pass_123|
		  And The user click GetStart in "Array"

@Array1
Scenario: The user is able to navigate to Arrays in Python page
 Given The user is on the "Array" page after logged in
 When The user clicks "Arrays in Python" button
 Then The user in "Array" page.
 
