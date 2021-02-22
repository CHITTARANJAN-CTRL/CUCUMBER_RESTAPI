package stepDefinitions;

import commonPrograms.IdnT_GetNotification;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;

public class IdnT_GetNotificationStepDef {

	public Response response;
	public JsonPath jsp;
	public static String email;
	public static String alertid;

	@Given("API to Get Notification")
	public void displayGetNotification() {

		System.out.println("********************************************************************************");
		System.out.println("Your Get Notification API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("********************************************************************************");

	}

	@When("User call {string} Get Notification GET HTTP request with valid email as {string}, Notificationtype as {string} and choose sortBy {string} with {string} sortOrder")
	public void executeGetValidNotificationAPI(String version, String email, String notificationtype, String sortby, String sortorder) {

		IdnT_GetNotificationStepDef.email = email;

		response = IdnT_GetNotification.getNotificationMethod(version, email, notificationtype, sortby, sortorder);

		System.out.println("");
		System.out.println("Get Notification Response Payload for valid email is too big to display. Hence not displayed on console");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());

		alertid = jsp.get("alertNotification[0].alertId");

	}
	
	@When("User call {string} Get Notification GET HTTP request with invalid email as {string}, Notificationtype as {string} and choose sortBy {string} with {string} sortOrder")
	public void executeGetInvalidNotificationAPI(String version, String email, String notificationtype, String sortby, String sortorder) {

		response = IdnT_GetNotification.getNotificationMethod(version, email, notificationtype, sortby, sortorder);

		System.out.println("");
		System.out.println("Get Notification Response Payload for Invalid email <"+email+"> is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());

	}

	@Then("Verify {int} expected status code in Get Notification response")
	public void verifyGetNotificationAPIRespCode(Integer statuscode) {

		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Get Notification API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Get Notification API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");

	}

	@Then("Verify the records are in sortBy {string} with {string} sortOrder in Get Notification response")
	public void verifyGetNotificationAPIsortOrder(String sortby, String sortorder) {

		if (sortby.equalsIgnoreCase("createdDate") && sortorder.equalsIgnoreCase("ASC")) {
			List<String> createddate = jsp.getList("alertNotification.createdDate");
			List<String> sortcreateddate = jsp.getList("alertNotification.createdDate");
			Collections.sort(sortcreateddate);
			Assert.assertTrue(createddate.equals(sortcreateddate), "Created Date Sort Order Missing");
		}

		else if (sortby.equalsIgnoreCase("createdDate") && sortorder.equalsIgnoreCase("DESC")) {
			List<String> createddate = jsp.getList("alertNotification.createdDate");
			List<String> sortcreateddate = jsp.getList("alertNotification.createdDate");
			Collections.sort(sortcreateddate);
			Collections.reverse(sortcreateddate);
			Assert.assertTrue(createddate.equals(sortcreateddate), "Created Date Sort Order Missing");
		}

		else if (sortby.equalsIgnoreCase("status") && sortorder.equalsIgnoreCase("ASC")) {
			List<String> status = jsp.getList("alertNotification.status");
			List<String> sortstatus = jsp.getList("alertNotification.status");
			Collections.sort(sortstatus);
			Assert.assertTrue(status.equals(sortstatus), "Status Sort Order Missing");
		}

		else if (sortby.equalsIgnoreCase("status") && sortorder.equalsIgnoreCase("DESC")) {
			List<String> status = jsp.getList("alertNotification.status");
			List<String> sortstatus = jsp.getList("alertNotification.status");
			Collections.sort(sortstatus);
			Collections.reverse(sortstatus);
			Assert.assertTrue(status.equals(sortstatus), "Status Sort Order Missing");
		}
	}

}
