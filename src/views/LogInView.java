package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;

public class LogInView extends JFrame 
{
	private JFrame logInFrame;
	private JPanel logInPane;
	
	private JTextField txtFieldAccountName;
	private JPasswordField passwordField;
	
	private JButton btnLogIn;
	
	
	// ----------------------------------------
	// GUI Constructor
	// ----------------------------------------
	// Note: The constructor does not automatically setVisible() to true.
	public LogInView() 
	{
		// General Window Properties
		logInFrame = new JFrame("Java Car Dealership Manager");
		logInFrame.setResizable(false);
		logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logInFrame.setBounds(100, 100, 350, 265);
		
		// logInPane Properties
		logInPane = new JPanel();
		logInPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		logInPane.setLayout(null);
		logInFrame.setContentPane(logInPane);
		
		
		// lblWelcome Properties
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblWelcome.setBounds(10, 15, 314, 14);
		logInPane.add(lblWelcome);
		
		// lblLogInInstructions Properties
		JLabel lblLogInInstructions = new JLabel("Please enter your account information below to log in.");
		lblLogInInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogInInstructions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLogInInstructions.setBounds(10, 30, 314, 14);
		logInPane.add(lblLogInInstructions);
		
		// lblAccountNameField Properties
		JLabel lblAccountName = new JLabel("Account Name:");
		lblAccountName.setHorizontalAlignment(SwingConstants.LEFT);
		lblAccountName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAccountName.setBounds(10, 69, 314, 14);
		logInPane.add(lblAccountName);
				
		// lblPassword Properties
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(10, 131, 314, 14);
		logInPane.add(lblPassword);
		
		
		// txtFieldAccountName Properties
		txtFieldAccountName = new JTextField();
		txtFieldAccountName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFieldAccountName.setBounds(10, 88, 314, 20);
		logInPane.add(txtFieldAccountName);
		txtFieldAccountName.setColumns(10);
		
		// passwordField Properties
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordField.setBounds(10, 150, 314, 20);
		logInPane.add(passwordField);
		
		
		// btnLogIn Properties
		btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogIn.setBounds(105, 188, 125, 30);
		logInPane.add(btnLogIn);
	}
	
	// ----------------------------------------
	// PUBLIC FACING METHODS FOR THE CONTROLLER
	// ----------------------------------------
	
	// ----------------------------------------
	// GUI Methods
	// ----------------------------------------
	
	/**
     * Sets the visibility of the LogInView.
     * @param visible - boolean -  If true, LogInView becomes visible. If false, LogInView is hidden.
     */
	public void setVisible(boolean visible)
	{
		this.logInFrame.setVisible(visible);
	}
	
	/**
	 * Disposes (deletes) the LogInVeiw window.
	 * @implNote Call this method when you are done with the window, no need to keep it around once the user is logged in.
	 */
	public void dispose()
	{
		this.logInFrame.dispose();
	}
	
	
	// ----------------------------------------
	// Account Data Related Methods
	// ----------------------------------------
	
	// Returns the String from txtFieldAccountName.
	public String getAccountName()
	{
		return this.txtFieldAccountName.getText();
	}
	
	// Returns the String from passwordField.
	public String getAccountPassword()
	{
		return new String(this.passwordField.getPassword());
	}
	
	// Creates an ActionListener for btnLogIn
	public void addLogInListener(ActionListener listener)
	{
		this.btnLogIn.addActionListener(listener);
	}
	
	// When called, displays a pop-up window letting the user know they have entered invalid credentials.
	public void badLogInMessage()
	{
		 JOptionPane.showMessageDialog(this, "The account name or password you have entered is incorrect.", "Invalid Account Credentials",  JOptionPane.OK_OPTION);
	}
}
