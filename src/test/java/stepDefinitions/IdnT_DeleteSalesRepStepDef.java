package stepDefinitions;

import org.testng.Assert;

import configurations.Configs;
import commonPrograms.IdnT_DeleteSalesRep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_DeleteSalesRepStepDef {
	
	public Response response;
	public JsonPath jsp;

	@Given("API to Delete Sales Representative")
	public void displayDeleteSalesRep() {
		
		System.out.println("*******************************************************************************************");
		System.out.println("Your Delete Sales Representative API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("*******************************************************************************************");
		System.out.println("");
		System.out.println("Deleting Sales Representative for: "+CreateTokenStepDef.salesrep_email);
		System.out.println("");
		
	}

	@When("User call {string} Delete Sales Representative DELETE HTTP request")
	public void executeDeleteSalesRepAPI(String version) {
		
		response = IdnT_DeleteSalesRep.deleteSalesRepMethod(version);

		System.out.println("");
		System.out.println("Delete Sales Representative Response Payload is:");
		System.out.println("");
		response.prettyPrint();

		jsp = new JsonPath(response.asString());
		
	}

	@Then("Verify {int} status code in Delete Sales Representative Details response")
	public void verifyDeleteSalesRepAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Delete Sales Representative API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Delete Sales Representative API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}

}
