Feature: Search Product
  As a User,
  I want to see search product functionality working as expected
  So that I can search anything product what I want

  Scenario Outline: Search results product displayed should be relevant to search keyword
    Given User navigate to the Tokopedia Home page
    When User search for keyword "<Keyword Search>" in search box and click Enter
    Then User can see product on the result page is contains "<Keyword Search>"

    Examples:
      | Keyword Search |
      | Kaos           |
      | Celana         |
      | Sepatu         |

  Scenario: Search results displayed product not available when not relevant search keyword
    Given User navigate to the Tokopedia Home page
    When User search for keyword "Shopee" in search box and click Enter
    Then User can see icon product not available in result page