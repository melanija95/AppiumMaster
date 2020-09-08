package pageObject;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DateWidgetsPageAndroid implements DateWidgetsPage {

	public TouchAction t;
	
	public DateWidgetsPageAndroid(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		t = new TouchAction(driver);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='2. Inline']")
	private WebElement inline;
	
	@AndroidFindBy(xpath="//*[@content-desc='9']")
	private WebElement num9;
	
	@AndroidFindBy(xpath="//*[@content-desc='15']")
	private WebElement first;
	
	@AndroidFindBy(xpath="//*[@content-desc='45']")
	private WebElement second;
	
	@AndroidFindBy(id="android:id/hours")
	private WebElement hours;
	
	@AndroidFindBy(id="android:id/minutes")
	private WebElement minutes;
	
	public void navigateToInline() {
		inline.click();
	}
	
	public void navigateToNum9() {
		num9.click();
	}
	
	public void swipe() throws InterruptedException {
		navigateToNum9();
		Thread.sleep(2000);
		t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();
		Thread.sleep(2000);
		Assert.assertEquals(hours.getText(), "9");
		Assert.assertEquals(minutes.getText(), "45");
	}
}
