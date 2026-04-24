package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.ConfigReader;

public class BaseTest {
    protected Browser browser;
    protected Page page;

    BrowserFactory browserFactory;
    ConfigReader configReader = ConfigReader.getInstance();

    @BeforeMethod
    public void setUp() {
        browserFactory = new BrowserFactory();
        browser = browserFactory.createBrowser();
        page = browser.newPage();
        page.navigate(configReader.getProperty("orangeHRM.url"));
    }

    @AfterMethod
    public void tearDown() {
        browserFactory.closeBrowser();
    }
}
