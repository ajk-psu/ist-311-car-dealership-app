package controllers;

import models.Ticket;
import models.Vehicle;
import views.AddTicketView;
import views.HomeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class AddTicketController 
{
    // Initializes variables
    private AddTicketView view;
    private HomeView homeView;
    private Object[] newTicketAttributes;

    // ----------------------------------------
	// Instantiate GUI
	// ----------------------------------------
    public AddTicketController(HomeView homeView, Vehicle selectedVehicle)
    {
        // Set view properties
        this.homeView = homeView;
        view = new AddTicketView(selectedVehicle);
        view.createListeners(new AddTicketListener());

        view.setVisible(true);
    }

    // ----------------------------------------
	// Add Vehicle Listener Logic
	// ----------------------------------------
    class AddTicketListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand())
            {
                // On button click
                case "Create Ticket":
                {
                    // Check for duplicates
                    if (validateData())
                    {
                        // Close current view
                        view.dispose();

                        // Updates home view table
                        homeView.addTicketToTable(new Ticket(newTicketAttributes));
                    }
                }
                    break;
            }
        }

        /**
         * This method validates the user's new ticket information to ensure it contains no null values duplicate IDs.
         * @return True if data is valid, false if it contains null values or duplicate IDs.
         */
        private boolean validateData()
        {
            // Gathers user data
            // Null value validation is handled
            newTicketAttributes = (view.getNewTicketAttributes());

            // If new ticket values exist
            if (newTicketAttributes != null)
            {

                // Get the user's ID input
                String attemptedInputID = String.valueOf(Arrays.asList(view.getNewTicketAttributes()).get(0));
                
                // For each row in the ticket table...
                String existingID = null;
                int checkedTickets = 0;
                for (int i=0;i<homeView.exportTicketDataFromTable().size();i++)
                {
                    
                    // Get the row's existing ID
                    existingID = String.valueOf(homeView.exportTicketDataFromTable().get(i).getTicketID());
                    
                    // Check if user data is a duplicate
                    if (attemptedInputID.equals(existingID))
                    {
                        // If yes, show message and return false
                        view.showDuplicateMessage();
                        break;
                    }
                    else
                        // If no, try again
                        checkedTickets += 1;
                }

                // If no duplicates are found
                if (checkedTickets == homeView.exportTicketDataFromTable().size())
                {
                    return true;
                }
            }
            return false;
        }
    }
}