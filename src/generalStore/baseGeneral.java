package generalStore;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class baseGeneral {

	public static AndroidDriver<AndroidElement> desiredCap() throws MalformedURLException {
		
		File parent = new File("src");
		File app = new File(parent, "General-Store.apk");
		
		// set the path of the app, device name info, automation name and port details
		DesiredCapabilities cap =  new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "SubhankarEmulator");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

}
