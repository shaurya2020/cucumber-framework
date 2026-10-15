Feature: Add Product to Cart

Background:
    Given user is on the SauceDemo login page
    When user enters valid username and password
    And user clicks on the login button
    Then user should be redirected to the products page

  Scenario: Add a single product to the cart
    When user adds "Sauce Labs Backpack" to the cart
    Then the cart badge should display "1"
    And the shopping cart should contain "Sauce Labs Backpack"

  Scenario: Add multiple products to the cart
    When user adds "Sauce Labs Backpack" to the cart
    And user adds "Sauce Labs Bike Light" to the cart
    Then the cart badge should display "2"

  Scenario: Remove a product from the cart
    When user adds "Sauce Labs Backpack" to the cart
    And user removes "Sauce Labs Backpack" from the cart
    Then the cart badge should not be displayed