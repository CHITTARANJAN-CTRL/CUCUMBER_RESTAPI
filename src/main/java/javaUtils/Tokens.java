package javaUtils;

import java.util.Base64;

public class Tokens {
	
	public static String getToken(String dcn, String buid, String country, String language) {
		
		String token = "{\r\n" + 
				"	\"scope\": [],\r\n" + 
				"	\"client_id\": \"DTCCP1002212TEST\",\r\n" + 
				"	\"iss\": \"https://pf-huat.us.dell.com\",\r\n" + 
				"	\"sub\": \"DTCPTESTTEAM@DELL.COM\",\r\n" + 
				"	\"affinityid\": \"2724084667\",\r\n" + 
				"	\"bu\": \""+buid+"\",\r\n" + 
				"	\"givenName\": \"VamseeKrishna\",\r\n" + 
				"	\"usertype\": \"customer\",\r\n" + 
				"	\"sn\": \"Tirupati\",\r\n" + 
				"	\"email\": \"Vamsee_Krishna_Tirup@Dellteam.com\",\r\n" + 
				"	\"exp\": 1590132263,\r\n" + 
				"	\"dcn\": \""+dcn+"\",\r\n" + 
				"	\"language\": \""+language+"\",\r\n" + 
				"	\"country\": \""+country+"\"\r\n" + 
				"}";
		
		token = Base64.getEncoder().encodeToString(token.getBytes());
		
		return token;
	}

}
