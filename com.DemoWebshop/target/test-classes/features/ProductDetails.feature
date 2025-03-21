Feature: Product details page

Background: 
    Given I search for Health Book
    When I click on the product

@ProductVerification
  Scenario: verifying the product details
    Then I see the product title
    And I see the product description
    And I see the product price
    And I see the product images
    And I see the product availabity
    
@ProductToWishlistCart
  Scenario: add the selected product to cart
  When I click on add to wishlist
  And I click on add to cart
  Then product is added
 
