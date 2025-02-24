package controllers;

import models.AccountModel;
import views.HomeView;
import views.LogInView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInController 
{
    private LogInView view;
    private AccountModel model;

    // Enable view (initialized via call in main) and add pass listener
    public LogInController(AccountModel model, LogInView view)
    {
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
            // User text gathered through view accessors
            String username = view.getAccountName();
            String password = view.getAccountPassword();

            // Passes to model for auth, then instantiates response
            if (model.authenticate(username, password))
            {
                new HomeController(new HomeView());
            }
            else
            {
                view.badLogInMessage();
            }
        }
    }
}