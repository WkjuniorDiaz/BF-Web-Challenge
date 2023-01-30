Feature: Signup

  @Signup
  Scenario Outline: TC01 - User sign up to Product Store
    When user select Sign up from menu bar
    And type username <username>
    And type password <password>
    And select Sign Up button
    Then verify confirmation message <message> displayed
    Examples:
      | username | password | message |
      | "Junior.Diaz.test4" | "Junior.Diaz.test4" | "Sign up successful." |