package stepDefinitions;

import commonPrograms.IdnT_UpdateNotification;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.Assert;

public class IdnT_UpdateNotificationStepDef {

	public Response response;
	public JsonPath jsp;

	@Given("API to Update Notification")
	public void displayUpdateNotification() {

		System.out.println("***********************************************************************************");
		System.out.println("Your Update Notification API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("***********************************************************************************");
		System.out.println("Updating Notification for the Alert ID: "+IdnT_GetNotificationStepDef.alertid);
		System.out.println("");

	}

	@When("User call {string} Update Notification PUT HTTP request with {string} status")
	public void executeUpdateNotificationAPI(String version, String status) {

		response = IdnT_UpdateNotification.updateNotificationMethod(version, status);

		System.out.println("");
		System.out.println("Update Notification Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());

	}

	@Then("Verify {int} expected status code in Update Notification response")
	public void verifyUpdateNotificationAPIRespCode(Integer statuscode) {

		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Update Notification API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Update Notification API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");

	}

}
