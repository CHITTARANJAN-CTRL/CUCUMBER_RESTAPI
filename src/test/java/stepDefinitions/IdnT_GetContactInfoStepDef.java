package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_GetContactInfo;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_GetContactInfoStepDef {
	
	public Response response;
	public JsonPath jsp;

	@Given("API to Get Contact Info")
	public void displayGetContactInfo() {
		
		System.out.println("********************************************************************************");
		System.out.println("Your Get Contact Info API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("********************************************************************************");
		System.out.println("Getting Contact Info for the camLocationId: " +IdnT_GetSiteBySiteIDStepDef.contactId);
		System.out.println("");
		
	}

	@When("User call {string} Get Contact Info GET HTTP request")
	public void executeGetContactInfoAPI(String version) {
		
		response = IdnT_GetContactInfo.getContactInfoMethod(version);

		System.out.println("");
		System.out.println("Get Contact Info Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
	}
	
	@When("User call {string} Get Contact Info GET HTTP request with invalid camLocationID")
	public void executeInvalidGetContactInfoAPI(String version) {
		
		response = IdnT_GetContactInfo.getContactInfoInvalidcamLocationIDMethod(version);

		System.out.println("");
		System.out.println("Get Contact Info Response Payload for Invalid camLocationID is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
		
	}

	@Then("Verify {int} status code in Get Contact Info response")
	public void verifyGetContactInfoAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Get Contact Info API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Get Contact Info API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}

}
