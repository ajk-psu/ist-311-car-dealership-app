package controllers;

import models.AccountModel;
import views.LogInView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInController 
{
    private LogInView view;
    private AccountModel model;

    // ----------------------------------------
	// Instantiate GUI
	// ----------------------------------------
    public LogInController(AccountModel model, LogInView view)
    {
        // Set view properties
        this.view = view;
        this.model = model;
        view.setVisible(true);
        this.view.addLogInListener(new LogInListener());
    }

    class LogInListener implements ActionListener 
    {
        // ActionListener enables btnLogIn in view to call actionPerformed when clicked 
        public void actionPerformed(ActionEvent e) 
        {   
            // Gathers user input from log in view
            String username = view.getAccountName();
            String password = view.getAccountPassword();

            // Authenticates with database account information
            if (model.authenticate(username, password))
            {
                // Hide current view
                view.setVisible(false);
                // Initialize home controller
                new HomeController(model, username, password);
            }
            else
            {
                // Invalid authentication response
                view.badLogInMessage();
            }
        }
    }
}