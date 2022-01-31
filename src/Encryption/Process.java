package Encryption;

import javax.swing.JOptionPane;

import BASELEVEL.XOREncryption;
import Management.HandlerKeys;

public class Process {
	
	private static String[] temp, temp2, tempx;
	private static String roundkey;
	
	public static void Start(String[] arrlvl1) {
		temp = new String[arrlvl1.length];
		temp2 = new String[arrlvl1.length];
		roundkey = HandlerKeys.generateRoundKey(arrlvl1.length);
			
		for (int x = 0; x < 12; x++) {
			//Row Shifting
		
			for (int i = 0; i < arrlvl1.length; i++) {
				if (i%4==0) {
					temp[i] = arrlvl1[i];
				}
				if (i%4==1) {
					String t = arrlvl1[i].charAt(3) + "";
					String t2 = arrlvl1[i].charAt(0) + "" + arrlvl1[i].charAt(1) + "" + arrlvl1[i].charAt(2) + "";
					temp[i] = t + t2;			
				}
				if (i%4==2) {
					String t = arrlvl1[i].charAt(2) + "" + arrlvl1[i].charAt(3) + "";
					String t2 = arrlvl1[i].charAt(0) + "" + arrlvl1[i].charAt(1) + "";
					temp[i] = t + t2;
				}
				if (i%4==3) {
					String t = arrlvl1[i].charAt(1) + "" + arrlvl1[i].charAt(2) + "" + arrlvl1[i].charAt(3) + "";
					String t2 = arrlvl1[i].charAt(0) + "";
					temp[i] = t + t2;
				}
			}
			
			//Round Key Addition
			
			for (int i = 0; i < arrlvl1.length; i++) {
				temp[i] = XOREncryption.encryptDecrypt(temp[i], roundkey.charAt(i));
			}
		
		}
		
	}
	
	public static void Reverse(String[] tempy) {
		roundkey = HandlerKeys.generateRoundKey(tempy.length);
		tempx = new String[tempy.length];
		temp2 = new String[tempy.length];
		tempx = tempy;
		String xx = "";
		for (int i = 0; i < tempy.length; i++) {
			xx += tempy[i];
		}
		
		//---------
		for (int x = 0; x < 12; x++) {
				/// Undo XOR
				
				for (int i = 0; i < tempy.length; i++) {
					tempx[i] = XOREncryption.encryptDecrypt(tempx[i], roundkey.charAt(i));
				}
				for (int i = 0; i < tempx.length; i++) {
					if (i%4==0) {
						tempx[i] = tempx[i];
					}
					if (i%4==1) {
						String t = tempx[i].charAt(1) + "" + tempx[i].charAt(2) + "" + tempx[i].charAt(3) + "";
						String t2 = tempx[i].charAt(0) + "";
						tempx[i] = t + t2;		
					}
					if (i%4==2) {
						String t = tempx[i].charAt(2) + "" + tempx[i].charAt(3) + "";
						String t2 = tempx[i].charAt(0) + "" + tempx[i].charAt(1) + "";
						tempx[i] = t + t2;
					}
					if (i%4==3) {
						String t = tempx[i].charAt(3) + "";
						String t2 = tempx[i].charAt(0) + "" + tempx[i].charAt(1) + "" + tempx[i].charAt(2) + "";
						tempx[i] = t + t2;	
					}
				}
				
				
				
				
				
		}

		for (int i = 0; i < tempy.length; i++) {

			tempx[i] = XOREncryption.encryptDecrypt(tempx[i], roundkey.charAt(i));
			
		}
		
		for (int i = 0; i < tempx.length; i++) {
			if (i%4==0) {
				tempx[i] = tempx[i];
			}
			if (i%4==1) {
				String t = tempx[i].charAt(1) + "" + tempx[i].charAt(2) + "" + tempx[i].charAt(3) + "";
				String t2 = tempx[i].charAt(0) + "";
				tempx[i] = t + t2;		
			}
			if (i%4==2) {
				String t = tempx[i].charAt(2) + "" + tempx[i].charAt(3) + "";
				String t2 = tempx[i].charAt(0) + "" + tempx[i].charAt(1) + "";
				tempx[i] = t + t2;
			}
			if (i%4==3) {
				String t = tempx[i].charAt(3) + "";
				String t2 = tempx[i].charAt(0) + "" + tempx[i].charAt(1) + "" + tempx[i].charAt(2) + "";
				tempx[i] = t + t2;	
				System.out.println("|"+t+t2+"|" + i);
			}
		}
		
		
		
		
		
		for (int i = 0; i < tempx.length; i++) {
			System.out.print(tempx[i]);
		}
		
		temp = tempx;
		
	}
	
	
	public static String[] getUpdatedArr() {
		return temp;
		
	}
	
	public static String getUpdatedArrString() {
		String t = "";
		for (int i = 0; i < temp.length; i++) {
			
			t = t + temp[i];
		}
		
		for (int i = 0; i < t.length()-1; i++) {
			if (t.charAt(i) == ' ') {
				t = t.substring(0, i);
				i = t.length();
			}
		}
		
		return t;
	}
	
	public static void setArr(String str) {
		int left = str.length()-(((int) str.length()/4)*4);
		String tempstr = str;
		for (int i = 0; i < left-1; i++) {
			tempstr += " ";
		}
		temp = new String[tempstr.length()/4];
		int count=0;
		for (int i = 0; i < tempstr.length()-1; i++) {
			if (i%4==0) {
			temp[count] = tempstr.substring(i, i+4);
			count++;
			}
		}	
	}
}
