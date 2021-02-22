package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_GetPreference;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_GetPreferenceStepDef {
	
	public Response response;
	public JsonPath jsp;
	
	public static int preferenceId;
	public static String eventName;

	@Given("API to Get Preferences")
	public void displayGetPreferences() {
		
		System.out.println("****************************************************************************************");
		System.out.println("Your Get Preferences API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("****************************************************************************************");
		System.out.println("Getting Preference for DCN: " + CreateTokenStepDef.rightIds);
		
	}

	@When("User call {string} Get Preferences GET HTTP request")
	public void executeGetPreferencesAPI(String version) {
		
		response = IdnT_GetPreference.getPreferenceMethod(version);

		System.out.println("");
		System.out.println("Get Preferences Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());

		preferenceId = jsp.getInt("[0].preferenceId");
		
		eventName = jsp.get("[0].name");

	}
	
	@When("User call {string} Get Preferences GET HTTP request after delete")
	public void executeAfterDeleteGetPreferencesAPI(String version) {
		
		response = IdnT_GetPreference.getPreferenceMethod(version);

		System.out.println("");
		System.out.println("Get Preferences Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());

	}

	@Then("Verify {int} status code in Get Preferences response")
	public void verifyGetPreferencesAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Get Preferences API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Get Preferences API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}

}
