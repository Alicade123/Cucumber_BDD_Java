Feature: Login Functionality

  In order to do internet banking
  As a valid Para Bank customer
  I want to login successfully

  Scenario Outline: Login Successful
    Given I am in the login page of the Para Bank Application
    When I enter valid "<username>" and "<password>" with "<fullName>"
    Then I should be taken to the OverView Page
    Examples:
      |username|password|fullName|
      |john|demo|John Smith|
#      |john|demo|John Smith|