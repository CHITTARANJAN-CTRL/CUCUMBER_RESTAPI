package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_GetCustomer;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_GetCustomerStepDef {

	public Response response;
	public JsonPath jsp;
	

	@Given("API to Get Customer")
	public void displayGetCustomer() 
	{
		
		System.out.println("****************************************************************************");
		System.out.println("Your Get Customer API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("****************************************************************************");
		System.out.println("Getting Customer for the DCN: "+CreateTokenStepDef.dcn);
		System.out.println("");
		
	}

	@When("User call {string} Get Customer GET HTTP request")
	public void executeGetCustomerAPI(String version) 
	{
		
		response = IdnT_GetCustomer.getCustomerMethod(version);

		System.out.println("");
		System.out.println("Get Customer Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
		
	}

	@Then("Verify {int} status code in Get Customer response")
	public void verifyGetCustomerAPIRespCode(Integer statuscode) 
	{
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Get Customer API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Get Customer API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}
	
	@Then("Verify DCN should not be null in Get Customer response")
	public void verifyGetCustomerDCN()
	{
		Assert.assertNotNull(jsp.get("dcn"), "Oops!! DCN is NULL in Get Customer response");                             
        System.out.println("Great!! DCN is not NULL in Get Customer response");
        System.out.println("");

	}
	
	@Then("Verify Name should not be null in Get Customer response")
	public void verifyGetCustomerName() 
	{
		Assert.assertNotNull(jsp.get("name"), "Oops!! Name is NULL in Get Customer response");                             
        System.out.println("Great!! Name is not NULL in Get Customer response");
        System.out.println("");
	}

	@Then("Verify Discount should not be null in Get Customer response")
	public void verifyGetCustomerDiscount() 
	{
		Assert.assertNotNull(jsp.get("discount"), "Oops!! Discount is NULL in Get Customer response");                             
        System.out.println("Great!! Discount is not NULL in Get Customer response");
        System.out.println("");
	}

	@Then("Verify companyNumber should not be null in Get Customer response")
	public void verifyGetCustomerCompanyNumber() 
	{
		Assert.assertNotNull(jsp.get("companyNumber"), "Oops!! companyNumber is NULL in Get Customer response");                             
        System.out.println("Great!! CompanyNumber is not NULL in Get Customer response");
        System.out.println("");
	}

	@Then("Verify giiCustomerNumber should not be null in Get Customer response")
	public void verifyGetCustomerGiiCustomerNumber() 
	{
		Assert.assertNotNull(jsp.get("giiCustomerNumber"), "Oops!! giiCustomerNumber is NULL in Get Customer response");                             
        System.out.println("Great!! GiiCustomerNumber is not NULL in Get Customer response");
        System.out.println("");
	}

	@Then("Verify OrganizationLegalName should not be null in Get Customer response")
	public void verifyGetCustomerOrganizationLegalName() 
	{
		Assert.assertNotNull(jsp.get("organizationLegalName"), "Oops!! OrganizationLegalName is NULL in Get Customer response");                             
        System.out.println("Great!! OrganizationLegalName is not NULL in Get Customer response");
        System.out.println("");
	}

	@Then("Verify Country should not be null in get Get Customer response")
	public void verifyGetCustomerCountry() 
	{
		Assert.assertNotNull(jsp.get("country"), "Oops!! Country is NULL in Get Customer response");                             
        System.out.println("Great!! Country is not NULL in Get Customer response");
        System.out.println("");
	}

	@Then("Verify BUID should not be null in Get Customer response")
	public void verifyGetCustomerBUID() 
	{
		Assert.assertNotNull(jsp.get("buId"), "Oops!! BUID is NULL in Get Customer response");                             
        System.out.println("Great!! BUID is not NULL in Get Customer response");
        System.out.println("");
	}

	@Then("Verify paymentMethods should not be null in Get Customer response")
	public void verifyGetCustomerpaymentMethods() 
	{
		Assert.assertNotNull(jsp.get("paymentMethods[0].name"), "Oops!! Credit Card paymentMethods is NULL in Get Customer response");  
		Assert.assertNotNull(jsp.get("paymentMethods[1].name"), "Oops!! Invoice Terms paymentMethods is NULL in Get Customer response");
        System.out.println("Great!! All paymentMethods is not NULL in Get Customer response");
        System.out.println("");
	}

	@Then("Verify billingcadence should not be null in Get Customer response")
	public void verifyGetCustomerbillingcadence() 
	{
		Assert.assertNotNull(jsp.get("billingcadence[0].name"), "Oops!! monthly billingcadence is NULL in Get Customer response");
		Assert.assertNotNull(jsp.get("billingcadence[1].name"), "Oops!! yearly billingcadence is NULL in Get Customer response");
		Assert.assertNotNull(jsp.get("billingcadence[2].name"), "Oops!! upfront billingcadence is NULL in Get Customer response");
        System.out.println("Great!! All billingcadence is not NULL in Get Customer response");
        System.out.println("");
	}

	@Then("Verify salesReps should not be null in Get Customer response")
	public void verifyGetCustomerSalesReps() 
	{		
		Assert.assertNotNull(jsp.get("salesReps[0].email"), "Oops!! salesReps is NULL in Get Customer response");                             
        System.out.println("Great!! salesReps is not NULL in Get Customer response");
        System.out.println("");       
	}

}

