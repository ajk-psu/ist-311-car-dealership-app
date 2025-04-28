package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;


public class AddVehicleView extends JFrame 
{
	private JFrame addVehicleFrame;
	private JPanel mainPane;
	
	private JButton btnAddVehicle;
	
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
	public AddVehicleView() 
	{	
		// General Window Properties
		addVehicleFrame = new JFrame("Add Vehicle");
		addVehicleFrame.setResizable(false);
		addVehicleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addVehicleFrame.setBounds(100, 100, 380, 415);
		
		// homePane Properties
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPane.setLayout(null);
		addVehicleFrame.setContentPane(mainPane);
		
		
		// btnAddVehicle Properties
		btnAddVehicle = new JButton("Add Vehicle");
		btnAddVehicle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddVehicle.setBounds(106, 323, 129, 41);
		mainPane.add(btnAddVehicle);
		
		
		// txtVIN Properties
		txtVIN = new JTextField();
		txtVIN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtVIN.setColumns(10);
		txtVIN.setBounds(124, 36, 230, 30);
		mainPane.add(txtVIN);
		
		// txtMake Properties
		txtMake = new JTextField();
		txtMake.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMake.setBounds(124, 77, 230, 30);
		mainPane.add(txtMake);
		txtMake.setColumns(10);
		
		// txtModel Properties
		txtModel = new JTextField();
		txtModel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtModel.setColumns(10);
		txtModel.setBounds(124, 118, 230, 30);
		mainPane.add(txtModel);
		
		// txtYear Properties
		txtYear = new JTextField();
		txtYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtYear.setColumns(10);
		txtYear.setBounds(124, 159, 230, 30);
		mainPane.add(txtYear);
		
		// txtColor Properties
		txtColor = new JTextField();
		txtColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtColor.setColumns(10);
		txtColor.setBounds(124, 200, 230, 30);
		mainPane.add(txtColor);
		
		// txtMileage Properties
		txtMileage = new JTextField();
		txtMileage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMileage.setColumns(10);
		txtMileage.setBounds(124, 241, 230, 30);
		mainPane.add(txtMileage);
		
		// txtPrice Properties
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPrice.setColumns(10);
		txtPrice.setBounds(124, 282, 230, 30);
		mainPane.add(txtPrice);
		
		
		// lblInstructions Properties
		JLabel lblInstructions = new JLabel("Please enter new vehicle details below.");
		lblInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInstructions.setBounds(10, 11, 344, 14);
		mainPane.add(lblInstructions);
		
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
		
		// lblColor Properties
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
	 * Sets the visibility of the addVehicleFrame
	 * @param visible - boolean -  If true, addVehicleFrame becomes visible. If false, it is hidden.
	 */
	public void setVisible(boolean visible)
	{
		this.addVehicleFrame.setVisible(visible);
	}
	
	/**
	 * Disposes (deletes) the AddVehicleView window.
	 * @implNote Call this method when you are done with the window, no need to keep it around once the user is finished adding a vehicle.
	 */
	public void dispose()
	{
		this.addVehicleFrame.dispose();
	}
	
	/**
     * When this method is called, it creates listeners for every interactable in the view.
     * @param listener - The listener to be added to the objects.
     */
	public void createListeners(ActionListener listener)
	{
		this.btnAddVehicle.addActionListener(listener);
	}
	
	
	// ----------------------------------------
	// Vehicle Data Related Methods
	// ----------------------------------------
	
	/**
     * When called, this method will collect the user's input from each text field and return them as one Object[] array to be used
     * elsewhere for Vehicle creation. This method will validate the user's input to ensure fields are not empty and are of the right
     * type. If the method cannot validate, it will instead return null.
     * @return If validation is successful, an Object[] array containing the attributes to construct a Vehicle from. If unsuccessful,
     * this method will return null instead.
     * @implNote This method can possibly return null if input validation fails. The caller should be ready to handle null being returned.
     */
	public Object[] getNewVehicleAttributes()
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
				
				return new Object[] {strVIN, intYear, strMake, strModel, strColor, dblMileage, dblPrice};
			}
			catch (NumberFormatException numEx)
			{
				JOptionPane.showMessageDialog(this, "Year must be an integer. Mileage and price must be valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
				return null;
			}
		}
	}
}
