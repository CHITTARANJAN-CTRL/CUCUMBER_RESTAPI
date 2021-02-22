package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_GetprimaryBillingAddress extends MyBase
{

	public static Response getPrimaryBillingAddressMethod(String version)
	{
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V2")) {

			basePath = Configs.getprimaryBillingAddress;

			resp =  given().log().all().relaxedHTTPSValidation().
					  headers("Content-Type", "application/json","token_payload",CreateTokenStepDef.token).
				    when().
					  get();
			}
		
		return resp;
	}
	
}
