package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.IdnT_CreateSiteStepDef;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_InitiateUCID extends MyBase {
	
	public static Response initiateUCIDMethod(String version) {
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {

		basePath = Configs.initiateUCIDV1;
		
		resp= given().log().all().relaxedHTTPSValidation()
				.pathParams("dcn", CreateTokenStepDef.dcn, "buid", CreateTokenStepDef.buid, "siteId", IdnT_CreateSiteStepDef.siteId )
				.headers("Content-Type", "application/json")
			  .when()
				.post();	
		}
		
		else if(version.equalsIgnoreCase("V2")) {

		basePath = Configs.initiateUCIDV2;
		
		resp= given().log().all().relaxedHTTPSValidation()
				.pathParams("siteId", IdnT_CreateSiteStepDef.siteId )
				.headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token)
			  .when()
				.post();	
		}
		
		return resp;
	}

}
