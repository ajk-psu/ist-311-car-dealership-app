package controllers;

import models.AccountModel;
import views.LogInView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LogInController
{
    private LogInView view;
    private AccountModel model;

    public LogInController(LogInView view, AccountModel model) 
    {
        this.view = view;
        this.model = model;

        this.view.addLogInListener(new AuthListener());
    }

    class AuthListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) { 
            String username = view.getUsername();
            String password = view.getPassword();

            if (model.authenticate(username, password))
            {
                HomeController homeController = new HomeController(view, model, model.getID(username, password));
            }
            else
            {
                view.badLogin();
                view.destroyView();
                view.createView();
            }
        }
    }
}