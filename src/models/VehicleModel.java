package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class VehicleModel 
{
    Connection connection;

    public VehicleModel(Connection connection)
    {
        if (connection != null)
            this.connection = connection;
    }

    /**
     * Selects vehicle data from database and returns for display.
     * @return An array list of type Vehicle containing every row of the Vehicle table.
     */
    public ArrayList<Vehicle> getAllVehicles() 
    {
        // Prep statement
        ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
        String query = "SELECT VIN, Make, Model, Vehicle_Year, Color, Mileage, Price FROM Vehicle ORDER BY Make ASC";

        // Attempt statement
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            // For each row selected...
            while (rs.next()) {
                // Group column results in an array
                Object[] vehicleAttributes = {rs.getString("VIN"),
                                              rs.getString("Make"), 
                                              rs.getString("Model"), 
                                              rs.getInt("Vehicle_Year"), 
                                              rs.getString("Color"), 
                                              rs.getDouble("Mileage"), 
                                              rs.getDouble("Price")};
                
                // Make vehicle object and append to list
                vehicleList.add(new Vehicle(vehicleAttributes));
            }
            // Return the finished list
            return vehicleList;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return null; // Return null if no vehicles are found and/or list cannot be made

    }

    /**
     * Commits finished vehicle data to database upon program exit
     */
    public boolean updateAllVehicles(ArrayList<Vehicle> viewTable)
    {
        // Prep statement to clear previous save
        String query = "DELETE FROM Vehicle";

        // Attempt to run
        try (PreparedStatement stmt = connection.prepareStatement(query))
        {
            stmt.executeUpdate();
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Failed Vehicle Delete", JOptionPane.ERROR_MESSAGE);
        }

        // Once table is clear, insert values from Home View
        query = "INSERT INTO Vehicle (VIN, Make, Model, Vehicle_Year, Color, Mileage, Price) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int updatesComplete = 0;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {

            // Iterate through each vehicle in home table
            for (int i=0; i<viewTable.size();i++)
            {
                // Make vehicle object with current row's data
                Vehicle v = viewTable.get(i);

                // Use vehicle's accessors to fill statement
                stmt.setString(1, v.getVIN());
                stmt.setString(2, v.getMake());
                stmt.setString(3, v.getModel());
                stmt.setInt(4, v.getYear());
                stmt.setString(5, v.getColor());
                stmt.setDouble(6, v.getMileage());
                stmt.setDouble(7, v.getPrice());

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
            JOptionPane.showMessageDialog(null, e.getMessage(), "Failed Vehicle Insert", JOptionPane.ERROR_MESSAGE);
        }
        // Return false if error occurs or update fails
        return false;
    }
}
