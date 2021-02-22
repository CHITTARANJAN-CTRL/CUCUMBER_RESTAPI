Feature: Identity Sites V2

  @regression
  Scenario Outline: Generate token and store fields
    Given With DCN, BUID, Country, Language and other attributes
    When User create token for Site Service with "<DCN>", "<FirstName>", "<LastName>", "<CustomerEmail>", "<AddressLineOne>", "<BUID>", "<Country>" and "<Language>"
    Then Display encrypted token in console and store the below values

    Examples: 
      | DCN       | FirstName | LastName | CustomerEmail                 | AddressLineOne | BUID | Country | Language |
      | FR7762354 | Vamsee    | T        | vamsee_krishna_tirup@Dell.com | E9 Parmer Lane |  909 | FR      | FR       |

  Scenario: Creating Site V2
    Given API to Create Site
    When User call "V2" Create Site POST HTTP request
    Then Verify 201 status code in Create Site response

  Scenario: Get Site by SiteId V2
    Given API to Get Site by SiteId
    When User call "V2" Get Site by SiteId GET HTTP request
    Then Verify 200 status code in Get Site by SiteId response
    And Verify contactId should not be null in Get Site by SiteId response
    And Verify phoneContactMethodId should not be null in Get Site by SiteId response
    And Verify emailContactMethodId should not be null in Get Site by SiteId response
    And Verify firstName should not be null in Get Site by SiteId response
    And Verify lastName should not be null in Get Site by SiteId response
    And Verify phoneContactMethodId should not be null in Get Site by SiteId response
    And Verify phone number should not be null in Get Site by SiteId response
    And Verify phone countryCode should not be null in Get Site by SiteId response
    And Verify phone areaCode should not be null in Get Site by SiteId response
    And Verify phone phoneType should not be null in Get Site by SiteId response
    And Verify emailContactMethodId should not be null in Get Site by SiteId response
    And Verify email value should not be null in Get Site by SiteId response
    And Verify address siteId should not be null in Get Site by SiteId response
    And Verify address ucidStatus should not be null in Get Site by SiteId response
    And Verify address primary should not be null in Get Site by SiteId response
    And Verify address addressLineOne should not be null in Get Site by SiteId response
    And Verify address addressLineTwo should not be null in Get Site by SiteId response
    And Verify address addressLineThree should not be null in Get Site by SiteId response
    And Verify address city should not be null in Get Site by SiteId response
    And Verify address countryCode should not be null in Get Site by SiteId response
    And Verify address zipPostalCode should not be null in Get Site by SiteId response
    And Verify address status should not be null in Get Site by SiteId response
    And Verify address provinceStateCountyCode should not be null in Get Site by SiteId response

  Scenario: Update Site Contact Details V2
    Given API to Update Site
    When User call "V2" Update Site PUT HTTP request with the firstname "VamseeKrishna" lastname "Tirupati" and email "Vamsee_Krishna_Tirupati@Dellteam.com"
    Then Verify 200 status code in Update Site response

  Scenario: Get Site by SiteId V2
    Given API to Get Site by SiteId
    When User call "V2" Get Site by SiteId GET HTTP request
    Then Verify 200 status code in Get Site by SiteId response
    And Verify contactId should not be null in Get Site by SiteId response
    And Verify phoneContactMethodId should not be null in Get Site by SiteId response
    And Verify emailContactMethodId should not be null in Get Site by SiteId response
    And Verify firstName should not be null in Get Site by SiteId response
    And Verify lastName should not be null in Get Site by SiteId response
    And Verify phoneContactMethodId should not be null in Get Site by SiteId response
    And Verify phone number should not be null in Get Site by SiteId response
    And Verify phone countryCode should not be null in Get Site by SiteId response
    And Verify phone areaCode should not be null in Get Site by SiteId response
    And Verify phone phoneType should not be null in Get Site by SiteId response
    And Verify emailContactMethodId should not be null in Get Site by SiteId response
    And Verify email value should not be null in Get Site by SiteId response
    And Verify address siteId should not be null in Get Site by SiteId response
    And Verify address ucidStatus should not be null in Get Site by SiteId response
    And Verify address primary should not be null in Get Site by SiteId response
    And Verify address addressLineOne should not be null in Get Site by SiteId response
    And Verify address city should not be null in Get Site by SiteId response
    And Verify address countryCode should not be null in Get Site by SiteId response
    And Verify address zipPostalCode should not be null in Get Site by SiteId response
    And Verify address status should not be null in Get Site by SiteId response
    And Verify address provinceStateCountyCode should not be null in Get Site by SiteId response

  Scenario: Get Primary Site V2
    Given API to Get Primary Site
    When User call "V2" Get Primary Site GET HTTP request
    Then Verify 200 status code in Get Primary Site response
    And Verify customerDCN should not be null in Get Primarysite response
    And Verify billingaddress id should not be null in Get Primarysite response
    And Verify billingaddress contact contactId should not be null in Get Primarysite response
    And Verify billingaddress contact firstName should not be null in Get Primarysite response
    And Verify billingaddress contact lastName should not be null in Get Primarysite response
    And Verify billingaddress phoneNumber phoneContactMethodId should not be null in Get Primarysite response
    And Verify billingaddress phone number should not be null in Get Primarysite response
    And Verify billingaddress phone countryCode should not be null in Get Primarysite response
    And Verify billingaddress phone areaCode should not be null in Get Primarysite response
    And Verify billingaddress phone phoneType should not be null in Get Primarysite response
    And Verify billingaddress email contactMethodId should not be null in Get Primarysite response
    And Verify billingaddress email value should not be null in Get Primarysite response
    And Verify billingaddress address primary siteId should not be null in Get Primarysite response
    And Verify billingaddress address addressLineOne ucidStatus should not be null in Get Primarysite response
    And Verify billingaddress address city should not be null in Get Primarysite response
    And Verify billingaddress address countryCode should not be null in Get Primarysite response
    And Verify billingaddress address zipPostalCode should not be null in Get Primarysite response
    And Verify billingaddress address status should not be null in Get Primarysite response
    And Verify billingaddress address provinceStateCountyCode should not be null in Get Primarysite response
    And Verify shippingaddress id should not be null in Get Primarysite response
    And Verify shippingaddress contact contactId should not be null in Get Primarysite response
    And Verify shippingaddress contact firstName should not be null in Get Primarysite response
    And Verify shippingaddress contact lastName should not be null in Get Primarysite response
    And Verify shippingaddress phoneNumber phoneContactMethodId should not be null in Get Primarysite response
    And Verify shippingaddress phone number should not be null in Get Primarysite response
    And Verify shippingaddress phone countryCode should not be null in Get Primarysite response
    And Verify shippingaddress phone areaCode should not be null in Get Primarysite response
    And Verify shippingaddress phone phoneType should not be null in Get Primarysite response
    And Verify shippingaddress emailContactMethodId should not be null in Get Primarysite response
    And Verify shippingaddress email value should not be null in Get Primarysite response
    And Verify shippingaddress address primary siteId should not be null in Get Primarysite response
    And Verify shippingaddress address addressLineOne ucidStatus should not be null in Get Primarysite response
    And Verify shippingaddress address city should not be null in Get Primarysite response
    And Verify shippingaddress address countryCode should not be null in Get Primarysite response
    And Verify shippingaddress address zipPostalCode should not be null in Get Primarysite response
    And Verify shippingaddress address status should not be null in Get Primarysite response
    And Verify shippingaddress address provinceStateCountyCode should not be null in Get Primarysite response

  Scenario: Get Primary Shipping Address V2
    Given API to Get Primary Shipping Address
    When User call "V2" Get Primar yShipping Address GET HTTP request with sitetype "installAt"
    Then Verify 200 status code in Get Primary Shipping Address response

  Scenario: Get Primary Billing address V2
    Given API to Get Primary Billing Address
    When User call "V2" Get Primary Billing Address GET HTTP request
    Then Verify 200 status code in Get Primary Billing Address response

  Scenario: Get All Sites V2
    Given API to Get All Sites
    When User call "V2" Get All Sites GET HTTP request
    Then Verify 200 status code in Get All Sites response

  Scenario: Get UCID Status V2
    Given API to Get UCID Status
    When User call "V2" Get UCID Status GET HTTP request
    Then Verify 200 status code in Get UCID Status response

  Scenario: Initiate UCID V2
    Given API to Initiate UCID
    When User call "V2" Initiate UCID POST HTTP request
    Then Verify 200 or 400 status code in Initiate UCID response

  Scenario: Get Contact Info V2
    Given API to Get Contact Info
    When User call "V2" Get Contact Info GET HTTP request
    Then Verify 200 status code in Get Contact Info response

  Scenario: Get Contact Info V2 with invalid camLocationID
    Given API to Get Contact Info
    When User call "V2" Get Contact Info GET HTTP request with invalid camLocationID
    Then Verify 404 status code in Get Contact Info response
