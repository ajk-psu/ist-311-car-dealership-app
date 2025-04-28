
package models;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TicketModel {

    Connection connection;

    public TicketModel(Connection connection)
    {
        if (connection != null)
            this.connection = connection;
    }

    /**
     * Selects ticket data from database and returns for display.
     * @return An array list of type Ticket containing every row of the Ticket table.
     */
    public ArrayList<Ticket> getAllTickets() 
    {
        // Prep statement
        ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
        String query = "SELECT ID, VIN, Vehicle.Vehicle_Year, Vehicle.Make, Vehicle.Model, Description " +
                       "FROM Ticket INNER JOIN Vehicle ON VIN = Vehicle.VIN ORDER BY VIN ASC, Vehicle.Make ASC";

        // Attempt statement
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            // For each row selected...
            while (rs.next()) {
                // Group column results in an array
                Object[] ticketAttributes = {rs.getInt("ID"),
                                             rs.getString("VIN"),
                                             rs.getInt("Vehicle.Vehicle_Year"), 
                                             rs.getString("Vehicle.Make"), 
                                             rs.getString("Vehicle.Model"), 
                                             rs.getString("Description")};
                
                // Make ticket object and append to list
                ticketList.add(new Ticket(ticketAttributes));
            }
            // Return the finished list
            return ticketList;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return null; // Return null if no tickets are found and/or list cannot be made
    }

    /**
     * Commits finished ticket data to database upon program exit
     */
    public boolean updateAllTickets(ArrayList<Ticket> viewTable)
    {
        // Prep statement to clear previous save
        String query = "DELETE FROM Ticket";

        // Attempt to run
        try (PreparedStatement stmt = connection.prepareStatement(query))
        {
            stmt.executeUpdate();
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Failed Ticket Delete", JOptionPane.ERROR_MESSAGE);
        }

        // Once table is clear, insert values from Home View
        query = "INSERT INTO Ticket (ID, VIN, Description) VALUES (?, ?, ?)";
        int updatesComplete = 0;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {

            // Iterate through each vehicle in home table
            for (int i=0; i<viewTable.size();i++)
            {
                // Make vehicle object with current row's data
                Ticket v = viewTable.get(i);

                // Use vehicle's accessors to fill statement
                stmt.setInt(1, v.getTicketID());
                stmt.setString(2, v.getVIN());
                stmt.setString(3, v.getDescription());

                // Commit vehicle to database
                stmt.executeUpdate();
                updatesComplete += 1;

                // Return true if each vehicle updates
                if (updatesComplete == viewTable.size())
                    return true;
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Failed Ticket Insert", JOptionPane.ERROR_MESSAGE);
        }
        // Return false if error occurs or update fails
        return false;
    }
}