package controllers;

import models.Ticket;
import views.HomeView;
import views.TicketDetailsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketDetailsController
{
    // Initialize variables
    private Ticket selectedTicket;
    private TicketDetailsView view;
    private HomeView homeView;

    // ----------------------------------------
	// Instantiate GUI
	// ----------------------------------------
    public TicketDetailsController(HomeView homeView, Ticket selectedTicket)
    {
        // Set view properties
        this.homeView = homeView;
        this.selectedTicket = selectedTicket;
        view = new TicketDetailsView(selectedTicket);
        view.createListeners(new TicketDetailsListener());

        view.setVisible(true);
    }

    // ----------------------------------------
	// Vehicle Details Listener Logic
	// ----------------------------------------
    class TicketDetailsListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand())
            {
                // On button click
                case "Edit Ticket Details":
                    // Close ticket details view
                    view.dispose();
                    // Initialize update details controller
                    new UpdateTicketDetailsController(homeView, selectedTicket);
                    break;

                // On button click
                case "Remove Ticket":
                    // Close vehicle details view
                    view.dispose();
                    
                    // Update home view table
                    homeView.removeTicketFromTable(selectedTicket);
                    break;
            }
        }
    }
}