package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_DeleteSalesRep extends MyBase {
	
	public static Response deleteSalesRepMethod(String version) {

		baseURI = baseuri;

		if (version.equalsIgnoreCase("V1")) {

			basePath = Configs.deleteSalesRepV1;

			resp = given().log().all().relaxedHTTPSValidation().
					pathParams("email", CreateTokenStepDef.salesrep_email).
					headers("Content-Type", "application/json").
				   when().
				   	delete();
		}

		return resp;

	}

}
