package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import payloads.IdnT_CreateUserOptinOptoutPayload;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_CreateUserOptinOptout extends MyBase{
	
	public static Response createUserOptinOptoutMethod(String version, String prefId){
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.createUserOptinOptoutV1;
			
			resp= given().log().all().relaxedHTTPSValidation()
					.headers("Content-Type", "application/json")
					.body(IdnT_CreateUserOptinOptoutPayload.createUserOptinOptoutV1(CreateTokenStepDef.useroptinoptout_email, CreateTokenStepDef.dcn, prefId))
				  .when()
					.post();			
		}
		
		else if(version.equalsIgnoreCase("V2")) {
			
			basePath = Configs.createUserOptinOptoutV2;
			
			resp= given().log().all().relaxedHTTPSValidation()
					.headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token)
					.body(IdnT_CreateUserOptinOptoutPayload.createUserOptinOptoutV2(CreateTokenStepDef.useroptinoptout_email, prefId))
				  .when()
					.post();			
		}
		
		return resp;
	}

}
