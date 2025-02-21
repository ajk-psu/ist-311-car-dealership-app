package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class LogInView 
{
    private String username;
    private String password;
    private ActionListener authListener;

    public LogInView() 
    {
        createView();
    }
 
    public void createView()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("  -Login View Created");
        System.out.print("Username: ");
        username = scanner.nextLine();
        System.out.print("");
        System.out.print("Password: ");
        password = scanner.nextLine();
    }

    public void addAuthListener(ActionListener authListener)
    {
        this.authListener = authListener;
        System.out.println("  -Listener Added");
    }

    public void removeAuthListener()
    {
        this.authListener = null;
        System.out.println("  -Listener Removed");
    }

    public void fireListener()
    {
        if (authListener != null) 
        {
            ActionEvent event = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "button click");
            authListener.actionPerformed(event);
            System.out.println("  -Listener Fired");
        }
        else 
        {
            System.out.println("  -Error: No Listener Added");
        }
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public void badLogin()
    {
        System.out.println("  -Incorrect Login Popup Displayed");
    }

    public void destroyView() 
    {
        System.out.println("  -Login View Destroyed");
    }
}
