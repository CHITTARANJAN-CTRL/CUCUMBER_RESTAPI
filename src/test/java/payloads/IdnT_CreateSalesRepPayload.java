package payloads;

public class IdnT_CreateSalesRepPayload 
{
	public static String createSalesRep(String firstname, String lastname, String fullname, String email,String salerepId)
	{
		
		return "[\r\n" + 
				"    {\r\n" + 
				"        \"firstName\": \""+firstname+"\",\r\n" + 
				"        \"lastName\": \""+lastname+"\",\r\n" + 
				"        \"fullName\": \""+fullname+"\",\r\n" + 
				"        \"email\": \""+email+"\",\r\n" + 
				"        \"phone\": \"7502100\",\r\n" + 
				"        \"salesRepId\": \""+salerepId+"\",\r\n" + 
				"        \"attributes\": {\r\n" + 
				"            \"currentCustomer\": \"123\",\r\n" + 
				"            \"quarterlytarget\": \"25%\"\r\n" + 
				"        },\r\n" + 
				"        \"createdBy\": \"createsalesrep@dell.com\"\r\n" + 
				"    }\r\n" + 
				"]";
	}

}
