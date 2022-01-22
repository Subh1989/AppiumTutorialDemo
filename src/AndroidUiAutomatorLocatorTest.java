import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidUiAutomatorLocatorTest extends Base{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		//Validate clickable features for all options
		
		int data = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
		System.out.println(data);
		
	}

}
