package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import payloads.IdnT_UpdateUserOptinOptoutPayload;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_UpdateUserOptinOptout extends MyBase {

	public static Response UpdateUserOptinOptoutMethod(String version, String preferenceid, String optin) {

		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.updateUserOptinOptoutV1;

			resp = given().log().all().relaxedHTTPSValidation().
					pathParams("email", CreateTokenStepDef.useroptinoptout_email, "dcn", CreateTokenStepDef.dcn).
					headers("Content-Type", "application/json").
					body(IdnT_UpdateUserOptinOptoutPayload.UpdateUserOptinOptoutV1(CreateTokenStepDef.useroptinoptout_email, CreateTokenStepDef.dcn, preferenceid, optin)).
				   when().
					 put();			
		}
		
		else if(version.equalsIgnoreCase("V2")) {
			
			basePath = Configs.updateUserOptinOptoutV2;

			resp = given().log().all().relaxedHTTPSValidation().
					pathParams("email", CreateTokenStepDef.useroptinoptout_email).
					headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
					body(IdnT_UpdateUserOptinOptoutPayload.UpdateUserOptinOptoutV2(CreateTokenStepDef.useroptinoptout_email, preferenceid, optin)).
				   when().
					 put();			
		}

		return resp;
	}
}
