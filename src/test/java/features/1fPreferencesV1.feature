Feature: Identity Preferences V1

  @regression
  Scenario Outline: Generate token and store fields
    Given With DCN, BUID, Country, Language and other attributes
    When User create token for Preferences Service with "<DCN>", "<RightIds>", "<BUID>", "<Country>" and "<Language>"
    Then Display encrypted token in console and store the below values

    Examples: 
      | DCN          | RightIds     | BUID | Country | Language |
      | 529999842939 | 529999845388 |   11 | US      | EN       |

  Scenario: Create Preference for given RightsID V1
    Given API to Create Preference
    When User call "V1" Create Preference POST HTTP request
    Then Verify 201 status code in Create Preference response

  Scenario: Get All Preferences V1
    Given API to Get Preferences
    When User call "V1" Get Preferences GET HTTP request
    Then Verify 200 status code in Get Preferences response

  Scenario: Update Preference for given RightsID V1
    Given API to Update Preference
    When User call "V1" Update Preference PUT HTTP request
    Then Verify 200 status code in Update Preference response

  Scenario: Get All Preferences V1
    Given API to Get Preferences
    When User call "V1" Get Preferences GET HTTP request
    Then Verify 200 status code in Get Preferences response

  Scenario: Get Payload Structure V1
    Given API to Get Payload Structure
    When User call "V1" Get Payload Structure GET HTTP request
    Then Verify 200 status code in Get Payload Structure response

  Scenario: Delete Preference for given RightsID V1
    Given API to Delete Preference
    When User call "V1" Delete Preference DELETE HTTP request
    Then Verify 200 status code in Delete Preferences response

  Scenario: Get All Preferences after delete V1
    Given API to Get Preferences
    When User call "V1" Get Preferences GET HTTP request after delete
    Then Verify 200 status code in Get Preferences response
