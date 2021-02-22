Feature: Identity User-OptinOptout V1

  @regression
  Scenario Outline: Generate token and store fields
    Given With DCN, BUID, Country, Language and other attributes
    When User create token for User-OptinOptout Service with "<DCN>", "<UserEmail>", "<BUID>", "<Country>" and "<Language>"
    Then Display encrypted token in console and store the below values
	
    Examples: 
      | DCN          | UserEmail                        | BUID | Country | Language |
      | 529999842939 | Chitta_ranjan_Nayak@dellteam.com |   11 | US      | EN       |

  Scenario: Create User-OptinOptout V1
    Given API to Create User-OptinOptout
    When User call "V1" Create User-OptinOptout POST HTTP request for the preferenceIds "1,2,3,4,5,6"
    Then Verify 201 status code in Create User-OptinOptout response

  Scenario Outline: Get User-OptinOptout V1
    Given API to Get User-OptinOptout
    When User call "V1" Get User-OptinOptout GET HTTP request for "<UserEmail>"
    Then Verify 200 status code in Get User-OptinOptout response

    Examples: 
      | UserEmail                        |
      | CHITTA_RANJAN_NAYAK@dellteam.com |
      | CHiTta_RaNjAn_NaYaK@dellteam.com |

  Scenario: Update User-OptinOptout V1
    Given API to Update User-OptinOptout
    When User call "V1" Update User-OptinOptout PUT HTTP request with the PreferenceId "5" and Optin as "false"
    Then Verify 200 status code in Update User-OptinOptout response

  Scenario Outline: Get User-OptinOptout V1
    Given API to Get User-OptinOptout
    When User call "V1" Get User-OptinOptout GET HTTP request for "<UserEmail>"
    Then Verify 200 status code in Get User-OptinOptout response

    Examples: 
      | UserEmail                          |
      | cHITTA_rANJAN_nAYAK@dellteam.com   |
      | CHiTta_RaNjAn_NaYaK%40dellteam.com |

  Scenario: Delete User-OptinOptout V1
    Given API to Delete User-OptinOptout
    When User call "V1" Delete User-OptinOptout DELETE HTTP request
    Then Verify 200 status code in Delete User-OptinOptout response

  Scenario: Get User-OptinOptout V1
    Given API to Get User-OptinOptout
    When User call "V1" Get User-OptinOptout GET HTTP request for "Chitta_ranjan_Nayak@dellteam.com"
    Then Verify 200 status code in Get User-OptinOptout response
    Then User call "V1" Create User-OptinOptout POST HTTP request for the preferenceIds "1,2,3,4,5,6"
