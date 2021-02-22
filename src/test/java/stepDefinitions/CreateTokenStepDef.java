package stepDefinitions;

import static configurations.Configs.*;

import java.util.concurrent.ThreadLocalRandom;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javaUtils.Tokens;

public class CreateTokenStepDef {
		
	public static String dcn;
	public static String buid;
	public static String country;
	public static String language;
	
	public static String salesrep_fn;
	public static String salesrep_ln;
	public static String salesrep_name;
	public static String salesrep_email;
	public static String salesrep_id;
	
	public static String customersalesrep_email;
	
	public static String customer_fn;
	public static String customer_ln;
	public static String customer_email;
	public static String addressone;
	
	public static String useroptinoptout_email;
	
	public static String eventtype;
	
	public static String rightIds;
	

	
	public static String token;
	
	@Given("With DCN, BUID, Country, Language and other attributes")
	public void displayEnvironment() {
		
		System.out.println("**************************************************************");
		System.out.println("Your CCP-SB API Test Execution started in "+ENV+" Environment.");
		System.out.println("**************************************************************");

	}

	@When("User create token for Sales Rep Service with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void generateSalesRepToken(String dcn, String salesrep_fn, String salesrep_ln, String salesrep_name, String salesrep_email, String salesrep_id, String buid, String country, String language) {
	
		CreateTokenStepDef.dcn = dcn;
		CreateTokenStepDef.salesrep_fn = salesrep_fn;
		CreateTokenStepDef.salesrep_ln = salesrep_ln;
		CreateTokenStepDef.salesrep_name = salesrep_name;
		CreateTokenStepDef.salesrep_email = salesrep_email;
		CreateTokenStepDef.salesrep_id = salesrep_id;
		CreateTokenStepDef.buid = buid;
		CreateTokenStepDef.country = country;
		CreateTokenStepDef.language = language;
		
		token = Tokens.getToken(dcn, buid, country, language);
		
	}
	
	@When("User create token for Customer Service with {string}, {string}, {string}, {string} and {string}")
	public void generateCustomerToken(String dcn, String customersalesrep_email, String buid, String country, String language) {
	
		CreateTokenStepDef.dcn = dcn;
		CreateTokenStepDef.customersalesrep_email = customersalesrep_email;
		CreateTokenStepDef.buid = buid;
		CreateTokenStepDef.country = country;
		CreateTokenStepDef.language = language;
		
		token = Tokens.getToken(dcn, buid, country, language);
		
	}
	
	@When("User create token for Site Service with {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void generateSitesToken(String dcn, String firstname, String lastname, String email, String addressone, String buid, String country, String language) {
	
		CreateTokenStepDef.dcn = dcn;
		CreateTokenStepDef.customer_fn = firstname;
		CreateTokenStepDef.customer_ln = lastname;
		CreateTokenStepDef.customer_email = email;
		CreateTokenStepDef.addressone = String.valueOf(ThreadLocalRandom.current().nextInt(999, 99999))+" "+addressone;
		CreateTokenStepDef.buid = buid;
		CreateTokenStepDef.country = country;
		CreateTokenStepDef.language = language;		
		
		token = Tokens.getToken(dcn, buid, country, language);
		
	}
	
	@When("User create token for User-OptinOptout Service with {string}, {string}, {string}, {string} and {string}")
	public void generateUserOptinOptoutToken(String dcn, String useroptinoptout_email, String buid, String country, String language) {
	
		CreateTokenStepDef.dcn = dcn;
		CreateTokenStepDef.useroptinoptout_email = useroptinoptout_email;
		CreateTokenStepDef.buid = buid;
		CreateTokenStepDef.country = country;
		CreateTokenStepDef.language = language;
		
		token = Tokens.getToken(dcn, buid, country, language);
		
	}	
	
	@When("User create token for Notifications Service with {string}, {string}, {string}, {string} and {string}")
	public void generateNotificationsToken(String dcn, String eventtype, String buid, String country, String language) {
	
		CreateTokenStepDef.dcn = dcn;
		CreateTokenStepDef.eventtype = eventtype;
		CreateTokenStepDef.buid = buid;
		CreateTokenStepDef.country = country;
		CreateTokenStepDef.language = language;
		
		token = Tokens.getToken(dcn, buid, country, language);
		
	}
	
	@When("User create token for Preferences Service with {string}, {string}, {string}, {string} and {string}")
	public void generatePreferencesToken(String dcn, String rightIds, String buid, String country, String language) {
	
		CreateTokenStepDef.dcn = dcn;
		CreateTokenStepDef.rightIds = rightIds;
		CreateTokenStepDef.buid = buid;
		CreateTokenStepDef.country = country;
		CreateTokenStepDef.language = language;
		
		token = Tokens.getToken(dcn, buid, country, language);
		
	}

	@Then("Display encrypted token in console and store the below values")
	public void displayToken() {
		
		System.out.println("");
		System.out.println("Below is the required token to proceed further:");
		System.out.println("");
		System.out.println(token);
		System.out.println("");

	}	

}
