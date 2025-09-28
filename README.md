# Beymen WebSite Test Scenario

    Given User navigates to website and verify title as "Beymen.com – Türkiye’nin Tek Dijital Lüks Platformu" and current link as "https://www.beymen.com/tr"
    When User type a product name and then removes it
    Then User type another product name and then enter with keyboard key
    Then User verifies current link as "https://www.beymen.com/tr/search?q=gomlek"
    And User clicks first product on the page and verifies product page
    Then User adds selected product to cart
    And User verifies the price of the product on both Product Detail Page and Cart Page
    When User switch to two quantities of the selected product as 2
    Then User removes the product from cart page
    And User verifies cart page is empty

Cucumber + JUnit + Java(version 11) + BDD are used in this project

The script can be kicked either from Runner Class under Runner Folder or from Scenario.feature file which is under features folder


HTML report is created after each run and that can be viewed under Target Folder# Beymen
# Beymen
# Beymen
