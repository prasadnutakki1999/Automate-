Feature: validating menus in home page

  Scenario Outline: Checking  login
    Given open <browser> and navigate to <page>
    When user enters <username> and <password>
    And clicks on login button
    When expected title of page matches with resulted page
    And print and count the all menu links
    And click on each menu link
    Then click on logout and close the browser

    Examples: 
      | browser | page                          | username                 | password |
      | chrome  | https://demo.nopcommerce.com/ | durganutakki99@gmail.com | Eswar99@ |
      | edge    | https://demo.nopcommerce.com/ | durganutakki99@gmail.com | Eswar99@ |
