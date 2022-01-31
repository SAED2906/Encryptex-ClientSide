package DATA;


import Encryption.Encryptor;

public class BlockDiv extends Encryptor{
	
	public static String[] Main = new String[0];
	public static String[] arrlvl1 = new String[0];
	
	static int count = 0;
		public static void init() {
			
			Main = new String[Encryptor.getE().length()/16+1];
			arrlvl1 = new String[(Encryptor.getE().length()/16)*4];
			
		}
			
		
		public static void BlockDiv(final String input) {
			Main[count] = input;
			count++;
			
		}
		
		public static void Populate() {
			int countx = 0;
			System.out.println("da");
			for (int j = 0; j < Main.length-1; j++) {
			
				System.out.println("d + "  + j);
				arrlvl1[countx] = Main[j].substring(0, 4);
				countx++;
				arrlvl1[countx] = Main[j].substring(4, 8);
				countx++;
				arrlvl1[countx] = Main[j].substring(8, 12);
				countx++;
				arrlvl1[countx] = Main[j].substring(12, 16);
				countx++;
			}
		}
		
		public static String getarrlvl1(int pos) {
			return arrlvl1[pos];
		}
		
		
		
		
		
}
