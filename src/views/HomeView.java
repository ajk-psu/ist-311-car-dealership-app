package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import models.Vehicle;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

public class HomeView extends JFrame 
{
	private JFrame homeFrame;
	private JPanel homePane;
	
	private JTable tblVehicle;
	private JTable tblTicket;
	private final String[] VEHICLE_TABLE_COLUMN_NAMES = {"VIN", "Make", "Model", "Year", "Color", "Mileage", "Price"};
	private final String[] TICKET_TABLE_COLUMN_NAMES = {"Ticket ID", "Open Date", "Close Date", "Description"};
	
	private DefaultTableModel dataVehicle = new DefaultTableModel(VEHICLE_TABLE_COLUMN_NAMES, 0)
	{
		// Disables default editable cell behavior in each table
		@Override
		public boolean isCellEditable(int row, int column)
		{
			return false; 
		}
	};
	
	private DefaultTableModel dataTicket = new DefaultTableModel(TICKET_TABLE_COLUMN_NAMES, 0)
	{
		@Override
		public boolean isCellEditable(int row, int column)
		{
			return false;
		}
	};
	
	private JButton btnSelectVehicle;
	private JButton btnAddVehicle;
	private JButton btnAddTicket;
	private JButton btnSelectTicket;
	
	private JLabel lblWelcomeMessage;

	// ----------------------------------------
	// GUI Constructor
	// ----------------------------------------
	public HomeView() 
	{
		// General Window Properties
		homeFrame = new JFrame("Java Car Dealership Manager");
		homeFrame.setResizable(false);
		// Db connection severed and program closed via HomeCloseListener (in HomeController)
		homeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		homeFrame.setBounds(100, 100, 750, 785);
				
		// homePane Properties
		homePane = new JPanel();
		homePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		homePane.setLayout(null);
		homeFrame.setContentPane(homePane);
				
		// tblVehicle Properties
		tblVehicle = new JTable(dataVehicle);
		tblVehicle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblVehicle.setFillsViewportHeight(true);
		
		// tblTicket Properties
		tblTicket = new JTable(dataTicket);
		tblTicket.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblTicket.setFillsViewportHeight(true);
		
		
		// scrlPaneVehicle Properties
		JScrollPane scrlPaneVehicle = new JScrollPane(tblVehicle);
		scrlPaneVehicle.setBounds(10, 75, 714, 250);
		homePane.add(scrlPaneVehicle);
		
		// scrlPaneTicket
		JScrollPane scrlPaneTicket = new JScrollPane(tblTicket);
		scrlPaneTicket.setBounds(10, 436, 714, 250);
		homePane.add(scrlPaneTicket);
		
	
		// lblWelcomeMessage Properties
		lblWelcomeMessage = new JLabel("Welcome, [Name Here]!");
		lblWelcomeMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblWelcomeMessage.setBounds(10, 11, 714, 25);
		homePane.add(lblWelcomeMessage);
		
		// lblVehicleInventory Properties
		JLabel lblVehicleInventory = new JLabel("Vehicle Inventory");
		lblVehicleInventory.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVehicleInventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblVehicleInventory.setBounds(10, 47, 714, 25);
		homePane.add(lblVehicleInventory);
		
		JLabel lblTickets = new JLabel("Repair Tickets");
		lblTickets.setHorizontalAlignment(SwingConstants.CENTER);
		lblTickets.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTickets.setBounds(10, 400, 714, 25);
		homePane.add(lblTickets);
		
		
		// btnSelectVehicle Properties
		btnSelectVehicle = new JButton("Select Vehicle");
		btnSelectVehicle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSelectVehicle.setBounds(10, 336, 135, 35);
		homePane.add(btnSelectVehicle);
		
		// btnAddVehicle Properties
		btnAddVehicle = new JButton("Add Vehicle");
		btnAddVehicle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddVehicle.setBounds(589, 336, 135, 35);
		homePane.add(btnAddVehicle);
		
		// btnSelectTicket Properties
		btnSelectTicket = new JButton("Select Ticket");
		btnSelectTicket.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSelectTicket.setBounds(10, 697, 135, 35);
		homePane.add(btnSelectTicket);

		// btnAddTicket Properties
		btnAddTicket = new JButton("Open New Ticket");
		btnAddTicket.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddTicket.setBounds(589, 697, 135, 35);
		homePane.add(btnAddTicket);
		

		// seperatorHeader Properties
		JSeparator seperatorHeader = new JSeparator();
		seperatorHeader.setBounds(10, 36, 714, 2);
		homePane.add(seperatorHeader);
		
		// seperatorHeader Properties
		JSeparator separatorVehicleInventory = new JSeparator();
		separatorVehicleInventory.setBounds(10, 387, 714, 2);
		homePane.add(separatorVehicleInventory);
	}
	
	
	// ----------------------------------------
	// PUBLIC FACING METHODS FOR THE CONTROLLER
	// ----------------------------------------
	
	// ----------------------------------------
	// GUI Methods
	// ----------------------------------------
	/**
     * Sets the visibility of the HomeView.
     * @param visible - boolean -  If true, HomeView becomes visible. If false, HomeView is hidden.
     */
	public void setVisible(boolean visible)
	{
		this.homeFrame.setVisible(visible);
	}
	
	
	/**
     * When this method is called, it creates listeners for every interactable (and window close operation) in the view.
     * @param listener - The listener to be added to the objects.
     */
	public void createListeners(ActionListener listener, WindowAdapter HomeCloseListener)
	{
		// Add button click listeners
		this.btnSelectVehicle.addActionListener(listener);
		this.btnAddVehicle.addActionListener(listener);
		this.btnSelectTicket.addActionListener(listener);
		this.btnAddTicket.addActionListener(listener);

		// Add window close listener
		this.homeFrame.addWindowListener(HomeCloseListener);
	}
	
	/**
     * Updates the welcome message to include the user's real name.
     * @param name - String -String containing the user's real name.
     */
	public void updateWelcomeMessage(String name)
	{
		this.lblWelcomeMessage.setText("Welcome, " + name + "!");
	}
	
	
	// ----------------------------------------
	// Vehicle Data Related Methods
	// ----------------------------------------
	/**
     * Updates dataVehicle with a supplied ArrayList of Vehicle objects. 
     * @param arrayOfVehicles - ArrayList<Vehicle> - The ArrayList of Vehicle objects to be added to dataVehicle.
     * @implNote This method will override all data in the table when called!
     */
	public void updateEntireVehicleTable(ArrayList<Vehicle> arrayOfVehicles)
	{
		// Clears the vehicle table model of all existing data.
		this.dataVehicle.setRowCount(0);
		
		// For each vehicle in the ArrayList<Vehicle>, create an Object[] from the data
		// and then add it to the vehicle table model.
		for (Vehicle currentVehicle : arrayOfVehicles)
		{
			Object[] vehicleRow = 
				{
						currentVehicle.getVIN(),
						currentVehicle.getMake(),
						currentVehicle.getModel(),
						currentVehicle.getYear(),
						currentVehicle.getColor(),
						currentVehicle.getMileage(),
						currentVehicle.getPrice()
				};
			this.dataVehicle.addRow(vehicleRow);
		}
	}
	
	/**
     * Adds a single new Vehicle object to the vehicle data table model.
     * @param newVehicle - Vehicle - The new Vehicle object to be added to the table.
     * @implNote This method only affects the view's table data.
     */
	public void addVehicleToTable(Vehicle newVehicle)
	{
		Object[] newRow =
			{
				newVehicle.getVIN(),
				newVehicle.getMake(),
				newVehicle.getModel(),
				newVehicle.getYear(),
				newVehicle.getColor(),
				newVehicle.getMileage(),
				newVehicle.getPrice()
			};
		this.dataVehicle.addRow(newRow);
	}
	
	/**
     * Updates the attributes of the specified Vehicle in the data table.
     * @param updatedVehicle - Vehicle - The Vehicle object to be updated.
     * @implNote This method only affects the view's table data.
     */
	public void updateVehicleInTable(Vehicle updatedVehicle)
	{
		// Get the VIN from the updated Vehicle object.
		// (This is the primary key of Vehicles and should always be unique, no need to validate uniqueness).
		String targetVIN = updatedVehicle.getVIN();
		
		// Search through the table for the VIN number.
		for (int row = 0; row < dataVehicle.getRowCount(); row++)
		{
			String currentVIN = (String) dataVehicle.getValueAt(row, 0); // Column 0 should always be the VIN number.
			
			// Vehicle found.
			if (currentVIN.equals(targetVIN))
			{
				this.dataVehicle.setValueAt(updatedVehicle.getMake(), row, 1);
				this.dataVehicle.setValueAt(updatedVehicle.getModel(), row, 2);
				this.dataVehicle.setValueAt(updatedVehicle.getYear(), row, 3);
				this.dataVehicle.setValueAt(updatedVehicle.getColor(), row, 4);
				this.dataVehicle.setValueAt(updatedVehicle.getMileage(), row, 5);
				this.dataVehicle.setValueAt(updatedVehicle.getPrice(), row, 6);
				break;
			}
		}
	}
	
	/**
     * Removes the specified Vehicle object from the view's table.
     * @param updatedVehicle - Vehicle - The Vehicle object to be updated.
     * @implNote This method only affects the view's table data.
     */
	public void removeVehicleFromTable(Vehicle vehicleToRemove)
	{
		String targetVIN = vehicleToRemove.getVIN();
		
		// Search through the table for the VIN number.
		for (int row = 0; row < dataVehicle.getRowCount(); row++)
		{
			String currentVIN = (String) dataVehicle.getValueAt(row, 0); // Column 0 should always be the VIN number.
			
			// Vehicle found.
			if (currentVIN.equals(targetVIN))
			{
				this.dataVehicle.removeRow(row);
				break;
			}
		}
	}
	
	/**
     * Returns the selected Vehicle from the table.
     * @return The selected Vehicle object from the table, or null if nothing was selected.
     * @implNote This method will return null if the user does not have an item selected. While the user will be alerted
     * that nothing was selected, the method will still return null. Make sure you are prepared to handle this null value 
     * in the controller.
     */
	public Vehicle getSelectedVehicleFromTable() 
	{
		int selectedRow = this.tblVehicle.getSelectedRow();
		
		// No row is selected!
		if (selectedRow == -1)
		{
			JOptionPane.showMessageDialog(this, "Please select a row first.", "No Row Selected!", JOptionPane.WARNING_MESSAGE);
			return null;
		}
		else
		{
			String strVIN = (String) this.dataVehicle.getValueAt(selectedRow, 0);
			String strMake = (String) this.dataVehicle.getValueAt(selectedRow, 1);
			String strModel = (String) this.dataVehicle.getValueAt(selectedRow, 2);
			int intYear = (int) this.dataVehicle.getValueAt(selectedRow, 3);
			String strColor = (String) this.dataVehicle.getValueAt(selectedRow, 4);
			double dblMileage = (double) this.dataVehicle.getValueAt(selectedRow, 5);
			double dblPrice = (double) this.dataVehicle.getValueAt(selectedRow, 6);
			
			return new Vehicle(strVIN, strMake, strModel, intYear, strColor, dblMileage, dblPrice);
		}
	}
	
	/**
     * Exports the entire contents of the view's vehicle data table into an ArrayList of Vehicle objects.
     * @return An ArrayList of Vehicle objects.
     */
	public ArrayList<Vehicle> exportVehicleDataFromTable()
	{
		ArrayList<Vehicle> vehicleList = new ArrayList<>();
		
		// Figure out how many rows (vehicles) there are in the table.
		int rowCount = this.dataVehicle.getRowCount();
		
		// For each row, grab the vehicle attributes and then construct a new Vehicle object from them.
		// Then add the object to the ArrayList.
		for (int row = 0; row < rowCount; row++)
		{
			String strVIN = (String) this.dataVehicle.getValueAt(row, 0);
			String strMake = (String) this.dataVehicle.getValueAt(row, 1);
			String strModel = (String) this.dataVehicle.getValueAt(row, 2);
			int intYear = (int) this.dataVehicle.getValueAt(row, 3);
			String strColor = (String) this.dataVehicle.getValueAt(row, 4);
			double dblMileage = (double) this.dataVehicle.getValueAt(row, 5);
			double dblPrice = (double) this.dataVehicle.getValueAt(row, 6);
			
			Vehicle vehicle = new Vehicle(strVIN, strMake, strModel, intYear, strColor, dblMileage, dblPrice);
			vehicleList.add(vehicle);
		}
		return vehicleList;
	}
}
