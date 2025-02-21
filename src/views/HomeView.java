package views;

public class HomeView
{
    private int id;

    public HomeView(int id)
    {
        this.id = id;
        createView(id);
    }

    public void createView(int id)
    {
        System.out.println("  -Home View Created (Employee #" + id + ")");
    }
}
