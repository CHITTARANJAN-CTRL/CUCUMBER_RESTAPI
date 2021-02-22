package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_GetPreference extends MyBase {

	public static Response getPreferenceMethod(String version) {

		baseURI = baseuri;

		if (version.equalsIgnoreCase("V1")) {

			basePath = Configs.getAllPreferencesV1;

			resp = given().log().all().relaxedHTTPSValidation().
					queryParam("rightIds", CreateTokenStepDef.rightIds).
					headers("Content-Type", "application/json").
				   when().
				   	get();
		}

		return resp;
	}

}
