package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;

public class HomeView extends JFrame 
{
	
	private JFrame homeFrame;
	private JPanel homePane;

	// GUI Constructor
	// Note: The constructor does not automatically setVisible() to true.
	public HomeView() 
	{
		// General Window Properties
		homeFrame = new JFrame("Java Car Dealership Manager");
		homeFrame.setResizable(false);
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeFrame.setBounds(100, 100, 645, 444);
		
		// homePane Properties
		homePane = new JPanel();
		homePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		homePane.setLayout(new BorderLayout(0, 0));
		homeFrame.setContentPane(homePane);
		
		// lblWelcomeMessage Properties
		JLabel lblWelcomeMessage = new JLabel("Welcome, user!");
		lblWelcomeMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		homePane.add(lblWelcomeMessage, BorderLayout.NORTH);
		
		// lblBodyMessage Properties
		JLabel lblBodyMessage = new JLabel("You are logged in now!");
		lblBodyMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		homePane.add(lblBodyMessage, BorderLayout.CENTER);
	}
	
	// View Methods for the Controller
	public void setVisible(boolean visible)
	{
		homeFrame.setVisible(visible);
	}
}
