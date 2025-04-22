package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.util.ArrayList;

public class HomeView extends JFrame 
{
	
	private JFrame homeFrame;
	private JPanel homePane;
	
	private JTable tblVehicle;
	private JTable tblTicket;
	private final String[] TICKET_TABLE_COLUMN_NAMES = {"Ticket ID", "Open Date", "Close Date", "Description"};
	private final String[] VEHICLE_TABLE_COLUMN_NAMES = {"ID", "Make", "Model", "Year", "Color", "Mileage", "Price", "Purchase Date", "Sale Date"};
	
	private DefaultTableModel tblVehicleData = new DefaultTableModel(VEHICLE_TABLE_COLUMN_NAMES, 0);
	private DefaultTableModel ticketData = new DefaultTableModel(TICKET_TABLE_COLUMN_NAMES, 0);
	
	private JButton btnSelectVehicle;
	private JButton btnAddVehicle;
	private JButton btnAddTicket;
	private JButton btnSelectTicket;
	
	private JLabel lblWelcomeMessage;

	// GUI Constructor
	// Note: The constructor does not automatically setVisible() to true.
	public HomeView() 
	{
		// General Window Properties
		homeFrame = new JFrame("Java Car Dealership Manager");
		homeFrame.setResizable(false);
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeFrame.setBounds(100, 100, 750, 785);
				
		// homePane Properties
		homePane = new JPanel();
		homePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		homePane.setLayout(null);
		homeFrame.setContentPane(homePane);
				
		// tblVehicle Properties
		tblVehicle = new JTable(tblVehicleData);
		tblVehicle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblVehicle.setFillsViewportHeight(true);
		
		// tblTicket Properties
		tblTicket = new JTable(ticketData);
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
		
		
		// seperatorHeader Properties
		JSeparator seperatorHeader = new JSeparator();
		seperatorHeader.setBounds(10, 36, 714, 2);
		homePane.add(seperatorHeader);
		
		// seperatorHeader Properties
		JSeparator separatorVehicleInventory = new JSeparator();
		separatorVehicleInventory.setBounds(10, 387, 714, 2);
		homePane.add(separatorVehicleInventory);
		
		JLabel lblTickets = new JLabel("Repair Tickets");
		lblTickets.setHorizontalAlignment(SwingConstants.CENTER);
		lblTickets.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTickets.setBounds(10, 400, 714, 25);
		homePane.add(lblTickets);
		
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
	}
	
	// ----------------------------------------
	// PUBLIC FACING METHODS FOR THE CONTROLLER
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
     * When this method is called, it creates listeners for every interactable in the view.
     * @param listener - The listener to be added to the objects.
     */
	public void createListeners(ActionListener listener)
	{
		this.btnSelectVehicle.addActionListener(listener);
		this.btnAddVehicle.addActionListener(listener);
		this.btnSelectTicket.addActionListener(listener);
		this.btnAddTicket.addActionListener(listener);
	}
	
	/**
     * Updates the welcome message to include the user's real name.
     * @param name - String -String containing the user's real name.
     */
	public void updateWelcomeMessage(String name)
	{
		this.lblWelcomeMessage.setText("Welcome, " + name + "!");
	}
	
	
	/**
     * Appends a new row of data to the end of dataVehicle.
     * @param rowIndex - int - The index of the row to pull data from.
     */
	public void addNewVehicleData(Object[] newVehicleData)
	{
		this.tblVehicleData.addRow(newVehicleData);
	}
	
	/**
     * Updates tblVehicleData with a supplied ArrayList of Objects[]. 
     * @param arrayOfVehicleData - ArrayList<Object[]> - The ArrayList of Objects[] to be added to tblVehicleData.
     * @implNote This method will override all data in the table when called! Use updateSingleVehicleDataRow if you need to 
     * update a single row.
     */
	public void updateAllVehicleData(ArrayList<Object[]> arrayOfVehicleData)
	{
		// Clears table of all data
		this.tblVehicleData.setRowCount(0);
		
		for (Object[] row : arrayOfVehicleData)
		{
			this.tblVehicleData.addRow(row);
		}
	}
	
	/**
     * Updates a single row of tblVehicleData with a supplied Object[] and index to be changed.
     * @param rowIndex - int - The index of the row to be changed
     * @param updatedRowData - Object[] -  The set of data to change the row to.
     */
	public void updateSingleVehicleDataRow(int rowIndex, Object[] updatedRowData)
	{
		for (int column = 0; column < updatedRowData.length; column++)
		{
			this.tblVehicleData.setValueAt(updatedRowData[column], rowIndex, column);
		}
	}
	
	/**
     * Removes a single row of tblVehicleData at the specified index. Will prompt the user to confirm they want to remove the row.
     * @param rowIndex - int - The index of the row to be removed
     */
	public void removeSingleVehicleDataRow(int rowIndex)
	{
		// Make sure rowIndex is actually valid.
		if (rowIndex >= 0 && rowIndex < this.tblVehicleData.getRowCount())
		{
			this.tblVehicleData.removeRow(rowIndex);
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Could not find specificed row.", "Error", JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
     * Exports the selected row of data (using int rowIndex) to an Object[] for use elsewhere in the program.
     * @param rowIndex - int - The index of the row to pull data from.
     * @return Returns a single Object[], representing a single row of data from tblVehicleData.
     */
	public Object[] getSelectedVehicleData(int rowIndex)
	{
		Object[] selectedVehicleData = new Object[this.tblVehicle.getColumnCount()];
		
		for (int column = 0; column < this.tblVehicle.getColumnCount(); column++)
		{
			selectedVehicleData[column] = this.tblVehicle.getValueAt(rowIndex, column);
		}
		
		return selectedVehicleData;
	}
	
	/**
     * Returns the row index of the selected row from JTable tblVehicle as an int.
     * @return Returns the row index.
     * @implNote This method will return -1 if the user did not select a row! While the user will receive a warning,
     * the method will still return a value regardless. Be prepared to handle -1 in case the user did not select a value!  
     */
	public int getSelectedVehicleRowIndex()
	{
		int selectedRowIndex = this.tblVehicle.getSelectedRow();
		
		if (selectedRowIndex != -1)
		{
			return selectedRowIndex;
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Please select a row first.", "No Row Selected!", JOptionPane.WARNING_MESSAGE);
			return selectedRowIndex;
		}
	}
}
