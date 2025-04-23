package models;

public class Vehicle 
{
	// -------------------
	// CLASS ATTRIBUTES
	// -------------------
	private String strVIN;
	private String strMake;
	private String strModel;
	private String strColor;
	
	private int intYear;
	
	private double dblMileage;
	private double dblPrice;
	
	
	// -------------------
	// CLASS CONSTRUCTORS
	// -------------------
	public Vehicle(String VIN, String make, String model, int year, String color, double mileage, double price)
	{
		this.strVIN = VIN;
		this.strMake = make;
		this.strModel = model;
		this.intYear = year;
		this.strColor = color;
		this.dblMileage = mileage;
		this.dblPrice = price;
	}
	
	public Vehicle(Object[] attributes)
	{
		// It's possible that some methods in this program return null. This should be handled before calling this method,
		// but in the case it wasn't this if will act as a final check to stop the program from using a null value.
		if (attributes != null) 
		{
			this.strVIN = (String) attributes[0];
			this.strMake = (String) attributes[1];
			this.strModel = (String) attributes[2];
			this.intYear = (int) attributes[3];
			this.strColor = (String) attributes[4];
			this.dblMileage = (double) attributes[5];
			this.dblPrice = (double) attributes[6];
		}
		else
		{
			// If the array is null, do nothing.
			return;
		}
	}
	
	
	// -------------------
	// ACCESORS
	// -------------------
	
	/**
     * When called, returns the vehicle identification number (VIN) attribute of a Vehicle.
     * @return A String containing a Vehicle's VIN.
     */
	public String getVIN()
	{
		return this.strVIN;
	}
	
	/**
     * When called, returns the make (manufacturer) attribute of a Vehicle.
     * @return A String containing a Vehicle's make.
     */
	public String getMake()
	{
		return this.strMake;
	}
	
	/**
     * When called, returns the model attribute of a Vehicle.
     * @return A String containing a Vehicle's model.
     */
	public String getModel()
	{
		return this.strModel;
	}
	
	/**
     * When called, returns the production year attribute of a Vehicle.
     * @return A int containing a Vehicle's production year.
     */
	public int getYear()
	{
		return this.intYear;
	}
	
	/**
     * When called, returns the color attribute of a Vehicle.
     * @return A String containing a Vehicle's color.
     */
	public String getColor()
	{
		return this.strColor;
	}
	
	/**
     * When called, returns the mileage attribute of a Vehicle.
     * @return A double containing a Vehicle's mileage.
     */
	public double getMileage()
	{
		return this.dblMileage;
	}
	
	/**
     * When called, returns the price attribute of a Vehicle (in US dollars).
     * @return A double containing a Vehicle's sale price.
     */
	public double getPrice()
	{
		return this.dblPrice;
	}
	
	
	// -------------------
	// MUTATORS
	// -------------------
	
	/**
     * Sets all of a Vehicle's objects attributes to that of the given Object[] array.
     * @param newAttributes - Object[] - An Object[] array containing the 7 attributes of Vehicle objects. This array must be
     * in the proper order for this method to work (VIN, Make, Model, Year, Color, Mileage, Price).
     */
	public void setEverything(Object[] newAttributes)
	{
		// It's possible that some methods in this program return null. This should be handled before calling this method,
		// but in the case it wasn't this if will act as a final check to stop the program from using a null value.
		if (newAttributes != null) 
		{
			this.strVIN = (String) newAttributes[0];
			this.strMake = (String) newAttributes[1];
			this.strModel = (String) newAttributes[2];
			this.intYear = (int) newAttributes[3];
			this.strColor = (String) newAttributes[4];
			this.dblMileage = (double) newAttributes[5];
			this.dblPrice = (double) newAttributes[6];
		}
		else
		{
			// If the array is null, do nothing.
			return;
		}
	}
	
	/**
     * Sets a Vehicle object's VIN attribute to the given VIN.
     * @param newVIN - String - A String containing the new VIN value to change the Vehicle's VIN attribute to.
     */
	public void setVIN(String newVIN)
	{
		this.strVIN = newVIN;
	}
	
	/**
     * Sets a Vehicle object's make (manufacturer) attribute to the given make.
     * @param newMake - String - A String containing the new make value to change the Vehicle's make attribute to.
     */
	public void setMake(String newMake)
	{
		this.strMake = newMake;
	}
	
	/**
     * Sets a Vehicle object's model attribute to the given make.
     * @param newModel - String - A String containing the new model value to change the Vehicle's make attribute to.
     */
	public void setModel(String newModel)
	{
		this.strModel = newModel;
	}
	
	/**
     * Sets a Vehicle object's production year attribute to the given year.
     * @param newYear - int - An int containing the new production year value to change the Vehicle's year attribute to.
     */
	public void setYear(int newYear)
	{
		this.intYear = newYear;
	}
	
	/**
     * Sets a Vehicle object's color attribute to the given color.
     * @param newColor - String - A String containing the new color value to change the Vehicle's color attribute to.
     */
	public void setColor(String newColor)
	{
		this.strColor = newColor;
	}
	
	/**
     * Sets a Vehicle object's mileage attribute to the given mileage.
     * @param newMileage - double - A double containing the new mileage value to change the Vehicle's mileage attribute to.
     */
	public void setMileage(double newMileage)
	
	{
		this.dblMileage = newMileage;
	}
	
	/**
     * Sets a Vehicle object's price attribute to the given price (in US dollars).
     * @param newPrice - double - A double containing the new price value to change the Vehicle's mileage attribute to.
     */
	public void setPrice(double newPrice)
	{
		this.dblPrice = newPrice;
	}
	
}
