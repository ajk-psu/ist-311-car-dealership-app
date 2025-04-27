package controllers;

import models.AccountModel;
import models.DBConnection;
import views.LogInView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LogInController 
{
    private LogInView view;
    private AccountModel accountModel;
    private DBConnection dbConnection;

    // ----------------------------------------
	// Instantiate GUI
	// ----------------------------------------
    public LogInController()
    {
        // Instantiate db connection
        dbConnection = new DBConnection();

        // Instantiate account model
        accountModel = new AccountModel(dbConnection.getConnection());

        // Instantiate log in view
        view = new LogInView();

        // Set view properties
        view.setVisible(true);
        view.addLogInListener(new LogInListener(), new LogInCloseListener());
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
            if (accountModel.authenticate(username, password))
            {
                // Hide current view
                view.setVisible(false);
                // Initialize home controller
                new HomeController(dbConnection, accountModel, username, password);
            }
            else
            {
                // Invalid authentication response
                view.badLogInMessage();
            }
        }
    }

    // ----------------------------------------
	// Window Listener Logic
	// ----------------------------------------
    class LogInCloseListener extends WindowAdapter
    {
        @Override
        // When window is closed
        public void windowClosed(WindowEvent e) {
            // Sever connection and close program
            dbConnection.closeConnection();
            System.exit(0);
        }
    }
}