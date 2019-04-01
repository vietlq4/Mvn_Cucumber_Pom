Feature: Payment feature
  As aa automation tester
  I want to create new customer
  So that I want to make sure payment correctly
  @pre_condition
  Scenario: [PRE-Condition] Create new account and login
    #Register new account
    Given I click Here link button
    When I input "automation@gmail.com" into email field
    Then I click btn Submit button
    And I get userId and password
    #Login with new userID and password
    Given I open Login page
    When I input userId and password into fields
    Then I click Login button
    #Verify Login success
    Then I verify Login success