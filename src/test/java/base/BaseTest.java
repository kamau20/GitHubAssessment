package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected Browser browser;
    protected Page page;

    BrowserFactory browserFactory;

    @BeforeMethod
    public void setUp() {
        browserFactory = new BrowserFactory();
        browser = browserFactory.createBrowser();
        page = browser.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod
    public void tearDown() {
        browserFactory.closeBrowser();
    }
}
