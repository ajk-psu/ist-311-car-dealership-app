package controllers;

import models.Vehicle;
import views.AddVehicleView;
import views.HomeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddVehicleController 
{
    // Initializes variables
    private AddVehicleView view;
    private HomeView homeView;
    private Object[] newVehicleAttributes;

    // ----------------------------------------
	// Instantiate GUI
	// ----------------------------------------
    public AddVehicleController(HomeView homeView)
    {
        // Set view properties
        this.homeView = homeView;
        view = new AddVehicleView();
        view.createListeners(new AddVehicleListener());

        view.setVisible(true);
    }

    // ----------------------------------------
	// Add Vehicle Listener Logic
	// ----------------------------------------
    class AddVehicleListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand())
            {
                // On button click
                case "Add Vehicle":
                    // Gathers user data
                    newVehicleAttributes = (view.getNewVehicleAttributes());

                    // Validates data - no null values accepted
                    if (newVehicleAttributes != null)
                    {
                        // TODO: Add vehicle in database

                        // Close current view
                        view.dispose();

                        // Updates home view table
                        homeView.addVehicleToTable(new Vehicle(newVehicleAttributes));
                    }
                    break;
            }
        }
    }
}