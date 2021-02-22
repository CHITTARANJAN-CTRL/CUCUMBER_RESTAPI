package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_GetCustomerBillingCadence;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_GetCustomerBillingCadenceStepDef {
	
	public Response response;
	public JsonPath jsp;

	@Given("API to Get Customer Billing Cadence")
	public void displayGetCustomerBillingCadence() {
		
		System.out.println("****************************************************************************************");
		System.out.println("Your Customer Billing Cadence API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("****************************************************************************************");
		
	}

	@When("User call {string} Get Customer Billing Cadence GET HTTP request")
	public void executeGetCustomerBillingCadenceAPI(String version) {
		
		response = IdnT_GetCustomerBillingCadence.getCustomerBillingCadenceMethod(version);

		System.out.println("");
		System.out.println("Get Customer Billing Cadence Response Payload is:");
		System.out.println("");
		response.prettyPrint();

		jsp = new JsonPath(response.asString());
		
	}

	@Then("Verify {int} status code in Get Customer Billing Cadence response")
	public void verifyGetCustomerBillingCadenceAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Customer Billing Cadence API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Customer Billing Cadence API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}

}
