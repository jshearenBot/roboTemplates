package test.java.roboTestPlatforms;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by JShearen7 on 7/13/2016.
 */
public class AndroidTestPlatform {
    public AndroidDriver<AndroidElement> androidDevice;

    public AndroidDriver<AndroidElement>openAppInAndroidSimulator(String appPackage, String appActivity){
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("deviceName", "emulator-5554");
            //desiredCapabilities.setCapability("platformVersion", "6.0");
            desiredCapabilities.setCapability("unicodeKeyboard", true);
            desiredCapabilities.setCapability("resetKeyboard", true);
            desiredCapabilities.setCapability("appPackage", appPackage);
            desiredCapabilities.setCapability("appActivity", appActivity);
            desiredCapabilities.setCapability("noReset", true);
            androidDevice = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        androidDevice.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return androidDevice;
    }

    public void pauseForSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendTextToEmulator(String stringText){
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("adb -s emulator-5554 shell input text "+stringText);
        } catch (IOException e) {
            e.printStackTrace();
        }
        pauseForSeconds(1);
    }

    public void LaunchAndroidTestApplicationFromHomeScreen(){
        //TODO: I don't like this try/catch block
        try {
            androidDevice.launchApp();
        }catch (WebDriverException e){
            System.out.println("App is already open! Continuing...");
        }
    }
}
