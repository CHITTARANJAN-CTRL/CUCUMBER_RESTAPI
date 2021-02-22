package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;

public class IdnT_GetCustomersUnderSalesRep extends MyBase {

	public static Response getCustomersUnderSalesRepMethod(String version, String salesrepemail) {

		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {
			
			basePath = Configs.getCustomersUnderSalesRepV1;

			resp =  given().log().all().relaxedHTTPSValidation().
					  pathParams("email", salesrepemail).
					  headers("Content-Type", "application/json").
				    when().
					  get();
		}
		
		else if(version.equalsIgnoreCase("V2")) {
			
			basePath = Configs.getCustomersUnderSalesRepV2;

			resp =  given().log().all().relaxedHTTPSValidation().
					  pathParams("email", salesrepemail).
					  headers("Content-Type", "application/json").
				    when().
					  get();
		}

		return resp;
	}

}
