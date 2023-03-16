Feature: Search and Place the order for Products

  @SearchProduct
  Scenario Outline: Search Experience for Product search in both homepage and offers page
    Given User navigates to GreenCart Landing page
    When User searched with the shortname "<shortName>" and extracted name of the product
    Then User searched for "<shortName>" shortname in offers page to check if product exists
    And Validate product name in offers page matches with landing page

    Examples:
    | shortName |
    | Tom       |
    | Beet      |