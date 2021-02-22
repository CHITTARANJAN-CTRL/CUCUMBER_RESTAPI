package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_CreateSalesRep;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_CreateSalesRepStepDef {

	public Response response;
	public JsonPath jsp;

	@Given("API to Create Sales Representative")
	public void displayCreateSalesRep() {
		
		System.out.println("*******************************************************************************************");
		System.out.println("Your Create Sales Representative API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("*******************************************************************************************");
		
	}

	@When("User call {string} Create Sales Representative POST HTTP request")
	public void executeCreateSalesRepAPI(String version) {

		response = IdnT_CreateSalesRep.createSalesRepMethod(version);

		System.out.println("");
		System.out.println("Create Sales Representative Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
		
	}

	@Then("Verify {int} status code in Create Sales Representative response")
	public void verifyCreateSalesRepAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Create Sales Representative API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Create Sales Representative API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}

}
