package pageObject;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public interface DateWidgetsPage {
	
	public void navigateToInline();
	public void swipe() throws InterruptedException;
}