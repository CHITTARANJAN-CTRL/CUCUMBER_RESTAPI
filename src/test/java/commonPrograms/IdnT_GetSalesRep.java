package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_GetSalesRep extends MyBase {

	public static Response getSalesRepMethod(String version) {
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.getSalesRepV1;

			resp = given().log().all().relaxedHTTPSValidation().
					pathParams("email", CreateTokenStepDef.salesrep_email).
					headers("Content-Type", "application/json").
				   when().
				    get();
		}


		return resp;
	}

}
