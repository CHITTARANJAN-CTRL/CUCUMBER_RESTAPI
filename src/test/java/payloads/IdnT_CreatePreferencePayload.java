package payloads;

public class IdnT_CreatePreferencePayload {

	public static String createPreference(String rightids)
	{
		return  "{\r\n" + 
				"  \"rightIds\": [\r\n" + 
				"    \""+rightids+"\" \r\n" + 
				"  ],\r\n" + 
				"  \"name\": \"PurchaseApproved\",\r\n" + 
				"  \"description\": \"Testing of the order\",\r\n" + 
				"  \"preferenceType\": \"email\",\r\n" + 
				"  \"active\": true\r\n" + 
				"}";
	}

}