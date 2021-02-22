package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_SearchSiteAddress;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_SearchSiteAddressStepDef {

	public Response response;
	public JsonPath jsp;

	@Given("API to Search Site Address")
	public void displaySearchSiteAddress() {
		
		System.out.println("***********************************************************************************");
		System.out.println("Your Search Site Address API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("***********************************************************************************");
		
	}

	@When("User call {string} Search Site Address POST HTTP request")
	public void executeSearchSiteAddressAPI(String version) {

		response = IdnT_SearchSiteAddress.searchSiteAddressMethod(version);

		System.out.println("");
		System.out.println("Search Site Address Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());

	}

	@Then("Verify {int} status code in Search Site Address response")
	public void verifySearchSiteAddressAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Search Site Address API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Search Site Address API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}

}
