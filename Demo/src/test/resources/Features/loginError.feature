Feature: Automating login page for Sauce Demo - Error Scenario.

  @progression @smoke
  Scenario Outline: Login is successful with Locked credentials.
    Given user is on login page.
    When user enters valid "<username>" and "<password>".
    And user clicks on login button.
    Then user is not navigated to home page.
    And user gets error.
    And close the browser.

    Examples: 
      | username        | password     |
      | locked_out_user | secret_sauce |
