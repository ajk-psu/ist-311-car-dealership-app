package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBConnection {

    // Initialize class variables
    private static final String DATABASE_URL = "jdbc:ucanaccess://" + System.getProperty("user.dir") + "//db//dealership.accdb";
    private Connection connection;

    /**
     * Get the driver and path to the database so it is linked to this java program.
     */

    public DBConnection() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connection = DriverManager.getConnection(DATABASE_URL);
            System.out.println("Database connected.");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method will return the database connection. If none exists, it will return null.
     * @return The database connection for constructing other models, null if none exists.
     */
    public Connection getConnection()
    {
        if (connection != null)
            return connection;
        else
            return null;
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
}
