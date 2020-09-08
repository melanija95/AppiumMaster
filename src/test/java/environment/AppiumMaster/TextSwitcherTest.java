package environment.AppiumMaster;

import java.io.IOException;

import org.testng.annotations.Test;

public class TextSwitcherTest extends BaseTestClass {

	@Test
	public void textSwitcherTest() throws InterruptedException, IOException {
		homePage.navigateToViews();
		scrollToText("TextSwitcher");
		viewsPage.navigateToTextSwicher();
		textSwitcherPage.pressNext(5);
	}
}
