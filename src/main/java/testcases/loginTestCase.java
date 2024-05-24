package testcases;

import java.io.IOException;

import functions.functions;

public class loginTestCase {
	public static void main(String[] args) throws IOException {
		
		functions.readExcel();
		functions.OpenHOmepage();
		functions.navigateToRegisterPage();
		functions.fillDetilasOnRegister();
//		functions.navigateToaccountCreatedPage();
//		functions.checkAccountCreation();
		functions.navigateToLoginPage();
		functions.fillDetilasOnLoginPage();
		functions.navigateToDashboardPage();
		functions.navigateToLogout();
		
		functions.checkLogout();
//		functions.closeBrowser();
	}
	

}
