package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

public class BasePage {
    public BasePage(Page page) {
        this.page = page;
    }

    protected final Page page;
}
