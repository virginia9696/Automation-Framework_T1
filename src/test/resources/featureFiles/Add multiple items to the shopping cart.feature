Feature: Shopping cart functionality

  Scenario: Add and remove items from the shopping cart
    Given user navigates on "http://automationpractice.com/" page
    When selects "Dresses" category order 2 from top bar menu
    And selects position 1 with name "Printed Dress" item from displayed page
    And presses on "Add to cart" button
    Then 1 item is displayed on shoppingCartPopUp
    When selects "T-shirts" category order 3 from top bar menu
    And selects position 1 with name "Faded Short Sleeve T-shirts" item from displayed page
    And presses on "Add to cart" button
    Then 2 items are displayed in the main shopping cart
    When removes item 1 from shopping card table, pressing on "Delete" button
    Then 1 items are displayed in the main shopping cart
    And item with name "Faded Short Sleeve T-shirts" is displayed in the shopping cart


