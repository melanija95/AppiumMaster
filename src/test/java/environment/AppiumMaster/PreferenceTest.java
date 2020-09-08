package environment.AppiumMaster;
import java.io.IOException;

import org.testng.annotations.Test;

public class PreferenceTest extends BaseTestClass {

	@Test(dataProvider="InputData", dataProviderClass=TestData.class)
	public void apiDemoTest(String input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		//xpath syntax - tagName[@attribute='value']

		homePage.navigateToPreferences();
		
		preferencePage.navigateToDependencies();
		preferencePage.checkWiFiOption();
		preferencePage.navigateToEditField();
		preferencePage.setName(input);
		preferencePage.clickOK();

	}

}
