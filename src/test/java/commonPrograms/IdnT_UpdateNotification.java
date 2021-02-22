package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.IdnT_GetNotificationStepDef;

public class IdnT_UpdateNotification extends MyBase
{
	
	public static Response updateNotificationMethod(String version, String status) 
	{
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.updateNotificationV1;
			
			resp = given().log().all().relaxedHTTPSValidation().
					queryParams("alert", IdnT_GetNotificationStepDef.alertid, "status", status).
					headers("Content-Type", "application/json").
				   when().
					put();						
		}
		
		return resp;
	}

}
