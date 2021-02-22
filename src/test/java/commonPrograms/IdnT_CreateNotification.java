package commonPrograms;

import configurations.Configs;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import payloads.IdnT_CreateNotificationPayload;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_CreateNotification extends MyBase{
	
	public static Response createNotificationMethod(String version) {
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.createNotificationV1;
			
			if (CreateTokenStepDef.eventtype.equalsIgnoreCase("PurchaseRequest")) {
				
				resp =  given().log().all().relaxedHTTPSValidation().
						headers("Content-Type", "application/json").
						body(IdnT_CreateNotificationPayload.createRequestNotificationV1(CreateTokenStepDef.dcn, CreateTokenStepDef.eventtype)).
					when().
						post();									
			}
			
			else if (CreateTokenStepDef.eventtype.equalsIgnoreCase("PurchaseApproved")) {
				
				resp =  given().log().all().relaxedHTTPSValidation().
						headers("Content-Type", "application/json").
						body(IdnT_CreateNotificationPayload.createApproveNotificationV1(CreateTokenStepDef.dcn, CreateTokenStepDef.eventtype)).
					when().
						post();									
			}
			
			else if (CreateTokenStepDef.eventtype.equalsIgnoreCase("PurchaseRejected")) {
				
				resp =  given().log().all().relaxedHTTPSValidation().
						headers("Content-Type", "application/json").
						body(IdnT_CreateNotificationPayload.createRejectNotificationV1(CreateTokenStepDef.dcn, CreateTokenStepDef.eventtype)).
					when().
						post();									
			}
	
		}		
		
		else if(version.equalsIgnoreCase("V2")) {
			
			basePath = Configs.createNotificationV2;
			
			if (CreateTokenStepDef.eventtype.equalsIgnoreCase("PurchaseRequest")) {
				
				resp =  given().log().all().relaxedHTTPSValidation().
						headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
						body(IdnT_CreateNotificationPayload.createRequestNotificationV2(CreateTokenStepDef.eventtype)).
					when().
						post();
			}
			
			else if (CreateTokenStepDef.eventtype.equalsIgnoreCase("PurchaseApproved")) {
				
				resp =  given().log().all().relaxedHTTPSValidation().
						headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
						body(IdnT_CreateNotificationPayload.createApproveNotificationV2(CreateTokenStepDef.eventtype)).
					when().
						post();
			}
			
			else if (CreateTokenStepDef.eventtype.equalsIgnoreCase("PurchaseRejected")) {
				
				resp =  given().log().all().relaxedHTTPSValidation().
						headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
						body(IdnT_CreateNotificationPayload.createRejectNotificationV2(CreateTokenStepDef.eventtype)).
					when().
						post();
			}
			
		}
		
		return resp;
		
	}

}
