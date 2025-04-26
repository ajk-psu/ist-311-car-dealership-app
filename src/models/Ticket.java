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
