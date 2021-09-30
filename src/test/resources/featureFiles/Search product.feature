Feature: Search functionality

  Scenario Outline: Search product on search bar from category <categoryName>
    Given user navigates on <url> page
    When selects category <categoryOrder> with name <categoryName> from top bar menu
    And get the name of the product <productOrder> order
    When enter found product name in the search bar and click search button
    Then The actual displayed product name is equal with expected product name
    Examples:
      | url                              | categoryName | categoryOrder | productOrder |
      | "http://automationpractice.com/" | "Women"      | "1"           | 1            |
      | "http://automationpractice.com/" | "Dresses"    | "2"           | 1            |
      | "http://automationpractice.com/" | "T-shirts"   | "3"           | 1            |