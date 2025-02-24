package controllers;

import views.HomeView;

public class HomeController
{
    // Enables success screen (initialized in main)
    public HomeController(HomeView view)
    {
        view.setVisible(true);
    }
}
