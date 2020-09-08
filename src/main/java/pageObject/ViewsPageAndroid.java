package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ViewsPageAndroid implements ViewsPage {

	public ViewsPageAndroid(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Drag and Drop']")
	private WebElement dragAndDrop;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Expandable Lists']")
	private WebElement expLists;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='TextSwitcher']")
	private WebElement textSwitcher;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Visibility']")
	private WebElement visibility;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Date Widgets']")
	private WebElement dateWidgets;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Search View']")
	private WebElement searchView;
	
	public void navigateToDragAndDrop() {
		dragAndDrop.click();
	}
	
	public void navigateToExpandableLists() {
		expLists.click();
	}
	
	public void navigateToTextSwicher() {
		textSwitcher.click();
	}

	public void navigateToVisibility() {
		visibility.click();
	}
	
	public void navigateToDateWidgets() {
		dateWidgets.click();
	}
	
	public void navigateToSerchView() {
		searchView.click();
	}
}
