package pageObject;

import static io.appium.java_client.touch.TapOptions.tapOptions;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import static java.time.Duration.ofSeconds;

import java.time.Duration;
import java.util.List;

public class TextPageAndroid implements TextPage {

	public TouchAction t;
	
	public TextPageAndroid(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		t = new TouchAction(driver);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Linkify']")
	private WebElement linkify;
	
	@AndroidFindBy(className="android.widget.TextView")
	private List<WebElement> texts;

	public void navigateToLinkify() {
		linkify.click();
	}

	public void navigateToGoogle() {
		//Point p = texts.get(1).getLocation();
		//int x = texts.get(1).getSize().getWidth()/2;
        //int y = p.y + 140;
        texts.get(1).click();
        //t.tap(TapOptions.tapOptions().withPosition(PointOption.point(x, y)));
        //t.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).release().perform();
	}

}
