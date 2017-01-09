package test.java.roboTestPlatforms;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by JShearen7 on 5/2/2016.
 */
public class IosTestPlatform {
    public IOSDriver<IOSElement> iosDevice;

    public IOSDriver<IOSElement> createiPhone6PlusEmulator(String applicationName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6 Plus");
        capabilities.setCapability(MobileCapabilityType.APP, applicationName);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        try {
            iosDevice = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        iosDevice.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return iosDevice;
    }

    public boolean checkIOSElementIsPresent (String iosElement){
        try{
            WebDriverWait wait = new WebDriverWait(iosDevice,1);
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.IosUIAutomation(iosElement)));
            System.out.println(iosElement +" FOUND!!!! Returning true...");
            return true;
        }catch (TimeoutException e) {
            System.out.println(iosElement +" not found!!! Continuing...");
            return false;
        }
    }

    public boolean checkElementByXpathIsPresent (String xpath){
        try{
            WebDriverWait wait = new WebDriverWait(iosDevice,1);
            wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath(xpath)));
            System.out.println(xpath +" FOUND!!!! Returning true...");
            return true;
        }catch (TimeoutException e){
            System.out.println(xpath +" not found!!! Continuing...");
            return false;
        }
    }

    public void LaunchIosTestApplicationFromHomeScreen(){
        //TODO: I don't like this try/catch block
        try {
            iosDevice.launchApp();
        }catch (WebDriverException e){
            System.out.println("App is already open! Continuing...");
        }
    }

    public void pauseForSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

