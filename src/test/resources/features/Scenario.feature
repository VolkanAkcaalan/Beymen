Feature: Scenario - Proje Odevi



  @BeymenSmokeTest
  Scenario: Scenario 1 - Home Page > Product Page > Product Detail Page > Cart Page
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

