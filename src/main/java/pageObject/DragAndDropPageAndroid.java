package pageObject;

import static io.appium.java_client.touch.offset.ElementOption.element;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DragAndDropPageAndroid implements DragAndDropPage {

	public TouchAction t;
	
	public DragAndDropPageAndroid(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		t = new TouchAction(driver);
	}
	
	@AndroidFindBy(className="android.view.View")
	private List<WebElement> circles;
	
	public void dragAndDrop() {
		WebElement source = circles.get(0);
		WebElement destination = circles.get(1);
		//t.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();
		t.longPress(element(source)).moveTo(element(destination)).release().perform();
	}
}
