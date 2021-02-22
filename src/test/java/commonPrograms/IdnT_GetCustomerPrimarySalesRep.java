package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_GetCustomerPrimarySalesRep extends MyBase {

	public static Response getCustomerPrimarySalesRepMethod(String version) {
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.getCustomerPrimarySalesRepV1;

			resp =  given().log().all().relaxedHTTPSValidation().
					  pathParams("dcn", CreateTokenStepDef.dcn).
					  headers("Content-Type", "application/json").
				    when().
					  get();			
		}
		
		else if(version.equalsIgnoreCase("V2")) {
			
			basePath = Configs.getCustomerPrimarySalesRepV2;

			resp =  given().log().all().relaxedHTTPSValidation().
					  headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
				    when().
					  get();			
		}

		return resp;
		
	}

}
