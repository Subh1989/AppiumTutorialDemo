package generalStore;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_Test3 extends baseGeneral{

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
		
		//Scroll to the product we need to select and click on add to cart and validate correct product is present in the checkout page
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"+ ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("+ "new UiSelector().text(\"Jordan 6 Rings\"));");
		List<AndroidElement> products = driver.findElementsById("com.androidsample.generalstore:id/productName");
		for(int i=0; i<products.size(); i++)
		{
			String item = products.get(i).getText();
			if(item.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
				break;
			}
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		String actualProduct = driver.findElementById("com.androidsample.generalstore:id/productName").getText();
		Assert.assertEquals(actualProduct, "Jordan 6 Rings");

	}

}
