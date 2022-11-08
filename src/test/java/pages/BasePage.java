package pages;

import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public abstract class BasePage {
    private WebDriver webDriver;
    public final Logger logger = Logger.getLogger("BasePage");

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}

