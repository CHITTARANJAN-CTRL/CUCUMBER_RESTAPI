package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_UpdatePreferences;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_UpdatePreferencesStepDef {
	public Response response;
	public JsonPath jsp;

	@Given("API to Update Preference")
	public void displayUpdatePreference() {

		System.out.println("*********************************************************************************");
		System.out.println("Your Update Preference API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("*********************************************************************************");
		System.out.println("Updating Preference for RightIds: "+CreateTokenStepDef.rightIds);

	}

	@When("User call {string} Update Preference PUT HTTP request")
	public void executeUpdatePreferenceAPI(String version) {

		response = IdnT_UpdatePreferences.UpdatePreferencesMethod(version);

		System.out.println("");
		System.out.println("Update Preference Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());

	}

	@Then("Verify {int} status code in Update Preference response")
	public void verifyUpdatePreferenceAPIRespCode(Integer statuscode) {

		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Update Preference API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Update Preference API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");

	}

}
