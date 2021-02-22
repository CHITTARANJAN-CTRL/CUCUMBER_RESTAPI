package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import payloads.IdnT_CreateSitePayload;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_CreateSite extends MyBase {

	public static Response createSiteMethod(String version) {

		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {		
			
		basePath = Configs.createSiteV1;

		resp= given().log().all().relaxedHTTPSValidation().
				pathParam("dcn", CreateTokenStepDef.dcn).
				queryParam("type", "installAt").
				headers("Content-Type", "application/json").
				body(IdnT_CreateSitePayload.createSiteV1(CreateTokenStepDef.buid, CreateTokenStepDef.dcn, CreateTokenStepDef.customer_fn, CreateTokenStepDef.customer_ln, CreateTokenStepDef.customer_email, CreateTokenStepDef.addressone, CreateTokenStepDef.country)).
			  when().
				post();	
		}
		
		else if(version.equalsIgnoreCase("V2") && CreateTokenStepDef.country.equalsIgnoreCase("US")) {		
			
		basePath = Configs.createSiteV2;

		resp= given().log().all().relaxedHTTPSValidation().
				queryParam("type", "installAt").
				headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
				body(IdnT_CreateSitePayload.createSiteV2US(CreateTokenStepDef.customer_fn, CreateTokenStepDef.customer_ln, CreateTokenStepDef.customer_email, CreateTokenStepDef.addressone, CreateTokenStepDef.country)).
			  when().
				post();	
		}
		
		else if(version.equalsIgnoreCase("V2") && CreateTokenStepDef.country.equalsIgnoreCase("GB")) {		
			
		basePath = Configs.createSiteV2;

		resp= given().log().all().relaxedHTTPSValidation().
				queryParam("type", "installAt").
				headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
				body(IdnT_CreateSitePayload.createSiteV2GB(CreateTokenStepDef.customer_fn, CreateTokenStepDef.customer_ln, CreateTokenStepDef.customer_email, CreateTokenStepDef.addressone, CreateTokenStepDef.country)).
			  when().
				post();	
		}
		
		else if(version.equalsIgnoreCase("V2") && CreateTokenStepDef.country.equalsIgnoreCase("FR")) {		
			
		basePath = Configs.createSiteV2;

		resp= given().log().all().relaxedHTTPSValidation().
				queryParam("type", "installAt").
				headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
				body(IdnT_CreateSitePayload.createSiteV2FR(CreateTokenStepDef.customer_fn, CreateTokenStepDef.customer_ln, CreateTokenStepDef.customer_email, CreateTokenStepDef.addressone, CreateTokenStepDef.country)).
			  when().
				post();	
		}
		
		else if(version.equalsIgnoreCase("V2") && CreateTokenStepDef.country.equalsIgnoreCase("DE")) {		
			
		basePath = Configs.createSiteV2;

		resp= given().log().all().relaxedHTTPSValidation().
				queryParam("type", "installAt").
				headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
				body(IdnT_CreateSitePayload.createSiteV2DE(CreateTokenStepDef.customer_fn, CreateTokenStepDef.customer_ln, CreateTokenStepDef.customer_email, CreateTokenStepDef.addressone, CreateTokenStepDef.country)).
			  when().
				post();	
		}
		
		else if(version.equalsIgnoreCase("V2") && CreateTokenStepDef.country.equalsIgnoreCase("AU")) {		
			
			basePath = Configs.createSiteV2;

			resp= given().log().all().relaxedHTTPSValidation().
					queryParam("type", "installAt").
					headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
					body(IdnT_CreateSitePayload.createSiteV2AU(CreateTokenStepDef.customer_fn, CreateTokenStepDef.customer_ln, CreateTokenStepDef.customer_email, CreateTokenStepDef.addressone, CreateTokenStepDef.country)).
				  when().
					post();	
			}
		
else if(version.equalsIgnoreCase("V2") && CreateTokenStepDef.country.equalsIgnoreCase("NZ")) {		
			
			basePath = Configs.createSiteV2;

			resp= given().log().all().relaxedHTTPSValidation().
					queryParam("type", "installAt").
					headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
					body(IdnT_CreateSitePayload.createSiteV2DE(CreateTokenStepDef.customer_fn, CreateTokenStepDef.customer_ln, CreateTokenStepDef.customer_email, CreateTokenStepDef.addressone, CreateTokenStepDef.country)).
				  when().
					post();	
			}

		return resp;
	}

}
