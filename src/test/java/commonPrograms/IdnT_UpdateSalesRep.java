package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import payloads.IdnT_UpdateSalesRepPayload;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_UpdateSalesRep extends MyBase {

	public static Response updateSalesRep(String version, String firstname, String lastname, String fullname) {
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.updateSalesRepV1;

			resp = given().log().all().relaxedHTTPSValidation().
					pathParams("email", CreateTokenStepDef.salesrep_email).
					headers("Content-Type", "application/json").
					body(IdnT_UpdateSalesRepPayload.updateSalesRep(firstname, lastname, fullname)).
				   when().
				   	put();					
		}

		return resp;
		
	}

}
