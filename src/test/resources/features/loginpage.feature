Feature: Login Functionality

  As a user
  I want to be able to log in with my account
  So that I can access the product list

      Scenario Outline: Login with valid credentials
        Given I open the browser
        When I navigate to path "<url>"
        And I enter a valid username "<username>"
        And I enter a valid password "<password>"
        And I click on the login button
        Then Page title should be "Swag Labs"
        When Highest valued product and add to cart
        And I navigate to cart


        Examples:
          | url                        | username      | password     | inventorypage   |
          | https://www.saucedemo.com/ | standard_user | secret_sauce | /inventory.html |
