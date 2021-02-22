Feature: Identity Sales Representative V1

  @regression
  Scenario Outline: Generate token and store fields
    Given With DCN, BUID, Country, Language and other attributes
    When User create token for Sales Rep Service with "<DCN>", "<FirstName>", "<LastName>", "<FullName>", "<SalesRepemail>", "<SalesRepId>", "<BUID>", "<Country>" and "<Language>"
    Then Display encrypted token in console and store the below values

    Examples: 
      | DCN          | FirstName  | LastName   | FullName              | SalesRepemail                   | SalesRepId  | BUID | Country | Language |
      | 529999845388 | SalRep1_FN | SalRep1_LN | SalRep1_FN SalRep1_LN | automationsalesrep@dellteam.com | 75021002244 |   11 | US      | EN       |

  Scenario: Create Sales Representative V1
    Given API to Create Sales Representative
    When User call "V1" Create Sales Representative POST HTTP request
    Then Verify 201 status code in Create Sales Representative response

  Scenario: Get Sales Representative Details V1
    Given API to Get Sales Representative Details
    When User call "V1" Get Sales Representative Details GET HTTP request
    Then Verify 200 status code in Get Sales Representative Details response
    And Verify firstName field should not be null in Get Sales Representative Details response
    And Verify lastName field should not be null in Get Sales Representative Details response
    And Verify fullName field should not be null in Get Sales Representative Details response
    And Verify email field should not be null in Get Sales Representative Details response
    And Verify phone field should not be null in Get Sales Representative Details response
    And Verify salesRepId field should not be null in Get Sales Representative Details response
    
  Scenario: Update Sales Representative Details V1
    Given API to Update Sales Representative Details
    When User call "V1" Update Sales Representative Details PUT HTTP request for firstname "SalesRep2_FN" lastname "SalesRep2_LN" and fullname "SalesRep2_FN SalesRep2_LN"
    Then Verify 200 status code in Update Sales Representative Details response

   Scenario: Get Sales Representative Details V1
    Given API to Get Sales Representative Details
    When User call "V1" Get Sales Representative Details GET HTTP request
    Then Verify 200 status code in Get Sales Representative Details response
    And Verify firstName field should not be null in Get Sales Representative Details response
    And Verify lastName field should not be null in Get Sales Representative Details response
    And Verify fullName field should not be null in Get Sales Representative Details response
    And Verify email field should not be null in Get Sales Representative Details response
    And Verify phone field should not be null in Get Sales Representative Details response
    And Verify salesRepId field should not be null in Get Sales Representative Details response

  Scenario: Delete Sales Representative V1
    Given API to Delete Sales Representative
    When User call "V1" Delete Sales Representative DELETE HTTP request
    Then Verify 200 status code in Delete Sales Representative Details response

  Scenario: Get Sales Representative Details V1
    Given API to Get Sales Representative Details
    When User call "V1" Get Sales Representative Details GET HTTP request
    Then Verify 404 status code in Get Sales Representative Details response
