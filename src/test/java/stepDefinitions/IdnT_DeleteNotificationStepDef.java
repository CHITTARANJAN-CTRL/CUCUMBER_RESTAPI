package stepDefinitions;

import commonPrograms.IdnT_DeleteNotification;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.Assert;

public class IdnT_DeleteNotificationStepDef {

	public Response response;
	public JsonPath jsp;

	@Given("API to Delete Notification")
	public void displayDeleteNotification() {

		System.out.println("***********************************************************************************");
		System.out.println("Your Delete Notification API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("***********************************************************************************");
		System.out.println("Deleting Notification for the Alert ID: " +IdnT_GetNotificationStepDef.alertid);
		System.out.println("");

	}

	@When("User call {string} Delete Notification DELETE HTTP request")
	public void executeDeleteNotificationAPI(String version) {

		response = IdnT_DeleteNotification.deleteNotificationMethod(version);

		System.out.println("");
		System.out.println("Delete Notification Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());

	}

	@Then("Verify {int} expected status code in Delete Notification response")
	public void verifyDeleteNotificationAPIRespCode(Integer statuscode) {

		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Delete Notification API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Delete Notification API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");

	}

}
