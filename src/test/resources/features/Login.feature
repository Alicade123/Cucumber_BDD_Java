
#1. Scenario
#Feature: Login Functionality
#
#  In order to do internet banking
#  As a valid Para Bank customer
#  I want to login successfully
#
#  Scenario: Login Successful
#    Given I am in the login page of the Para Bank Application
#    When I enter valid credential
#    Then I should be taken to the OverView Page

#2. Scenario Outline
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
#        |john|demo|John Smith|


##  3. Table
#Feature: Login Functionality
#
#  In order to do internet banking
#  As a valid Para Bank customer
#  I want to login successfully
#
# Scenario: Login Successful
#    Given I am in the login page of the Para Bank Application
#    When I enter valid credential
#    |john|demo|
#    Then I should be taken to the OverView Page


##  3. Multirow Table
#Feature: Login Functionality
#
#  In order to do internet banking
#  As a valid Para Bank customer
#  I want to login successfully
#
#  Scenario: Login Successful
#    Given I am in the login page of the Para Bank Application
#    When I enter valid credential
#      |username|password|
#      |john|demo|
#      |john|demo|
#      |john|demo|
#    Then I should be taken to the LoginPage