package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import models.Vehicle;

import java.awt.Font;
import java.awt.event.ActionListener;


public class AddTicketView extends JFrame 
{
	private JFrame addTicketFrame;
	private JPanel mainPane;
	
	private JButton btnCreateTicket;
	
	private JTextField txtVIN;
	private JTextField txtMake;
	private JTextField txtModel;
	private JTextField txtYear;
	private JTextField txtTicketID;
	private JTextArea txtDescription;
	
	private Vehicle vehicleSubjectOfTicket;
	
	
	// ----------------------------------------
	// GUI Constructor
	// ----------------------------------------
	
	/**
	 * Constructor for the AddTicketView window. This constructor needs a Vehicle object passed to it.
	 * @param problemVehicle - Vehicle - The Vehicle object of that is the subject of the ticket to be made.
	 */
	public AddTicketView(Vehicle problemVehicle) 
	{	
		this.vehicleSubjectOfTicket = problemVehicle;
		
		// General Window Properties
		addTicketFrame = new JFrame("Add Vehicle");
		addTicketFrame.setTitle("Report Vehicle Issue");
		addTicketFrame.setResizable(false);
		addTicketFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addTicketFrame.setBounds(100, 100, 380, 610);

		// homePane Properties
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPane.setLayout(null);
		addTicketFrame.setContentPane(mainPane);
		
		
		// btnCreateTicket Properties
		btnCreateTicket = new JButton("Create Ticket");
		btnCreateTicket.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCreateTicket.setBounds(106, 519, 129, 41);
		mainPane.add(btnCreateTicket);
		
		
		// txtDescription Properties
		txtDescription = new JTextArea();
		txtDescription.setWrapStyleWord(true);
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDescription.setColumns(10);
		txtDescription.setBounds(10, 61, 344, 221);
		mainPane.add(txtDescription);
		
		// txtTicketID Properties
		txtTicketID = new JTextField();
		txtTicketID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTicketID.setColumns(10);
		txtTicketID.setBounds(124, 293, 230, 30);
		mainPane.add(txtTicketID);
		
		// txtVIN Properties
		txtVIN = new JTextField(vehicleSubjectOfTicket.getVIN());
		txtVIN.setEditable(false);
		txtVIN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtVIN.setColumns(10);
		txtVIN.setBounds(124, 355, 230, 30);
		mainPane.add(txtVIN);
		
		// txtYear Properties
		txtYear = new JTextField(Integer.toString(vehicleSubjectOfTicket.getYear()));
		txtYear.setEditable(false);
		txtYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtYear.setColumns(10);
		txtYear.setBounds(124, 396, 230, 30);
		mainPane.add(txtYear);
		
		// txtMake Properties
		txtMake = new JTextField(vehicleSubjectOfTicket.getMake());
		txtMake.setEditable(false);
		txtMake.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMake.setBounds(124, 437, 230, 30);
		mainPane.add(txtMake);
		txtMake.setColumns(10);
		
		// txtModel Properties
		txtModel = new JTextField(vehicleSubjectOfTicket.getModel());
		txtModel.setEditable(false);
		txtModel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtModel.setColumns(10);
		txtModel.setBounds(124, 478, 230, 30);
		mainPane.add(txtModel);
		
		
		// lblInstructions Properties
		JLabel lblInstructions = new JLabel("Please describe the issue this vehicle has below.");
		lblInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInstructions.setBounds(10, 11, 344, 14);
		mainPane.add(lblInstructions);
		
		// lblVIN Properties
		JLabel lblVIN = new JLabel("VIN");
		lblVIN.setHorizontalAlignment(SwingConstants.LEFT);
		lblVIN.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVIN.setBounds(10, 362, 79, 14);
		mainPane.add(lblVIN);
		
		// lblMake Properties
		JLabel lblMake = new JLabel("Make");
		lblMake.setHorizontalAlignment(SwingConstants.LEFT);
		lblMake.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMake.setBounds(10, 444, 79, 14);
		mainPane.add(lblMake);
	
		// lblModel Properties
		JLabel lblModel = new JLabel("Model");
		lblModel.setHorizontalAlignment(SwingConstants.LEFT);
		lblModel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModel.setBounds(10, 486, 79, 14);
		mainPane.add(lblModel);
		
		// lblYear Properties
		JLabel lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblYear.setBounds(10, 404, 79, 14);
		mainPane.add(lblYear);
		
		JLabel lblTicketID = new JLabel("Ticket ID");
		lblTicketID.setHorizontalAlignment(SwingConstants.LEFT);
		lblTicketID.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTicketID.setBounds(10, 300, 79, 14);
		mainPane.add(lblTicketID);
		
		JLabel lblDescription = new JLabel("Description of Issue");
		lblDescription.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescription.setBounds(10, 36, 344, 14);
		mainPane.add(lblDescription);
		
		
		JSeparator separatorVehicleInfo = new JSeparator();
		separatorVehicleInfo.setBounds(10, 337, 344, 2);
		mainPane.add(separatorVehicleInfo);
	}
	
	
	// ----------------------------------------
	// PUBLIC FACING METHODS FOR THE CONTROLLER
	// ----------------------------------------
		
	// ----------------------------------------
	// GUI Methods
	// ----------------------------------------
	
	/**
	 * Sets the visibility of the addTicketFrame
	 * @param visible - boolean -  If true, addVehicleFrame becomes visible. If false, it is hidden.
	 */
	public void setVisible(boolean visible)
	{
		this.addTicketFrame.setVisible(visible);
	}
	
	/**
	 * Disposes (deletes) the AddTicketView window.
	 * @implNote Call this method when you are done with the window, no need to keep it around once the user is finished making a ticket.
	 */
	public void dispose()
	{
		this.addTicketFrame.dispose();
	}
	
	/**
     * When this method is called, it creates listeners for every interactable in the view.
     * @param listener - The listener to be added to the objects.
     */
	public void createListeners(ActionListener listener)
	{
		this.btnCreateTicket.addActionListener(listener);
	}

	/**
     * When this method is called, it displays a "no duplicates accepted" message to the user.
     */
	public void showDuplicateMessage()
	{
		JOptionPane.showMessageDialog(null, "Each ticket ID must be unique.", "Input Error", JOptionPane.ERROR_MESSAGE);
	}
	
	
	// ----------------------------------------
	// Ticket Data Related Methods
	// ----------------------------------------
	
	/**
     * When called, this method will collect the user's input from each text field and return them as one Object[] array to be used
     * elsewhere for Ticket creation. This method will validate the user's input to ensure fields are not empty and are of the right
     * type. If the method cannot validate, it will instead return null.
     * @return If validation is successful, an Object[] array containing the attributes to construct a Ticket from. If unsuccessful,
     * this method will return null instead.
     * @implNote This method can possibly return null if input validation fails. The caller should be ready to handle null being returned.
     */
	public Object[] getNewTicketAttributes()
	{
		// First grab all Strings from the text fields.
		String strTicketID = this.txtTicketID.getText().trim();
		String strDescription = this.txtDescription.getText().trim();
		String strVIN = this.txtVIN.getText().trim();
		String strYear = this.txtYear.getText().trim();
		String strMake = this.txtMake.getText().trim();
		String strModel = this.txtModel.getText().trim();
		

		// Check to see if any fields are empty. We are not allowing empty/null values.
		if (strTicketID.isEmpty() || strDescription.isEmpty() || strVIN.isEmpty() || strYear.isEmpty() || strMake.isEmpty() || strModel.isEmpty())
		{
			JOptionPane.showMessageDialog(this,"All fields are required. Please fill out every field.","Input Error",JOptionPane.ERROR_MESSAGE);
			return null;
		}
		else
		{
			// Attempts to cast strYear to the appropriate type.
			try
			{
				int intYear = Integer.parseInt(strYear);
				int intTicketID = Integer.parseInt(strTicketID);
				
				return new Object[] {intTicketID, strVIN, intYear, strMake, strModel, strDescription};
			}
			catch (NumberFormatException numEx)
			{
				JOptionPane.showMessageDialog(this, "Year must be an integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
				return null;
			}
		}
	}
}
