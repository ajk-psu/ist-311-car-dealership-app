package controllers;

import views.HomeView;
import models.AccountModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeController 
{
    private HomeView view;
    private AccountModel model;
    private int employeeID;

    public HomeController(AccountModel model, String username, String password)
    {
        this.model = model;
        view = new HomeView();
        employeeID = model.getEmployeeID(username, password);
        System.out.println(employeeID);

        view.setVisible(true);
        view.createListeners(new HomeListener());

    }

    public int getEmployeeID()
    {
        return employeeID;
    }
}

    class HomeListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand())
            {
                case "Select Vehicle":
                // call show details view
                break;
                case "Add Vehicle":
                // call add details view
                break;
            }
        }
    }