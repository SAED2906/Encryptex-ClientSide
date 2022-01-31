package Encryption;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

import BASELEVEL.*;
import DATA.BlockDiv;
import Management.HandlerKeys;

public class Encryptor {
	
	static int arrSize = 0;
	protected static String Encoded;
	
	public static String getE() {
		return Encoded;
	}
	
	public static byte[] Encrypt(String Path, String Hash) throws IOException, NoSuchAlgorithmException {
		Encoded = Base64Encoder.Encode(Path);
		HandlerKeys.setSharedKey(Hash);
		System.out.println(Encoded);
		
		BlockDiv.init();
		
		int blocks16 = ((int) Encoded.length()/16)*16;
		
		int leftover = Encoded.length() - blocks16;

		if (leftover != 0) {
		for (int i = 0; i < (16 - leftover); i++) {
			Encoded = Encoded + " ";
		}
		
		}
		
		
		BlockDiv Block = new BlockDiv();
		
			for (int i = 1; i < Encoded.length()+1; i++) {
				if (i%16 == 0) {
				Block.BlockDiv(Encoded.substring(i-16, i));
				arrSize++;
				}
			}
		Block.Populate();
		
		for (int i = 0; i < Block.arrlvl1.length; i++) {
			System.out.print(Block.arrlvl1[i]);
			
		}

		Process.Start(Block.arrlvl1);

		String[] st = Process.getUpdatedArr();
		String temp = "";
		for (int i = 0; i < Process.getUpdatedArr().length; i++) {
			temp += st[i];
		}

		byte[] byteArray;
		byteArray = temp.getBytes();

		return byteArray;
	}
	
	public static void Decrypt(byte[] bs, String hash) {
		String str = new String(bs);
		HandlerKeys.setSharedKey(hash);
		Process.setArr(str);
		Process.Reverse(Process.getUpdatedArr());
		Base64Encoder.Decode(Process.getUpdatedArrString());
	}
	
	

}
