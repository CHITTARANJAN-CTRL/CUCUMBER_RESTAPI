package commonPrograms;

import static configurations.Configs.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MyBase {
	
	public static String baseuri = RestAssured.baseURI = ENV.equalsIgnoreCase("DIT") ? DIT_BaseUri : (ENV.equalsIgnoreCase("GE2") ? GE2_BaseUri : (ENV.equalsIgnoreCase("GE4") ? GE4_BaseUri : STG_BaseUri));
	public static Response resp;

}