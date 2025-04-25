package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Vehicle;
import views.HomeView;
import views.UpdateVehicleDetailsView;

public class UpdateVehicleDetailsController
{
    private UpdateVehicleDetailsView view;
    private HomeView homeView;
    private Object[] updatedVehicleAttributes;

    public UpdateVehicleDetailsController(HomeView homeView, Vehicle selectedVehicle)
    {
        this.homeView = homeView;
        view = new UpdateVehicleDetailsView(selectedVehicle);
        view.createListeners(new UpdateVehicleDetailsListener());
        view.setVisible(true);
    }

    class UpdateVehicleDetailsListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand())
            {
                case "Update Vehicle Details":
                updatedVehicleAttributes = (view.getUpdatedVehicleAttributes());

                if (updatedVehicleAttributes != null) // validates data
                {
                    // add in database
                    view.dispose();
                    homeView.updateVehicleInTable(new Vehicle(updatedVehicleAttributes));
                }
                break;
            }
        }
    }
}