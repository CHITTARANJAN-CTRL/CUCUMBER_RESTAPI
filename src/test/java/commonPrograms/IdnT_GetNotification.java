package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_GetNotification extends MyBase {

	public static Response getNotificationMethod(String version, String email, String notificationtype, String sortby, String sortorder) {

		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.getNotificationV1;

			resp = given().log().all().relaxedHTTPSValidation().
						pathParams("dcn", CreateTokenStepDef.dcn, "email", email).
						queryParams("notificationtype", notificationtype, "sortBy", sortby, "sortOrder", sortorder).
						headers("Content-Type", "application/json").
					when().
						get();			
		}
		
		else if(version.equalsIgnoreCase("V2")) {
			
			basePath = Configs.getNotificationV2;

			resp = given().log().all().relaxedHTTPSValidation().
						pathParams("email", email).
						queryParams("notificationtype", notificationtype, "sortBy", sortby, "sortOrder", sortorder).
						headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
					when().
						get();			
		}

		return resp;
	}

}
