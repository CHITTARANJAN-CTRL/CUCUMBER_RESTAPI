package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_GetCustomerPrimarySalesRep;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_GetCustomerPrimarySalesRepStepDef {
	public Response response;
	public JsonPath jsp;

	@Given("API to Get Customer Primary Sales Representative")
	public void displayGetCustomerPrimarySalesRep() {

		System.out.println("*************************************************************************************************************");
		System.out.println("Your Get Customer Primary Sales Representative API Test Execution started in " + Configs.ENV + " Environment.");
		System.out.println("*************************************************************************************************************");

	}

	@When("User call {string} Get Customer Primary Sales Representative GET HTTP request")
	public void executeGetCustomerPrimarySalesRepAPI(String version) {
		
		response = IdnT_GetCustomerPrimarySalesRep.getCustomerPrimarySalesRepMethod(version);

		System.out.println("");
		System.out.println("Get Customer Primary Sales Representative Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
	}

	@Then("Verify {int} status code in Get Customer Primary Sales Representative response")
	public void verifyGetCustomerPrimarySalesRepAPIRespCode(Integer statuscode) {

		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Get Customer Primary Sales Representative API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Get Customer Primary Sales Representative API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}

}
