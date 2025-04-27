package controllers;

import models.Vehicle;
import views.HomeView;
import views.UpdateVehicleDetailsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateVehicleDetailsController
{
    // Initialize variables
    private UpdateVehicleDetailsView view;
    private HomeView homeView;
    private Object[] updatedVehicleAttributes;

    // ----------------------------------------
	// Instantiate GUI
	// ----------------------------------------
    public UpdateVehicleDetailsController(HomeView homeView, Vehicle selectedVehicle)
    {
        // Set view properties
        this.homeView = homeView;
        view = new UpdateVehicleDetailsView(selectedVehicle);
        view.createListeners(new UpdateVehicleDetailsListener());

        view.setVisible(true);
    }

    // ----------------------------------------
	// Update Vehicle Listener Logic
	// ----------------------------------------
    class UpdateVehicleDetailsListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand())
            {
                // On button click
                case "Update Vehicle Details":
                // Gathers user data
                updatedVehicleAttributes = (view.getUpdatedVehicleAttributes());

                // Validates user data for null values and types
                if (updatedVehicleAttributes != null)
                {
                    // TODO: Update vehicle in database

                    // Close current view
                    view.dispose();

                    // Update home view table
                    homeView.updateVehicleInTable(new Vehicle(updatedVehicleAttributes));
                }
                break;
            }
        }
    }
}