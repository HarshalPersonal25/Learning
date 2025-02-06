Feature: Automating login page for Sauce Demo.

  Background: Common steps for Automation Login Feature
    Given user is on login page.

  @regression
  Scenario Outline: Login is successful with Standard credentials.
    When user enters valid "<username>" and "<password>".
    And user clicks on login button.
    Then user is navigated to home page.
    And close the browser.

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |

  @regression @smoke
  Scenario Outline: Login is successful with Problem credentials.
    When user enters valid "<username>" and "<password>".
    And user clicks on login button.
    Then user is navigated to home page.
    And close the browser.

    Examples: 
      | username     | password     |
      | problem_user | secret_sauce |

  @sanity @progression
  Scenario Outline: Login is successful with Performance credentials.
    When user enters valid "<username>" and "<password>".
    And user clicks on login button.
    Then user is navigated to home page.
    And close the browser.

    Examples: 
      | username                | password     |
      | performance_glitch_user | secret_sauce |
