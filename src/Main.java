// Program executes here.

import models.*;
import views.*;
import controllers.*;

public class Main 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello world!");
		
		// Quick temporary method to test if the program connects to the Access database.
		AccountModel.debugTestConnection();
	}
}
