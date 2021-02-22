package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_GetCustomer extends MyBase {
	
	public static Response getCustomerMethod(String version) {

		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.getCustomerV1;

			resp =  given().log().all().relaxedHTTPSValidation().
					  pathParams("dcn", CreateTokenStepDef.dcn).
					  headers("Content-Type", "application/json").
				    when().
					  get();			
		}
		
		else if(version.equalsIgnoreCase("V2")) {
			
			basePath = Configs.getCustomerV2;

			resp =  given().log().all().relaxedHTTPSValidation().
					  pathParams("dcn", CreateTokenStepDef.dcn, "buId", CreateTokenStepDef.buid).				  
					  headers("Content-Type", "application/json").
				    when().
					  get();			
		}

		return resp;
	}

}
