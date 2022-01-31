package GUI;

import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.DefaultCaret;

import BASELEVEL.toHexDump;
import CLIENT.ThreadClient;
import Encryption.Encryptor;
import Statistics.Time;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Panel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import java.awt.Scrollbar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class MainGui {

	public static JFrame frmEncyptex;
	static Panel panel_3 = new Panel();
	static Icon icon;
	static JLabel lblForIcon = new JLabel("");
	public static JTextField txtPath = new JTextField();;
	public static JTextField textMyHash;
	public static JTextArea txtConsole = new JTextArea();
	public static JTextField textmyUUID = new JTextField();
	public static JTextArea txtOnline;
	public static JLabel lblTimer;
	private JTextField txtDestination;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui window = new MainGui();
					window.frmEncyptex.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEncyptex = new JFrame();
		frmEncyptex.setTitle("Encyptex");
		frmEncyptex.setFont(new Font("Dialog", Font.PLAIN, 20));
		frmEncyptex.setForeground(Color.BLACK);
		frmEncyptex.setBackground(Color.BLACK);
		frmEncyptex.setType(Type.UTILITY);
		frmEncyptex.setBounds(100, 100, 825, 600);
		frmEncyptex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEncyptex.getContentPane().setLayout(null);
		frmEncyptex.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		    	try {
					Shutdown(textmyUUID.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	
		        System.out.println("Terminated");
		    }
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 808, 561);
		panel.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), null));
		frmEncyptex.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 402, 561);
		panel.add(panel_1);
		panel_1.setLayout(null);
		txtPath.setBounds(10, 194, 382, 20);
		
		//txtPath = new JTextField();
		txtPath.setEditable(false);
		txtPath.setForeground(Color.GREEN);
		txtPath.setHorizontalAlignment(SwingConstants.LEFT);
		txtPath.setText("Path");
		txtPath.setBackground(Color.BLACK);
		panel_1.add(txtPath);
		txtPath.setColumns(10);
		
		
		
		TextField Path = new TextField();
		Path.setBounds(204, 10, 188, 22);
		Path.setEditable(false);
		Path.setForeground(Color.GREEN);
		Path.setFont(new Font("Dialog", Font.PLAIN, 10));
		Path.setBackground(Color.BLACK);
		panel_1.add(Path);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 330, 382, 220);
		panel_1.add(scrollPane);
		
		
		txtConsole.setWrapStyleWord(true);
		txtConsole.setToolTipText("Console: Displays Status");
		txtConsole.setRows(8);
		txtConsole.setLineWrap(true);
		txtConsole.setForeground(Color.GREEN);
		txtConsole.setEditable(false);
		txtConsole.setColumns(1);
		txtConsole.setBackground(Color.BLACK);
		scrollPane.setViewportView(txtConsole);
		
		
		Button button = new Button("File Select");
		button.setBounds(10, 230, 85, 22);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
			    dialog.setMode(FileDialog.LOAD);
			    dialog.setVisible(true);
			    String file = dialog.getFile();
			    System.out.print(dialog.getFile());
			    
			    File file2 = new File((dialog.getFile()));
			    dialog.getIconImages();
			    Path.setText(file);

			    JFileChooser chooser = new JFileChooser();
			    String p1 = "";
			    try {
					for (int i = 0; i < file2.getCanonicalPath().length(); i++) {
						if (file2.getCanonicalPath().charAt(i) == '\\'){
							
							p1 = p1 + '\\';
							
						}else {
							p1 = p1 + file2.getCanonicalPath().charAt(i);
						}
						
						
								
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    System.out.println(p1);
			    System.out.println(file2.getAbsolutePath());
			    try {
					System.out.println(file2.getCanonicalPath());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    //
			    
			    //BUSY RN---------------------------------++++++++++++++++++++++++++++++++++++++++++++------------------------------------------------+++++++++++++++++++++++++++++++++++++++++++++++
			    
			    //
				File file3;
				file3 = new File(dialog.getDirectory() + dialog.getFile());
				//System.out.println(dialog.getDirectory() + dialog.getFile());
				setPath(dialog.getDirectory() + dialog.getFile());
				
				appendText(Time.getTimeHMS() + ": File Select success.\n"+ Time.getTimeHMS() +": File Selected: "+ dialog.getFile()+ "\n" + Time.getTimeHMS() +": File Parent folder: " + dialog.getDirectory());

   
   Icon icon2 = chooser.getFileSystemView().getSystemIcon(file3);
   //icon2 = chooser.getFileSystemView().getSystemIcon(file3);

   int scale = 12;

   BufferedImage bi = new BufferedImage(
     scale*icon2.getIconWidth(),
     scale*icon2.getIconHeight(),
     BufferedImage.TYPE_INT_ARGB);
   Graphics2D g = bi.createGraphics();
   g.scale(scale,scale);
   icon2.paintIcon(null,g,0,0);
   g.dispose();
   lblForIcon.setIcon(new ImageIcon(bi));
			}
		});
		button.setFont(new Font("Dialog", Font.PLAIN, 10));
		button.setForeground(Color.GREEN);
		button.setBackground(Color.BLACK);
		panel_1.add(button);
		panel_3.setBounds(0, 0, 194, 188);
			
		panel_3.setBackground(Color.BLACK);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		lblForIcon.setBackground(Color.BLACK);
		
		lblForIcon.setForeground(Color.WHITE);
		lblForIcon.setBounds(0, 0, 194, 188);
		panel_3.add(lblForIcon);
		
		JLabel lblHash = new JLabel("My Hash:");
		lblHash.setBounds(10, 269, 64, 14);
		lblHash.setForeground(Color.GREEN);
		panel_1.add(lblHash);
		
		textMyHash = new JTextField();
		textMyHash.setBounds(70, 267, 322, 20);
		textMyHash.setText("Invalid Client - Restart");
		textMyHash.setEditable(false);
		textMyHash.setForeground(Color.GREEN);
		textMyHash.setFont(new Font("Tahoma", Font.PLAIN, 9));
		textMyHash.setBackground(Color.BLACK);
		panel_1.add(textMyHash);
		textMyHash.setColumns(10);
		
		JLabel lblConsole = new JLabel("Console");
		lblConsole.setBounds(176, 301, 71, 14);
		lblConsole.setForeground(Color.GREEN);
		panel_1.add(lblConsole);
		
		
		textmyUUID.setFont(new Font("Tahoma", Font.PLAIN, 9));
		textmyUUID.setEditable(false);
		textmyUUID.setForeground(Color.GREEN);
		textmyUUID.setBackground(Color.BLACK);
		textmyUUID.setBounds(204, 163, 188, 20);
		panel_1.add(textmyUUID);
		textmyUUID.setColumns(10);
		
		JLabel lblUUID = new JLabel("My UUID:");
		lblUUID.setForeground(Color.GREEN);
		lblUUID.setBounds(204, 138, 76, 14);
		panel_1.add(lblUUID);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(405, 0, 402, 561);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 163, 382, 168);
		panel_2.add(scrollPane_1);
		
		txtOnline = new JTextArea();
		txtOnline.setRows(8);
		txtOnline.setEditable(false);
		txtOnline.setForeground(Color.GREEN);
		txtOnline.setBackground(Color.BLACK);
		scrollPane_1.setViewportView(txtOnline);
		
		JLabel lblOnline = new JLabel("Online:");
		lblOnline.setForeground(Color.GREEN);
		lblOnline.setBounds(10, 138, 64, 14);
		panel_2.add(lblOnline);
		
		lblTimer = new JLabel("5");
		lblTimer.setForeground(Color.GREEN);
		lblTimer.setBounds(368, 138, 24, 14);
		panel_2.add(lblTimer);
		
		txtDestination = new JTextField();
		txtDestination.setForeground(Color.GREEN);
		txtDestination.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtDestination.setColumns(10);
		txtDestination.setBackground(Color.BLACK);
		txtDestination.setBounds(117, 11, 275, 20);
		panel_2.add(txtDestination);
		
		JLabel lblDest_UUID = new JLabel("Destination UUID:");
		lblDest_UUID.setForeground(Color.GREEN);
		lblDest_UUID.setBounds(10, 13, 144, 14);
		panel_2.add(lblDest_UUID);
		
		Button btnSend = new Button("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!txtDestination.getText().isBlank()) {
					System.out.println(ThreadClient.getHash(textmyUUID.getText(), txtDestination.getText()));
					ThreadClient.sendFile(Encryptor.Encrypt(txtPath.getText(), ThreadClient.getHash(textmyUUID.getText(), txtDestination.getText())), txtDestination.getText(), textmyUUID.getText());
					}
				} catch (IOException | NoSuchAlgorithmException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnSend.setActionCommand("");
		btnSend.setForeground(Color.GREEN);
		btnSend.setFont(new Font("Dialog", Font.PLAIN, 10));
		btnSend.setBackground(Color.BLACK);
		btnSend.setBounds(10, 337, 382, 51);
		panel_2.add(btnSend);
		
		JLabel lblStatistics = new JLabel("Encryption Algorythm writes at 12.6kb per second using about 60% CPU usage");
		lblStatistics.setBounds(10, 38, 382, 14);
		panel_2.add(lblStatistics);
		
		Button btnReceive = new Button("Receive");
		btnReceive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//ThreadClient
					if (!txtDestination.getText().isBlank()) {
					String temp = ThreadClient.receiveFile(textmyUUID.getText(), txtDestination.getText());
					
					
					Encryptor.Decrypt(toHexDump.HexToBytes(temp), ThreadClient.getHash(textmyUUID.getText(), txtDestination.getText()));
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnReceive.setForeground(Color.GREEN);
		btnReceive.setFont(new Font("Dialog", Font.PLAIN, 10));
		btnReceive.setBackground(Color.BLACK);
		btnReceive.setActionCommand("");
		btnReceive.setBounds(10, 500, 382, 51);
		panel_2.add(btnReceive);
		
		JLabel lblStats = new JLabel("File size conversion [File] -> [Encrypted file] is 2.6 times");
		lblStats.setBounds(10, 63, 382, 14);
		panel_2.add(lblStats);
		
		
		
		
		appendText(Time.getTimeHMS() + ": Login Successful");
		appendText(Time.getTimeHMS() + ": Initializing");
		Time.ThreadStart_Alive();
		
	}
	
	public static void setPath(String path) {
		txtPath.setText(path);
	}
	
	public static void appendText(String str){
	    txtConsole.append(str + "\n");
	    scrollDown();
	}

	public static void scrollDown(){
	    txtConsole.setCaretPosition(txtConsole.getText().length());
	}
	
	public static void appendTextOnline(String str){
		//txtOnline.append(str + "\n");
		txtOnline.setText(str);
		//scrollDownOnline();
	}

	public static void scrollDownOnline(){
		txtOnline.setCaretPosition(txtOnline.getText().length());
	}
	
	public static void Shutdown(String UUID) throws UnknownHostException, IOException {
		ThreadClient.Kill(UUID);
	}
}

