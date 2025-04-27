package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import models.AccountModel;
import models.DBConnection;
import models.VehicleModel;
import views.HomeView;

public class HomeController 
{
    // Initialize variables
    private HomeView view;
    private VehicleModel vehicleModel;
    private DBConnection dbConnection;
    private int employeeID;
    private String employeeName;

    // ----------------------------------------
	// Instantiate GUI
	// ----------------------------------------
    public HomeController(DBConnection dbConnection, AccountModel accountModel, String username, String password)
    {
        // Localize db connection for window listener use
        this.dbConnection = dbConnection;

        // Instantiate vehicle model
        vehicleModel = new VehicleModel(dbConnection.getConnection());

        // Gather employee data from AccountModel
        employeeID = accountModel.getEmployeeID(username, password);
        employeeName = accountModel.getEmployeeName(employeeID);

        // Set view properties
        view = new HomeView();
        view.createListeners(new HomeListener(), new HomeCloseListener());
        view.updateWelcomeMessage(employeeName);
        view.updateEntireVehicleTable(vehicleModel.getAllVehicles());

        view.setVisible(true);
    }

    // ----------------------------------------
	// Home View Listener Logic
	// ----------------------------------------
    class HomeListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand())
            {
                // On button click
                case "Select Vehicle":
                    // Checks user input for null values, only accepts complete data
                    if (view.getSelectedVehicleFromTable() != null)

                        // Instantiates vehicle details controller
                        new VehicleDetailsController(view, view.getSelectedVehicleFromTable());
                    break;

                // On button click
                case "Add Vehicle":
                    // Instantiates add vehicle controller
                    new AddVehicleController(view);
                    break;
            }
        }
    }

    // ----------------------------------------
	// Window Listener Logic
	// ----------------------------------------
    class HomeCloseListener extends WindowAdapter
    {
        @Override
        // When window is closed
        public void windowClosing(WindowEvent e) {
            switch (view.showCloseDialogue())
            {
                // User saves changes
                case 1:
                    // Commit vehicle edits to database
                    if (vehicleModel.updateAllVehicles(view.exportVehicleDataFromTable()))
                    {
                        // Sever connection and close program
                        dbConnection.closeConnection();
                        view.dispose();
                        System.exit(0);
                    }
                    break;

                // User closes without saving
                case 0:
                    // Sever connection and close program
                    dbConnection.closeConnection();
                    view.dispose();
                    System.exit(0);
                    break;

                // User clicks elsewhere
                case -1:
                    break;
            }
        }
    }
}