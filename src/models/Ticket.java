package models;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Ticket.java
 * 
 * This class represents a simplified repair ticket for a car in the dealership system.
 * 
 * Responsibilities:
 * - Acts as a data model to store ticket information (ticketID, vin, year, make, model, description).
 * - Handles database operations for retrieving ticket data (used for populating the HomeView).
 * 
 * This class uses JDBC to connect to the Access database file (dealership.accdb).
 * It provides a method to fetch all tickets and convert them into Ticket objects for use in the GUI.
 * 
 * Expected Field Order in Object[] arrays:
 * { ticketID, vin, year, make, model, description }
 * 
 * Used by:
 * - Controller classes to retrieve ticket data for HomeView
 * - GUI classes to populate ticket tables
 */
public class Ticket 
{
    // -------------------
    // CLASS ATTRIBUTES
    // -------------------
    private int ticketID;
    private String vin;
    private int year;
    private String make;
    private String model;
    private String description;

    // Static Database Connection
    private static final String DATABASE_URL = "jdbc:ucanaccess://" + System.getProperty("user.dir") + "//db//dealership.accdb";
    private static Connection connection = null;

    // -------------------
    // CLASS CONSTRUCTORS
    // -------------------

    /**
     * Full constructor for manually creating a Ticket.
     */
    public Ticket(int ticketID, String vin, int year, String make, String model, String description)
    {
        this.ticketID = ticketID;
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.description = description;
    }

    /**
     * Constructor for creating a Ticket from an Object[] array.
     * Expected order: {ticketID, vin, year, make, model, description}
     */
    public Ticket(Object[] attributes)
    {
        if (attributes != null) 
        {
            this.ticketID = (int) attributes[0];
            this.vin = (String) attributes[1];
            this.year = (int) attributes[2];
            this.make = (String) attributes[3];
            this.model = (String) attributes[4];
            this.description = (String) attributes[5];
        }
    }

    // -------------------
    // ACCESSORS (GETTERS)
    // -------------------
    public int getTicketID() { return this.ticketID; }
    public String getVIN() { return this.vin; }
    public int getYear() { return this.year; }
    public String getMake() { return this.make; }
    public String getModel() { return this.model; }
    public String getDescription() { return this.description; }

    // -------------------
    // MUTATORS (SETTERS)
    // -------------------
    public void setTicketID(int ticketID) { this.ticketID = ticketID; }
    public void setVIN(String vin) { this.vin = vin; }
    public void setYear(int year) { this.year = year; }
    public void setMake(String make) { this.make = make; }
    public void setModel(String model) { this.model = model; }
    public void setDescription(String description) { this.description = description; }

    // -------------------
    // DATABASE METHODS
    // -------------------

    /**
     * Establishes the database connection if not already connected.
     */
    private static void connectToDatabase()
    {
        if (connection == null)
        {
            try
            {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                connection = DriverManager.getConnection(DATABASE_URL);
                System.out.println("Ticket: Database connected.");
            }
            catch (ClassNotFoundException | SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Retrieves all tickets from the database.
     * @return ArrayList of Ticket objects
     */
    public static ArrayList<Ticket> getAllTickets()
    {
        connectToDatabase(); // Ensure connection exists

        ArrayList<Ticket> ticketList = new ArrayList<>();
        String query = "SELECT TicketID, VIN, Year, Make, Model, Description FROM Ticket";

        try (PreparedStatement stmt = connection.prepareStatement(query))
        {
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                Object[] attributes = {
                    rs.getInt("TicketID"),
                    rs.getString("VIN"),
                    rs.getInt("Year"),
                    rs.getString("Make"),
                    rs.getString("Model"),
                    rs.getString("Description")
                };
                Ticket ticket = new Ticket(attributes);
                ticketList.add(ticket);
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

        return ticketList;
    }

    /**
     * Closes the database connection.
     */
    public static void closeConnection()
    {
        try
        {
            if (connection != null)
            {
                connection.close();
                System.out.println("Ticket: Database connection closed.");
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
/*
It holds ticket info (ticketID, VIN, year, make, model, description).
It connects to the database directly — no extra TicketModel needed.

You can load tickets by calling:
 * ArrayList<Ticket> tickets = Ticket.getAllTickets();
 
No dummy data needed anymore for tickets.
If needed, you can manually close the connection with:
	Ticket.closeConnection(); 
	*/

