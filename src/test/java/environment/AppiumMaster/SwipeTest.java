package environment.AppiumMaster;

import org.testng.annotations.Test;

public class SwipeTest extends BaseTestClass {

	@Test
	public void swipeTest() throws InterruptedException {

		homePage.navigateToViews();
		viewsPage.navigateToDateWidgets();
		dateWidgetsPage.navigateToInline();
		dateWidgetsPage.swipe();	
	}
}
