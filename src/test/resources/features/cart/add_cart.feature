@add_cart_feature
Feature: Add Cart
  As a User,
  I want to see Add cart functionality working as expected

  Scenario: Subtotal amount matches the total of selected products
    Given User navigate to the online store home page
    And the user has added the following products to the cart:
      | Product Name           | Price  |
      | Joust Duffle Bag       | $34.00 |
      | Wayfarer Messenger Bag | $45.00 |
      | Didi Sport Watch       | $92.00 |
    When the user views the cart page
    Then the cart should display a subtotal amount of "$171.00"