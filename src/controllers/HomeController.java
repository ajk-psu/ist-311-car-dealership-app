package controllers;

import views.HomeView;

public class HomeController
{
    private HomeModel model;
    private HomeView view;
    private int id;

    public HomeController(HomeModel model, HomeView view, int id)
    {
        this.model = model;
        this.view = view;
        this.id = id;

        this.view.createView();
    }
}
