package payloads;

public class IdnT_UpdateSalesRepPayload 
{
	public static String updateSalesRep(String firstname, String lastname, String fullname)
	{

		return "{\r\n" + 
				"    \"firstName\": \""+firstname+"\",\r\n" + 
				"    \"lastName\": \""+lastname+"\",\r\n" + 
				"    \"fullName\": \""+fullname+"\",\r\n" + 
				"    \"phone\": \"7502195\",\r\n" + 
				"    \"attributes\": {\r\n" + 
				"        \"currentCustomer\": \"12345\",\r\n" + 
				"        \"quarterlytarget\": \"50%\"\r\n" + 
				"    },\r\n" + 
				"    \"updatedBy\": \"updatesalesrep@dell.com\"\r\n" + 
				"}";
		
	}

}