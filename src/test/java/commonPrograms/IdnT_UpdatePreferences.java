package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.CreateTokenStepDef;
import stepDefinitions.IdnT_GetPreferenceStepDef;

public class IdnT_UpdatePreferences extends MyBase {

	public static Response UpdatePreferencesMethod(String version) {

		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.updatePreferencesV1;

			resp = given().log().all().relaxedHTTPSValidation().
					pathParam("preferenceId", IdnT_GetPreferenceStepDef.preferenceId).
					queryParam("rightIds", CreateTokenStepDef.rightIds).
					headers("Content-Type", "application/json").
				   when().
					put();			
		}

		return resp;
	}

}
