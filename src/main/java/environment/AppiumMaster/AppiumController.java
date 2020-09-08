package environment.AppiumMaster;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumController {

    public static OS executionOS;

    public enum OS {
        ANDROID,
        IOS
    }
    
    public static AppiumController instance = new AppiumController();
    public static AppiumDriverLocalService service;
    private static AppiumDriver driver;
    
    public AppiumDriverLocalService startServer()
	{
		boolean flag = checkIfServerIsRunnning(4723); 
		if (!flag)
		{
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}

		return service;
	}
	
    public static boolean checkIfServerIsRunnning(int port) 
    {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
    
    public static void startEmulator() throws IOException, InterruptedException
    {
    	Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\startEmulator.bat");
    	Thread.sleep(6000);
    }
    
    public AppiumDriver createDriver() throws IOException, InterruptedException {
        
    	if (driver != null) {
            return driver;
        }
    	
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	File classpathRoot = new File(System.getProperty("user.dir"));
    	
    	String device = System.getProperty("deviceName");
    	executionOS = OS.valueOf(System.getProperty("executionOS"));
    	
    	switch(executionOS) {
    		case ANDROID:
    			if (device.contains("emulator"))
    				startEmulator();
                File appDir = new File(classpathRoot, "/apps/Android");
                File app = new File (appDir, "ApiDemos-debug.apk");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("deviceName", device);
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
                capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
                capabilities.setCapability("adbExecTimeout", 50000);
                driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
    		case IOS:
                appDir = new File(classpathRoot, "/apps/iOS/");
                app = new File(appDir, "ContactsSimulator.app");
                capabilities.setCapability("platformName", "ios");
                capabilities.setCapability("deviceName", device);
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("automationName", "XCUITest");
                driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
    	}
    	
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
    }
    
    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    
	public static void getScreenshot(String name) throws IOException
	{
		 SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		 Date date = new Date();
		 String fileName = sdf.format(date);
		 File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\Screenshots\\" + name + "_" + fileName + ".png"));
	}
}
