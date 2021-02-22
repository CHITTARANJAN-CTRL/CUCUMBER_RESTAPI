package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_DeleteCustomer extends MyBase {

	public static Response deleteCustomerMethod(String version) {

		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.deleteCustomerV1;

			resp =  given().log().all().relaxedHTTPSValidation().
				    pathParam("dcn", CreateTokenStepDef.dcn).
					headers("Content-Type", "application/json").
				when().
					delete();		
		}
		
		else if(version.equalsIgnoreCase("V2")) {
			
			basePath = Configs.deleteCustomerV2;

			resp =  given().log().all().relaxedHTTPSValidation().
				    pathParams("dcn", CreateTokenStepDef.dcn, "buId",CreateTokenStepDef.buid).
					headers("Content-Type", "application/json").
				when().
					delete();		
		}

		return resp;
	}

	
	//Below method is to delete before the Customer Creation if at all record exists to avoid our unnecessary test failures
	public static Response createDeleteCustomerMethod(String version) {

		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.deleteCustomerV1;

			resp =  given().relaxedHTTPSValidation().
				    pathParam("dcn", CreateTokenStepDef.dcn).
					headers("Content-Type", "application/json").
				when().
					delete();		
		}
		
		else if(version.equalsIgnoreCase("V2")) {
			
			basePath = Configs.deleteCustomerV2;

			resp =  given().relaxedHTTPSValidation().
				    pathParams("dcn", CreateTokenStepDef.dcn, "buId", CreateTokenStepDef.buid).
					headers("Content-Type", "application/json").
				when().
					delete();		
		}

		return resp;
	}
	
}
