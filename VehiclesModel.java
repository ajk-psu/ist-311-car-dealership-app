	/**
     * Retrieves the vehicle records from the database after successful user authentication.
     *
     * @return a list of vehicles available in the system (or an empty list if no records are found)
     * @throws SQLException if a database access error occurs
     */

package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class VehiclesModel {
    private static final String DATABASE_URL = "jdbc:ucanaccess://" + System.getProperty("user.dir") + "//db//dealership.accdb";
    private Connection connection = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public VehiclesModel() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connection = DriverManager.getConnection(DATABASE_URL);
            System.out.println("Database connected.");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicleList = new ArrayList<>();
        String query = "SELECT ID, Make, Model FROM Vehicles";

        try {
            stmt = connection.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String make = rs.getString("Make");
                String model = rs.getString("Model");

                Vehicle vehicle = new Vehicle(id, make, model); // assuming this class exists
                vehicleList.add(vehicle);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicleList;
    }

    // Add this to clean up after you're done using the object
    public void close() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Closing Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    }