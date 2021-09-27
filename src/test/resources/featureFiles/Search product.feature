Feature: Search functionality

  Scenario Outline: Search product on search bar <description>
    Given user navigates on <url> page
    When selects <categoryName> category order <categoryOrder> from top bar menu
    And get the name of the displayed product <productOrder>
    When enter product name in the search bar and click search button
    Then actual displayed product is equal with expected product
    Examples:
      | url                              | categoryName | categoryOrder | productOrder | description |
      | "http://automationpractice.com/" | "Women"      | 1             | 1            | Test        |
      | "http://automationpractice.com/" | "Dresses"    | 2             | 2            | Yer         |
      | "http://automationpractice.com/" | "T-shirts"   | 3             | 3            | DAta        |