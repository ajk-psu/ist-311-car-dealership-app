package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import models.Vehicle;

import java.awt.Font;
import java.awt.event.ActionListener;

public class UpdateVehicleDetailsView extends JFrame 
{
	private JFrame updateDetailsViewFrame;
	private JPanel mainPane;
	
	private JButton btnUpdateVehicleDetails;
	
	private JTextField txtVIN;
	private JTextField txtMake;
	private JTextField txtModel;
	private JTextField txtYear;
	private JTextField txtColor;
	private JTextField txtMileage;
	private JTextField txtPrice;
	
	
	// ----------------------------------------
	// GUI Constructor
	// ----------------------------------------
	/**
	 * Constructs the UpdateVehicleDetailsView window when called. This window needs to have a Vehicle passed to it to parse information from.
	 * @param selectedVehicle - Vehicle - The Vehicle object to inspect the details of.
	 */
	public UpdateVehicleDetailsView(Vehicle selectedVehicle) 
	{	
		// General Window Properties
		updateDetailsViewFrame = new JFrame("Vehicle Details");
		updateDetailsViewFrame.setResizable(false);
		updateDetailsViewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		updateDetailsViewFrame.setBounds(100, 100, 380, 410);
		
		// homePane Properties
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPane.setLayout(null);
		updateDetailsViewFrame.setContentPane(mainPane);
		
		
		// btnEditVehicle Properties
		btnUpdateVehicleDetails = new JButton("Update Vehicle Details");
		btnUpdateVehicleDetails.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUpdateVehicleDetails.setBounds(89, 323, 169, 41);
		mainPane.add(btnUpdateVehicleDetails);
		
		
		// txtVINProperties
		txtVIN = new JTextField(selectedVehicle.getVIN());
		txtVIN.setEditable(false);
		txtVIN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtVIN.setColumns(10);
		txtVIN.setBounds(124, 36, 230, 30);
		mainPane.add(txtVIN);
		
		// txtMake Properties
		txtMake = new JTextField(selectedVehicle.getMake());
		txtMake.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMake.setBounds(124, 77, 230, 30);
		mainPane.add(txtMake);
		txtMake.setColumns(10);
		
		// txtModel Properties
		txtModel = new JTextField(selectedVehicle.getModel());
		txtModel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtModel.setColumns(10);
		txtModel.setBounds(124, 118, 230, 30);
		mainPane.add(txtModel);
		
		// txtYear Properties
		txtYear = new JTextField(Integer.toString(selectedVehicle.getYear()));
		txtYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtYear.setColumns(10);
		txtYear.setBounds(124, 159, 230, 30);
		mainPane.add(txtYear);
		
		// txtColor Properties
		txtColor = new JTextField(selectedVehicle.getColor());
		txtColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtColor.setColumns(10);
		txtColor.setBounds(124, 200, 230, 30);
		mainPane.add(txtColor);
		
		// txtMileage Properties
		txtMileage = new JTextField(Double.toString(selectedVehicle.getMileage()));
		txtMileage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMileage.setColumns(10);
		txtMileage.setBounds(124, 241, 230, 30);
		mainPane.add(txtMileage);
		
		// txtPrice Properties
		txtPrice = new JTextField(Double.toString(selectedVehicle.getPrice()));
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPrice.setColumns(10);
		txtPrice.setBounds(124, 282, 230, 30);
		mainPane.add(txtPrice);
		
		
		// lblTitle Properties
		JLabel lblTitle = new JLabel("You are now editing the information for this vehicle.");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitle.setBounds(10, 11, 344, 14);
		mainPane.add(lblTitle);
		
		// lblVIN Properties
		JLabel lblVIN = new JLabel("VIN");
		lblVIN.setHorizontalAlignment(SwingConstants.LEFT);
		lblVIN.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVIN.setBounds(10, 43, 79, 14);
		mainPane.add(lblVIN);
		
		// lblMake Properties
		JLabel lblMake = new JLabel("Make");
		lblMake.setHorizontalAlignment(SwingConstants.LEFT);
		lblMake.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMake.setBounds(10, 84, 79, 14);
		mainPane.add(lblMake);
		
		// lblModel Properties
		JLabel lblModel = new JLabel("Model");
		lblModel.setHorizontalAlignment(SwingConstants.LEFT);
		lblModel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModel.setBounds(10, 126, 79, 14);
		mainPane.add(lblModel);
		
		// lblYear Properties
		JLabel lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblYear.setBounds(10, 167, 79, 14);
		mainPane.add(lblYear);
		
		// lblColorProperties
		JLabel lblColor = new JLabel("Color");
		lblColor.setHorizontalAlignment(SwingConstants.LEFT);
		lblColor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblColor.setBounds(10, 208, 79, 14);
		mainPane.add(lblColor);
		
		// lblMileage Properties
		JLabel lblMileage = new JLabel("Mileage");
		lblMileage.setHorizontalAlignment(SwingConstants.LEFT);
		lblMileage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMileage.setBounds(10, 249, 79, 14);
		mainPane.add(lblMileage);
		
		// lblPrice Properties
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrice.setBounds(10, 290, 79, 14);
		mainPane.add(lblPrice);
	}
	
	// ----------------------------------------
	// PUBLIC FACING METHODS FOR THE CONTROLLER
	// ----------------------------------------
			
	// ----------------------------------------
	// GUI Methods
	// ----------------------------------------
	/**
	 * Sets the visibility of the vehicleDetailsViewFrame
	 * @param visible - boolean -  If true, vehicleDetailsViewFrame becomes visible. If false, it is hidden.
	 */
	public void setVisible(boolean visible)
	{
		this.updateDetailsViewFrame.setVisible(visible);
	}
	
	/**
	 * Disposes (deletes) the VehicleDetailsView window.
	 * @implNote Call this method when you are done with the window.
	 */
	public void dispose()
	{
		this.updateDetailsViewFrame.dispose();
	}
	
	/**
     * When this method is called, it creates listeners for every interactable in the view.
     * @param listener - The listener to be added to the objects.
     */
	public void createListeners(ActionListener listener)
	{
		this.btnUpdateVehicleDetails.addActionListener(listener);
	}
	
	// ----------------------------------------
	// Vehicle Data Related Methods
	// ----------------------------------------
		
	/**
	 * When called, this method will collect the user's input from each text field and return them as one Object[] array to be used
	 * elsewhere for updating a Vehicle's attributes. This method will validate the user's input to ensure fields are not empty
	 * and are of the right type. If the method cannot validate, it will instead return null.
	 * @return If validation is successful, an Object[] array containing the attributes to update a Vehicle's attributes from. 
	 * If unsuccessful, this method will return null instead.
	 * @implNote This method can possibly return null if input validation fails. The caller should be ready to handle null being returned.
	 */
		public Object[] getUpdatedVehicleAttributes()
		{
			// First grab all Strings from the text fields.
			String strVIN = this.txtVIN.getText().trim();
			String strMake = this.txtMake.getText().trim();
			String strModel = this.txtModel.getText().trim();
			String strYear = this.txtYear.getText().trim();
			String strColor = this.txtColor.getText().trim();
			String strMileage = this.txtMileage.getText().trim();
			String strPrice = this.txtPrice.getText().trim();
			
			// Check to see if any fields are empty. We are not allowing empty/null values.
			if (strVIN.isEmpty() || strMake.isEmpty() || strModel.isEmpty() || strYear.isEmpty() || strColor.isEmpty() || strMileage.isEmpty() || strPrice.isEmpty())
			{
				JOptionPane.showMessageDialog(this,"All fields are required. Please fill out every field.","Input Error",JOptionPane.ERROR_MESSAGE);
				return null;
			}
			else
			{
				// Attempts to cast strYear, dblMileage, and dblPrice the appropriate types.
				try
				{
					int intYear = Integer.parseInt(strYear);
					double dblMileage = Double.parseDouble(strMileage);
					double dblPrice = Double.parseDouble(strPrice);
					
					return new Object[] {strVIN, strMake, strModel, intYear, strColor, dblMileage, dblPrice};
				}
				catch (NumberFormatException numEx)
				{
					JOptionPane.showMessageDialog(this, "Year must be an integer. Mileage and price must be valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
					return null;
				}
			}
		}
}
