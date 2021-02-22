package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_DeleteUserOptinOptout;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_DeleteUserOptinOptoutStepDef {
	
	public Response response;
	public JsonPath jsp;

	@Given("API to Delete User-OptinOptout")
	public void displayDeleteUserOptinOptout() {

		System.out.println("***************************************************************************************");
		System.out.println("Your Delete User-OptinOptout API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("***************************************************************************************");

	}

	@When("User call {string} Delete User-OptinOptout DELETE HTTP request")
	public void executeDeleteUserOptinOptoutAPI(String version) {

		response = IdnT_DeleteUserOptinOptout.deleteUserOptinOptoutMethod(version);

		System.out.println("");
		System.out.println("Delete User-OptinOptout Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());

	}

	@Then("Verify {int} status code in Delete User-OptinOptout response")
	public void verifyDeleteUserOptinOptoutAPIRespCode(Integer statuscode) {

		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Delete User-OptinOptout API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Delete User-OptinOptout API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");

	}

}
