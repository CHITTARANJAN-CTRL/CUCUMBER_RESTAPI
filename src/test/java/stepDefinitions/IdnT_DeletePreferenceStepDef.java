package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_DeletePreference;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_DeletePreferenceStepDef {
	public Response response;
	public JsonPath jsp;

	@Given("API to Delete Preference")
	public void displayDeletePreference() {
		
		System.out.println("*********************************************************************************");
		System.out.println("Your Delete Preference API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("*********************************************************************************");
		System.out.println("Deleting Preference for the RightIds: "+CreateTokenStepDef.rightIds);
		System.out.println("");
		
	}

	@When("User call {string} Delete Preference DELETE HTTP request")
	public void executeDeletePreferenceAPI(String version) {
		
		response = IdnT_DeletePreference.deletePreferenceMethod(version);

		System.out.println("");
		System.out.println("Delete Preference Response Payload is:");
		System.out.println("");
		response.prettyPrint();

		jsp = new JsonPath(response.asString());
		
	}

	@Then("Verify {int} status code in Delete Preferences response")
	public void verifyDeletePreferenceAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Delete Preference API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Delete Preference API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}

}
