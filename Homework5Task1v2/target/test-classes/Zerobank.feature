Feature: Zero Bank features
  As a user
  I want to transfer money
  Add a new payee
  Pay a saved payee
  Background:
    Given Login to the app with credentials
  Scenario: Transfer money from one account to another account
    When User goes to transfer funds
    And Select from account
    And Select to account
    And fill amount
    And fill description
    And user submits
    And success message is shown
    Then User logs out