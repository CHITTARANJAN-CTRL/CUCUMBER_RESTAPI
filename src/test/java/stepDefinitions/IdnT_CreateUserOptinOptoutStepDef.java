package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_CreateUserOptinOptout;
import commonPrograms.IdnT_DeleteUserOptinOptout;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_CreateUserOptinOptoutStepDef {

	public Response deleteresponse;
	public Response response;
	public JsonPath jsp;

	@Given("API to Create User-OptinOptout")
	public void displayCreateUserOptinOptout() {

		System.out.println("***************************************************************************************");
		System.out.println("Your Create User-OptinOptout API Test Execution started in " + Configs.ENV + " Environment.");
		System.out.println("***************************************************************************************");

	}

	@When("User call {string} Create User-OptinOptout POST HTTP request for the preferenceIds {string}")
	public void executeCreateUserOptinOptoutAPI(String version, String prefId) {
		
		// Below delete call is made to Delete Customer if already exists
		deleteresponse = IdnT_DeleteUserOptinOptout.createDeleteUserOptinOptoutMethod(version);

		response = IdnT_CreateUserOptinOptout.createUserOptinOptoutMethod(version, prefId);

		System.out.println("");
		System.out.println("Create User-OptinOptout Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());

	}

	@Then("Verify {int} status code in Create User-OptinOptout response")
	public void verifyCreateUserOptinOptoutAPIRespCode(Integer statuscode) {

		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode,
				"FAILED!! Your Create User-OptinOptout API Test Execution Errored with unexpected "
						+ response.getStatusCode() + " status code.");
		System.out.println("SUCCESS!! Your Create User-OptinOptout API Test Execution response is " + statuscode
				+ " as expected.");
		System.out.println("");

	}

}
