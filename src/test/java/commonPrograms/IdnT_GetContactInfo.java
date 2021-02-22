package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.CreateTokenStepDef;
import stepDefinitions.IdnT_GetSiteBySiteIDStepDef;

public class IdnT_GetContactInfo extends MyBase {

	public static Response getContactInfoMethod(String version) {
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {

		basePath = Configs.getContactInfoV1;

		resp =  given().log().all().relaxedHTTPSValidation().
				  pathParams("dcn", CreateTokenStepDef.dcn, "camLocationId", IdnT_GetSiteBySiteIDStepDef.contactId, "businessUnitId", CreateTokenStepDef.buid).
				  headers("Content-Type", "application/json").
			    when().
				  get();
		}
		
		else if(version.equalsIgnoreCase("V2")) {

		basePath = Configs.getContactInfoV2;

		resp =  given().log().all().relaxedHTTPSValidation().
				  pathParams("camLocationId", IdnT_GetSiteBySiteIDStepDef.contactId).
				  headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
			    when().
				  get();
		}
		
		return resp;
	}
	
	public static Response getContactInfoInvalidcamLocationIDMethod(String version) {
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {

		basePath = Configs.getContactInfoV1;

		resp =  given().log().all().relaxedHTTPSValidation().
				  pathParams("dcn", CreateTokenStepDef.dcn, "camLocationId", "123454321", "businessUnitId", CreateTokenStepDef.buid).
				  headers("Content-Type", "application/json").
			    when().
				  get();
		}
		
		else if(version.equalsIgnoreCase("V2")) {

		basePath = Configs.getContactInfoV2;

		resp =  given().log().all().relaxedHTTPSValidation().
				  pathParams("camLocationId", "123454321").
				  headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
			    when().
				  get();
		}
		
		return resp;
	}	

}
