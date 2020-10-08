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
@Login
Feature: Login Check
	abc
  @Valid
  Scenario Outline: Log in with valid credentials
    Given I go to loginPage
    When I login with global variable
    Then I proceed to mainPage <mainPage>
    Examples: 
      | mainPage|
      | http://demo.guru99.com/V4/manager/Managerhomepage.php|
