package models;

public class Ticket 
{
	private int intTicketID;
	private String strVIN;
	private int intYear;
	private String strMake;
	private String strModel;
	private String strDescription;
	
	
	// -------------------
	// CLASS CONSTRUCTORS
	// -------------------
	
	public Ticket (int ticketID, String VIN, int year, String make, String model, String description)
	{
		this.intTicketID = ticketID;
		this.strVIN = VIN;
		this.intYear = year;
		this.strMake = make;
		this.strModel = model;
		this.strDescription = description;
	}
	
	// Alternative constructor in cases you might want to pass a Vehicle object directly.
	public Ticket (int ticketID, Vehicle problemVehicle, String description)
	{
		this.intTicketID = ticketID;
		this.strDescription = description;
		
		// Get vehicle information from the Vehicle object.
		this.intYear = problemVehicle.getYear();
		this.strVIN = problemVehicle.getVIN();
		this.strMake = problemVehicle.getMake();
		this.strModel = problemVehicle.getModel();
	}
	
	// Alternative constructor in cases you might want to use an Object[] array of Ticket details.
	public Ticket (Object attributes[])
	{
		if (attributes != null)
		{
			this.intTicketID = (int) attributes[0];
			this.strVIN = (String) attributes[1];
			this.intYear = (int) attributes[2];
			this.strMake = (String) attributes[3];
			this.strModel = (String) attributes[4];
			this.strDescription = (String) attributes[5];
		}
		else
		{
			return;
		}
		
	}
	
	// -------------------
	// ACCESORS
	// -------------------
	
	/**
     * When called, returns the ticket ID attribute of a Ticket.
     * @return An integer containing a Ticket's ID.
     */
	public int getTicketID()
	{
		return this.intTicketID;
	}
	
	
	/**
     * When called, returns the VIN attribute of a Ticket.
     * @return A String containing the VIN of the Vehicle the Ticket is about.
     */
	public String getVIN()
	{
		return this.strVIN;
	}
	
	/**
     * When called, returns the production year attribute of a Ticket.
     * @return An integer containing the production year of the Vehicle the Ticket is about.
     */
	public int getYear()
	{
		return this.intYear;
	}
	
	/**
     * When called, returns the make (manufacturer) attribute of a Ticket.
     * @return A String containing the make (manufacturer) of the Vehicle the Ticket is about.
     */
	public String getMake()
	{
		return this.strMake;
	}
	
	/**
     * When called, returns the model attribute of a Ticket.
     * @return A String containing the model of the Vehicle the Ticket is about.
     */
	public String getModel()
	{
		return this.strModel;
	}
	
	/**
     * When called, returns the description attribute of a Ticket.
     * @return A String containing a description of the problem of the Vehicle the Ticket is about.
     */
	public String getDescription()
	{
		return this.strDescription;
	}
	
	
	// -------------------
	// MUTATORS
	// -------------------
	
	/**
     * Sets a Ticket's Ticket ID attribute to the given ID.
     * @param newTicketAttributes - Object[] - An Object[] array containing the new attributes to change a Ticket's attributes to. 
     * This array must be in the proper order (Ticket ID, VIN, Year, Make, Model, Description) in order for this method to work.
     */
	public void setEverything(Object[] newTicketAttributes)
	{
		// It's possible that some methods in this program return null. This should be handled before calling this method,
		// but in the case it wasn't this if will act as a final check to stop the program from using a null value.
		if (newTicketAttributes != null)
		{
			this.intTicketID = (int) newTicketAttributes[0];
			this.strVIN = (String) newTicketAttributes[1];
			this.intYear = (int) newTicketAttributes[2];
			this.strMake = (String) newTicketAttributes[3];
			this.strModel = (String) newTicketAttributes[4];
			this.strDescription = (String) newTicketAttributes[5];
		}
		else
		{
			// If the array is null, do nothing.
			return;
		}
	}
	
	/**
     * Sets a Ticket's Ticket ID attribute to the given ID.
     * @param newTicketID - int - An integer containing the new ticket ID value to change the Ticket's TicketID attribute to.
     */
	public void setTicketID(int newTicketID)
	{
		this.intTicketID = newTicketID;
	}
	
	/**
     * Sets a Ticket object's VIN attribute to the given VIN.
     * @param newVIN - String - A String containing the new VIN value to change the Ticket's VIN attribute to.
     */
	public void setVIN(String newVIN)
	{
		this.strVIN = newVIN;
	}
	
	/**
     * Sets a Ticket object's production year attribute to the given year.
     * @param newYear - int - An int containing the new production year value to change the Ticket's year attribute to.
     */
	public void setYear(int newYear)
	{
		this.intYear = newYear;
	}
	
	/**
     * Sets a Vehicle object's make (manufacturer) attribute to the given make.
     * @param newMake - String - A String containing the new make value to change the Ticket's make attribute to.
     */
	public void setMake(String newMake)
	{
		this.strMake = newMake;
	}
	
	/**
     * Sets a Vehicle object's model attribute to the given model.
     * @param newModel - String - A String containing the new model value to change the Ticket's make attribute to.
     */
	public void setModel(String newModel)
	{
		this.strModel = newModel;
	}
	
	/**
     * Sets a Ticket object's problem description attribute to the given description.
     * @param newDescription - String - A String containing the the description of the problem to change the Ticket's description attribute to.
     */
	public void setDescription(String newDescription)
	{
		this.strDescription = newDescription;
	}
}
