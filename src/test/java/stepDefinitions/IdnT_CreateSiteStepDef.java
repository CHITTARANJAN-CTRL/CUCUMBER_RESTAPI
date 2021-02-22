package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_CreateSite;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_CreateSiteStepDef {
	
	public Response response;
	public JsonPath jsp;
	public static String siteId;
	
	@Given("API to Create Site")
	public void displayCreateSite() {
		
		System.out.println("***************************************************************************");
		System.out.println("Your Create Site API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("***************************************************************************");
		
	}

	@When("User call {string} Create Site POST HTTP request")
	public void executeCreateSiteAPI(String version) {
		
		response = IdnT_CreateSite.createSiteMethod(version);

		System.out.println("");
		System.out.println("Create Site Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
		
		siteId = jsp.get("siteId");
		
	}

	@Then("Verify {int} status code in Create Site response")
	public void verifyCreateSiteAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Create Site API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Create Site API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}

}
