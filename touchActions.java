package practice;

import java.awt.Desktop.Action;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class touchActions {
	private static  AndroidDriver driver;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "a6fuugukwcwseekv");
    	capabilities.setCapability("platformName", "Android");
    	capabilities.setCapability("appPackage", "com.android.chrome");
    	capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        URL url=new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, capabilities);
        
        System.out.println("Account verification");
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	WebElement account = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]"));
    	account.click();
    	WebElement accountverify = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]"));
    	accountverify.click();
   // WebElement gotit = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"));
   // 	gotit.click();
    	WebElement Notification = driver.findElement(AppiumBy.id("com.android.chrome:id/negative_button"));
    	Notification.click();

    	
    	System.out.println("Chrom browser lauched successfully");
    
    
    Dimension size = driver.manage().window().getSize();
    int width = size.getWidth();
    int height = size.getHeight();

    // Calculate the start and end points for the swipe from the top right
    int startX = width - 10; // Start near the right edge of the screen
    int startY = 10;         // Start near the top of the screen
    int endX = startX;       // End at the same X coordinate
    int endY = height / 2;   // Swipe halfway down the screen

    // Swipe down from the top right to open the notification panel
    new TouchAction((PerformsTouchActions)driver)
        .press(PointOption.point(startX, startY))
        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
        .moveTo(PointOption.point(endX, endY))
        .release()
        .perform();

    // Wait for the notification panel to open
    Thread.sleep(2000); // It's better to use an explicit wait here

    // Find the mobile data toggle element by its icon, text, or content-desc
	WebElement data = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Control centre\"]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]"));

    // Tap on the mobile data toggle to enable it
    new TouchAction((PerformsTouchActions)driver)
        .tap(TapOptions.tapOptions().withElement(ElementOption.element(data)))
        .perform(); 

    
 // Swipe up action
    new TouchAction((PerformsTouchActions)driver)
        .press(PointOption.point(startY, startX))
        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
        .moveTo(PointOption.point(endY, endX))
        .release()
        .perform();
	}

}
