package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class VehiclesModel {
    private static final String DATABASE_URL = "jdbc:ucanaccess://" + System.getProperty("user.dir") + "//db//dealership.accdb";
    private Connection connection = null;

    public VehiclesModel() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connection = DriverManager.getConnection(DATABASE_URL);
            System.out.println("Database connected.");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Retrieves the vehicle records from the database after successful user authentication.
     *
     * @return a list of vehicles available in the system (or an empty list if no records are found)
     * @throws SQLException if a database access error occurs
     */


    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicleList = new ArrayList<>();
        String query = "SELECT ID, Make, Model FROM Vehicles";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String make = rs.getString("Make");
                String model = rs.getString("Model");

                Vehicle vehicle = new Vehicle(id, make, model);
                vehicleList.add(vehicle);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // or show a popup if needed
        }

        return vehicleList;
    }