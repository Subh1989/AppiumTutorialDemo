import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

	public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		
		File parent = new File("src");
		File app = new File(parent, "ApiDemos-debug.apk");
		
		// set the path of the app, device name info, automation name and port details
		DesiredCapabilities cap =  new DesiredCapabilities();
		if(device.equals("real"))
		{
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); //if we use real device
		}
		else if(device.equals("emulator"))
		{
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "SubhankarEmulator");
		}
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		return driver;
		

	}

}
