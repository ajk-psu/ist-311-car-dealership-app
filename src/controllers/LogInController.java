package controllers;

import models.AccountModel;
import models.HomeModel;
import views.HomeView;
import views.LogInView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInController
{
    private LogInView view;
    private AccountModel model;
    private AuthListener authListener;

    public LogInController(LogInView view, AccountModel model) 
    {
        this.view = view;
        this.model = model;

        createView();
    }

    public void createView()
    {
        if (authListener == null)
        {
            authListener = new AuthListener();
        }
        view.addAuthListener(authListener);

        view.createView();
        this.view.fireListener();
    }

    class AuthListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {

            String username = view.getUsername();
            String password = view.getPassword();

            if (model.authenticate(username, password))
            {
                new HomeController(new HomeView(model.getID(username, password)), new HomeModel(), model.getID(username, password));
            }
            else
            {
                view.badLogin();
                view.removeAuthListener();
                view.destroyView();
                createView();
            }
        }
    }
}