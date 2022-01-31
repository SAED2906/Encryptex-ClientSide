package BASELEVEL;

public class XOREncryption {
	
	

	public static String encryptDecrypt(String inputString, char key) 
    { 
        
        char xorKey = key; 
        
  
        String output = ""; 
  
        int len = inputString.length(); 
  
        for (int i = 0; i < len; i++)  
        { 
            output = output + Character.toString((char) (inputString.charAt(i) ^ xorKey)); 
        } 
  
        //System.out.println(output); 
        return output; 
    } 
  
 
} 