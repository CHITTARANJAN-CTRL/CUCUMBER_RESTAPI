package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_GetUserOptinOptout extends MyBase {
	
	public static Response GetUserOptinOptoutMethod(String version, String user_email) {
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.getUserOptinOptoutV1;

			resp = given().log().all().relaxedHTTPSValidation()
					.pathParams("email", user_email, "dcn", CreateTokenStepDef.dcn)
					.headers("Content-Type", "application/json").
				   when().
				   	 get();			
		}
		
		else if(version.equalsIgnoreCase("V2")) {
			
			basePath = Configs.getUserOptinOptoutV2;

			resp = given().log().all().relaxedHTTPSValidation()
					.pathParams("email", user_email)
					.headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
				   when().
				   	 get();			
		}

		return resp;

	}
}