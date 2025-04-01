package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;

public class HomeView extends JFrame 
{
	
	private JFrame homeFrame;
	private JPanel homePane;
	private JTable tblVehicle;
	private JButton btnSelectVehicle;
	private JButton btnAddVehicle;
	
	// Temporary data to fill table with, this needs to get filled with data from the database in the future.
	private Object[][] vehicleData = {{1, "Ford", "Focus", 2003, "Blue", 120000, 5000, "May 2024", "N/A"}, {2, "Honda", "Civic", 1999, "Red", 220000, 1000, "May 2022", "N/A"}};
	private Object[][] ticketData = {};
	
	private final String[] TICKET_TABLE_COLUMN_NAMES = {};
	private final String[] VEHICLE_TABLE_COLUMN_NAMES = {"ID", "Make", "Model", "Year", "Color", "Mileage", "Price", "Purchase Date", "Sale Date"};
	
	

	// GUI Constructor
	// Note: The constructor does not automatically setVisible() to true.
	public HomeView() 
	{
		// tblVehicle Properties
		tblVehicle = new JTable(vehicleData, VEHICLE_TABLE_COLUMN_NAMES);
		tblVehicle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblVehicle.setFillsViewportHeight(true);
		
		
		// General Window Properties
		homeFrame = new JFrame("Java Car Dealership Manager");
		homeFrame.setResizable(false);
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeFrame.setBounds(100, 100, 720, 450);
		
		// homePane Properties
		homePane = new JPanel();
		homePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		homePane.setLayout(null);
		homeFrame.setContentPane(homePane);
		
		// scrlPaneVehicle Properties
		JScrollPane scrlPaneVehicle = new JScrollPane(tblVehicle);
		scrlPaneVehicle.setBounds(10, 75, 684, 250);
		homePane.add(scrlPaneVehicle);
		
		
		// lblWelcomeMessage Properties
		JLabel lblWelcomeMessage = new JLabel("Welcome, [Name Here]!");
		lblWelcomeMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblWelcomeMessage.setBounds(10, 11, 684, 25);
		homePane.add(lblWelcomeMessage);
		
		// lblVehicleInventory Properties
		JLabel lblVehicleInventory = new JLabel("Vehicle Inventory");
		lblVehicleInventory.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVehicleInventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblVehicleInventory.setBounds(10, 47, 684, 25);
		homePane.add(lblVehicleInventory);
		
		
		// btnSelectVehicle Properties
		btnSelectVehicle = new JButton("Select Vehicle");
		btnSelectVehicle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSelectVehicle.setBounds(10, 336, 135, 35);
		homePane.add(btnSelectVehicle);
		
		// btnSelectVehicle Properties
		btnAddVehicle = new JButton("Add Vehicle");
		btnAddVehicle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddVehicle.setBounds(559, 336, 135, 35);
		homePane.add(btnAddVehicle);
		
		
		// seperatorHeader Properties
		JSeparator seperatorHeader = new JSeparator();
		seperatorHeader.setBounds(10, 36, 684, 2);
		homePane.add(seperatorHeader);
		
		// seperatorHeader Properties
		JSeparator separatorVehicleInventory = new JSeparator();
		separatorVehicleInventory.setBounds(10, 387, 684, 2);
		homePane.add(separatorVehicleInventory);
	}
	
	// View Methods for the Controller
	public void setVisible(boolean visible)
	{
		homeFrame.setVisible(visible);
	}
	
	// When this method is called, it creates listeners for every interactable in the view.
	public void createListeners(ActionListener listener)
	{
		btnSelectVehicle.addActionListener(listener);
		btnAddVehicle.addActionListener(listener);
	}
	
}
