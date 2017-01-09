package test.java.roboUtilities;


import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PauseWebBrowserTest {
    WebDriver webBrowser;

    public PauseWebBrowserTest(WebDriver webBrowser){
        this.webBrowser = webBrowser;
    }

    public void setWebBrowser(WebDriver webBrowser){
        this.webBrowser = webBrowser;
    }

    public void waitForElementIdToBeVisisble(String elementId){
        WebDriverWait pauseAutomationTest = new WebDriverWait(webBrowser, 15);
        pauseAutomationTest.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId)));
    }

    public void waitForElementIdToBeVisisble(String elementId, int seconds){
        WebDriverWait pauseAutomationTest = new WebDriverWait(webBrowser, seconds);
        pauseAutomationTest.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId)));
    }

    public void waitForCssElementToBeVisible(String cssElement) {
        WebDriverWait pauseAutomationTest = new WebDriverWait(webBrowser, 15);
        pauseAutomationTest.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssElement)));
    }

    public void waitForCssElementToBeVisible(String cssElement, int seconds) {
        WebDriverWait pauseAutomationTest = new WebDriverWait(webBrowser, seconds);
        pauseAutomationTest.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssElement)));
    }

    public void waitForCssElementToBeVisible(WebDriver webBrowser, String cssElement) {
        WebDriverWait pauseAutomationTest = new WebDriverWait(webBrowser, 15);
        pauseAutomationTest.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssElement)));
    }


    public void waitForCssElementToBeClickable(String cssElement) {
        WebDriverWait pauseAutomationTest = new WebDriverWait(webBrowser, 15);
        pauseAutomationTest.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssElement)));
    }

    public void waitForCssElementToBeClickable(String cssElement, int seconds) {
        WebDriverWait pauseAutomationTest = new WebDriverWait(webBrowser, seconds);
        pauseAutomationTest.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssElement)));
    }

    public void waitForCssElementToBeClickable(WebDriver webBrowser, String cssElement) {
        WebDriverWait pauseAutomationTest = new WebDriverWait(webBrowser, 15);
        pauseAutomationTest.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssElement)));
    }

    public void waitForXpathElementToBeVisible(String xpathElement){
        WebDriverWait pauseAutomationTest = new WebDriverWait(webBrowser, 15);
        pauseAutomationTest.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathElement)));
    }

    public void waitForXpathElementToBeVisible(String xpathElement, int seconds){
        WebDriverWait pauseAutomationTest = new WebDriverWait(webBrowser, seconds);
        pauseAutomationTest.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathElement)));
    }

    public void pauseForSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
