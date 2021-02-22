package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_CreatePreference;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_CreatePreferenceStepDef {

	public Response response;
	public JsonPath jsp;

	@Given("API to Create Preference")
	public void displayCreatePreference() {
		
		System.out.println("*********************************************************************************");
		System.out.println("Your Create Preference API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("*********************************************************************************");
		
	}

	@When("User call {string} Create Preference POST HTTP request")
	public void executeCreatePreferenceAPI(String version) {

		response = IdnT_CreatePreference.createPreferenceMethod(version);

		System.out.println("");
		System.out.println("Create Preference Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());

	}

	@Then("Verify {int} status code in Create Preference response")
	public void verifyCreatePreferenceAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Create Preference API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Create Preference API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}

}
