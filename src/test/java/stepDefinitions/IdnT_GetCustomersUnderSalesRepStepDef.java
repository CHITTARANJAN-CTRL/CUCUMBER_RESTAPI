package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_GetCustomersUnderSalesRep;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_GetCustomersUnderSalesRepStepDef {
	public Response response;
	public JsonPath jsp;

	@Given("API to Get Customers under a Sales Representative")
	public void displayGetCustomersUnderSalesRep() {

		System.out.println("**********************************************************************************************************");
		System.out.println("Your Get Customers under a Sales Representative API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("**********************************************************************************************************");

	}

	@When("User call {string} Get Customers under a Sales Representative GET HTTP request for {string}")
	public void executeGetCustomersUnderSalesRepAPI(String version, String salesrepemail) {

		response = IdnT_GetCustomersUnderSalesRep.getCustomersUnderSalesRepMethod(version, salesrepemail);

		System.out.println("");
		System.out.println("Get Customers under a Sales Representative Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());

	}

	@Then("Verify {int} status code in Get Customers under a Sales Representative response")
	public void verifyGetCustomersUnderSalesRepAPIRespCode(Integer statuscode) {

		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Get Customers under a Sales Representative API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Get Customers under a Sales Representative API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");

	}

}
