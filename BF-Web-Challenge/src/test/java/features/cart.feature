Feature: Cart

  @AddCart @Regression
  Scenario Outline: TC03 - User add a product into cart
    When user select the category <category> of the product desire
    And select product <product> to be add
    And select Add to cart button
    And select Cart option from Menu bar
    Then verify product <product> was added to list of product

    Examples:
      | category | product |
      | "Laptops" | "MacBook Pro" |