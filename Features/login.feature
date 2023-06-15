Feature: login
  Scenario: Login into the commerce application
    Given Launch the Application
    When click login button with credentials "admin@yourstore.com" and "admin"
    Then Validating user can navigate to homepage
    When Click logout button
    Then Validating user can navigate to Loginpage
    And Close the browser

  Scenario Outline: Login into the commerce application by using data driven
    Given Launch the Application
    When click login button with credentials "<email>" and "<password>"
    Then Validating user can navigate to homepage
    When Click logout button
    Then Validating user can navigate to Loginpage
    And Close the browser

    Examples:
      | email               | password |
      | admin@yourstore.com | admin    |
      | admin@yourstore.com | admin123 |
