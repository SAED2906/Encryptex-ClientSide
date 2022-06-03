package BASELEVEL;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
public class Digester {
 
    public static void main(String[] args) {
    	String temp = System.getProperty("user.name") + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_LEVEL") + "";
        System.out.println(hexDigest(temp, "SHA-256"));
        //System.out.println(temp);
    }
    
    public static String getKey() {
    	String temp = System.getProperty("user.name") + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_LEVEL") + "";
    	return hexDigest(temp, "SHA-256");
    }
    
 
    static String hexDigest(String str, String digestName) {
        try {
            MessageDigest md = MessageDigest.getInstance(digestName);
            
            byte[] digest = md.digest(str.getBytes(StandardCharsets.UTF_8));
            char[] hex = new char[digest.length * 2];
            for (int i = 0; i < digest.length; i++) {
                hex[2 * i] = "0123456789abcdef".charAt((digest[i] & 0xf0) >> 4);
                hex[2 * i + 1] = "0123456789abcdef".charAt(digest[i] & 0x0f);
            }
            return new String(hex);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }
}
