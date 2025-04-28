package controllers;

import models.Ticket;
import views.HomeView;
import views.UpdateTicketDetailsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateTicketDetailsController
{
    // Initialize variables
    private UpdateTicketDetailsView view;
    private HomeView homeView;
    private Object[] updatedTicketAttributes;

    // ----------------------------------------
	// Instantiate GUI
	// ----------------------------------------
    public UpdateTicketDetailsController(HomeView homeView, Ticket selectedTicket)
    {
        // Set view properties
        this.homeView = homeView;
        view = new UpdateTicketDetailsView(selectedTicket);
        view.createListeners(new UpdateTicketDetailsListener());

        view.setVisible(true);
    }

    // ----------------------------------------
	// Update Ticket Listener Logic
	// ----------------------------------------
    class UpdateTicketDetailsListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand())
            {
                // On button click
                case "Update Ticket Details":
                // Gathers user data
                updatedTicketAttributes = (view.getUpdatedTicketAttributes());

                // Validates user data for null values and types
                if (updatedTicketAttributes != null)
                {

                    // Close current view
                    view.dispose();

                    // Update home view table
                    homeView.updateTicketInTable(new Ticket(updatedTicketAttributes));
                }
                break;
            }
        }
    }
}