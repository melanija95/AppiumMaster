package environment.AppiumMaster;

import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTestClass {

	@Test
	public void dragAndDropTest() {
		
		homePage.navigateToViews();
		viewsPage.navigateToDragAndDrop();
		dragAndDropPage.dragAndDrop();
	}
}
