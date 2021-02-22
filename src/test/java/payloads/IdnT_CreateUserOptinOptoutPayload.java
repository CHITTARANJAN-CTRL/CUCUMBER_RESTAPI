package payloads;

public class IdnT_CreateUserOptinOptoutPayload {
	
     public static String createUserOptinOptoutV1(String email,String dcn, String prefId) {

    	 return "{\n" + 
    	 		"    \"email\": \""+email+"\",\n" + 
    	 		"    \"dcn\": \""+dcn+"\",\n" + 
    	 		"    \"createdBy\": \"createuseroptinoptout@dell.com\",    \n" + 
    	 		"    \"preferenceIds\": [\n" + 
    	 		"        "+prefId+"\n" + 
    	 		"    ]\n" + 
    	 		"}";   	 
     }
     
     public static String createUserOptinOptoutV2(String email, String prefId) {
    	     	 
    	 return "{\n" + 
     	 		"    \"email\": \""+email+"\",\n" + 
     	 		"    \"createdBy\": \"createuseroptinoptout@dell.com\",    \n" + 
     	 		"    \"preferenceIds\": [\n" + 
     	 		"        "+prefId+"\n" + 
     	 		"    ]\n" + 
     	 		"}"; 
     }
     
}

