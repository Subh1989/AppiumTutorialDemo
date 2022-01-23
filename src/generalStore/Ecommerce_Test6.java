package generalStore;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Ecommerce_Test6 extends baseGeneral{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement> driver = desiredCap();
		
		//Scrolling to Argentina
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Argentina" + "\").instance(0))")); 
		driver.findElement(By.xpath("//*[@text = 'Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//Select multiple product and click on Add to Cart and validate the sum of the price selected should match the total price
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		List<AndroidElement>priceLists = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		double sum = 0;
		for(int i=0; i<priceLists.size(); i++)
		{
			String p = priceLists.get(i).getText();
			double val = getAmount(p);
			sum = sum+val;
		}
		System.out.println(sum);
		String totalPrice = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		String[] p1 = totalPrice.split(" ");
		double finalPrice = Double.parseDouble(p1[1]);
		System.out.println(finalPrice);
		Assert.assertEquals(finalPrice, sum);
		
		//Mobile Gestures Functionality to tap the checkbox
		TouchAction t = new TouchAction(driver);
		WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		
		//Mobile Gestures Functionality to longpress on terms and conditions
		WebElement termsConditions = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		t.longPress(longPressOptions().withElement(element(termsConditions)).withDuration(ofSeconds(2))).release().perform();
		driver.findElement(By.id("android:id/button1")).click();
		
		//Click on Visit to the website button
		driver.findElement(By.xpath("//*[@text = 'Visit to the website to complete purchase']")).click();
		
		//Swithcing to WebView and perform some action and again switch back to Native app view
		Thread.sleep(7000);
		Set<String> contexts = driver.getContextHandles();
		for(String contextName : contexts)
		{
			System.out.println(contextName);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("hello");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		
		//Switch Back to Native APP
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");

	}
	
	public static double getAmount(String val)
	{
		val = val.substring(1);
		double val2 = Double.parseDouble(val);
		return val2;
	}

}
