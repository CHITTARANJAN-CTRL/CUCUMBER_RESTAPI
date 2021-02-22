package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_UpdateSite;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_UpdateSiteStepDef {

	public Response response;
	public JsonPath jsp;

	@Given("API to Update Site")
	public void displayUpdateSite() {
		
		System.out.println("***************************************************************************");
		System.out.println("Your Update Site API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("***************************************************************************");
		System.out.println("Updating site for dcn: " + CreateTokenStepDef.dcn);
		System.out.println("");
		
	}

	@When("User call {string} Update Site PUT HTTP request with the firstname {string} lastname {string} and email {string}")
	public void executeUpdateSiteAPI(String version, String fname, String lname, String email) {
		
		response = IdnT_UpdateSite.updateSiteMethod(version, fname, lname, email);

		System.out.println("");
		System.out.println("Update Site Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
		
	}

	@Then("Verify {int} status code in Update Site response")
	public void verifyUpdateSiteAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Update Site API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Update Site API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}

}
