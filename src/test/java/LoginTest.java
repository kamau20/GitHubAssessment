import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        context = browser.newContext();
        page = context.newPage();
    }

    @Test
    public void testSuccessfulLogin() {
        // Step 1: Navigate to OrangeHRM login page
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Step 2: Wait for the page to fully load
        page.waitForLoadState();
        System.out.println("Navigated to OrangeHRM Login Page");

        // Step 3: Enter username
        page.fill("input[name='username']", "Admin");
        System.out.println("Entered username: Admin");

        // Step 4: Enter password
        page.fill("input[name='password']", "admin123");
        System.out.println("Entered password");

        // Step 5: Click the Login button
        page.click("button[type='submit']");
        System.out.println("Clicked Login button");

        // Step 6: Wait for dashboard to load after login
        page.waitForURL("**/dashboard**");
        System.out.println("Redirected to Dashboard");

        // Step 7: Assert we are on the dashboard
        String currentUrl = page.url();
        Assert.assertTrue(currentUrl.contains("dashboard"),
                "Login failed! Expected dashboard URL but got: " + currentUrl);

        // Step 8: Assert dashboard header is visible
        String header = page.locator("h6.oxd-text").first().textContent();
        System.out.println("✅ Dashboard header found: " + header);
        Assert.assertNotNull(header, "Dashboard header should be visible after login");

        System.out.println("Login test PASSED successfully!");
    }
}
