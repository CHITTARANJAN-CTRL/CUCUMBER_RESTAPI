package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_DeleteCustomer;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_DeleteCustomerStepDef {
	
	public Response response;
	public JsonPath jsp;

	@Given("API to Delete Customer")
	public void displayDeleteCustomer() {
		
		System.out.println("*******************************************************************************");
		System.out.println("Your Delete Customer API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("*******************************************************************************");
		
	}

	@When("User call {string} Delete Customer DELETE HTTP request")
	public void executeDeleteCustomerAPI(String version) {
		
		response = IdnT_DeleteCustomer.deleteCustomerMethod(version);

		System.out.println("");
		System.out.println("Delete Customer Response Payload is:");
		System.out.println("");
		response.prettyPrint();

		jsp = new JsonPath(response.asString());

	}

	@Then("Verify {int} status code in Delete Customer response")
	public void verifyDeleteCustomerAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Delete Customer API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Delete Customer API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");

	}

}
