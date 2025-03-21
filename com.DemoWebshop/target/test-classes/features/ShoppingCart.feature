Feature: Perform adding and removing operations on shopping cart

@Verifyingremove
Scenario Outline: Perform remove actions on Shopping cart
Given Search "<Product1>"
When Click on add to cart1
And Click on shopping cart
And Click remove product
And Click update shopping cart
Then verify shopping cart

Examples:
|Product1       |
|Smartphone|

@verifyingupdatequantities
Scenario Outline: Perfome Update quantity actions in shopping cart
Given Search "<Product1>"
When Click on add to cart1
And Click on shopping cart
And Click update quantity
And Click update shopping cart
And verify update shopping cart
Then Verify checkout button

Examples:
|Product1       |
|Smartphone|


#Feature: Perform adding and removing operations on shopping cart
#
#@AddingRemovingitems
#Scenario Outline: Perform actions on Shopping cart
#Given I Search "<item>"
#When I add item to cart
#And I add more "<items>"
#And I Click on shopping cart
#And I Click remove product
#And I Click update shopping cart
#And update the quantity of an item
#Then verify shopping cart 
#
#Examples:
#|item    |items        |
#|laptop  |health book  |  
