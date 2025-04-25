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
    private AccountModel model;
    private int employeeID;
    private String employeeName;
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    // For debug only
    private Object[] VEHICLE_1 = {"9X3T4Y6Z8W1A2B5C7", "Toyota", "Camry", 2021, "Red", 34215.5, 23499.99};
    private Object[] VEHICLE_2 = {"J4K8M1P0S3R6T9V2Z", "Honda", "Accord", 2019, "Black", 58703.2, 19950.50};


    public HomeController(AccountModel model, String username, String password)
    {
        // Instantiate model
        this.model = model;

        // Gather employee data from AccountModel
        employeeID = model.getEmployeeID(username, password);
        employeeName = model.getEmployeeName(employeeID);

        // Create GUI from HomeView
        view = new HomeView();
        view.createListeners(new HomeListener());
        view.updateWelcomeMessage(employeeName);
        backfillTable(); // For debug only

        view.setVisible(true);
    }

    private void backfillTable()
    {
        vehicles.add(new Vehicle(VEHICLE_1));
        vehicles.add(new Vehicle(VEHICLE_2));
        view.updateEntireVehicleTable(vehicles);
    }
}

    class HomeListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand())
            {
                case "Select Vehicle":
                // call show details view
                break;
                case "Add Vehicle":
                // call add details view
                break;
            }
        }
    }