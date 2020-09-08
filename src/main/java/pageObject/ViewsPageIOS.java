package pageObject;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ViewsPageIOS implements ViewsPage {

	public ViewsPageIOS(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void navigateToDragAndDrop() {

	}
	
	public void navigateToExpandableLists() {
		
	}
	
	public void navigateToTextSwicher() {
		
	}
	
	public void navigateToVisibility() {
		
	}
	
	public void navigateToDateWidgets() {
		
	}
	
	public void navigateToSerchView() {
		
	}

}
