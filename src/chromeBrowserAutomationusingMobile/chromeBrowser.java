package chromeBrowserAutomationusingMobile;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class chromeBrowser extends BaseChrome{

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = chromeCap();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		driver.findElement(By.cssSelector("a[href*='products']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000)", "");
		String actualCourse = driver.findElement(By.xpath("(//*[@class='list-group-item'])[3]/div/div/a")).getText();
		Assert.assertEquals(actualCourse, "Devops");
		driver.findElement(By.xpath("(//*[@class='list-group-item'])[3]/div/div/a")).click();
		

	}

}
