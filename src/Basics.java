import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Basics extends Base{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click on preference
		List<AndroidElement> al = driver.findElements(By.className("android.widget.TextView"));
		for(int i=0; i<al.size(); i++)
		{
			System.out.println(al.get(i).getText());
		}

		driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		//driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click(); ==> This also works fine
		
		driver.findElementByXPath("//android.widget.TextView[contains(@text, 'Preference dependencies')]").click();
		
		driver.findElementById("android:id/checkbox").click();
		
		Assert.assertTrue(driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").isEnabled());
		
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		
		String textTile = driver.findElementById("android:id/alertTitle").getText();
		Assert.assertEquals(textTile, "WiFi settings");
		
		driver.findElementById("android:id/edit").sendKeys("Subhankar");
		
//		driver.findElementById("android:id/button1").click();
		
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
	}

}
