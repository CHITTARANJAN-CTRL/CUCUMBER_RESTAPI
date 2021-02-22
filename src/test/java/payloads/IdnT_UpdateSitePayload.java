package payloads;

public class IdnT_UpdateSitePayload 
{
	
	public static String updateSiteV1(String contactId, String phoneContactId, String emailContactId, String dcn, String buid, String siteId, String fname, String lname, String email) {
		
		return "{\r\n" + 
				"  \"businessUnitId\": \""+buid+"\",\r\n" + 
				"  \"dcn\": \""+dcn+"\",\r\n" + 
				"  \"contact\": {\r\n" + 
				"   \"contactId\": \""+contactId+"\",\r\n" + 
				"   \"firstName\": \""+fname+"\",\r\n" + 
				"    \"lastName\": \""+lname+"\",  \r\n" + 
				"    \"email\": {\r\n" + 
				"      \"value\": \""+email+"\",\r\n" + 
				"      \"contactMethodId\": \""+emailContactId+"\"\r\n" + 
				"    },\r\n" + 
				"    \"phone\": {\r\n" + 
				"      \"number\": \"7502100\",\r\n" + 
				"      \"countryCode\": \"1\",     \r\n" + 
				"      \"areaCode\": \"309\",\r\n" + 
				"      \"contactMethodId\": \""+phoneContactId+"\",\r\n" + 
				"\"phoneType\": \"WorkPhone\"\r\n" + 
				"    }\r\n" + 
				"  },\r\n" + 
				"  \"siteId\": \""+siteId+"\"\r\n" + 
				"}";
	}
	
	public static String updateSiteV2(String contactId, String phoneContactId, String emailContactId, String siteId, String fname, String lname, String email) {
		
		return "{\r\n" + 
				"\"contact\": {\r\n" + 
				"\"contactId\": \""+contactId+"\",\r\n" + 
				"\"firstName\": \""+fname+"\",\r\n" + 
				"\"lastName\": \""+lname+"\",\r\n" + 
				"\"email\": {\r\n" + 
				"\"value\": \""+email+"\",\r\n" + 
				"\"contactMethodId\": \""+emailContactId+"\"\r\n" + 
				"},\r\n" + 
				"\"phone\": {\r\n" + 
				"\"number\": \"8679334\",\r\n" + 
				"\"countryCode\": \"1\",\r\n" + 
				"\"areaCode\": \"636\",\r\n" + 
				"\"contactMethodId\": \""+phoneContactId+"\",\r\n" + 
				"\"phoneType\": \"WorkPhone\"\r\n" + 
				"}\r\n" + 
				"},\r\n" + 
				"\"siteId\": \""+siteId+"\"\r\n" + 
				"}";
	}

}
