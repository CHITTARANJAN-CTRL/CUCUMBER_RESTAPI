package payloads;

public class IdnT_CreateSitePayload 
{
	public static String createSiteV1(String buid, String dcn, String fn, String ln, String email, String addresslineone, String country)
	{	
		return "{\n" + 
				"    \"businessUnitId\": \""+buid+"\",\n" + 
				"    \"dcn\": \""+dcn+"\",\n" + 
				"    \"contact\": {\n" + 
				"        \"firstName\": \""+fn+"\",\n" + 
				"        \"lastName\": \""+ln+"\",\n" + 
				"        \"email\": \""+email+"\",\n" + 
				"        \"phone\": {\n" + 
				"            \"number\": \"6322923\",\n" + 
				"            \"countryCode\": \"1\",\n" + 
				"            \"areaCode\": \"614\"\n" + 
				"        },\n" + 
				"        \"primary\": true\n" + 
				"    },\n" + 
				"    \"address\": {\n" + 
				"        \"addressLineOne\": \""+addresslineone+"\",\n" + 
				"        \"addressLineTwo\": \"Line Two\",\n" + 
				"        \"addressLineThree\": \"Line Three\",\n" + 
				"        \"addressLineFour\": \"Line Four\",\n" + 
				"        \"county\": \"Franklin\",\n" + 
				"        \"city\": \"Columbus\",\n" + 
				"        \"countryCode\": \""+country+"\",\n" + 
				"        \"provinceStateCode\": \"OH\",\n" + 
				"        \"zipPostalCode\": \"43016\"\n" + 
				"    }\n" + 
				"}";
	}
	
	public static String createSiteV2US(String fn, String ln, String email, String addresslineone, String country)
	{	
		return "{\n" + 
				"    \"contact\": {\n" + 
				"        \"firstName\": \""+fn+"\",\n" + 
				"        \"lastName\": \""+ln+"\",\n" + 
				"        \"email\": \""+email+"\",\n" + 
				"        \"phone\": {\n" + 
				"            \"number\": \"6322923\",\n" + 
				"            \"countryCode\": \"1\",\n" + 
				"            \"areaCode\": \"614\"\n" + 
				"        },\n" + 
				"        \"primary\": true\n" + 
				"    },\n" + 
				"    \"address\": {\n" + 
				"        \"addressLineOne\": \""+addresslineone+"\",\n" + 
				"        \"addressLineTwo\": \"Line Two\",\n" + 
				"        \"addressLineThree\": \"Line Three\",\n" + 
				"        \"addressLineFour\": \"Line Four\",\n" + 
				"        \"county\": \"Franklin\",\n" + 
				"        \"city\": \"Columbus\",\n" + 
				"        \"countryCode\": \""+country+"\",\n" + 
				"        \"provinceStateCode\": \"OH\",\n" + 
				"        \"zipPostalCode\": \"43016\"\n" + 
				"    }\n" + 
				"}";
	}
	
	public static String createSiteV2GB(String fn, String ln, String email, String addresslineone, String country)
	{	
		return "{\n" + 
				"    \"contact\": {\n" + 
				"        \"firstName\": \""+fn+"\",\n" + 
				"        \"lastName\": \""+ln+"\",\n" + 
				"        \"email\": \""+email+"\",\n" + 
				"        \"phone\": {\n" + 
				"            \"number\": \"6322923\",\n" + 
				"            \"countryCode\": \"44\",\n" + 
				"            \"areaCode\": \"614\"\n" + 
				"        },\n" + 
				"        \"primary\": true\n" + 
				"    },\n" + 
				"    \"address\": {\n" + 
				"        \"addressLineOne\": \""+addresslineone+"\",\n" + 
				"        \"addressLineTwo\": \"Line Two\",\n" + 
				"        \"addressLineThree\": \"Line Three\",\n" + 
				"        \"addressLineFour\": \"Line Four\",\n" + 
				"        \"city\": \"Edigburgh\",\n" + 
				"        \"countryCode\": \""+country+"\",\n" + 
				"        \"provinceStateCountyCode\": \"UK-JJ\",\n" + 
				"        \"zipPostalCode\": \"EH125JL\"\n" + 
				"    }\n" + 
				"}";
	}
	
	public static String createSiteV2FR(String fn, String ln, String email, String addresslineone, String country)
	{	
		return "{\n" + 
				"    \"contact\": {\n" + 
				"        \"firstName\": \""+fn+"\",\n" + 
				"        \"lastName\": \""+ln+"\",\n" + 
				"        \"email\": \""+email+"\",\n" + 
				"        \"phone\": {\n" + 
				"            \"number\": \"6322923\",\n" + 
				"            \"countryCode\": \"33\",\n" + 
				"            \"areaCode\": \"614\"\n" + 
				"        },\n" + 
				"        \"primary\": true\n" + 
				"    },\n" + 
				"    \"address\": {\n" + 
				"        \"addressLineOne\": \""+addresslineone+"\",\n" + 
				"        \"addressLineTwo\": \"Line Two\",\n" + 
				"        \"addressLineThree\": \"Line Three\",\n" + 
				"        \"addressLineFour\": \"Line Four\",\n" +
				"        \"city\": \"Paris\",\n" + 
				"        \"countryCode\": \""+country+"\",\n" + 
				"        \"provinceStateCountyCode\": \"FR-75\",\n" + 
				"        \"zipPostalCode\": \"75011\"\n" + 
				"    }\n" + 
				"}";
	}
	
	public static String createSiteV2DE(String fn, String ln, String email, String addresslineone, String country)
	{	
		return "{\r\n" + 
				"    \"contact\": {\r\n" + 
				"        \"firstName\": \""+fn+"\",\r\n" + 
				"        \"lastName\": \""+ln+"\",\r\n" + 
				"        \"email\": \""+email+"\",\r\n" + 
				"        \"phone\": {\r\n" + 
				"            \"number\": \"6322923\",\r\n" + 
				"            \"countryCode\": \"33\",\r\n" + 
				"            \"areaCode\": \"614\"\r\n" + 
				"        },\r\n" + 
				"        \"primary\": true\r\n" + 
				"    },\r\n" + 
				"    \"address\": {\r\n" + 
				"        \"addressLineOne\": \""+addresslineone+"\",\r\n" + 
				"        \"addressLineTwo\": \"Line Two\",\r\n" + 
				"        \"addressLineThree\": \"Line Three\",\r\n" + 
				"        \"addressLineFour\": \"Line Four\",\r\n" + 
				"        \"city\": \"Paris\",\r\n" + 
				"        \"countryCode\": \"FR\",\r\n" + 
				"        \"provinceStateCountyCode\": \"FR-75\",\r\n" + 
				"        \"zipPostalCode\": \"75011\"\r\n" + 
				"    }\r\n" + 
				"}";
	}
	
	public static String createSiteV2AU(String fn, String ln, String email, String addresslineone, String country)
	{	
		return "{\r\n" + 
				"    \"contact\": {\r\n" + 
				"        \"firstName\": \""+fn+"\",\r\n" + 
				"        \"lastName\": \""+ln+"\",\r\n" + 
				"        \"email\": \""+email+"\",\r\n" + 
				"        \"phone\": {\r\n" + 
				"            \"number\": \"6322923\",\r\n" + 
				"            \"countryCode\": \"33\",\r\n" + 
				"            \"areaCode\": \"614\"\r\n" + 
				"        },\r\n" + 
				"        \"primary\": true\r\n" + 
				"    },\r\n" + 
				"    \"address\": {\r\n" + 
				"        \"addressLineOne\": \""+addresslineone+"\",\r\n" + 
				"        \"addressLineTwo\": \"Line Two\",\r\n" + 
				"        \"addressLineThree\": \"Line Three\",\r\n" + 
				"        \"addressLineFour\": \"Line Four\",\r\n" + 
				"        \"city\": \"Paris\",\r\n" + 
				"        \"countryCode\": \"AU\",\r\n" + 
				"        \"provinceStateCountyCode\": \"FR-75\",\r\n" + 
				"        \"zipPostalCode\": \"75011\"\r\n" + 
				"    }\r\n" + 
				"}";
	}


}
