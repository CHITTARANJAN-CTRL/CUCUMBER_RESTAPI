package payloads;

public class IdnT_CreateCustomerPayload 
{
	public static String createCustomerV1(String dcn, String customersalesrepemail) 
	{

		return "{\n" + 
				"    \"dcn\": \""+dcn+"\",\n" + 
				"    \"name\": \"Boeing\",\n" + 
				"    \"discount\": \"10\",\n" + 
				"    \"createdBy\": \"createcustomer@dell.com\",\n" + 
				"    \"salesReps\": [\n" + 
				"        {\n" + 
				"            \"email\": \""+customersalesrepemail+"\",\n" + 
				"            \"isPrimary\": true\n" + 
				"        }\n" + 
				"    ]\n" + 
				"}";
		
	}
	
	public static String createCustomerV2(String dcn, String customersalesrepemail, String buid, String country) 
	{
		
		return "{\r\n" + 
				"    \"dcn\": \""+dcn+"\",\r\n" + 
				"    \"name\": \"Boeing\",\r\n" + 
				"    \"discount\": \"5\",\r\n" + 
				"    \"createdBy\": \"createcustomer@dell.com\",\r\n" + 
				"    \"salesReps\": [\r\n" + 
				"        {\r\n" + 
				"            \"email\": \""+customersalesrepemail+"\",\r\n" + 
				"            \"isPrimary\": true\r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"buId\": \""+buid+"\",\r\n" + 
				"    \"country\": \""+country+"\"\r\n" + 
				"}";
		
	}

}
