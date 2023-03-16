Feature: User can add products to the cart and navigate to the Cart Page

  @PlaceOrder
  Scenario Outline: The user can increment items quantity and add them to the cart
    Given User navigates to GreenCart Landing page
    When User searched with the shortname "<shortName>" and extracted name of the product
    And Added "3" items of the selected product to cart
    Then User proceeds to Checkout and validate the "<longName>" items in checkout page
    And Verify user has the ability to enter promo codes and place an order

    Examples:
    | shortName | longName |
    | Tom       | Tomato   |
