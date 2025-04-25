package controllers;

import views.HomeView;
import models.AccountModel;
import models.Vehicle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomeController 
{
    private HomeView view;
    private int employeeID;
    private String employeeName;
    private ArrayList<Vehicle> vehicleTableContents = new ArrayList<Vehicle>();

    public HomeController(AccountModel model, String username, String password)
    {
        // Gather employee data from AccountModel
        employeeID = model.getEmployeeID(username, password);
        employeeName = model.getEmployeeName(employeeID);

        // Create GUI from HomeView
        view = new HomeView();
        view.createListeners(new HomeListener());
        view.updateWelcomeMessage(employeeName);
        populateVehicleTable();

        view.setVisible(true);
    }
    /*
     *  will run model method to query database and pass resulting array to the view
     */
    private void populateVehicleTable()
    {
        // Debug only, will use model data
        vehicleTableContents.add(new Vehicle("9X3T4Y6Z8W1A2B5C7", "Toyota", "Camry", 2021, "Red", 34215.5, 23499.99));
        vehicleTableContents.add(new Vehicle("J4K8M1P0S3R6T9V2Z", "Honda", "Accord", 2019, "Black", 58703.2, 19950.50));
        view.updateEntireVehicleTable(vehicleTableContents);
    }

    class HomeListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand())
            {
                case "Select Vehicle":
                    if (view.getSelectedVehicleFromTable() != null) // Prevents null argument in constructor
                        new VehicleDetailsController(view, view.getSelectedVehicleFromTable());
                    break;
                case "Add Vehicle":
                    new AddVehicleController(view);
                    break;
            }
        }
    }
}