package BASELEVEL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Base64Encoder {
	
	public static void main(String[]args) throws IOException {
		//Decode(Encode("C:\\Users\\William Marais\\Downloads\\Rainbow Six Siege - Lion Drone Sound (OLD) (mp3cut.net).mp3"));
		//System.out.println(Encode("C:\\Users\\William Marais\\Downloads\\Rainbow Six Siege - Lion Drone Sound (OLD) (mp3cut.net).mp3"));
	}
	
	public static String Encode(String path) throws IOException {
		File file = new File(path);
		FileInputStream image = new FileInputStream(file);
		byte imagebytes[] = new byte[(int) file.length()];
		image.read(imagebytes);
		String encoded = Base64.getEncoder().encodeToString(imagebytes);
		image.close();
		return encoded;
	}
	
	public static void Decode(String Base64Encoded) {
		
		byte[] imagebytes = Base64.getDecoder().decode(Base64Encoded);
		
		
		JFrame Frame = new JFrame();
		 
		JFileChooser dialog = new JFileChooser();
		dialog.setDialogTitle("Specify a file to save");   
		 
		int input = dialog.showSaveDialog(Frame);
		 
		if (input == JFileChooser.APPROVE_OPTION) {
		    File fileToSave = dialog.getSelectedFile();
		    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
		    try {
				FileOutputStream image = new FileOutputStream(fileToSave.getAbsolutePath());
			try {
				image.write(imagebytes);
				image.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			    } catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	

}
