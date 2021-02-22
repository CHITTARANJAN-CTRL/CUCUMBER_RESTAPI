package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_GetCustomerPurchaseEntity;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_GetCustomerPurchaseEntityStepDef {
	
	public Response response;
	public JsonPath jsp;

	@Given("API to Get Customer Purchase Entity")
	public void displayGetCustomerPurchaseEntity() {
		
		System.out.println("********************************************************************************************");
		System.out.println("Your Get Customer Purchase Entity API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("********************************************************************************************");
		
	}

	@When("User call {string} Get Customer Purchase Entity GET HTTP request")
	public void executeGetCustomerPurchaseEntityAPI(String version) {

		response = IdnT_GetCustomerPurchaseEntity.getCustomerPurchaseEntityMethod(version);

		System.out.println("");
		System.out.println("Get Customer Purchase Entity Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
		
	}
	
	@When("User call {string} Get Customer Purchase Entity GET HTTP request for invalid DCN")
	public void executeGetCustomerPurchaseForInvalidDCNEntityAPI(String version) {
		
		response = IdnT_GetCustomerPurchaseEntity.getCustomerPurchaseEntityMethodForInvalidDCN(version);

		System.out.println("");
		System.out.println("Get Customer Purchase Entity Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
		
	}
	
	@Then("Verify {int} status code in Get Customer Purchase Entity response")
	public void verify_status_code_in_Get_Customer_Purchase_Entity_response(Integer statuscode)
	{
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Get Customer Purchase Entity API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Get Customer Purchase Entity API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
	}

	

}
