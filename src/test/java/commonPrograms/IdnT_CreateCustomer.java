package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import payloads.IdnT_CreateCustomerPayload;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_CreateCustomer extends MyBase {
	
	public static Response createCustomerMethod(String version) {
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.createCustomerV1;

			resp = given().log().all().relaxedHTTPSValidation().
					header("Content-Type", "application/json").
					body(IdnT_CreateCustomerPayload.createCustomerV1(CreateTokenStepDef.dcn, CreateTokenStepDef.customersalesrep_email)).
				   when().
					post();						
		}
		
		else if(version.equalsIgnoreCase("V2")) {
			System.out.println("buid for create customer"+CreateTokenStepDef.buid);
			basePath = Configs.createCustomerV2;
			resp = given().log().all().relaxedHTTPSValidation().
					header("Content-Type", "application/json").
					body(IdnT_CreateCustomerPayload.createCustomerV2(CreateTokenStepDef.dcn, CreateTokenStepDef.customersalesrep_email, CreateTokenStepDef.buid, CreateTokenStepDef.country)).
				   when().
					post();						
		}

		return resp;
	}
	

}
