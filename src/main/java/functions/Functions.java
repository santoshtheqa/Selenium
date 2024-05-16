package functions;

public class Functions {

	public static void OpenHOmepage() {
		base.openBrowser();
		base.goToUrl("https://www.google.com");
		base.closeBrowser();
	}
	
	public static void closeBrowser() {
		base.closeBrowser();
	}
	
}
