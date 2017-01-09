package test.java.roboUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import test.java.roboTestPlatforms.WebBrowserTestPlatformV2;

public class FullWebSiteGoogleOverlayCheck extends WebBrowserTestPlatformV2 implements GoogleOverlayUiElements {
	private WebDriver webBrowser;
	PauseWebBrowserTest pauseWebBrowserTest;

	public FullWebSiteGoogleOverlayCheck(WebDriver webBrowser){
		this.webBrowser = webBrowser;
	}

	public void checkForOverlayAndClose(String iFrame) {
		pauseWebBrowserTest = new PauseWebBrowserTest(webBrowser);
		try{
			webBrowser.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
			pauseWebBrowserTest.waitForElementIdToBeVisisble(iFrame,1);
			webBrowser.switchTo().frame(iFrame);
			pauseWebBrowserTest.waitForCssElementToBeClickable(adOverlayCloseButton,3);
			webBrowser.findElement(By.cssSelector(adOverlayCloseButton)).click();
		}catch (TimeoutException e){
			System.out.println("Timeout Exception: Element was not found on overlay!...Continuing");
		}catch (NoSuchFrameException e){
			System.out.println("NoSuchFrame Exception: Element was not found on overlay!...Continuing");
		}catch(WebDriverException e){
			System.out.println("WebDriver Exception: Element was not found on overlay!...Continuing");
		} finally{
			webBrowser.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			webBrowser.switchTo().defaultContent();
			Actions action = new Actions(webBrowser);
			action.moveByOffset(500,500).perform();
		}
	}
}

interface GoogleOverlayUiElements{
	String adOverlayCloseButton = "#close > img";
}
