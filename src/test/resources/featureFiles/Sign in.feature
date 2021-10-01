Feature: Authentication Page

  Scenario: Complete Sign in popup form using DataTable
    Given user navigates on "http://automationpractice.com/" page
    When presses on "Sign in" button
    Then page heading "Authentication" is displayed
    When enters data in fields
      |yopmail.an@yopmail.com|11121314|
    And clicks on SignIn button
    Then text "Welcome to your account" is displayed

