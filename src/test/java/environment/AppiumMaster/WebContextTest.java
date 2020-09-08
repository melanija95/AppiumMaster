package environment.AppiumMaster;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class WebContextTest extends BaseTestClass {

	@Test
	public void changeContext() throws InterruptedException, IOException {
		
		homePage.navigateToText();
		textPage.navigateToLinkify();
		textPage.navigateToGoogle();
		Thread.sleep(7000);
		
		AppiumDriver driver = AppiumController.instance.createDriver();
		Set<String> contexts = driver.getContextHandles();

		for(String contextName :contexts)
		{
			System.out.println(contextName);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		driver.findElement(By.name("q")).sendKeys("hello");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		((AndroidDriver<AndroidElement>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
	}
}
