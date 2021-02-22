package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_GetPayloadStructure;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_GetPayloadStructureStepDef {
	
	public Response response;
	public JsonPath jsp;

	@Given("API to Get Payload Structure")
	public void displayGetPayloadStructure() {
		
		System.out.println("*********************************************************************************");
		System.out.println("Your Payload Structure API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("*********************************************************************************");
		System.out.println("Getting Preference for the Event: "+IdnT_GetPreferenceStepDef.eventName);
		System.out.println("");
		
	}

	@When("User call {string} Get Payload Structure GET HTTP request")
	public void executeGetPayloadStructureAPI(String version) {
		
		response = IdnT_GetPayloadStructure.GetPayloadStructureMethod(version);

		System.out.println("");
		System.out.println("Get Payload Structure Response Payload is:");
		System.out.println("");
		response.prettyPrint();

		jsp = new JsonPath(response.asString());

	}

	@Then("Verify {int} status code in Get Payload Structure response")
	public void verifyGetPayloadStructureAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Get Payload Structure API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Get Payload Structure API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");	
		
	}

}
