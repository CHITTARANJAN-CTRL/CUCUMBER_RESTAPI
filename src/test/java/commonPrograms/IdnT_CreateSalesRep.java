package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import payloads.IdnT_CreateSalesRepPayload;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_CreateSalesRep extends MyBase {
	
	public static Response createSalesRepMethod(String version) {
		
		baseURI = baseuri;

		if (version.equalsIgnoreCase("V1")) {

			basePath = Configs.createSalesRepV1;

			resp = given().log().all().relaxedHTTPSValidation().
					header("Content-Type", "application/json").
					body(IdnT_CreateSalesRepPayload.createSalesRep(CreateTokenStepDef.salesrep_fn, CreateTokenStepDef.salesrep_ln, CreateTokenStepDef.salesrep_name, CreateTokenStepDef.salesrep_email, CreateTokenStepDef.salesrep_id)).
				   when().
				   	post();
		}

		return resp;
	}

}
