Feature: Payee Features
  As a user I want to
  Add a new payee
  Pay a saved payee

  Background:
    Given Login to the app with credentials

  Scenario: User adds new payee
    When User goes to pay bills tab
    And user clicks Add New Payee
    And User enters payee name
    And User enters payee address
    And User enters Account
    And user enters payee details
    And user hits add
    And Success message is shown
    Then User logs out

  Scenario: User Pays saved payee
    When user goes to pay bills tab
    And user selects random payee
    And user selects random account
    And user enters amount
    And user enters date
    And user enters description
    And user hits pay
    And success text is shown
    Then User logs out