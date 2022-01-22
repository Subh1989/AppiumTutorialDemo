package generalStore;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_Test4 extends baseGeneral{

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
//		for(int i=0; i<priceLists.size(); i++)
//		{
//			String p = priceLists.get(i).getText().substring(1);
//			double val = Double.parseDouble(p);
//			sum = sum+val;
//		}
		
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

	}
	
	public static double getAmount(String val)
	{
		val = val.substring(1);
		double val2 = Double.parseDouble(val);
		return val2;
	}

}
