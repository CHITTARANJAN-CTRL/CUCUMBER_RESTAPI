Feature: Identity Customers V2

  @regression
  Scenario Outline: Generate token and store fields
    Given With DCN, BUID, Country, Language and other attributes
    When User create token for Customer Service with "<DCN>", "<CustomerSalesRepEmail>", "<buId>", "<Country>" and "<Language>"
    Then Display encrypted token in console and store the below values

    Examples: 
      | DCN       | CustomerSalesRepEmail           | buId | Country | Language |
      | FR7762354 | frcustautosalesrep@dellteam.com | 909 | FR      | FR       |

  Scenario: Create Customer V2
    Given API to Create Customer
    When User call "V2" Create Customer POST HTTP request
    Then Verify 201 status code in Create Customer response

  Scenario: Get Customer Details V2
    Given API to Get Customer
    When User call "V2" Get Customer GET HTTP request
    Then Verify 200 status code in Get Customer response
    And Verify DCN should not be null in Get Customer response
    And Verify Name should not be null in Get Customer response
    And Verify Discount should not be null in Get Customer response
    And Verify companyNumber should not be null in Get Customer response
    And Verify giiCustomerNumber should not be null in Get Customer response
    And Verify OrganizationLegalName should not be null in Get Customer response
    And Verify Country should not be null in get Get Customer response
    And Verify BUID should not be null in Get Customer response
    And Verify paymentMethods should not be null in Get Customer response
    And Verify billingcadence should not be null in Get Customer response
    And Verify salesReps should not be null in Get Customer response

  Scenario Outline: Update Customer Details V2
    Given API to Update Customer
    When User call "V2" Update Customer PUT HTTP request for name "Google" discount "2.2" and salesRep "<CustomerSalesRepEmail>"
    Then Verify 200 status code in Update Customer response

    Examples: 
      | CustomerSalesRepEmail           |
      | frCUSTAUTOSALESREP@dellteam.com |
      | FRcustautosalesrep@DELLTEAM.COM |
      | FrcUStautoSAleSRep@dellteam.com |
      | frcustautosalesrep@dellteam.com |

  Scenario: Get Customer Details V2
    Given API to Get Customer
    When User call "V2" Get Customer GET HTTP request
    Then Verify 200 status code in Get Customer response
    And Verify DCN should not be null in Get Customer response
    And Verify Name should not be null in Get Customer response
    And Verify Discount should not be null in Get Customer response
    And Verify companyNumber should not be null in Get Customer response
    And Verify giiCustomerNumber should not be null in Get Customer response
    And Verify OrganizationLegalName should not be null in Get Customer response
    And Verify Country should not be null in get Get Customer response
    And Verify BUID should not be null in Get Customer response
    And Verify paymentMethods should not be null in Get Customer response
    And Verify billingcadence should not be null in Get Customer response
    And Verify salesReps should not be null in Get Customer response

  Scenario: Update Customer Discount V2
    Given API to Update Customer Discount
    When User call "V2" Update Customer Discount PUT HTTP request for the discount of "21.90"
    Then Verify 200 status code in Update Customer Discount response

  Scenario: Get Customer Details V2
    Given API to Get Customer
    When User call "V2" Get Customer GET HTTP request
    Then Verify 200 status code in Get Customer response
    And Verify DCN should not be null in Get Customer response
    And Verify Name should not be null in Get Customer response
    And Verify Discount should not be null in Get Customer response
    And Verify companyNumber should not be null in Get Customer response
    And Verify giiCustomerNumber should not be null in Get Customer response
    And Verify OrganizationLegalName should not be null in Get Customer response
    And Verify Country should not be null in get Get Customer response
    And Verify BUID should not be null in Get Customer response
    And Verify paymentMethods should not be null in Get Customer response
    And Verify billingcadence should not be null in Get Customer response
    And Verify salesReps should not be null in Get Customer response

  Scenario: Get Customer Payment Methods V2
    Given API to Get Customer Payment Methods
    When User call "V2" Get Customer Payment Methods GET HTTP request
    Then Verify 200 status code in Get Customer Payment Methods response

  Scenario: Get Customer Billing Cadence V2
    Given API to Get Customer Billing Cadence
    When User call "V2" Get Customer Billing Cadence GET HTTP request
    Then Verify 200 status code in Get Customer Billing Cadence response

  Scenario: Get Customer Primary Sales Representative V2
    Given API to Get Customer Primary Sales Representative
    When User call "V2" Get Customer Primary Sales Representative GET HTTP request
    Then Verify 200 status code in Get Customer Primary Sales Representative response

  Scenario Outline: Get Customers under a Sales Representative V2
    Given API to Get Customers under a Sales Representative
    When User call "V2" Get Customers under a Sales Representative GET HTTP request for "<salesrepemail>"
    Then Verify 200 status code in Get Customers under a Sales Representative response

    Examples: 
      | salesrepemail                   |
      | frCUSTAUTOSALESREP@dellteam.com |
      | FRcustautosalesrep@DELLTEAM.COM |
      | FrcUStautoSAleSRep@dellteam.com |
      | frcustautosalesrep@dellteam.com |
      | inavalidSalesRep@dellteam.com   |

  Scenario: Delete customer V2
    Given API to Delete Customer
    When User call "V2" Delete Customer DELETE HTTP request
    Then Verify 200 status code in Delete Customer response

  Scenario: Get Customer Payment Methods V2
    Given API to Get Customer Payment Methods
    When User call "V2" Get Customer Payment Methods GET HTTP request
    Then Verify 200 status code in Get Customer Payment Methods response

  Scenario: Get Customer Billing Cadence V2
    Given API to Get Customer Billing Cadence
    When User call "V2" Get Customer Billing Cadence GET HTTP request
    Then Verify 200 status code in Get Customer Billing Cadence response

  Scenario: Get Customer Primary Sales Representative V2
    Given API to Get Customer Primary Sales Representative
    When User call "V2" Get Customer Primary Sales Representative GET HTTP request
    Then Verify 404 status code in Get Customer Primary Sales Representative response

  Scenario: Get Customer Details V2
    Given API to Get Customer
    When User call "V2" Get Customer GET HTTP request
    Then Verify 404 status code in Get Customer response
    And User call "V2" Create Customer POST HTTP request to support other tracks
