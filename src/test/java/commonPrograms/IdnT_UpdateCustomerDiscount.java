package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_UpdateCustomerDiscount extends MyBase {

	public static Response updateCustomerDiscountMethod(String version, String discount) {
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.updateCustomerDiscountV1;

			resp =  given().log().all().relaxedHTTPSValidation().
					  pathParams("dcn", CreateTokenStepDef.dcn, "discount", discount).
					  headers("Content-Type", "application/json").
				    when().
					  put();			
		}
		
		else if(version.equalsIgnoreCase("V2")) {
			
			basePath = Configs.updateCustomerDiscountV2;

			resp =  given().log().all().relaxedHTTPSValidation().
					  pathParams("discount", discount).
					  headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
				    when().
					  put();			
		}
		
		
		return resp;
	}

}
