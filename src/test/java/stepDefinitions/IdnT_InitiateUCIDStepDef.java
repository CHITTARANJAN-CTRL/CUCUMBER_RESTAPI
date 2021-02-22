package stepDefinitions;

import commonPrograms.IdnT_InitiateUCID;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_InitiateUCIDStepDef {
	
	public Response response;
	public JsonPath jsp;

	@Given("API to Initiate UCID")
	public void displayInitiateUCID() {

		System.out.println("*****************************************************************************");
		System.out.println("Your Initiate UCID API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("*****************************************************************************");
		System.out.println("Initiated UCID for the DCN: "+CreateTokenStepDef.dcn);
		System.out.println("");
	}

	@When("User call {string} Initiate UCID POST HTTP request")
	public void executeInitiateUCIDAPI(String version) {
		
		response = IdnT_InitiateUCID.initiateUCIDMethod(version);

		System.out.println("");
		System.out.println("Initiate UCID Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());

	}

	@Then("Verify {int} or {int} status code in Initiate UCID response")
	public void verifyInitiateUCIDAPIRespCode(Integer statuscode200, Integer statuscode400) {
		
		if(response.getStatusCode() == statuscode200) {
			
			System.out.println("");
			System.out.println("SUCCESS!! Your Initiate UCID API Test Execution response is "+statuscode200+" as expected.");	
			System.out.println("");
			
		}
		
		else if(response.getStatusCode() == statuscode400) {
			
			System.out.println("");
			System.out.println("Oops!! Your UCID Initialization is already in progress and hence response is "+statuscode400+" as expected.");	
			System.out.println("");
			
		}

		
	}

}
