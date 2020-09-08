package environment.AppiumMaster;

import org.testng.annotations.Test;

public class ExpandableListsTest extends BaseTestClass {

	@Test
	public void expandableListsTest() throws InterruptedException {
		
		homePage.navigateToViews();
		viewsPage.navigateToExpandableLists();
		expListsPage.navigateToCustomAdapter();
		expListsPage.checkSampleAction();
	}
}
