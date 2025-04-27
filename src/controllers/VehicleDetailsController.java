package controllers;

import models.Vehicle;
import views.HomeView;
import views.VehicleDetailsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehicleDetailsController
{
    // Initialize variables
    private Vehicle selectedVehicle;
    private VehicleDetailsView view;
    private HomeView homeView;

    // ----------------------------------------
	// Instantiate GUI
	// ----------------------------------------
    public VehicleDetailsController(HomeView homeView, Vehicle selectedVehicle)
    {
        // Set view properties
        this.homeView = homeView;
        this.selectedVehicle = selectedVehicle;
        view = new VehicleDetailsView(selectedVehicle);
        view.createListeners(new VehicleDetailsListener());

        view.setVisible(true);
    }

    // ----------------------------------------
	// Vehicle Details Listener Logic
	// ----------------------------------------
    class VehicleDetailsListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand())
            {
                // On button click
                case "Edit Vehicle":
                    // Close vehicle details view
                    view.dispose();
                    // Initialize update details controller
                    new UpdateVehicleDetailsController(homeView, selectedVehicle);
                    break;

                // On button click
                case "Remove Vehicle":
                    // Close vehicle details view
                    view.dispose();
                    // TODO: Remove vehicle from database
                    
                    // Update home view table
                    homeView.removeVehicleFromTable(selectedVehicle);
                    break;
            }
        }
    }
}