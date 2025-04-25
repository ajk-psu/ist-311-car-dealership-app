package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Vehicle;
import views.AddVehicleView;
import views.HomeView;

public class AddVehicleController 
{
    private AddVehicleView view;
    private HomeView homeView;
    private Object[] newVehicleAttributes;

    public AddVehicleController(HomeView homeView)
    {
        this.homeView = homeView;
        view = new AddVehicleView();
        view.createListeners(new AddVehicleListener());
        view.setVisible(true);
    }

    class AddVehicleListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand())
            {
                case "Add Vehicle":
                    newVehicleAttributes = (view.getNewVehicleAttributes());

                    if (newVehicleAttributes != null) // validates data
                    {
                        // add in database
                        view.dispose();
                        homeView.addVehicleToTable(new Vehicle(newVehicleAttributes));
                    }
                    break;
            }
        }
    }
}