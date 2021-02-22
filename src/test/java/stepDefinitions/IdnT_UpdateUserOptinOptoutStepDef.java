package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_UpdateUserOptinOptout;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_UpdateUserOptinOptoutStepDef {

	public Response response;
	public JsonPath jsp;

	@Given("API to Update User-OptinOptout")
	public void displayUpdateUserOptinOptout() {

		System.out.println("***************************************************************************************");
		System.out.println("Your Update User-OptinOptout API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("***************************************************************************************");

	}

	@When("User call {string} Update User-OptinOptout PUT HTTP request with the PreferenceId {string} and Optin as {string}")
	public void executeUpdateUserOptinOptoutAPI(String version, String preferenceid, String optin) {

		response = IdnT_UpdateUserOptinOptout.UpdateUserOptinOptoutMethod(version, preferenceid, optin);

		System.out.println("");
		System.out.println("Update User-OptinOptout Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
	}

	@Then("Verify {int} status code in Update User-OptinOptout response")
	public void verifyUpdateUserOptinOptoutAPIRespCode(Integer statuscode) {

		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Update User-OptinOptout API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Update User-OptinOptout API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}

}
