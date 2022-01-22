import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragAndDropDemo extends Base{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
		
		//long press on source element, move to the destination element and then release
		
		TouchAction ta = new TouchAction(driver);
		
		WebElement source = driver.findElementsByClassName("android.view.View").get(0);
		WebElement destination = driver.findElementsByClassName("android.view.View").get(1);
		
		ta.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();
		//ta.longPress((element(source))).moveTo(element(destination)).release().perform(); ==> This also works
		
		System.out.println(driver.findElementByXPath("//android.widget.TextView[@text='Dropped!']").getText());
		
		
		

	}

}
