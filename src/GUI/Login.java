package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BASELEVEL.Digester;
import CLIENT.ThreadClient;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame {

	public static JPanel contentPane;
	public static Login frame;
	private JTextField Username;
	private JPasswordField Password;
	public static JLabel lblValidate = new JLabel("");
	public static JLabel lblUsernameErrorMessage = new JLabel("");
	public static JLabel lblPasswordErrorMessage = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLog = new JLabel("Login");
		lblLog.setBounds(149, 11, 137, 14);
		contentPane.add(lblLog);
		
		Username = new JTextField();
		Username.setBounds(149, 50, 137, 20);
		contentPane.add(Username);
		Username.setColumns(10);
		
		Password = new JPasswordField();
		Password.setBounds(149, 112, 137, 20);
		contentPane.add(Password);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 53, 101, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 115, 101, 14);
		contentPane.add(lblPassword);
		
		
		lblUsernameErrorMessage.setForeground(Color.RED);
		lblUsernameErrorMessage.setBounds(296, 53, 128, 14);
		contentPane.add(lblUsernameErrorMessage);
		
		
		lblPasswordErrorMessage.setForeground(Color.RED);
		lblPasswordErrorMessage.setBounds(296, 115, 128, 14);
		contentPane.add(lblPasswordErrorMessage);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					String pwrd = new String(Password.getPassword());
					if (Username.getText().isBlank()) {
						lblUsernameErrorMessage.setText("Invalid Username");
					}else {
						lblUsernameErrorMessage.setText("");
					}
					
					
					if (pwrd.isBlank() && (pwrd.length() <= 5)) {
						lblPasswordErrorMessage.setText("Invalid Password");
					}else {
						lblPasswordErrorMessage.setText("");
					}
					
					if (!Username.getText().isBlank()) {
						if (!pwrd.isBlank()) {
							if (pwrd.length() >= 5) {
								if (ThreadClient.Login(Username.getText(), pwrd)) {
									setVisible(false);
								}
							}
						}
					}
						
					
						
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnLogin.setBounds(149, 168, 137, 23);
		contentPane.add(btnLogin);
		
		JButton btnToLogin = new JButton("Register");
		btnToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Register rg = new Register();
				rg.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnToLogin.setBounds(335, 227, 89, 23);
		contentPane.add(btnToLogin);
		
		
		lblValidate.setForeground(Color.GREEN);
		lblValidate.setBounds(142, 212, 144, 14);
		contentPane.add(lblValidate);
		
		
	}
	
	public static void FRMDispose() {
		frame.dispose();
	}
}
