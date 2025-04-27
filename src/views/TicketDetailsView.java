package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import models.Ticket;

import java.awt.Font;
import java.awt.event.ActionListener;


public class TicketDetailsView extends JFrame 
{
	private JFrame ticketDetailsFrame;
	private JPanel mainPane;
	
	private JButton btnEditTicket;
	
	private JTextField txtVIN;
	private JTextField txtMake;
	private JTextField txtModel;
	private JTextField txtYear;
	private JTextField txtTicketID;
	
	private JTextArea txtDescription;
	
	private Ticket ticketMain;
	private JButton btnRemoveTicket;
	
	
	// ----------------------------------------
	// GUI Constructor
	// ----------------------------------------
	
	/**
	 * Constructor for the TicketDetailsView window. This constructor needs a Ticket object passed to it.
	 * @param ticket - Ticket - The ticket object of that is the subject of the report to be made.
	 */
	public TicketDetailsView(Ticket ticket) 
	{	
		this.ticketMain = ticket;
		
		// General Window Properties
		ticketDetailsFrame = new JFrame("Add Vehicle");
		ticketDetailsFrame.setTitle("Ticket Details");
		ticketDetailsFrame.setResizable(false);
		ticketDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ticketDetailsFrame.setBounds(100, 100, 380, 610);
		
		// homePane Properties
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPane.setLayout(null);
		ticketDetailsFrame.setContentPane(mainPane);
		
		
		// btnCreateTicket Properties
		btnEditTicket = new JButton("Edit Ticket Details");
		btnEditTicket.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEditTicket.setBounds(10, 519, 148, 41);
		mainPane.add(btnEditTicket);
		
		// btnRemoveTicket Properties
		btnRemoveTicket = new JButton("Remove Ticket");
		btnRemoveTicket.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRemoveTicket.setBounds(206, 519, 148, 41);
		mainPane.add(btnRemoveTicket);
		
		
		// txtTicketID Properties
		txtTicketID = new JTextField(Integer.toString(ticketMain.getTicketID()));
		txtTicketID.setEditable(false);
		txtTicketID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTicketID.setColumns(10);
		txtTicketID.setBounds(124, 36, 230, 30);
		mainPane.add(txtTicketID);
		
		
		// txtDescription Properties
		txtDescription = new JTextArea(ticketMain.getDescription());
		txtDescription.setEditable(false);
		txtDescription.setWrapStyleWord(true);
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDescription.setColumns(10);
		txtDescription.setBounds(10, 102, 344, 221);
		mainPane.add(txtDescription);
		
		// txtVIN Properties
		txtVIN = new JTextField(ticketMain.getVIN());
		txtVIN.setEditable(false);
		txtVIN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtVIN.setColumns(10);
		txtVIN.setBounds(124, 355, 230, 30);
		mainPane.add(txtVIN);
		
		// txtYear Properties
		txtYear = new JTextField(Integer.toString(ticketMain.getYear()));
		txtYear.setEditable(false);
		txtYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtYear.setColumns(10);
		txtYear.setBounds(124, 396, 230, 30);
		mainPane.add(txtYear);
		
		// txtMake Properties
		txtMake = new JTextField(ticketMain.getMake());
		txtMake.setEditable(false);
		txtMake.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMake.setBounds(124, 437, 230, 30);
		mainPane.add(txtMake);
		txtMake.setColumns(10);
		
		// txtModel Properties
		txtModel = new JTextField(ticketMain.getModel());
		txtModel.setEditable(false);
		txtModel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtModel.setColumns(10);
		txtModel.setBounds(124, 478, 230, 30);
		mainPane.add(txtModel);
		
		
		// lblInstructions Properties
		JLabel lblInstructions = new JLabel("Viewing ticket details...");
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
		lblTicketID.setBounds(10, 43, 79, 14);
		mainPane.add(lblTicketID);
		
		JLabel lblDescription = new JLabel("Description of Issue / Addtional Notes");
		lblDescription.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescription.setBounds(10, 77, 344, 14);
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
	 * Sets the visibility of the ticketDetailsView
	 * @param visible - boolean -  If true, TicketDetailsView becomes visible. If false, it is hidden.
	 */
	public void setVisible(boolean visible)
	{
		this.ticketDetailsFrame.setVisible(visible);
	}
	
	/**
	 * Disposes (deletes) the ticketDetailsView window.
	 * @implNote Call this method when you are done with the window.
	 */
	public void dispose()
	{
		this.ticketDetailsFrame.dispose();
	}
	
	/**
     * When this method is called, it creates listeners for every interactable in the view.
     * @param listener - The listener to be added to the objects.
     */
	public void createListeners(ActionListener listener)
	{
		this.btnEditTicket.addActionListener(listener);
		this.btnRemoveTicket.addActionListener(listener);
	}
	
	/**
     * When this method is called, it creates listeners for every interactable in the view.
     * @param listener - The listener to be added to the objects.
     */
	
	// ----------------------------------------
	// Ticket Data Related Methods
	// ----------------------------------------
	
	/**
     * Returns the subject Ticket of this View.
     * @return The subject Ticket that was used to make this View.
     */
	public Ticket getTicket()
	{
		return this.ticketMain;
	}

	
}
