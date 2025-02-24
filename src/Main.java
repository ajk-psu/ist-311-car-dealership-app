// Program executes here.

import models.*;
import views.*;
import controllers.*;

public class Main 
{
	public static void main(String[] args) 
	{
		//	====================================
		//	MODELS-VIEWS-CONTROLLERS DEFINITIONS
		//	====================================
		
		AccountModel accountModel = new AccountModel();
		LogInView logInView = new LogInView();
		new LogInController(accountModel, logInView);
		
		
		//System.out.println("Hello world!");
		
		// Quick temporary method to test if the program connects to the Access database.
		//AccountModel.debugTestConnection();
	}
}
