package test.java.roboTestPlatforms;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by jshearen on 9/12/2016.
 */
public class MobileWebBrowserTestPlatform {
    private String projectPathLocation = System.getProperty("user.dir");
    private String testScenarioTitle;
    private WebDriver mobileWebBrowser;

    public WebDriver createMobileWebBrowser(){
        WebDriver webDriver = null;
        ChromeOptions chromeOptions = new ChromeOptions();
        String userAgent = "--user-agent=Mozilla/5.0 (Linux; Android 5.1.1; Nexus 5 Build/LMY48B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.78 Mobile Safari/537.36"; //Nexus 5
        chromeOptions.addArguments(userAgent);
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY , chromeOptions);
        System.setProperty("webdriver.chrome.driver", projectPathLocation + "\\chromedriver.exe");
        try {
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        mobileWebBrowser = webDriver;
        return webDriver;
    }

    public void quitMobileWebBrowserAndSaveScreenshot() {
        saveScreenshotInReportDirectory();
        mobileWebBrowser.quit();
    }

    public void quitMobileWebBrowserAndSaveScreenshot(WebDriver mobileWebBrowser) {
        saveScreenshotInReportDirectory(mobileWebBrowser);
        mobileWebBrowser.quit();
    }

    public void setTestScenarioTitle(String testScenarioTitle) {
        this.testScenarioTitle = testScenarioTitle;
    }

    private void saveScreenshotInReportDirectory( ){
        try {
            File scrFile = ((TakesScreenshot) mobileWebBrowser).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(projectPathLocation+"\\test-report\\screenshots\\mobileWebSite\\" + testScenarioTitle + ".jpeg"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveScreenshotInReportDirectory(WebDriver mobileWebBrowser){
        try {
            File scrFile = ((TakesScreenshot) mobileWebBrowser).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(projectPathLocation+"\\test-report\\screenshots\\mobileWebSite\\"+ testScenarioTitle + "_secondaryBrowser.jpeg"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
