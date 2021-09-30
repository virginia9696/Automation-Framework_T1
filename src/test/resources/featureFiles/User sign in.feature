Feature: Authentication Page

  Scenario: Complete Sign in popup form using DataTable
    Given user navigates on "http://automationpractice.com/" page
    When presses on "Sign in" button
    Then page heading "Authentication" is displayed
#    When valid email address is inserted
#    And valid password is inserted
#
## //   When user insert data in fields
##//      | yopmail.an@yopmail.com | 11121314 |
#
#    And user click on sign in button
#    And authentication done successfully
