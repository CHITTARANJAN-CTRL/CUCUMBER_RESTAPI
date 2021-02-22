package commonPrograms;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import configurations.Configs;
import io.restassured.response.Response;
import stepDefinitions.CreateTokenStepDef;

public class IdnT_GetAllSites extends MyBase {

	public static Response getAllSitesMethod(String version) {
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {

		basePath = Configs.getAllSitesV1;

		resp =  given().log().all().relaxedHTTPSValidation().
				  pathParams("dcn", CreateTokenStepDef.dcn).
				  queryParams("siteType", "installAt", "filterByUcid", "false", "pageNumber", 1, "pageSize", 5).
				  headers("Content-Type", "application/json").
			    when().
				  get();
		}
		
		else if(version.equalsIgnoreCase("V2")) {

		basePath = Configs.getAllSitesV2;

		resp =  given().log().all().relaxedHTTPSValidation().
				  queryParams("siteType", "installAt", "filterByUcid", "false", "pageNumber", 1, "pageSize", 5).
				  headers("Content-Type", "application/json", "token_payload", CreateTokenStepDef.token).
			    when().
				  get();
		}
		
		return resp;
	}
	
	
	
	public static Response getAllSiteInvalidDCNMethod(String version) {
		
		baseURI = baseuri;
		
		if(version.equalsIgnoreCase("V1")) {

		basePath = Configs.getAllSitesV1;

		resp =  given().log().all().relaxedHTTPSValidation().
				  pathParam("dcn", "123454321").
				  headers("Content-Type", "application/json").
			    when().
				  get();
		}
		
		else if(version.equalsIgnoreCase("V2")) {

		basePath = Configs.getAllSitesV2;

		resp =  given().log().all().relaxedHTTPSValidation().
				  headers("Content-Type", "application/json", "token_payload", "ewoJInNjb3BlIjogW10sCgkiY2xpZW50X2lkIjogIkRUQ0NQMTAwMjIxMlRFU1QiLAoJImlzcyI6ICJodHRwczovL3BmLWh1YXQudXMuZGVsbC5jb20iLAoJInN1YiI6ICJEVENQVEVTVFRFQU1AREVMTC5DT00iLAoJImFmZmluaXR5aWQiOiAiMjcyNDA4NDY2NyIsCgkiYnUiOiAiMTEiLAoJImdpdmVuTmFtZSI6ICJWYW1zZWVLcmlzaG5hIiwKCSJ1c2VydHlwZSI6ICJjdXN0b21lciIsCgkic24iOiAiVGlydXBhdGkiLAoJImVtYWlsIjogIlZhbXNlZV9LcmlzaG5hX1RpcnVwQERlbGx0ZWFtLmNvbSIsCgkiZXhwIjogMTU5MDEzMjI2MywKCSJkY24iOiAiMTIzNDU0MzIxIiwKCSJsYW5ndWFnZSI6ICJlbl9VUyIsCgkiY291bnRyeSI6ICJVUyIKfQ==").
			    when().
				  get();
		}
		
		return resp;
	}

}
