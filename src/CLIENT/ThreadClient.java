/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLIENT;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ProgressMonitor;
import javax.swing.ProgressMonitorInputStream;
import javax.swing.border.EmptyBorder;

import BASELEVEL.Digester;
import BASELEVEL.toHexDump;
import Encryption.Test;
import GUI.MainGui;
import Statistics.Time;

/**
 *
 * @author William Marais
 */
public class ThreadClient{
	
	public static String host_Final = "'";
	
	
	
	
	public static void isAlive(String UUID) throws UnknownHostException {
		//Allows Server to determine which users (UID) are online at a given moment by sending isAlive notifications to server, if one is not sent in a given time, the server presumes the clientThread is Dead
		
		String HOST = InetAddress.getLocalHost().getHostAddress();
        final int PORT = 25565;
        
        
        //System.out.println("Client started.");
        
        try (
            Socket socket = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner in = new Scanner(socket.getInputStream());
            Scanner s = new Scanner("Alive,"+UUID);
        		
        		
        ) {
        	//Send key for encryption
                //System.out.print("Input: ");
                String input = s.nextLine();
                out.println(input);
                
                //if (input.equalsIgnoreCase("exit")) ;//break;
                //System.out.println("Echoed from server: " + in.nextLine());
            //Receive Key
                
                //Use Key


            //}
        } catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public static String getHash(String Destination_UID, String Home_UID) throws UnknownHostException, IOException {//uses user ID and home user ID to get Shared Hash on server
		String HOST = InetAddress.getLocalHost().getHostAddress();
        final int PORT = 25565;
        
        
        //System.out.println("Client started.");
        
        try (
            Socket socket = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner in = new Scanner(socket.getInputStream());
            Scanner s = new Scanner("gH," + Destination_UID + "," + Home_UID);
        		
        		
        ) {
        	//Send key for encryption
                //System.out.print("Input: ");
                String input = s.nextLine();
                out.println(input);
                
                //if (input.equalsIgnoreCase("exit")) ;//break;
                //System.out.println("Echoed from server: " + in.nextLine());
            //Receive Key
                
                //Use Key
                
                
                return in.nextLine();

            //}
        }
	}
	
	public static String getOnline() throws UnknownHostException, IOException {//uses user ID and home user ID to get Shared Hash on server
		String HOST = InetAddress.getLocalHost().getHostAddress();
        final int PORT = 25565;
        
        
        //System.out.println("Client started.");
        
        try (
            Socket socket = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner in = new Scanner(socket.getInputStream());
            Scanner s = new Scanner("Active,");
        		
        		
        ) {
        	//Send key for encryption
                //System.out.print("Input: ");
                String input = s.nextLine();
                out.println(input);
                
                //if (input.equalsIgnoreCase("exit")) ;//break;
                //System.out.println("Echoed from server: " + in.nextLine());
            //Receive Key
                
                //Use Key
                String temp = in.nextLine();
                String temp2 = "";
                //System.out.println(temp);
                
                Scanner sc = new Scanner(temp).useDelimiter(",");
                while (sc.hasNext()) {
                	temp2 += sc.next() + "\n";
                }
                
                return temp2;

            //}
        }
	}
	
	public static void Kill(String UUID) throws UnknownHostException, IOException {//uses user ID and home user ID to get Shared Hash on server
		String HOST = InetAddress.getLocalHost().getHostAddress();
        final int PORT = 25565;
        
        
        //System.out.println("Client started.");
        
        try (
            Socket socket = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner in = new Scanner(socket.getInputStream());
            Scanner s = new Scanner("Terminate," + UUID);
        		
        		
        ) {
        	//Send key for encryption
                //System.out.print("Input: ");
                String input = s.nextLine();
                out.println(input);
                
                //if (input.equalsIgnoreCase("exit")) ;//break;
                //System.out.println("Echoed from server: " + in.nextLine());
            //Receive Key
                
                //Use Key
                
            

            //}
        }
	}
	
	public static String receiveFile(String Home, String Dest) throws UnknownHostException, IOException {
		String HOST = InetAddress.getLocalHost().getHostAddress();
        final int PORT = 25565;
        String text = "";
        int count = 0;
        
        System.out.println("Client started.");
        boolean received = false;
        
        while (!received) {
        
        try (
            Socket socket = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner in = new Scanner(socket.getInputStream());
            //Scanner s = new Scanner("RF," + Home + "," + Dest + "," + count);
        		
        		
        ) {
        	//Send key for encryption
                String input = "RF," + Home + "," + Dest + "," + count;
                out.println(input);
                
//                if (input.equalsIgnoreCase("exit")) ;//break;
//                System.out.println("Echoed from server: " + in.nextLine());
                String temp = in.nextLine();
                //System.out.println(temp.substring(0, 4));
                if (temp.substring(0, 4).contains("DONE")){
                	received = true;
                	
                	text += temp.substring(4);
                	//System.out.println("Test--------");
                	break;
                }else {
                	text += temp;
                	count++;
                }
                
                
            //Receive Key
                
                //Use Key
                
                
                

            //}
        }
        
        
        
        }
        
        return text;
        
        
	}
	
	public static void sendFile(byte[] file, String dest, String from) throws UnknownHostException, InterruptedException{
		String HOST = InetAddress.getLocalHost().getHostAddress();
        final int PORT = 25565;
        System.out.println("Need to scan File");
        
        System.out.println("Client started.");
        String hex = toHexDump.BytesToHex(file);
    	int length = (int) (hex.length()/60000);
    	//JOptionPane.showMessageDialog(null, length);
        
        try (
            Socket socket = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner in = new Scanner(socket.getInputStream());
            Scanner s = new Scanner("SF," + dest + "," + from);
        	//DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        		
        		
        ) {
        	//dataOutputStream.write(file);
        	
        	
        	String input = s.nextLine();
        	out.println(input);
        	
        	FileSender.start(hex);
        	MainGui.appendText(Time.getTimeHMS() + ": File Transfer Successful " + "\n" + Time.getTimeHMS() + ": File Name: " + dest + "," + from);
        	//System.out.println("Echoed from server: " + in.nextLine());
        	
//        	out.println(s.nextLine());
//        	
//        	JOptionPane.showMessageDialog(null, "1");
//        	//+"\n" + Test.bytesToHex(file)
//        	socket.getOutputStream().flush();
//        	//System.out.println("Echoed from server: " + in.nextLine());
//        	
//        	
//        	for (int i = 0; i < length; i++) {
//        		if (i != length-1) {
//        		out.println(hex.substring((i)*60000, (i+1)*60000));
//        		in.nextLine();
//        		
//        		}else {
//        			out.println(hex.substring((i)*60000, hex.length()));
//            		in.nextLine();
//            		//in.wait();
//        		}
//        	}
        	
        	
        	
        	
        	
        	//socket.getOutputStream().write(file);
        	
//        	int blocks16 = ((int) File.length()/16)*16;
//    		//System.out.println(blocks16);
//    		int leftover = File.length() - blocks16;
//    		System.out.println(leftover);
//    		System.out.println("b");
//    		if (leftover != 0) {
//    		for (int i = 0; i < (16 - leftover); i++) {
//    			File = File + " ";
//    		}
//    		}
//        	
//        	for (int i = 1; i < File.length()+1; i++) {
//        		if (i%16 == 0) {
//    				out.println("SF," + File.substring(i-16, i));
//    				}
//        		System.out.println(File.length()+1-i);
//        	}
//        	
//        	
//        	JOptionPane.showMessageDialog(null, File);
//        	System.out.println("Scanned File");
//        	
        	
        	
        	
        	
        	
        	//Send key for encryption
               // System.out.print("Input: ");
                 
                //JOptionPane.showMessageDialog(null, input);
                 
                
                
                //if (input.equalsIgnoreCase("exit")) ;//break;
                //
            //Receive Key
                
                //Use Key
                //int length = File.length()/1000;
                //for (int i = 0; i < length; i++) {
                //	
                //}
                
                
                
                
                
                
                
                
                
                
                
                
                
                

            //}
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean Login(String Username, String Password, String ip) throws UnknownHostException, IOException {
		boolean status = false;
		host_Final = ip;
		String HOST = host_Final;
        final int PORT = 25565;
        
        
        System.out.println("Client started.");
        
        try (
        		
            Socket socket = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner in = new Scanner(socket.getInputStream());
            Scanner s = new Scanner("Login,"+Username+","+Password);
        		
        		
        ) {
        	
        	//Send key for encryption
                System.out.print("Attempting Login");
                String input = s.nextLine();
                out.println(input);
                //System.out.println("A");
                if (input.equalsIgnoreCase("exit")) ;//break;
                String fromServer = in.nextLine();
                if (!fromServer.isEmpty()) {
                	
                	MainGui gui = new MainGui();
                	gui.frmEncyptex.setVisible(true);
                	//GUI.Login.FRMDispose();
                	gui.textMyHash.setText(Digester.getKey());
                	gui.textmyUUID.setText(fromServer);
                	//GUI.Register.frame.dispose();
                	status = true;
                }
                
                System.out.println(": " + fromServer);
            //Receive Key
                
                //Use Key
                
                
                return status;

            //}
        }
	}
	
	public static void Register(String Username, String Password, String HashKey, String ip) throws UnknownHostException, IOException {
		host_Final = ip;
		String HOST = host_Final;
        final int PORT = 25565;
        
        
        System.out.println("Client started.");
        
        try (
            Socket socket = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner in = new Scanner(socket.getInputStream());
            Scanner s = new Scanner("Register,"+Username+","+Password+","+HashKey);
        		
        		
        ) {
        	
                String input = s.nextLine();
                out.println(input);
                
                if (input.equalsIgnoreCase("exit")) ;//break;
                
                
                //From Server
                String output = in.nextLine();
                if (output.equalsIgnoreCase("true")) {
                	GUI.Register.lblValidate.setForeground(Color.GREEN);
                	GUI.Register.lblValidate.setText("Registered");
                }
                if (output.equalsIgnoreCase("false")) {
                	GUI.Register.lblValidate.setForeground(Color.RED);
                    GUI.Register.lblValidate.setText("Failed Registration");
                   }
                
                System.out.println("Echoed from server: " + output);
          
                
        
                //
                
                

            //}
        }
	}
	
	
    
    
 
}
