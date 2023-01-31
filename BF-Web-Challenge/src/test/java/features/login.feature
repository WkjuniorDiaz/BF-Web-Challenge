Feature: Login

  @LoginLogout @Regression
  Scenario Outline: TC02 - User Log in and Log out to Product Store
    Given user sign up to Product Store with username <username> and password <password>
    When user select Log in from Menu bar
    And type same username <username>
    And type same password <password>
    And select Log in button
    And select Log out from menu bar
    Then verify user is log out from product store

    Examples:
      | username | password |
      | "okJBtest30" | "okJBtest30" |