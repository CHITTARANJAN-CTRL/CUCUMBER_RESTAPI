package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_GetprimaryBillingAddress;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_GetprimaryBillingAddressStepDef {
	
	public Response response;
	public JsonPath jsp;

	@Given("API to Get Primary Billing Address")
	public void displayGetprimaryBillingAddress() {
		
		System.out.println("***********************************************************************************************");
		System.out.println("Your Get PrimaryB illing Address API Test Execution started in " + Configs.ENV + " Environment.");
		System.out.println("***********************************************************************************************");
		System.out.println("Getting Primary Billing Address for the DCN: " + CreateTokenStepDef.dcn);
		System.out.println("");
		
	}

	@When("User call {string} Get Primary Billing Address GET HTTP request")
	public void executeGetprimaryBillingAddressAPI(String version) {
		
		response = IdnT_GetprimaryBillingAddress.getPrimaryBillingAddressMethod(version);

		System.out.println("");
		System.out.println("Get Primary Billing Address Response Payload is:");
		System.out.println("");
		
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
		
	}

	@Then("Verify {int} status code in Get Primary Billing Address response")
	public void verifyGetprimaryBillingAddressAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Get Primary Billing Address API Test Execution Errored with unexpected " + response.getStatusCode()+ " status code.");
		System.out.println("SUCCESS!! Your Get Primary Billing Address API Test Execution response is " + statuscode + " as expected.");
		System.out.println("");
		
	}

}
