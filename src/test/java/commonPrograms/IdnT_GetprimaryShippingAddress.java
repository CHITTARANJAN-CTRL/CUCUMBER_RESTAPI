package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_GetprimaryShippingAddress extends MyBase {

	public static Response getprimaryShippingAddressMethod(String version, String siteType) {
		
		baseURI = baseuri;

		if (version.equalsIgnoreCase("V2")) {

			basePath = Configs.getprimaryShippingAddress;

			resp = given().log().all().relaxedHTTPSValidation().
					queryParam("siteType", siteType).
					headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
				   when().
					get();
		}

		return resp;
	}

}
