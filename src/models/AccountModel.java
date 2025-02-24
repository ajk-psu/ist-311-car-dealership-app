package models;

//import java.sql.*;


public class AccountModel 
{

	public boolean authenticate(String username, String password)
	{

		if (username.equals("username") && password.equals("password"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public int getID(String username, String password) 
	{
		if (authenticate(username, password))
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}

	/* 
	// This is just a temporary static method to test whether or not the Access driver is set up
	// and can connect the program to the database.
	public static void debugTestConnection()
	{
		String databaseURL = "jdbc:ucanaccess://db//dealership.accdb";
		System.out.printf("%nAttempting to connect...%n" + "String databaseURL: " + databaseURL + "%n");	
		
		try 
		{
			Connection connection = DriverManager.getConnection(databaseURL);
			System.out.printf("Connection Successful! Now closing connection...%n");	
			
			connection.close();
			System.out.printf("Connection Closed!%n");
		}
		catch (SQLException sqlExcept)
		{
			System.out.printf("Connection Failed! Printing stack trace...%n");
			sqlExcept.printStackTrace();
			
			
		}
	}
	*/
	
}
