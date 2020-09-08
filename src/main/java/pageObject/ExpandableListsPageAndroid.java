package pageObject;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ExpandableListsPageAndroid implements ExpandableListsPage {

	public TouchAction t;
	
	public ExpandableListsPageAndroid(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		t = new TouchAction(driver);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='1. Custom Adapter']")
	private WebElement customAdapter;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='People Names']")
	private WebElement peopleNames;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Sample action']")
	private WebElement sampleAction;
	
	
	public void navigateToCustomAdapter() {
		customAdapter.click();
	}
	
	public void checkSampleAction() throws InterruptedException {
		t.longPress(longPressOptions().withElement(element(peopleNames)).withDuration(ofSeconds(2))).release().perform();
		Thread.sleep(2000);
		Assert.assertTrue(sampleAction.isDisplayed());
	}
	
}
