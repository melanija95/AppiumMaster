package environment.AppiumMaster;

import java.io.IOException;

import org.testng.annotations.Test;

public class VisibilityTest extends BaseTestClass {

	@Test
	public void visibilityTest() throws IOException, InterruptedException {
		
		homePage.navigateToViews();
		scrollToText("Visibility");
		viewsPage.navigateToVisibility();
		visibilityPage.checkVisibility();
	}
}
