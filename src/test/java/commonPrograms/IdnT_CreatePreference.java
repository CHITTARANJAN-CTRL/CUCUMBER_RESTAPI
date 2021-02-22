package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import payloads.IdnT_CreatePreferencePayload;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_CreatePreference extends MyBase {

	public static Response createPreferenceMethod(String version) {
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.createPreferencesV1;

			resp = given().log().all().relaxedHTTPSValidation().
					header("Content-Type", "application/json").
					body(IdnT_CreatePreferencePayload.createPreference(CreateTokenStepDef.rightIds)).
				   when().
					post();						
		}

		return resp;
	}

}
