package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_GetCustomerPaymentMethods;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_GetCustomerPaymentMethodsStepDef {
	public Response response;
	public JsonPath jsp;

	@Given("API to Get Customer Payment Methods")
	public void displayGetCustomerPaymentMethods() {
		
		System.out.println("************************************************************************************************");
		System.out.println("Your Get Customer Payment Methods API Test Execution started in "+ Configs.ENV +" Environment.");
		System.out.println("************************************************************************************************");
	}
	

	@When("User call {string} Get Customer Payment Methods GET HTTP request")
	public void executeGetCustomerPaymentMethodsAPI(String version) {
		
		response = IdnT_GetCustomerPaymentMethods.getCustomerPaymentMethodsMethod(version);

		System.out.println("");
		System.out.println("Get Customer Payment Methods Response Payload is:");
		System.out.println("");
		response.prettyPrint();

		jsp = new JsonPath(response.asString());
		
	}

	@Then("Verify {int} status code in Get Customer Payment Methods response")
	public void verifyGetCustomerPaymentMethodsAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Get Customer Payment Methods API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Get Customer Payment Methods API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}

}
