package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class SearchViewPageAndroid implements SearchViewPage {

	public SearchViewPageAndroid(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Filter']")
	private WebElement filter;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Cheese hunt']")
	private WebElement searchField;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Figue']")
	private WebElement figue;
	
	public void navigateToFilter() {
		filter.click();
	}
	
	public void search(String name) throws InterruptedException {
		searchField.sendKeys(name);
		Thread.sleep(2000);
		Assert.assertTrue(figue.isDisplayed());
	}
	
}
