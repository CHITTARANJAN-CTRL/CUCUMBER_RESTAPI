package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_UpdateCustomerDiscount;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_UpdateCustomerDiscountStepDef {
	public Response response;
	public JsonPath jsp;

	@Given("API to Update Customer Discount")
	public void displayUpdateCustomerDiscount() {
		
		System.out.println("****************************************************************************************");
		System.out.println("Your Update Customer Discount API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("****************************************************************************************");		
	}

	@When("User call {string} Update Customer Discount PUT HTTP request for the discount of {string}")
	public void executeUpdateCustomerDiscountAPI(String version, String discount) {
		
		response = IdnT_UpdateCustomerDiscount.updateCustomerDiscountMethod(version, discount);

		System.out.println("");
		System.out.println("Update Customer Discount Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
		
	}

	@Then("Verify {int} status code in Update Customer Discount response")
	public void verifyUpdateCustomerDiscountAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Update Customer Discount API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Update Customer Discount API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}

}
