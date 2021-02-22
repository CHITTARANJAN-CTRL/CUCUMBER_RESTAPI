package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_GetSalesRep;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_GetSalesRepStepDef {
	public Response response;
	public JsonPath jsp;

	@Given("API to Get Sales Representative Details")
	public void displayGetSalesRep() {
		
		System.out.println("************************************************************************************************");
		System.out.println("Your Get Sales Representative Details API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("************************************************************************************************");
		System.out.println("Getting Sales Representative Details for: "+CreateTokenStepDef.salesrep_email);
		System.out.println("");

	}

	@When("User call {string} Get Sales Representative Details GET HTTP request")
	public void executeGetSalesRepAPI(String version) {
		
		response = IdnT_GetSalesRep.getSalesRepMethod(version);

		System.out.println("");
		System.out.println("Get Sales Representative Details Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
		
	}

	@Then("Verify {int} status code in Get Sales Representative Details response")
	public void verifyGetSalesRepAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Get Sales Representative Details API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Get Sales Representative Details API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}
	
	@Then("Verify firstName field should not be null in Get Sales Representative Details response")
	public void verifyGetSalesRepfirstName()
	{
		Assert.assertNotNull(jsp.get("firstName"), "Oops!! firstName is NULL in get sales representative responsee");                             
        System.out.println("Great!! firstName is not NULL in get sales representative response");
        System.out.println("");
	}

	@Then("Verify lastName field should not be null in Get Sales Representative Details response")
	public void verifyGetSalesReplastName() 
	{
		Assert.assertNotNull(jsp.get("lastName"), "Oops!! lastName is NULL in get sales representative responsee");                             
        System.out.println("Great!! lastName is not NULL in get sales representative response");
        System.out.println("");
	}

	@Then("Verify fullName field should not be null in Get Sales Representative Details response")
	public void verifyGetSalesRepfullName() 
	{
		Assert.assertNotNull(jsp.get("fullName"), "Oops!! lastName is NULL in get sales representative responsee");                             
        System.out.println("Great!! fullName is not NULL in get sales representative response");
        System.out.println("");
	}

	@Then("Verify email field should not be null in Get Sales Representative Details response")
	public void verifyGetSalesRepemail() 
	{
		Assert.assertNotNull(jsp.get("email"), "Oops!! email is NULL in get sales representative responsee");                             
        System.out.println("Great!! email is not NULL in get sales representative response");
        System.out.println("");
	}

	@Then("Verify phone field should not be null in Get Sales Representative Details response")
	public void verifyGetSalesRepphone() 
	{
		Assert.assertNotNull(jsp.get("phone"), "Oops!! phone is NULL in get sales representative responsee");                             
        System.out.println("Great!! phone is not NULL in get sales representative response");
        System.out.println("");
	}

	@Then("Verify salesRepId field should not be null in Get Sales Representative Details response")
	public void verifyGetSalesRepId() 
	{
		Assert.assertNotNull(jsp.get("salesRepId"), "Oops!! salesRepId is NULL in get sales representative responsee");                             
        System.out.println("Great!! salesRepId is not NULL in get sales representative response");
        System.out.println("");
	}

	

}
