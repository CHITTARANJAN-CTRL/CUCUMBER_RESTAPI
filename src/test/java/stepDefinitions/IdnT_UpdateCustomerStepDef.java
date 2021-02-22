package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_UpdateCustomer;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_UpdateCustomerStepDef {
	
	public Response response;
	public JsonPath jsp;

	@Given("API to Update Customer")
	public void displayUpdateCustomer() {
		
		System.out.println("*******************************************************************************");
		System.out.println("Your Update Customer API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("*******************************************************************************");
		
	}

	@When("User call {string} Update Customer PUT HTTP request for name {string} discount {string} and salesRep {string}")
	public void executeUpdateCustomerAPI(String version, String name, String discount, String customersalesrep) {
		
		response = IdnT_UpdateCustomer.updateCustomerMethod(version, name, discount, customersalesrep);

		System.out.println("");
		System.out.println("Update Customer Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
	}

	@Then("Verify {int} status code in Update Customer response")
	public void verifyUpdateCustomerAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Update Customer API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Update Customer API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}

}
