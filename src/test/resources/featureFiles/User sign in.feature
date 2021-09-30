Feature: Authentication Page

  Scenario: Complete Sign in popup form using DataTable
    Given user navigates on 'https://automationpractice.com/' page
    Then user select sign in popup
    And  authentication page is displayed
    When valid email address is inserted
    And valid password is inserted

 //   When user insert data in fields
//      | yopmail.an@yopmail.com | 11121314 |

    And user click on sign in button
    And authentication done successfully
