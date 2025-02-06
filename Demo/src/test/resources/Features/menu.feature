Feature: Open Menu and click on All Items

  Background: Common steps for Automation Login Feature
    Given user is on login page.

  @progression
  Scenario Outline: Open Menu from home page.
    When user enters valid "<username>" and "<password>".
    And user clicks on login button.
    Then user is navigated to home page.
    
    When user clicks on Menu button.
    Then All Menu slidebar appears.
    
    When user clicks on all items option on Menu sidebar.
    Then user lands on inventory page.
    And close the browser.

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
