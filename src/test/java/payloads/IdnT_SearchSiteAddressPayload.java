package payloads;

public class IdnT_SearchSiteAddressPayload 
{
	public static String searchSiteAddressV1(String Addr1, String city, String state, String country)
	{
		return "{\r\n" + 
				"    \"addressLineOne\": \""+Addr1+"\",\r\n" + 
				"    \"city\": \""+city+"\",\r\n" + 
				"    \"state\": \""+state+"\",\r\n" + 
				"    \"country\": \""+country+"\",\r\n" + 
				"    \"sitetype\": \"ShippingAddress\"\r\n" + 
				"}";
	}
	
	public static String searchSiteAddressV2(String Addr1, String city, String state, String country)
	{
		return "{\r\n" + 
				"    \"addressLineOne\": \""+Addr1+"\",\r\n" + 
				"    \"city\": \""+city+"\",\r\n" + 
				"    \"state\": \""+state+"\",\r\n" + 
				"    \"country\": \""+country+"\",\r\n" + 
				"    \"sitetype\": \"ShippingAddress\"\r\n" + 
				"}";
	}

}
