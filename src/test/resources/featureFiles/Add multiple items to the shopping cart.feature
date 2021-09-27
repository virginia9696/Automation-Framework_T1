Feature: Shopping cart functionality

  Scenario: Add and remove items from the shopping cart
    Given user navigates on "http://automationpractice.com/" page
    When selects category "2" with name "Dresses" from top bar menu
    And selects position "1" with name "Printed Dress" item from displayed page
    And presses on "Add to cart" button
    Then "1" items are displayed in the shopping cart header
    When selects category "3" with name "T-shirts" from top bar menu
    And selects position "1" with name "Faded Short Sleeve T-shirts" item from displayed page
    And presses on "Add to cart" button
    Then "2" items displayed on shoppingCartPopUp
    And presses on "Proceed to checkout" button
    And removes item "1" from shopping card table, pressing on "Delete" button
    Then "1" item is displayed on shopping-cart summary
    And item with name "Faded Short Sleeve T-shirts" is displayed in the shopping cart