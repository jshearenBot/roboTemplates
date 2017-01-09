package test.java.roboTestPlatforms;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by jshearen on 8/31/716.
 */
public class WebBrowserTestPlatformV2 {
    private String projectPathLocation = System.getProperty("user.dir");
    private String testScenarioTitle;
    private WebDriver webBrowser;


    public WebDriver createWebBrowserInstance(){
        WebDriver webDriver = null;
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY , chromeOptions);

        try {
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
            webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        webBrowser = webDriver;
        return webDriver;
    }

    public void quitWebBrowserAndSaveScreenshot() {
        //saveScreenshotInReportDirectory();
        webBrowser.quit();
    }

    public void quitWebBrowserAndSaveScreenshot(WebDriver webBrowser) {
        //saveScreenshotInReportDirectory(webBrowser);
        webBrowser.quit();
    }

    public void setTestScenarioTitle(String testScenarioTitle) {
        this.testScenarioTitle = testScenarioTitle;
    }

    private void saveScreenshotInReportDirectory(){
        try {
            File scrFile = ((TakesScreenshot) webBrowser).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(projectPathLocation+"\\test-report\\screenshots\\fullWebSite\\" + testScenarioTitle + ".jpeg"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveScreenshotInReportDirectory(WebDriver webBrowser){
        try {
            File scrFile = ((TakesScreenshot) webBrowser).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(projectPathLocation+"\\test-report\\screenshots\\fullWebSite\\"+ testScenarioTitle + "_secondaryBrowser.jpeg"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
