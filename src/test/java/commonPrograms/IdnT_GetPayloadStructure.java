package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.IdnT_GetPreferenceStepDef;

public class IdnT_GetPayloadStructure extends MyBase {

	public static Response GetPayloadStructureMethod(String version) {

		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.getPayloadStructureV1;

			resp = given().log().all().relaxedHTTPSValidation().
					pathParams("eventName", IdnT_GetPreferenceStepDef.eventName).
					headers("Content-Type", "application/json").
				   when().
				   	get();				
		}

		return resp;
	}

}
