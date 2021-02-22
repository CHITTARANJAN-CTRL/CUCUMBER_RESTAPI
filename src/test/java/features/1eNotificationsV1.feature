Feature: Identity Notifications V1

@regression
  Scenario Outline: Generate token and store fields
    Given With DCN, BUID, Country, Language and other attributes
     When User create token for Notifications Service with "<DCN>", "<EventType>", "<BUID>", "<Country>" and "<Language>"
     Then Display encrypted token in console and store the below values
  
    Examples: 
      | DCN          | EventType       | BUID | Country | Language | 
      | 529999842939 | PurchaseRequest | 11   | US      | EN       | 
  
  Scenario: Create Notification V1
    Given API to Create Notification
     When User call "V1" Create Notification POST HTTP request
     Then Verify 201 status code in Create Notification response
  
  Scenario: Get Notification V1
    Given API to Get Notification
     When User call "V1" Get Notification GET HTTP request with valid email as "Chitta_ranjan_Nayak@dellteam.com", Notificationtype as "inapp" and choose sortBy "createdDate" with "DESC" sortOrder
     Then Verify 200 expected status code in Get Notification response
     Then Verify the records are in sortBy "createdDate" with "DESC" sortOrder in Get Notification response
  
  Scenario: Update Notification V1
    Given API to Update Notification
     When User call "V1" Update Notification PUT HTTP request with "Read" status
     Then Verify 200 expected status code in Update Notification response
  
  Scenario Outline: Get Notification V1
    Given API to Get Notification
     When User call "V1" Get Notification GET HTTP request with valid email as "<email>", Notificationtype as "inapp" and choose sortBy "createdDate" with "DESC" sortOrder
     Then Verify 200 expected status code in Get Notification response
     Then Verify the records are in sortBy "createdDate" with "DESC" sortOrder in Get Notification response
  
    Examples: 
      | email                              | 
      | Chitta_ranjan_Nayak@dellteam.com   | 
      | cHITTA_rANJAN_nAYAK@DELLTEAM.COM   | 
      | Chitta_ranjan_Nayak%40Dellteam.com | 
  
  Scenario: Delete Notification V1
    Given API to Delete Notification
     When User call "V1" Delete Notification DELETE HTTP request
     Then Verify 200 expected status code in Delete Notification response
  
  Scenario Outline: Get Notification for Invalid email data V1
    Given API to Get Notification
     When User call "V1" Get Notification GET HTTP request with invalid email as "<email>", Notificationtype as "inapp" and choose sortBy "createdDate" with "ASC" sortOrder
     Then Verify 200 expected status code in Get Notification response
  
    Examples: 
      | email                      | 
      | Chitta_ranjan@dellteam.com | 
      | Chitta_ranjan@gmil.com     | 
