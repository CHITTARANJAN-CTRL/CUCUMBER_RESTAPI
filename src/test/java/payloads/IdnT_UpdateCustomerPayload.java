package payloads;

public class IdnT_UpdateCustomerPayload {
	
	public static String updateCustomerV1(String name, String discount, String customersalesrep) {
		
		return "{\n" + 
				"    \"name\": \""+name+"\",\n" + 
				"    \"discount\": \""+discount+"\",\n" + 
				"    \"updatedBy\": \"updatecustomer@dell.com\",\n" + 
				"    \"salesReps\": [\n" + 
				"        {\n" + 
				"            \"email\": \""+customersalesrep+"\",\n" + 
				"            \"isPrimary\": true\n" + 
				"        }\n" + 
				"    ]\n" + 
				"}";
		
	}
	
	public static String updateCustomerV2(String name, String discount, String customersalesrep, String country) {
		
		return "{\r\n" + 
				"    \"name\": \""+name+"\",\r\n" + 
				"    \"discount\": \""+discount+"\",\r\n" + 
				"    \"updatedBy\": \"updatecustomer@dell.com\",\r\n" + 
				"    \"salesReps\": [\r\n" + 
				"        {\r\n" + 
				"            \"email\": \""+customersalesrep+"\",\r\n" + 
				"            \"isPrimary\": true\r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"country\": \""+country+"\"\r\n" + 
				"}";
		
	}

}
