import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;


public class SampleTest extends BaseTest {

    @Test
    public void testWithValidCredentials() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.userLogin("Admin", "admin123");
    }
}