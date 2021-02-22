package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import payloads.IdnT_UpdateCustomerPayload;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_UpdateCustomer extends MyBase {
	
	public static Response updateCustomerMethod(String version, String name, String discount, String customersalesrep) {

		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.updateCustomerV1;

			resp =  given().log().all().relaxedHTTPSValidation().
					pathParam("dcn", CreateTokenStepDef.dcn).				
					headers("Content-Type", "application/json").
					body(IdnT_UpdateCustomerPayload.updateCustomerV1(name, discount, customersalesrep)).
				when().
					put();			
		}
		
		else if(version.equalsIgnoreCase("V2")) {
			
			basePath = Configs.updateCustomerV2;

			resp =  given().log().all().relaxedHTTPSValidation().
					pathParams("dcn", CreateTokenStepDef.dcn ,"buId", CreateTokenStepDef.buid).				
					headers("Content-Type", "application/json").
					body(IdnT_UpdateCustomerPayload.updateCustomerV2(name, discount, customersalesrep, CreateTokenStepDef.country)).
				when().
					put();			
		}

		return resp;
	}

}
