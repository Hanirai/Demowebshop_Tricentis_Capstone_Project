Feature: Home page search
  # https://demowebshop.tricentis.com

 Background: Given I navigate to the home page
 
  @homePageProduct
  Scenario: Verifying the major sections
    And I verify the Featured Products
    
  @homePageSearchbar
  Scenario: Verifying the major sections
    And I verify the search bar
    
  @homePageSearchFunction
  Scenario Outline: Verify search bar functionality
    And I search for "<Book>"
    And I click on the search button
    Then I verify the search results

    Examples: 
      | Book    |
      |  Health Book   |
   

  @homePageFiltering
  Scenario Outline: Filtering results by category, price, and ratings
    And I search for "<Book>"
    And I click on the search button
    And I click on advanced search
    And I filter the results by category 
    And I filter the results by price
    And I filter the results by ratings
    Then I verify the filtered product displayed

   Examples: 
      | Book    |
      |  Health Book   |
