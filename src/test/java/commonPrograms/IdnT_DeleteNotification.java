package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.CreateTokenStepDef;
import stepDefinitions.IdnT_GetNotificationStepDef;

public class IdnT_DeleteNotification extends MyBase{
	
	public static Response deleteNotificationMethod(String version) {
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.deleteNotificationV1;
			
			resp =  given().log().all().relaxedHTTPSValidation().
						queryParams("alert", IdnT_GetNotificationStepDef.alertid, "recipient", IdnT_GetNotificationStepDef.email, "dcn", CreateTokenStepDef.dcn).
						headers("Content-Type", "application/json").
					when().
						delete();		
		}
		
		else if(version.equalsIgnoreCase("V2")) {
			
			basePath = Configs.deleteNotificationV2;
			
			resp =  given().log().all().relaxedHTTPSValidation().
						queryParams("alert", IdnT_GetNotificationStepDef.alertid, "recipient", IdnT_GetNotificationStepDef.email).
						headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
					when().
						delete();		
		}
		
		return resp;
	}

}
