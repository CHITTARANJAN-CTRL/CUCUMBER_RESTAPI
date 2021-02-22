package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import payloads.IdnT_UpdateSitePayload;
import stepDefinitions.IdnT_CreateSiteStepDef;
import stepDefinitions.CreateTokenStepDef;
import stepDefinitions.IdnT_GetSiteBySiteIDStepDef;

public class IdnT_UpdateSite extends MyBase {
	
	public static Response updateSiteMethod(String version, String fname, String lname, String email) {

		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {

		basePath = Configs.updateSiteContactV1;

		resp = given().log().all().relaxedHTTPSValidation().			
				  pathParams("dcn", CreateTokenStepDef.dcn, "buid", CreateTokenStepDef.buid ).
				  headers("Content-Type", "application/json").
				  body(IdnT_UpdateSitePayload.updateSiteV1(IdnT_GetSiteBySiteIDStepDef.contactId, IdnT_GetSiteBySiteIDStepDef.phoneContactMethodId, IdnT_GetSiteBySiteIDStepDef.emailContactMethodId, CreateTokenStepDef.dcn, CreateTokenStepDef.buid, IdnT_CreateSiteStepDef.siteId, fname, lname, email)).
				when().
					put();
		}
		
		else if(version.equalsIgnoreCase("V2")) {

		basePath = Configs.updateSiteContactV2;

		resp = given().log().all().relaxedHTTPSValidation().			
				  headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
				  body(IdnT_UpdateSitePayload.updateSiteV2(IdnT_GetSiteBySiteIDStepDef.contactId, IdnT_GetSiteBySiteIDStepDef.phoneContactMethodId, IdnT_GetSiteBySiteIDStepDef.emailContactMethodId, IdnT_CreateSiteStepDef.siteId, fname, lname, email)).
				when().
					put();
		}
		
		return resp;
	}

}
