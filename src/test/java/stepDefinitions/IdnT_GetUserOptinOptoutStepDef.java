package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_GetUserOptinOptout;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_GetUserOptinOptoutStepDef {
	
	public Response response;
	public JsonPath jsp;

	@Given("API to Get User-OptinOptout")
	public void displayGetUserOptinOptout() {
		
		System.out.println("****************************************************************************************");
		System.out.println("Your Get User-OptinOptout API Test Execution started in " + Configs.ENV + " Environment.");
		System.out.println("****************************************************************************************");
		
	}

	@When("User call {string} Get User-OptinOptout GET HTTP request for {string}")
	public void executeGetUserOptinOptoutAPI(String version, String user_email) {
		
		response = IdnT_GetUserOptinOptout.GetUserOptinOptoutMethod(version, user_email);

		System.out.println("");
		System.out.println("Get User-OptinOptout Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());

	}

	@Then("Verify {int} status code in Get User-OptinOptout response")
	public void verifyGetUserOptinOptoutAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Get User-OptinOptout API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Get User-OptinOptout API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}

}
