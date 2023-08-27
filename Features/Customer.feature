Feature: Customer

  Background: Common for all the Scenario
    Given User Lunch Chrome Browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view DashBoard

@sanity
  Scenario: Add new Customer
    When User click on Customer Menu
    And User click on Customers Menu Item
    And User click on Add New Button
    Then User can view Add new customer page
    When User enter customer info
    And Click on the save button
    And Close the Browser

@regression
  Scenario: Search Customer by Name
    When User click on Customer Menu
    And User click on Customers Menu Item
    And Enter customer FirstName as "Virat" and LastName as "Kohli"
    When click on the search Button
    Then User should found Name in the search table
    And Close the Browser

@regression
  Scenario: Search Customer by Email
    When User click on Customer Menu
    And User click on Customers Menu Item
    And Enter customer Email as "arthur_holmes@nopCommerce.com"
    When click on the search Button
    Then User should found Email in the search table
    And Close the Browser
