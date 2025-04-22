package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.BorderLayout;

public class AddVehicleView extends JFrame 
{
	
	private JFrame addVehicleFrame;
	private JPanel mainPane;
	private JButton btnAddVehicle;
	private JTextField txtMake;
	private JTextField txtModel;
	private JTextField txtYear;
	private JTextField txtColor;
	private JTextField txtMileage;
	private JTextField txtPrice;
	private JTextField txtPurchaseDate;
	private JTextField txtSaleDate;
	private JTextField txtVehicleID;
	
	public AddVehicleView() 
	{	
		// General Window Properties
		addVehicleFrame = new JFrame("Add Vehicle");
		addVehicleFrame.setResizable(false);
		addVehicleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addVehicleFrame.setBounds(100, 100, 380, 500);
		
		// homePane Properties
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPane.setLayout(null);
		addVehicleFrame.setContentPane(mainPane);
		
		// lblWelcome Properties
		JLabel lblWelcome = new JLabel("Please enter new vehicle details below.");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblWelcome.setBounds(10, 11, 344, 14);
		mainPane.add(lblWelcome);
		
		// txtMake Properties
		txtMake = new JTextField();
		txtMake.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMake.setBounds(124, 77, 230, 30);
		mainPane.add(txtMake);
		txtMake.setColumns(10);
		
		// txtMake Properties
		txtModel = new JTextField();
		txtModel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtModel.setColumns(10);
		txtModel.setBounds(124, 118, 230, 30);
		mainPane.add(txtModel);
		
		
		// txtMake Properties
		txtYear = new JTextField();
		txtYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtYear.setColumns(10);
		txtYear.setBounds(124, 159, 230, 30);
		mainPane.add(txtYear);
		
		
		// txtMake Properties
		txtColor = new JTextField();
		txtColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtColor.setColumns(10);
		txtColor.setBounds(124, 200, 230, 30);
		mainPane.add(txtColor);
		
		// txtMake Properties
		txtMileage = new JTextField();
		txtMileage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMileage.setColumns(10);
		txtMileage.setBounds(124, 241, 230, 30);
		mainPane.add(txtMileage);
		
		// txtMake Properties
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPrice.setColumns(10);
		txtPrice.setBounds(124, 282, 230, 30);
		mainPane.add(txtPrice);
		
		// txtMake Properties
		txtPurchaseDate = new JTextField();
		txtPurchaseDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPurchaseDate.setColumns(10);
		txtPurchaseDate.setBounds(124, 323, 230, 30);
		mainPane.add(txtPurchaseDate);
		
		// txtMake Properties
		txtSaleDate = new JTextField();
		txtSaleDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSaleDate.setColumns(10);
		txtSaleDate.setBounds(124, 364, 230, 30);
		mainPane.add(txtSaleDate);
		
		// txtMake Properties
		JLabel lblMake = new JLabel("Make");
		lblMake.setHorizontalAlignment(SwingConstants.LEFT);
		lblMake.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMake.setBounds(10, 84, 79, 14);
		mainPane.add(lblMake);
		
		// txtMake Properties
		JLabel lblModel = new JLabel("Model");
		lblModel.setHorizontalAlignment(SwingConstants.LEFT);
		lblModel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModel.setBounds(10, 126, 79, 14);
		mainPane.add(lblModel);
		
		// txtMake Properties
		JLabel lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblYear.setBounds(10, 167, 79, 14);
		mainPane.add(lblYear);
		
		// txtMake Properties
		JLabel lblColor = new JLabel("Color");
		lblColor.setHorizontalAlignment(SwingConstants.LEFT);
		lblColor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblColor.setBounds(10, 208, 79, 14);
		mainPane.add(lblColor);
		
		// txtMake Properties
		JLabel lblMileage = new JLabel("Mileage");
		lblMileage.setHorizontalAlignment(SwingConstants.LEFT);
		lblMileage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMileage.setBounds(10, 249, 79, 14);
		mainPane.add(lblMileage);
		
		// txtMake Properties
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrice.setBounds(10, 290, 79, 14);
		mainPane.add(lblPrice);
		
		// txtMake Properties
		JLabel lblPurchase = new JLabel("Purchase Date");
		lblPurchase.setHorizontalAlignment(SwingConstants.LEFT);
		lblPurchase.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPurchase.setBounds(10, 331, 94, 14);
		mainPane.add(lblPurchase);
		
		// txtMake Properties
		JLabel lblSellDate = new JLabel("Sale Date");
		lblSellDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblSellDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSellDate.setBounds(10, 372, 79, 14);
		mainPane.add(lblSellDate);
		
		// txtMake Properties
		btnAddVehicle = new JButton("Add Vehicle");
		btnAddVehicle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddVehicle.setBounds(108, 413, 129, 41);
		mainPane.add(btnAddVehicle);
		
		JLabel lblID = new JLabel("Vehicle ID");
		lblID.setHorizontalAlignment(SwingConstants.LEFT);
		lblID.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblID.setBounds(10, 43, 79, 14);
		mainPane.add(lblID);
		
		txtVehicleID = new JTextField();
		txtVehicleID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtVehicleID.setColumns(10);
		txtVehicleID.setBounds(124, 36, 230, 30);
		mainPane.add(txtVehicleID);
	}
	
	// View Methods for the Controller
	public void setVisible(boolean visible)
	{
		addVehicleFrame.setVisible(visible);
	}
	
	public void createListeners(ActionListener listener)
	{
		btnAddVehicle.addActionListener(listener);
	}
	
	public Object[] getAllData()
	{
		Object[] newVehicleData = null;
		return newVehicleData;
	}
	
	public String getTxtVehicleID()
	{
		String strVehicleID = this.txtVehicleID.getText().trim();
		
		if(strVehicleID.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Vehicle make was left empty. Value will be entered as 'Unknown'.", "Input Warning", JOptionPane.WARNING_MESSAGE);
			return "Unknown";
		}
		else
		{
			return strVehicleID;
		}
	}
	
	
	public String getTxtMake()
	{
		String strMake = this.txtMake.getText().trim();
		
		if(strMake.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Vehicle make was left empty. Value will be entered as 'Unknown'.", "Input Warning", JOptionPane.WARNING_MESSAGE);
			return "Unknown";
		}
		else
		{
			return strMake;
		}
	}
	
	public String getTxtModel()
	{
		String strModel = this.txtModel.getText().trim();
		
		if(strModel.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Vehicle model was left empty. Value will be entered as 'Unknown'.", "Input Warning", JOptionPane.WARNING_MESSAGE);
			return "Unknown";
		}
		else
		{
			return strModel;
		}
	}
	
	public String getTxtYear()
	{
		String strYear = this.txtModel.getText().trim();
		
		if(strYear.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Vehicle year was left empty. Value will be entered as 'Unknown'.", "Input Warning", JOptionPane.WARNING_MESSAGE);
			return "Unknown";
		}
		else
		{
			return strYear;
		}
	}
	
	public String getTxtColor()
	{
		String strColor = this.txtModel.getText().trim();
		
		if(strColor.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Vehicle color was left empty. Value will be entered as 'Unknown'.", "Input Warning", JOptionPane.WARNING_MESSAGE);
			return "Unknown";
		}
		else
		{
			return strColor;
		}
	}
	
	public String getTxtMileage()
	{
		String strMileage = this.txtModel.getText().trim();
		
		if(strMileage.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Vehicle mileage was left empty. Value will be entered as 'Unknown'.", "Input Warning", JOptionPane.WARNING_MESSAGE);
			return "Unknown";
		}
		else
		{
			return strMileage;
		}
	}
	
	public String getTxtPrice()
	{
		String strPrice = this.txtModel.getText().trim();
		
		if(strPrice.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Vehicle price was left empty. Value will be entered as 'Unknown'.", "Input Warning", JOptionPane.WARNING_MESSAGE);
			return "Unknown";
		}
		else
		{
			return strPrice;
		}
	}
	
	public String getTxtPurchaseDate()
	{
		String strPurchaseDate = this.txtModel.getText().trim();
		
		if(strPurchaseDate.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Vehicle purchase date was left empty. Value will be entered as 'Unknown'.", "Input Warning", JOptionPane.WARNING_MESSAGE);
			return "Unknown";
		}
		else
		{
			return strPurchaseDate;
		}
	}
	
	public String getTxtSaleDate()
	{
		String strSaleDate = this.txtModel.getText().trim();
		
		if(strSaleDate.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Vehicle sale date was left empty. Value will be entered as 'Unknown'.", "Input Warning", JOptionPane.WARNING_MESSAGE);
			return "Unknown";
		}
		else
		{
			return strSaleDate;
		}
	}
}
