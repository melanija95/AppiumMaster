package environment.AppiumMaster;

import java.io.IOException;

import org.testng.annotations.Test;

public class SearchTest extends BaseTestClass {

	@Test
	public void searchTest() throws InterruptedException, IOException {
		
		homePage.navigateToViews();
		scrollToText("Search View");
		viewsPage.navigateToSerchView();
		searchViewPage.navigateToFilter();
		searchViewPage.search("figue");
	}
}
