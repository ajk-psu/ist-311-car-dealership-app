
package models;

import java.sql.*;

import javax.swing.JOptionPane;

public class AccountModel {

    Connection connection;

    public AccountModel(Connection connection)
    {
        if (connection != null)
            this.connection = connection;
    }

    /**
     * Authenticate user login by checking username and password.
     * @param username The entered username.
     * @param password The entered password.
     * @return true if credentials match, false otherwise.
     */
    public boolean authenticate(String username, String password) {
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
    }

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
     * Retrieve employee first and last name after successful login.
     * @param id The employee id gained from authentication.
     * @return "FirstName LastName" if found, null if not found.
     */
    public String getEmployeeName(int id) {
        String query = "SELECT FirstName, LastName FROM Employee WHERE EmployeeID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("FirstName") + " " + rs.getString("LastName");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return null; // Return null if no employee name is found
    }
}