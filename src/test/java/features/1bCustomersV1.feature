Feature: Identity Customers V1

  @regression
  Scenario Outline: Generate token and store fields
    Given With DCN, BUID, Country, Language and other attributes
    When User create token for Customer Service with "<DCN>", "<CustomerSalesRepEmail>", "<BUID>", "<Country>" and "<Language>"
    Then Display encrypted token in console and store the below values

    Examples: 
      | DCN          | CustomerSalesRepEmail         | BUID | Country | Language |
      | 529999842939 | custautosalesrep@dellteam.com |   11 | US      | EN       |

  Scenario: Create Customer V1
    Given API to Create Customer
    When User call "V1" Create Customer POST HTTP request
    Then Verify 201 status code in Create Customer response

  Scenario: Get Customer Details V1
    Given API to Get Customer
    When User call "V1" Get Customer GET HTTP request
    Then Verify 200 status code in Get Customer response
    And Verify DCN should not be null in Get Customer response
    And Verify Name should not be null in Get Customer response
    And Verify Discount should not be null in Get Customer response
    And Verify companyNumber should not be null in Get Customer response
    And Verify OrganizationLegalName should not be null in Get Customer response
    And Verify paymentMethods should not be null in Get Customer response
    And Verify billingcadence should not be null in Get Customer response
    And Verify salesReps should not be null in Get Customer response

  Scenario Outline: Update Customer Details V1
    Given API to Update Customer
    When User call "V1" Update Customer PUT HTTP request for name "Google" discount "2.2" and salesRep "<CustomerSalesRepEmail>"
    Then Verify 200 status code in Update Customer response

    Examples: 
      | CustomerSalesRepEmail         |
      | CUSTAUTOSALESREP@dellteam.com |
      | custautosalesrep@DELLTEAM.COM |
      | cUStautoSAleSRep@dellteam.com |
      | custautosalesrep@dellteam.com |

  Scenario: Get Customer Details V1
    Given API to Get Customer
    When User call "V1" Get Customer GET HTTP request
    Then Verify 200 status code in Get Customer response
    And Verify DCN should not be null in Get Customer response
    And Verify Name should not be null in Get Customer response
    And Verify Discount should not be null in Get Customer response
    And Verify companyNumber should not be null in Get Customer response
    And Verify OrganizationLegalName should not be null in Get Customer response
    And Verify paymentMethods should not be null in Get Customer response
    And Verify billingcadence should not be null in Get Customer response
    And Verify salesReps should not be null in Get Customer response

  Scenario: Update Customer Discount V1
    Given API to Update Customer Discount
    When User call "V1" Update Customer Discount PUT HTTP request for the discount of "21.90"
    Then Verify 200 status code in Update Customer Discount response

  Scenario: Get Customer Details V1
    Given API to Get Customer
    When User call "V1" Get Customer GET HTTP request
    Then Verify 200 status code in Get Customer response
    And Verify DCN should not be null in Get Customer response
    And Verify Name should not be null in Get Customer response
    And Verify Discount should not be null in Get Customer response
    And Verify companyNumber should not be null in Get Customer response
    And Verify OrganizationLegalName should not be null in Get Customer response
    And Verify paymentMethods should not be null in Get Customer response
    And Verify billingcadence should not be null in Get Customer response
    And Verify salesReps should not be null in Get Customer response

  Scenario: Get Customer Payment Methods V1
    Given API to Get Customer Payment Methods
    When User call "V1" Get Customer Payment Methods GET HTTP request
    Then Verify 200 status code in Get Customer Payment Methods response

  Scenario: Get Customer Billing Cadence V1
    Given API to Get Customer Billing Cadence
    When User call "V1" Get Customer Billing Cadence GET HTTP request
    Then Verify 200 status code in Get Customer Billing Cadence response

  Scenario: Get Customer Primary Sales Representative V1
    Given API to Get Customer Primary Sales Representative
    When User call "V1" Get Customer Primary Sales Representative GET HTTP request
    Then Verify 200 status code in Get Customer Primary Sales Representative response

  Scenario: Get Customer Purchase Entity V1
    Given API to Get Customer Purchase Entity
    When User call "V1" Get Customer Purchase Entity GET HTTP request
    Then Verify 200 status code in Get Customer Purchase Entity response

  Scenario Outline: Get Customers under a Sales Representative V1
    Given API to Get Customers under a Sales Representative
    When User call "V1" Get Customers under a Sales Representative GET HTTP request for "<salesrepemail>"
    Then Verify 200 status code in Get Customers under a Sales Representative response

    Examples: 
      | salesrepemail                   |
      | CUSTAUTOSALESREP@dellteam.com   |
      | custautosalesrep@DELLTEAM.COM   |
      | cUStautoSAleSRep@dElltEam.com   |
      | CustAutoSalesRep%40dellteam.com |
      | invalidSalesRepp@dell.com       |

  Scenario: Delete customer V1
    Given API to Delete Customer
    When User call "V1" Delete Customer DELETE HTTP request
    Then Verify 200 status code in Delete Customer response

  Scenario: Get Customer Payment Methods V1
    Given API to Get Customer Payment Methods
    When User call "V1" Get Customer Payment Methods GET HTTP request
    Then Verify 200 status code in Get Customer Payment Methods response

  Scenario: Get Customer Billing Cadence V1
    Given API to Get Customer Billing Cadence
    When User call "V1" Get Customer Billing Cadence GET HTTP request
    Then Verify 200 status code in Get Customer Billing Cadence response

  Scenario: Get Customer Primary Sales Representative V1
    Given API to Get Customer Primary Sales Representative
    When User call "V1" Get Customer Primary Sales Representative GET HTTP request
    Then Verify 404 status code in Get Customer Primary Sales Representative response

  Scenario: Get Customer Purchase Entity V1 for invalid DCN
    Given API to Get Customer Purchase Entity
    When User call "V1" Get Customer Purchase Entity GET HTTP request for invalid DCN
    Then Verify 404 status code in Get Customer Purchase Entity response

  Scenario: Get Customer Details V1
    Given API to Get Customer
    When User call "V1" Get Customer GET HTTP request
    Then Verify 404 status code in Get Customer response
    And User call "V1" Create Customer POST HTTP request to support other tracks
