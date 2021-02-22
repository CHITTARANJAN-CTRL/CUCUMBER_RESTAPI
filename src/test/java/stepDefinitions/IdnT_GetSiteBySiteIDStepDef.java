package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_GetSiteBySiteID;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_GetSiteBySiteIDStepDef {

	
	public Response response;
	public JsonPath jsp;
	
	public static String contactId;
	public static String phoneContactMethodId;
	public static String emailContactMethodId;
	public static String city;
	public static String state;


	@Given("API to Get Site by SiteId")
	public void displayGetSitebySiteId() {
		
		System.out.println("**********************************************************************************");
		System.out.println("Your Get Site by SiteId API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("**********************************************************************************");
		System.out.println("Getting sites for siteId: " + IdnT_CreateSiteStepDef.siteId);
		System.out.println("");
		
	}

	@When("User call {string} Get Site by SiteId GET HTTP request")
	public void executeGetSitebySiteIdAPI(String version) {
		
		response = IdnT_GetSiteBySiteID.getSiteBySiteIDMethod(version);

		System.out.println("");
		System.out.println("Get Site by SiteId Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());

		contactId = jsp.get("contact[0].contactId");
		phoneContactMethodId = jsp.get("contact[0].phoneNumber.contactMethodId");
		emailContactMethodId = jsp.get("contact[0].email.contactMethodId");
		city = jsp.get("address.city");
		state = jsp.get("address.provinceStateCode");
		
		System.out.println("Retrived contactId(camLocationId) is: "+contactId);
		System.out.println("Retrived phoneContactMethodId is: "+phoneContactMethodId);
		System.out.println("Retrived emailContactMethodId is: "+emailContactMethodId);
		System.out.println("");
		
	}
	

	@When("User call {string} Get Site by SiteId GET HTTP request with invalid DCN")
	public void executeGetSitebySiteIdAPIInvalidDCN(String version) 
	{
		response = IdnT_GetSiteBySiteID.getSiteBySiteIDMethodForInvalidDCN(version);

		System.out.println("");
		System.out.println("Get Site by SiteId Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
	}
	
	
	@Then("Verify {int} status code in Get Site by SiteId response")
	public void verifyGetSitebySiteIdAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Get Site by SiteId API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Get Site by SiteId API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}
	
	@Then("Verify contactId should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdAPIcontactId()
	{
		Assert.assertNotNull(contactId, "Oops!! contactId(camLocationId) is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! contactId(camLocationId) is not NULL in Get Site by SiteId response");
        System.out.println("");

	}
	
	@Then("Verify phoneContactMethodId should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdAPIphoneContactMethodId()
	{
		Assert.assertNotNull(phoneContactMethodId, "Oops!! phoneContactMethodId is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! phoneContactMethodId is not NULL in Get Site by SiteId response");
        System.out.println("");

	}
	
	@Then("Verify emailContactMethodId should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdAPIemailContactMethodId()
	{
		Assert.assertNotNull(emailContactMethodId, "Oops!! emailContactMethodId is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! emailContactMethodId is not NULL in Get Site by SiteId response");
        System.out.println("");

	}
	
	@Then("Verify firstName should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdResponseFirstName()
	{
		Assert.assertNotNull(jsp.get("contact[0].firstName"), "Oops!! firstName is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! firstName is not NULL in Get Site by SiteId response");
        System.out.println("");
	   
	}

	@Then("Verify lastName should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdResponseLastName()
	{
		Assert.assertNotNull(jsp.get("contact[0].lastName"), "Oops!! lastName is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! lastName is not NULL in Get Site by SiteId response");
        System.out.println("");
	}

	@Then("Verify phone number should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdResponseNumber()
	{
		Assert.assertNotNull(jsp.get("contact[0].phoneNumber.number"), "Oops!! number is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! number is not NULL in Get Site by SiteId response");
        System.out.println("");
	}

	@Then("Verify phone countryCode should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdResponsePhoneCountryCode()
	{
		Assert.assertNotNull(jsp.get("contact[0].phoneNumber.countryCode"), "Oops!! countryCode is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! countryCode is not NULL in Get Site by SiteId response");
        System.out.println("");
	}

	@Then("Verify phone number areaCode should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdResponsePhoneNumber()
	{
		Assert.assertNotNull(jsp.get("contact[0].phoneNumber.number"), "Oops!! areaCode is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! areaCode is not NULL in Get Site by SiteId response");
        System.out.println("");
	}

	@Then("Verify phone areaCode should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdResponseAreaCode()
	{
		Assert.assertNotNull(jsp.get("contact[0].phoneNumber.areaCode"), "Oops!! phoneType is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! phoneType is not NULL in Get Site by SiteId response");
        System.out.println("");
	}
	
	@Then("Verify phone phoneType should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdResponsePhoneType()
	{
		Assert.assertNotNull(jsp.get("contact[0].phoneNumber.phoneType"), "Oops!! phoneType is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! phoneType is not NULL in Get Site by SiteId response");
        System.out.println("");
	}
	
	@Then("Verify email value should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdResponsevalue()
	{
		Assert.assertNotNull(jsp.get("contact[0].phoneNumber.phoneType"), "Oops!! email value is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! email value is not NULL in Get Site by SiteId response");
        System.out.println("");
	}

	@Then("Verify address siteId should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdResponseSiteId()
	{
		Assert.assertNotNull(jsp.get("address.siteId"), "Oops!! siteId is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! siteId is not NULL in Get Site by SiteId response");
        System.out.println("");
	}

	@Then("Verify address ucidStatus should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdResponseucidStatus()
	{
		Assert.assertNotNull(jsp.get("address.ucidStatus"), "Oops!! ucidStatus is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! ucidStatus is not NULL in Get Site by SiteId response");
        System.out.println("");
	}

	@Then("Verify address primary should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdResponsePrimary()
	{
		Assert.assertNotNull(jsp.get("address.primary"), "Oops!! primary is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! primary is not NULL in Get Site by SiteId response");
        System.out.println("");
	}

	@Then("Verify address addressLineOne should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdResponseAddressLineOne()
	{
		Assert.assertNotNull(jsp.get("address.addressLineOne"), "Oops!! addressLineOne is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! addressLineOne is not NULL in Get Site by SiteId response");
        System.out.println("");
	}

	@Then("Verify address addressLineTwo should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdResponseAddressLineTwo()
	{
		Assert.assertNotNull(jsp.get("address.addressLineTwo"), "Oops!! addressLineTwo is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! addressLineTwo is not NULL in Get Site by SiteId response");
        System.out.println("");
	}

	@Then("Verify address addressLineThree should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdResponseAddressLineThree()
	{
		Assert.assertNotNull(jsp.get("address.addressLineThree"), "Oops!! addressLineThree is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! addressLineThree is not NULL in Get Site by SiteId response");
        System.out.println("");
	}

	@Then("Verify address city should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdResponseCity()
	{
		Assert.assertNotNull(jsp.get("address.city"), "Oops!! city is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! city is not NULL in Get Site by SiteId response");
        System.out.println("");
	}

	@Then("Verify address countryCode should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdAddressCountryCode()
	{
		Assert.assertNotNull(jsp.get("address.countryCode"), "Oops!!address countryCode is NULL in Get Site by SiteId response");                             
        System.out.println("Great!!address countryCode is not NULL in Get Site by SiteId response");
        System.out.println("");
	}

	@Then("Verify address provinceStateCode should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdProvinceStateCode()
	{
		Assert.assertNotNull(jsp.get("address.provinceStateCode"), "Oops!! provinceStateCode is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! provinceStateCode is not NULL in Get Site by SiteId response");
        System.out.println("");
	}

	@Then("Verify address zipPostalCode should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdZipPostalCode()
	{
		Assert.assertNotNull(jsp.get("address.zipPostalCode"), "Oops!! zipPostalCode is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! zipPostalCode is not NULL in Get Site by SiteId response");
        System.out.println("");
	}

	@Then("Verify address isAddressVerified should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdIsAddressVerified()
	{
		Assert.assertNotNull(jsp.get("address.isAddressVerified"), "Oops!! isAddressVerified is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! isAddressVerified is not NULL in Get Site by SiteId response");
        System.out.println("");
	}

	@Then("Verify address status should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdStatus()
	{
		Assert.assertNotNull(jsp.get("address.status"), "Oops!! status is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! status is not NULL in Get Site by SiteId response");
        System.out.println("");
	}

	@Then("Verify address provinceStateCountyCode should not be null in Get Site by SiteId response")
	public void verifyGetSitebySiteIdProvinceStateCountyCode()
	{
		Assert.assertNotNull(jsp.get("address.provinceStateCountyCode"), "Oops!! provinceStateCountyCode is NULL in Get Site by SiteId response");                             
        System.out.println("Great!! provinceStateCountyCode is not NULL in Get Site by SiteId response");
        System.out.println("");
	}

}
