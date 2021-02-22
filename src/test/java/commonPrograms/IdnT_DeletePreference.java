package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.CreateTokenStepDef;
import stepDefinitions.IdnT_GetPreferenceStepDef;

public class IdnT_DeletePreference extends MyBase {

	public static Response deletePreferenceMethod(String version) {

		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.deletePreferencesV1;

			resp = given().log().all().relaxedHTTPSValidation().
					pathParams("preferenceId", IdnT_GetPreferenceStepDef.preferenceId, "rightId", CreateTokenStepDef.rightIds).
					headers("Content-Type", "application/json").
				   when().
					delete();			
		}

		return resp;
	}

}
