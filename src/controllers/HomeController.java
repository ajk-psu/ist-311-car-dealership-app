package controllers;

import models.HomeModel;
import views.HomeView;

public class HomeController
{
    private HomeModel model;
    private HomeView view;
    private int id;

    public HomeController(HomeView view, HomeModel model, int id)
    {
        this.model = model;
        this.view = view;
        this.id = id;

        this.view.createView(id);
    }
}
