import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstPlaywrightTest {
    private Playwright playwright;
    private Browser browser;
    private Page page;

    @BeforeMethod
    public void setUp(){
        playwright=Playwright.create(); //turn on playwright automation engine
        browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); //selecting the browser
        page=browser.newPage(); //opening a new tab

    }

    @Test
    public void loginPageValidator(){
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String title=page.title(); //get the website's title
        System.out.println("The page title is " + title);
        Assert.assertTrue(
                title.contains("OrangeHRM"),
                "Expected title to contain 'OrangeHRM' but got: " + title
        );
    }

    @AfterTest //will run after the tests is done
    public void teardown(){
        browser.close();  //close the browser after the test
        playwright.close();
    }
}


  