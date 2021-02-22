package stepDefinitions;

import org.testng.Assert;

import commonPrograms.IdnT_GetPrimarysite;
import configurations.Configs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IdnT_GetPrimarysiteStepDef {
	
	public Response response;
	public JsonPath jsp;

	@Given("API to Get Primary Site")
	public void displayGetPrimarySite() {
		
		System.out.println("********************************************************************************");
		System.out.println("Your Get Primary Site API Test Execution started in "+Configs.ENV+" Environment.");
		System.out.println("********************************************************************************");
		System.out.println("Getting Primary Site for the DCN: " +CreateTokenStepDef.dcn);
		System.out.println("");
		
	}

	@When("User call {string} Get Primary Site GET HTTP request")
	public void executeGetPrimarySiteAPI(String version) {
		
		response = IdnT_GetPrimarysite.getPrimarysite(version);

		System.out.println("");
		System.out.println("Get Primary Site Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
	}
	
	@When("User call {string} Get Primary Site GET HTTP request with invalid DCN")
public void executeGetPrimarySiteAPIForInvalidDCN(String version) {
		
		response = IdnT_GetPrimarysite.executeGetPrimarySiteAPIForInvalidDCN(version);

		System.out.println("");
		System.out.println("Get Primary Site Response Payload is:");
		System.out.println("");
		response.prettyPrint();
		System.out.println("");

		jsp = new JsonPath(response.asString());
	}

	@Then("Verify {int} status code in Get Primary Site response")
	public void verifyGetPrimarySiteAPIRespCode(Integer statuscode) {
		
		System.out.println("");
		Assert.assertTrue(response.getStatusCode() == statuscode, "FAILED!! Your Get Primary Site API Test Execution Errored with unexpected "+response.getStatusCode()+" status code.");
		System.out.println("SUCCESS!! Your Get Primary Site API Test Execution response is "+statuscode+" as expected.");	
		System.out.println("");
		
	}
	
	@Then("Verify customerDCN should not be null in Get Primarysite response")
	public void verifyGetPrimarySitesbillingaddressCustomerDCN() 
	{
		Assert.assertNotNull(jsp.get("customerDCN"), "Oops!! customerDCN is NULL in Get Primarysite response");                             
        System.out.println("Great!! customerDCN is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress id should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddresscustomerId() 
	{
		Assert.assertNotNull(jsp.get("billingaddress.id"), "Oops!! customerName is NULL in Get Primarysite response");                             
        System.out.println("Great!! customerName is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress contact contactId should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddressContactId() 
	{
		Assert.assertNotNull(jsp.get("billingaddress.contact[0].contactId"), "Oops!! contactId is NULL in Get Primarysite response");                             
        System.out.println("Great!! contactId is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress contact firstName should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddressfirstName() 
	{
		Assert.assertNotNull(jsp.get("billingaddress.contact[0].firstName"), "Oops!! firstName is NULL in Get Primarysite response");                             
        System.out.println("Great!! firstName is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress contact lastName should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddresslastName() 
	{
		Assert.assertNotNull(jsp.get("billingaddress.contact[0].lastName"), "Oops!! lastName is NULL in Get Primarysite response");                             
        System.out.println("Great!! lastName is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress phoneNumber phoneContactMethodId should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddressphoneContactMethodIdr() 
	{
		Assert.assertNotNull(jsp.get("billingaddress.contact[0].phoneNumber.contactMethodId"), "Oops!! phoneContactMethodId is NULL in Get Primarysite response");                             
        System.out.println("Great!! phoneContactMethodId is not NULL in Get Primarysite response");
        System.out.println("");
	}
	
	@Then("Verify billingaddress phone number should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddressphoneNumber() 
	{
		Assert.assertNotNull(jsp.get("billingaddress.contact[0].phoneNumber.number"), "Oops!! phoneNumber is NULL in Get Primarysite response");                             
        System.out.println("Great!! phoneNumber is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress phone countryCode should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddressPhoneCountryCode() 
	{
		Assert.assertNotNull(jsp.get("billingaddress.contact[0].phoneNumber.countryCode"), "Oops!! countryCode is NULL in Get Primarysite response");                             
        System.out.println("Great!! countryCode is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress phone areaCode should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddressPhoneareaCode() 
	{
		Assert.assertNotNull(jsp.get("billingaddress.contact[0].phoneNumber.areaCode"), "Oops!! areaCode is NULL in Get Primarysite response");                             
        System.out.println("Great!! areaCode is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress phone contactMethodId should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddressPhoneContactMethodId() 
	{
		Assert.assertNotNull(jsp.get("billingaddress.contact[0].phoneNumber.contactMethodId"), "Oops!! contactMethodId is NULL in Get Primarysite response");                             
        System.out.println("Great!! contactMethodId is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress phone phoneType should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddressPhonePhoneType() 
	{
		Assert.assertNotNull(jsp.get("billingaddress.contact[0].phoneNumber.phoneType"), "Oops!! phoneType is NULL in Get Primarysite response");                             
        System.out.println("Great!! phoneType is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress email contactMethodId should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddressEmailontactMethodId()
	{
		Assert.assertNotNull(jsp.get("billingaddress.contact[0].email.contactMethodId"), "Oops!! email contactMethodId is NULL in Get Primarysite response");                             
        System.out.println("Great!! email contactMethodId is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress email value should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddressEmailValue()
	{
		Assert.assertNotNull(jsp.get("billingaddress.contact[0].email.value"), "Oops!! email value is NULL in Get Primarysite response");                             
        System.out.println("Great!! email value is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress address primary siteId should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddressPrimary()
	{
		Assert.assertNotNull(jsp.get("billingaddress.address.primary"), "Oops!! primary is NULL in Get Primarysite response");                             
        System.out.println("Great!! primary value is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress address addressLineOne ucidStatus should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddressAddressLineOne()
	{
		Assert.assertNotNull(jsp.get("billingaddress.address.addressLineOne"), "Oops!! addressLineOne is NULL in Get Primarysite response");                             
        System.out.println("Great!! addressLineOne value is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress address addressLineTwo should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddressAddressLineTwo()
	{
		Assert.assertNotNull(jsp.get("billingaddress.address.addressLineTwo"), "Oops!! addressLineTwo is NULL in Get Primarysite response");                             
        System.out.println("Great!! addressLineOne value is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress address city should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddressCity()
	{
		Assert.assertNotNull(jsp.get("billingaddress.address.city"), "Oops!! city is NULL in Get Primarysite response");                             
        System.out.println("Great!! city value is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress address countryCode should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddresscAddressCountryCode()
	{
		Assert.assertNotNull(jsp.get("billingaddress.address.countryCode"), "Oops!! address countryCode is NULL in Get Primarysite response");                             
        System.out.println("Great!! address countryCode value is not NULL in Get Primarysite response");
        System.out.println("");
	}
	
	@Then("Verify billingaddress address provinceStateCode should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddresscProvinceStateCode()
	{
		Assert.assertNotNull(jsp.get("billingaddress.address.provinceStateCode"), "Oops!! provinceStateCode is NULL in Get Primarysite response");                             
        System.out.println("Great!! provinceStateCode value is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress address zipPostalCode should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddressZipPostalCode()
	{
		Assert.assertNotNull(jsp.get("billingaddress.address.zipPostalCode"), "Oops!! zipPostalCode is NULL in Get Primarysite response");                             
        System.out.println("Great!! zipPostalCode value is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress address isAddressVerified should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddresscisAddressVerified()
	{
		Assert.assertNotNull(jsp.get("billingaddress.address.isAddressVerified"), "Oops!! isAddressVerified is NULL in Get Primarysite response");                             
        System.out.println("Great!! isAddressVerified value is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress address status should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddressStatus()
	{
		Assert.assertNotNull(jsp.get("billingaddress.address.status"), "Oops!! status is NULL in Get Primarysite response");                             
        System.out.println("Great!! status value is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify billingaddress address provinceStateCountyCode should not be null in Get Primarysite response")
	public void verifyGetPrimarybillingaddressProvinceStateCountyCode()
	{
		Assert.assertNotNull(jsp.get("billingaddress.address.status"), "Oops!! provinceStateCountyCode is NULL in Get Primarysite response");                             
        System.out.println("Great!! provinceStateCountyCode value is not NULL in Get Primarysite response");
        System.out.println("");
	}
	
	@Then("Verify shippingaddress id should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddresscustomerId() 
	{
		Assert.assertNotNull(jsp.get("shippingaddress.id"), "Oops!! customerName is NULL in Get Primarysite response");                             
        System.out.println("Great!! customerName is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify shippingaddress contact contactId should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddressContactId() 
	{
		Assert.assertNotNull(jsp.get("shippingaddress.contact[0].contactId"), "Oops!! contactId is NULL in Get Primarysite response");                             
        System.out.println("Great!! contactId is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify shippingaddress contact firstName should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddressfirstName() 
	{
		Assert.assertNotNull(jsp.get("shippingaddress.contact[0].firstName"), "Oops!! firstName is NULL in Get Primarysite response");                             
        System.out.println("Great!! firstName is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify shippingaddress contact lastName should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddresslastName() 
	{
		Assert.assertNotNull(jsp.get("shippingaddress.contact[0].lastName"), "Oops!! lastName is NULL in Get Primarysite response");                             
        System.out.println("Great!! lastName is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify shippingaddress phoneNumber phoneContactMethodId should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddressphoneContactMethodId() 
	{
		Assert.assertNotNull(jsp.get("shippingaddress.contact[0].phoneNumber.contactMethodId"), "Oops!! phoneContactMethodId is NULL in Get Primarysite response");                             
        System.out.println("Great!! phoneContactMethodId is not NULL in Get Primarysite response");
        System.out.println("");
	}
	
	@Then("Verify shippingaddress phone number should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddressphoneNumber() 
	{
		Assert.assertNotNull(jsp.get("shippingaddress.contact[0].phoneNumber.number"), "Oops!! phoneNumber is NULL in Get Primarysite response");                             
        System.out.println("Great!! phoneNumber is not NULL in Get Primarysite response");
        System.out.println("");
	}
	@Then("Verify shippingaddress phone countryCode should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddressPhoneCountryCode() 
	{
		Assert.assertNotNull(jsp.get("shippingaddress.contact[0].phoneNumber.countryCode"), "Oops!! countryCode is NULL in Get Primarysite response");                             
        System.out.println("Great!! countryCode is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify shippingaddress phone areaCode should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddressPhoneareaCode() 
	{
		Assert.assertNotNull(jsp.get("shippingaddress.contact[0].phoneNumber.areaCode"), "Oops!! areaCode is NULL in Get Primarysite response");                             
        System.out.println("Great!! areaCode is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify shippingaddress phone contactMethodId should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddressPhoneContactMethodId() 
	{
		Assert.assertNotNull(jsp.get("billingaddress.contact[0].phoneNumber.contactMethodId"), "Oops!! contactMethodId is NULL in Get Primarysite response");                             
        System.out.println("Great!! contactMethodId is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify shippingaddress phone phoneType should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddressPhonePhoneType() 
	{
		Assert.assertNotNull(jsp.get("shippingaddress.contact[0].phoneNumber.phoneType"), "Oops!! phoneType is NULL in Get Primarysite response");                             
        System.out.println("Great!! phoneType is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify shippingaddress emailContactMethodId should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddressEmailontactMethodId()
	{
		Assert.assertNotNull(jsp.get("shippingaddress.contact[0].email.contactMethodId"), "Oops!! email contactMethodId is NULL in Get Primarysite response");                             
        System.out.println("Great!! email contactMethodId is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify shippingaddress email value should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddressEmailValue()
	{
		Assert.assertNotNull(jsp.get("shippingaddress.contact[0].email.value"), "Oops!! email value is NULL in Get Primarysite response");                             
        System.out.println("Great!! email value is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify shippingaddress address primary siteId should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddressPrimary()
	{
		Assert.assertNotNull(jsp.get("shippingaddress.address.primary"), "Oops!! primary is NULL in Get Primarysite response");                             
        System.out.println("Great!! primary value is not NULL in Get Primarysite response");
        System.out.println("");
	}
	
	@Then("Verify shippingaddress address addressLineOne ucidStatus should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddressAddressLineOne()
	{
		Assert.assertNotNull(jsp.get("shippingaddress.address.addressLineOne"), "Oops!! addressLineOne is NULL in Get Primarysite response");                             
        System.out.println("Great!! addressLineOne value is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify shippingaddress address addressLineTwo should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddressAddressLineTwo()
	{
		Assert.assertNotNull(jsp.get("shippingaddress.address.addressLineTwo"), "Oops!! addressLineTwo is NULL in Get Primarysite response");                             
        System.out.println("Great!! addressLineOne value is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify shippingaddress address city should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddressCity()
	{
		Assert.assertNotNull(jsp.get("shippingaddress.address.city"), "Oops!! city is NULL in Get Primarysite response");                             
        System.out.println("Great!! city value is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify shippingaddress address countryCode should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddressAddressCountryCode()
	{
		Assert.assertNotNull(jsp.get("shippingaddress.address.countryCode"), "Oops!! address countryCode is NULL in Get Primarysite response");                             
        System.out.println("Great!! address countryCode value is not NULL in Get Primarysite response");
        System.out.println("");
	}
	
	@Then("Verify shippingaddress address provinceStateCode should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddresscProvinceStateCode()
	{
		Assert.assertNotNull(jsp.get("shippingaddress.address.provinceStateCode"), "Oops!! provinceStateCode is NULL in Get Primarysite response");                             
        System.out.println("Great!! provinceStateCode value is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify shippingaddress address zipPostalCode should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddressZipPostalCode()
	{
		Assert.assertNotNull(jsp.get("shippingaddress.address.zipPostalCode"), "Oops!! zipPostalCode is NULL in Get Primarysite response");                             
        System.out.println("Great!! zipPostalCode value is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify shippingaddress address isAddressVerified should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddressisAddressVerified()
	{
		Assert.assertNotNull(jsp.get("shippingaddress.address.isAddressVerified"), "Oops!! isAddressVerified is NULL in Get Primarysite response");                             
        System.out.println("Great!! isAddressVerified value is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify shippingaddress address status should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddressStatus()
	{
		Assert.assertNotNull(jsp.get("shippingaddress.address.status"), "Oops!! status is NULL in Get Primarysite response");                             
        System.out.println("Great!! status value is not NULL in Get Primarysite response");
        System.out.println("");
	}

	@Then("Verify shippingaddress address provinceStateCountyCode should not be null in Get Primarysite response")
	public void verifyGetPrimaryshippingaddressProvinceStateCountyCode()
	{
		Assert.assertNotNull(jsp.get("shippingaddress.address.status"), "Oops!! provinceStateCountyCode is NULL in Get Primarysite response");                             
        System.out.println("Great!! provinceStateCountyCode value is not NULL in Get Primarysite response");
        System.out.println("");
	}
	
	
}