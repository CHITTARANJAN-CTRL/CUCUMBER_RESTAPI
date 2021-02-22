package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_GetUCIDStatus;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_GetUCIDStatusStepDef {
	
	public Response response;
	public JsonPath jsp;

	@Given("API to Get UCID Status")
	public void displayGetUCIDStatus() {
		
		System.out.println("*******************************************************************************");
		System.out.println("Your Get UCID Status API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("**********************************************P********************************");
		System.out.println("Getting UCID Status for the DCN: "+CreateTokenStepDef.dcn);
		System.out.println("");
		
	}

	@When("User call {string} Get UCID Status GET HTTP request")
	public void executeGetUCIDStatusAPI(String version) {
		
		response = IdnT_GetUCIDStatus.getUCIDStatusMethod(version);

		System.out.println("");
		System.out.println("Get UCID Status Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
		
	}

	@Then("Verify {int} status code in Get UCID Status response")
	public void verifyGetUCIDStatusAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Get UCID Status API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Get UCID Status API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}
	
	@Then("Verify ucid should not be null in Get UCID Status response")
	public void verifyGetUCIDStatusResponseUCID() {
	   
	    Assert.assertNotNull(jsp.get("ucid"), "Oops!! ucid is NULL in Get Customer response");                             
        System.out.println("Great!! ucid is not NULL in Get Customer response");
        System.out.println("");
	}

	@Then("Verify status should not be null in Get UCID Status response")
	public void verifyGetUCIDStatusResponseStatus() {
		   
	    Assert.assertNotNull(jsp.get("status"), "Oops!! status is NULL in Get Customer response");                             
        System.out.println("Great!! status is not NULL in Get Customer response");
        System.out.println("");
	}

	@Then("Verify statusDescription should not be null in Get UCID Status response")
	public void verifyGetUCIDStatusResponseStatusDescription() {
		   
	    Assert.assertNotNull(jsp.get("status"), "Oops!! statusDescription is NULL in Get Customer response");                             
        System.out.println("Great!! statusDescription is not NULL in Get Customer response");
        System.out.println("");
	}

}
