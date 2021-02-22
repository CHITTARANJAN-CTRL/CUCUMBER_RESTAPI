package stepDefinitions;

import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.Assert;

import commonPrograms.IdnT_CreateNotification;

public class IdnT_CreateNotificationStepDef {

	public Response response;
	public JsonPath jsp;

	@Given("API to Create Notification")
	public void displayCreateNotification() {

		System.out.println("***********************************************************************************");
		System.out.println("Your Create Notification API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("***********************************************************************************");

	}

	@When("User call {string} Create Notification POST HTTP request")
	public void executeCreateNotificationAPI(String version) {

		response = IdnT_CreateNotification.createNotificationMethod(version);

		System.out.println("");
		System.out.println("Create Notification Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());

	}

	@Then("Verify {int} status code in Create Notification response")
	public void verifyCreateNotificationAPIRespCode(Integer statuscode) {

		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Create Notification API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Create Notification API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");

	}

}
