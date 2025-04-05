/*
 * Get the driver and path to the database so it is linked to this java program.
 */
package models;

import java.sql.*;

import javax.swing.JOptionPane;

public class AccountModel {
    private static final String DATABASE_URL = "jdbc:ucanaccess://ist-311-car-dealership-app/db/dealership.accdb";      //DEBUG
    private Connection connection = null;

    public AccountModel() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connection = DriverManager.getConnection(DATABASE_URL);
            System.out.println("Database connected.");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Authenticate user login by checking username and password.
     * @param username The entered username.
     * @param password The entered password.
     * @return true if credentials match, false otherwise.
     */
    public boolean authenticate(String username, String password) { return true; }         /*          DEBUG
        String query = "SELECT * FROM Account WHERE AccountName = ? AND AccountPassword = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // True if the login exists

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    } */

    /**
     * Retrieve EmployeeID after successful login.
     * @param username The entered username.
     * @param password The entered password.
     * @return EmployeeID if found, -1 if not found.
     */
    public int getEmployeeID(String username, String password) {
        String query = "SELECT EmployeeID FROM Account WHERE AccountName = ? AND AccountPassword = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("EmployeeID");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return -1; // Return -1 if no EmployeeID is found
    }

    /**
     * Close the database connection.
     */
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

   /* 
    * THIS IS FOR TESTING THE MODEL LOGIC! THE OFFICIAL
    * main logic for authentication should be handled in LoginController.java!!!!
    * 
    public static void main(String[] args) {
        // Testing the model logic
        AccountModel model = new AccountModel();
        
        String username = "admin";
        String password = "password123";

        if (model.authenticate(username, password)) {
            int empID = model.getEmployeeID(username, password);
            JOptionPane.showMessageDialog(null, "Login Successful! Employee ID: " + empID);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }

        // Close connection
        model.closeConnection();
    } */
}