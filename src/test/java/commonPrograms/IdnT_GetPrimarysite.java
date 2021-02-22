package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_GetPrimarysite extends MyBase {

	public static Response getPrimarysite(String version) {
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {

		basePath = Configs.getPrimarySiteV1;

		resp =  given().log().all().relaxedHTTPSValidation().
				  pathParams("dcn", CreateTokenStepDef.dcn).
				  headers("Content-Type", "application/json").
			    when().
				  get();
		}
		
		else if(version.equalsIgnoreCase("V2")) {

		basePath = Configs.getPrimarySiteV2;

		resp =  given().log().all().relaxedHTTPSValidation().
				  headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
			    when().
				  get();
		}
		
		return resp;
	}

public static Response executeGetPrimarySiteAPIForInvalidDCN(String version) {
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {

		basePath = Configs.getPrimarySiteV1;

		resp =  given().log().all().relaxedHTTPSValidation().
				  pathParams("dcn", "52999984293912").
				  headers("Content-Type", "application/json").
			    when().
				  get();
		}
		
		else if(version.equalsIgnoreCase("V2")) {

		basePath = Configs.getPrimarySiteV2;

		resp =  given().log().all().relaxedHTTPSValidation().
				  headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
			    when().
				  get();
		}
		
		return resp;
	}
}
