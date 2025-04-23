package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import models.Vehicle;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.BorderLayout;

public class VehicleDetailsView extends JFrame 
{
	private JFrame vehicleDetailsViewFrame;
	private JPanel mainPane;
	
	private JButton btnEditVehicle;
	private JButton btnRemoveVehicle;
	
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
	 * Constructs the VehicleDetailsView window when called. This window needs to have a Vehicle passed to it to parse information from.
	 * @param selectedVehicle - Vehicle - The Vehicle object to inspect the details of.
	 */
	public VehicleDetailsView(Vehicle selectedVehicle) 
	{	
		// General Window Properties
		vehicleDetailsViewFrame = new JFrame("Vehicle Details");
		vehicleDetailsViewFrame.setResizable(false);
		vehicleDetailsViewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		vehicleDetailsViewFrame.setBounds(100, 100, 380, 410);
		
		// homePane Properties
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPane.setLayout(null);
		vehicleDetailsViewFrame.setContentPane(mainPane);
		
		
		// btnEditVehicle Properties
		btnEditVehicle = new JButton("Edit Vehicle");
		btnEditVehicle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEditVehicle.setBounds(10, 323, 129, 41);
		mainPane.add(btnEditVehicle);
		
		// btnRemoveVehicle Properties
		btnRemoveVehicle = new JButton("Remove Vehicle");
		btnRemoveVehicle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRemoveVehicle.setBounds(225, 323, 129, 41);
		mainPane.add(btnRemoveVehicle);
		
		
		// txtVINProperties
		txtVIN = new JTextField(selectedVehicle.getVIN());
		txtVIN.setEditable(false);
		txtVIN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtVIN.setColumns(10);
		txtVIN.setBounds(124, 36, 230, 30);
		mainPane.add(txtVIN);
		
		// txtMake Properties
		txtMake = new JTextField(selectedVehicle.getMake());
		txtMake.setEditable(false);
		txtMake.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMake.setBounds(124, 77, 230, 30);
		mainPane.add(txtMake);
		txtMake.setColumns(10);
		
		// txtModel Properties
		txtModel = new JTextField(selectedVehicle.getModel());
		txtModel.setEditable(false);
		txtModel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtModel.setColumns(10);
		txtModel.setBounds(124, 118, 230, 30);
		mainPane.add(txtModel);
		
		// txtYear Properties
		txtYear = new JTextField(Integer.toString(selectedVehicle.getYear()));
		txtYear.setEditable(false);
		txtYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtYear.setColumns(10);
		txtYear.setBounds(124, 159, 230, 30);
		mainPane.add(txtYear);
		
		// txtColor Properties
		txtColor = new JTextField(selectedVehicle.getColor());
		txtColor.setEditable(false);
		txtColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtColor.setColumns(10);
		txtColor.setBounds(124, 200, 230, 30);
		mainPane.add(txtColor);
		
		// txtMileage Properties
		txtMileage = new JTextField(Double.toString(selectedVehicle.getMileage()));
		txtMileage.setEditable(false);
		txtMileage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMileage.setColumns(10);
		txtMileage.setBounds(124, 241, 230, 30);
		mainPane.add(txtMileage);
		
		// txtPrice Properties
		txtPrice = new JTextField(Double.toString(selectedVehicle.getPrice()));
		txtPrice.setEditable(false);
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPrice.setColumns(10);
		txtPrice.setBounds(124, 282, 230, 30);
		mainPane.add(txtPrice);
		
		
		// lblTitle Properties
		JLabel lblTitle = new JLabel("Showing detailed vehicle information:");
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
		this.vehicleDetailsViewFrame.setVisible(visible);
	}
	
	/**
	 * Disposes (deletes) the VehicleDetailsView window.
	 * @implNote Call this method when you are done with the window.
	 */
	public void dispose()
	{
		this.vehicleDetailsViewFrame.dispose();
	}
	
	/**
     * When this method is called, it creates listeners for every interactable in the view.
     * @param listener - The listener to be added to the objects.
     */
	public void createListeners(ActionListener listener)
	{
		this.btnEditVehicle.addActionListener(listener);
		this.btnRemoveVehicle.addActionListener(listener);
	}
}
