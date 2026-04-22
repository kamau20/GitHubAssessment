package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class BrowserFactory {
    private Browser browser;
    private Playwright playwright;

    public Browser createBrowser() {
        playwright = Playwright.create();
        return browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    public void  closeBrowser() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
     // TODO: Add multi-browser selection logic
    // Default is Chromium

}
