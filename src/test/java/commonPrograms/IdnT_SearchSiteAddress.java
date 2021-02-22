package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import payloads.IdnT_SearchSiteAddressPayload;
import stepDefinitions.CreateTokenStepDef;
import stepDefinitions.IdnT_GetSiteBySiteIDStepDef;

public class IdnT_SearchSiteAddress extends MyBase {

	public static Response searchSiteAddressMethod(String version) {
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {

		basePath = Configs.searchSiteAddress;

		resp= given().log().all().relaxedHTTPSValidation().
				headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
				body(IdnT_SearchSiteAddressPayload.searchSiteAddressV1(CreateTokenStepDef.addressone, IdnT_GetSiteBySiteIDStepDef.city, IdnT_GetSiteBySiteIDStepDef.state, CreateTokenStepDef.country)).
			  when().
				post();	
		}
		
		else if(version.equalsIgnoreCase("V2")) {

		basePath = Configs.searchSiteAddress;

		resp= given().log().all().relaxedHTTPSValidation().
				headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
				body(IdnT_SearchSiteAddressPayload.searchSiteAddressV2(CreateTokenStepDef.addressone, IdnT_GetSiteBySiteIDStepDef.city, IdnT_GetSiteBySiteIDStepDef.state, CreateTokenStepDef.country)).
			  when().
				post();	
		}
		
		return resp;
	}

}
