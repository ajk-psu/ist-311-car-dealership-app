// Program executes here.

import models.*;
import views.*;
import controllers.*;

public class Main 
{
	public static void main(String[] args) 
	{
		LogInView logInView = new LogInView();
		AccountModel logInModel = new AccountModel();
		LogInController logInController = new LogInController(logInView, logInModel);

		/* 
		System.out.println("Hello world!");
		
		// Quick temporary method to test if the program connects to the Access database.
		AccountModel.debugTestConnection();
		*/
	}
}
