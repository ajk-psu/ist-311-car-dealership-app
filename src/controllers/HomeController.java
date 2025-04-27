package controllers;

import views.HomeView;
import models.AccountModel;
import models.Vehicle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class HomeController 
{
    // Initialize variables
    private HomeView view;
    private AccountModel model;
    private int employeeID;
    private String employeeName;
    private ArrayList<Vehicle> vehicleTableContents;

    // Create stock data
    // (For debug only, will be replaced with methods from model)
    private Object[] VEHICLE_1 = {"9X3T4Y6Z8W1A2B5C7", "Toyota", "Camry", 2021, "Red", 34215.5, 23499.99};
    private Object[] VEHICLE_2 = {"J4K8M1P0S3R6T9V2Z", "Honda", "Accord", 2019, "Black", 58703.2, 19950.50};
    private Object[] VEHICLE_3 = {"D5F7H2J9K4L0N3P1R", "Ford", "Mustang", 2022, "Blue", 1234.0, 28999.00};
    private Object[] VEHICLE_4 = {"H2G8Q5W3Z1X6C4V7B", "Chevrolet", "Silverado", 2020, "White", 45000.75, 34900.25};
    private Object[] VEHICLE_5 = {"Z4V7C1X8B3N6M2L5K", "Nissan", "Altima", 2018, "Silver", 30250.4, 17999.95};

    // ----------------------------------------
	// Instantiate GUI
	// ----------------------------------------
    public HomeController(AccountModel model, String username, String password)
    {
        // Localize model for listener use
        this.model = model;

        // Gather employee data from AccountModel
        employeeID = model.getEmployeeID(username, password);
        employeeName = model.getEmployeeName(employeeID);

        // Set view properties
        view = new HomeView();
        view.createListeners(new HomeListener(), new HomeCloseListener());
        view.updateWelcomeMessage(employeeName);
        populateVehicleTable();

        view.setVisible(true);
    }

    /*
     * Populates the vehicle table on instantiation of the home view
     */
    private void populateVehicleTable()
    {
        // Instantiate and fill array list
        vehicleTableContents = new ArrayList<Vehicle>();
        vehicleTableContents.add(new Vehicle(VEHICLE_1));
        vehicleTableContents.add(new Vehicle(VEHICLE_2));
        vehicleTableContents.add(new Vehicle(VEHICLE_3));
        vehicleTableContents.add(new Vehicle(VEHICLE_4));
        vehicleTableContents.add(new Vehicle(VEHICLE_5));

        // Update table in view
        view.updateEntireVehicleTable(vehicleTableContents);
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

    class HomeCloseListener extends WindowAdapter
    {
        @Override
        public void windowClosed(WindowEvent e) {
            model.closeConnection();
            System.exit(0);
        }
    }
}