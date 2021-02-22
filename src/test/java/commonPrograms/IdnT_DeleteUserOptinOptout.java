package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_DeleteUserOptinOptout extends MyBase
{

	public static Response deleteUserOptinOptoutMethod(String version) {
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
		basePath = Configs.deleteUserOptinOptoutV1; 
			
			resp =  given().log().all().relaxedHTTPSValidation().
					  pathParams("email", CreateTokenStepDef.useroptinoptout_email, "dcn", CreateTokenStepDef.dcn).
					  headers("Content-Type", "application/json").
					when().
					  delete();			
		}
		
		else if(version.equalsIgnoreCase("V2")) {
			
		basePath = Configs.deleteUserOptinOptoutV2; 
			
			resp =  given().log().all().relaxedHTTPSValidation().
					  pathParams("email", CreateTokenStepDef.useroptinoptout_email).
					  headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
					when().
					  delete();			
		}
			
		return resp;
		
	}
	
	//Below method is to delete before the UserOptinOptout Creation if at all record exists to avoid our unnecessary test failures
	public static Response createDeleteUserOptinOptoutMethod(String version) {
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {

			basePath = Configs.deleteUserOptinOptoutV1; 
			
			resp =  given().relaxedHTTPSValidation().
					  pathParams("email", CreateTokenStepDef.useroptinoptout_email, "dcn", CreateTokenStepDef.dcn).
					  headers("Content-Type", "application/json").
					when().
					  delete();	
		}
		
		else if(version.equalsIgnoreCase("V2")) {

			basePath = Configs.deleteUserOptinOptoutV2; 
			
			resp =  given().relaxedHTTPSValidation().
					  pathParams("email", CreateTokenStepDef.useroptinoptout_email).
					  headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
					when().
					  delete();	
		}
			
		return resp;
		
	}
	
}
