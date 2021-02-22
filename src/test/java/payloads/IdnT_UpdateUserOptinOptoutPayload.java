package payloads;

public class IdnT_UpdateUserOptinOptoutPayload  {
	
	 public static String UpdateUserOptinOptoutV1(String email, String dcn, String preferenceId ,String optin) {
    	 
    	 return "{\n" + 
    	 		"    \"email\": \""+email+"\",\n" + 
    	 		"    \"dcn\": \""+dcn+"\",\n" + 
    	 		"    \"updatedBy\": \"updateuseroptinoptout@dell.com\",\n" + 
    	 		"    \"preferences\": [\n" + 
    	 		"        {\n" + 
    	 		"            \"preferenceId\": "+preferenceId+",\n" + 
    	 		"            \"optin\": "+optin+"\n" + 
    	 		"        }\n" + 
    	 		"    ]\n" + 
    	 		"}";
     }
	 
	 public static String UpdateUserOptinOptoutV2(String email, String preferenceId ,String optin) {
    	 
    	 return "{\n" + 
    	 		"    \"email\": \""+email+"\",\n" + 
    	 		"    \"updatedBy\": \"updateuseroptinoptout@dell.com\",\n" + 
    	 		"    \"preferences\": [\n" + 
    	 		"        {\n" + 
    	 		"            \"preferenceId\": "+preferenceId+",\n" + 
    	 		"            \"optin\": "+optin+"\n" + 
    	 		"        }\n" + 
    	 		"    ]\n" + 
    	 		"}";
     }

}
