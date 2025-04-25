package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Vehicle;
import views.HomeView;
import views.VehicleDetailsView;

public class VehicleDetailsController
{
    private Vehicle selectedVehicle;
    private VehicleDetailsView view;
    private HomeView homeView;

    public VehicleDetailsController(HomeView homeView, Vehicle selectedVehicle)
    {
        this.homeView = homeView;
        this.selectedVehicle = selectedVehicle;
        view = new VehicleDetailsView(selectedVehicle);
        view.createListeners(new VehicleDetailsListener());
        view.setVisible(true);
    }

    class VehicleDetailsListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand())
            {
                case "Edit Vehicle":
                    view.dispose();
                    new UpdateVehicleDetailsController(homeView, selectedVehicle);
                    break;
                case "Remove Vehicle":
                    view.dispose();
                    // remove vehicle from database
                    homeView.removeVehicleFromTable(selectedVehicle);
                    break;
            }
        }
    }
}