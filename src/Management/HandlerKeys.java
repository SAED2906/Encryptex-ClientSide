package Management;

import BASELEVEL.Digester;

public class HandlerKeys {
	
	private static String SharedKey = Digester.getKey();
	
	public static void setSharedKey(String sharedKey) {
		SharedKey = sharedKey;
	}

	public static String generateRoundKey(int length){
			String tempkey = "";
			int amount = length/64;
			
		for (int i = 0; i < amount; i++) {
				tempkey = tempkey + SharedKey;
		}
		
			tempkey = tempkey + SharedKey.substring(0, length%64);
		
		
		return tempkey;
	}
}
