package stepDefinitions;

import org.testng.Assert;

import configurations.Configs;
import commonPrograms.IdnT_UpdateSalesRep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_UpdateSalesRepStepDef {
	
	public Response response;
	public JsonPath jsp;

	@Given("API to Update Sales Representative Details")
	public void displayUpdateSalesRep() {
		
		System.out.println("***************************************************************************************************");
		System.out.println("Your Update Sales Representative Details API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("***************************************************************************************************");
		System.out.println("Updating Sales Representative Details for: "+CreateTokenStepDef.salesrep_email);
		System.out.println("");
		
	}

	@When("User call {string} Update Sales Representative Details PUT HTTP request for firstname {string} lastname {string} and fullname {string}")
	public void executeUpdateSalesRepAPI(String version, String firstname, String lastname, String fullname) {
		
		response = IdnT_UpdateSalesRep.updateSalesRep(version, firstname, lastname, fullname);

		System.out.println("");
		System.out.println("Update Sales Representative Details Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
		
	}

	@Then("Verify {int} status code in Update Sales Representative Details response")
	public void verifyUpdateSalesRepAPIRespCode(Integer statuscode) {

		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Update Sales Representative Details API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Update Sales Representative Details API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}

}
