package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_CreateCustomer;
import commonPrograms.IdnT_DeleteCustomer;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_CreateCustomerStepDef {

	public Response deleteresponse;
	public Response response;
	public JsonPath jsp;

	@Given("API to Create Customer")
	public void displayCreateCustomer() {
		
		System.out.println("*******************************************************************************");
		System.out.println("Your Create Customer API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("*******************************************************************************");
		
		
	}

	@When("User call {string} Create Customer POST HTTP request")
	public void executeCreateCustomerAPI(String version) {
		
		// Below delete call is made to Delete Customer if already exists
		deleteresponse = IdnT_DeleteCustomer.createDeleteCustomerMethod(version);

		response = IdnT_CreateCustomer.createCustomerMethod(version);

		System.out.println("");
		System.out.println("Create Customer Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
		
	}
	
	@When("User call {string} Create Customer POST HTTP request to support other tracks")
	public void executeCreateCustomerAPItoSupport(String version) {

		response = IdnT_CreateCustomer.createCustomerMethod(version);

		System.out.println("");
		System.out.println("Created Customer again at the end to support the other tracks");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");
		
	}

	@Then("Verify {int} status code in Create Customer response")
	public void verifyCreateCustomerAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Create Customer API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Create Customer API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}
	

}
