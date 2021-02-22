package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.IdnT_CreateSiteStepDef;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_GetSiteBySiteID extends MyBase {

	public static Response getSiteBySiteIDMethod(String version) {

		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.getSiteBySiteIDV1;

			resp = given().log().all().relaxedHTTPSValidation().
					pathParams("dcn", CreateTokenStepDef.dcn, "siteId", IdnT_CreateSiteStepDef.siteId).
					headers("Content-Type", "application/json").
				   when().
					get();	
		}
		
		else if(version.equalsIgnoreCase("V2")) {
			
			basePath = Configs.getSiteBySiteIDV2;

			resp = given().log().all().relaxedHTTPSValidation().
					pathParams("siteId", IdnT_CreateSiteStepDef.siteId).
					headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
				   when().
					get();	
		}

		return resp;

	}
	
	public static Response getSiteBySiteIDMethodForInvalidDCN(String version)
	{
        baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.getSiteBySiteIDV1;

			resp = given().log().all().relaxedHTTPSValidation().
					pathParams("dcn","52999984293912", "siteId", IdnT_CreateSiteStepDef.siteId).
					headers("Content-Type", "application/json").
				   when().
					get();	
	}
		
else if(version.equalsIgnoreCase("V2")) {
			
			basePath = Configs.getSiteBySiteIDV2;

			resp = given().log().all().relaxedHTTPSValidation().
					pathParams("siteId", IdnT_CreateSiteStepDef.siteId).
					headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
				   when().
					get();	
		}

		return resp;

}
}