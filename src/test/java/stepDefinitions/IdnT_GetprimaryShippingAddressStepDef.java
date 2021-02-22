package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_GetprimaryShippingAddress;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_GetprimaryShippingAddressStepDef {
	
	public Response response;
	public JsonPath jsp;

	@Given("API to Get Primary Shipping Address")
	public void displayGetPrimaryShippingAddress() {
		
		System.out.println("***********************************************************************************************");
		System.out.println("Your Get PrimaryShipping Address API Test Execution started in " + Configs.ENV + " Environment.");
		System.out.println("***********************************************************************************************");
		System.out.println("Getting Primary Shipping Address for the DCN: " + CreateTokenStepDef.dcn);
		System.out.println("");
		
	}

	@When("User call {string} Get Primar yShipping Address GET HTTP request with sitetype {string}")
	public void executeGetPrimaryShippingAddressAPI(String version, String siteType) {
		
		response = IdnT_GetprimaryShippingAddress.getprimaryShippingAddressMethod(version, siteType);

		System.out.println("");
		System.out.println("Get Primary Shipping Address Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
		
	}

	@Then("Verify {int} status code in Get Primary Shipping Address response")
	public void verifyGetPrimaryShippingAddressAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Get Primary Shipping Address API Test Execution Errored with unexpected " + response.getStatusCode() + " status code.");
		System.out.println("SUCCESS!! Your Get Primary Shipping Address API Test Execution response is " + statuscode + " as expected.");
		System.out.println("");
		
	}

}
