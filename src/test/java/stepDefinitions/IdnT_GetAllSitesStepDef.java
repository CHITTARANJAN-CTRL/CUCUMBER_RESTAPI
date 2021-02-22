package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_GetAllSites;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_GetAllSitesStepDef {
	
	public Response response;
	public JsonPath jsp;

	@Given("API to Get All Sites")
	public void displayGetAllSites() {
		
		System.out.println("*****************************************************************************");
		System.out.println("Your Get All Sites API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("*****************************************************************************");
		System.out.println("Getting All Sites for the DCN: " +CreateTokenStepDef.dcn);
		System.out.println("");
		
	}

	@When("User call {string} Get All Sites GET HTTP request")
	public void executeGetAllSitesAPI(String version) {
		
		response = IdnT_GetAllSites.getAllSitesMethod(version);

		System.out.println("");
		System.out.println("Get All Sites Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
	}

	@When("User call {string} Get All Sites GET HTTP request with invalid DCN")
	public void executeInvalidGetAllSitesAPI(String version) {
		
		response = IdnT_GetAllSites.getAllSiteInvalidDCNMethod(version);

		System.out.println("");
		System.out.println("Get All Sites Response Payload for Invalid DCN is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
		
	}

	@Then("Verify {int} status code in Get All Sites response")
	public void verifyGetAllSitesAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Get All Sites API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Get All Sites API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}
	
	@Then("Verify customerDCN should not be null in Get all Sites response")
	public void getAllSitesResponseCustomerDCN()
	{
		Assert.assertNotNull(jsp.get("customerDCN"), "Oops!! customerDCN is NULL in Get all Sites response");                             
        System.out.println("Great!! customerDCN is not NULL in Get all Sites response");
        System.out.println("");
	}

	@Then("Verify siteId should not be null in Get all Sites response")
	public void getAllSitesResponseSiteId()
	{
		Assert.assertNotNull(jsp.get("installAtAddresses[0].siteId"), "Oops!! siteId is NULL in Get all Sites response");                             
        System.out.println("Great!! siteId is not NULL in Get all Sites response");
        System.out.println("");
	}

	@Then("Verify ucid should not be null in Get all Sites response")
	public void getAllSitesResponseUCID()
	{
		Assert.assertNotNull(jsp.get("installAtAddresses[0].ucid"), "Oops!! ucid is NULL in in Get all Sites response");                             
        System.out.println("Great!! ucid is not NULL in Get all Sites response");
        System.out.println("");
	}

	@Then("Verify ucidStatus should not be null in Get all Sites response")
	public void getAllSitesResponseUCIDStatus()
	{
		Assert.assertNotNull(jsp.get("installAtAddresses[0].ucidStatus"), "Oops!! ucidStatus is NULL in Get all Sites response");                             
        System.out.println("Great!! ucidStatus is not NULL in Get all Sites response");
        System.out.println("");
	}

	@Then("Verify addressLineOne should not be null in Get all Sites response")
	public void getAllSitesResponseAddressLineOne()
	{
		Assert.assertNotNull(jsp.get("installAtAddresses[0].addressLineOne"), "Oops!! addressLineOne is NULL in Get all Sites response");                             
        System.out.println("Great!! addressLineOne is not NULL in Get all Sites response");
        System.out.println("");
	}

	@Then("Verify city should not be null in Get all Sites response")
	public void getAllSitesResponseCity()
	{
		Assert.assertNotNull(jsp.get("installAtAddresses[0].city"), "Oops!! city is NULL in Get all Sites response");                             
        System.out.println("Great!! city is not NULL in Get all Sites response");
        System.out.println("");
	}

	@Then("Verify countryCode should not be null in Get all Sites response")
	public void getAllSitesResponseCountryCode()
	{
		Assert.assertNotNull(jsp.get("installAtAddresses[0].countryCode"), "Oops!! countryCode is NULL in Get all Sites response");                             
        System.out.println("Great!! countryCode is not NULL in Get all Sites response");
        System.out.println("");
	}

	@Then("Verify provinceStateCode should not be null in Get all Sites response")
	public void getAllSitesResponseProvinceStateCode()
	{
		Assert.assertNotNull(jsp.get("installAtAddresses[0].provinceStateCode"), "Oops!! provinceStateCode is NULL in Get all Sites response");                             
        System.out.println("Great!! provinceStateCode is not NULL in Get all Sites response");
        System.out.println("");
	}

	@Then("Verify zipPostalCode should not be null in Get all Sites response")
	public void getAllSitesResponseZipPostalCode()
	{
		Assert.assertNotNull(jsp.get("installAtAddresses[0].zipPostalCode"), "Oops!! zipPostalCode is NULL in Get all Sites response");                             
        System.out.println("Great!! zipPostalCode is not NULL in Get all Sites response");
        System.out.println("");
	}

	@Then("Verify status should not be null in Get all Sites response")
	public void getAllSitesResponseStatus()
	{
		Assert.assertNotNull(jsp.get("installAtAddresses[0].status"), "Oops!! status is NULL in Get all Sites response");                             
        System.out.println("Great!! status is not NULL in Get all Sites response");
        System.out.println("");
	}

	@Then("Verify provinceStateCountyCode should not be null in Get all Sites response")
	public void getAllSitesResponseProvinceStateCountyCode()
	{
		Assert.assertNotNull(jsp.get("installAtAddresses[0].provinceStateCountyCode"), "Oops!! provinceStateCountyCode is NULL in Get all Sites response");                             
        System.out.println("Great!! provinceStateCountyCode is not NULL in Get all Sites response");
        System.out.println("");
	}


}
