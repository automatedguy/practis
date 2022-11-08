package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    public DoButtonsPage doButtonsPage;
    public FontSizePage fontSizePage;
    public BackgroundColorPage backgroundColorPage;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        doButtonsPage = new DoButtonsPage(webDriver);
        fontSizePage = new FontSizePage(webDriver);
        backgroundColorPage = new BackgroundColorPage(webDriver);
    }

    public class DoButtonsPage extends BasePage {
        @FindBy(id = "do1")
        private WebElement buttonDO1;
        @FindBy(id = "do2")
        private WebElement buttonDO2;

        public DoButtonsPage(WebDriver webDriver) {
            super(webDriver);
            PageFactory.initElements(webDriver, this);
        }

        public DoButtonsPage clickOnButtonDO1() {
            logger.info("Clicking on button DO1");
            buttonDO1.click();
            return this;
        }

        public DoButtonsPage clickOnButtonDO2() {
            logger.info("Clicking on button DO2");
            buttonDO2.click();
            return this;
        }
    }

    public class FontSizePage extends BasePage {
        @FindBy(id = "btnIncreaseFont")
        private WebElement buttonIncreaseFont;
        @FindBy(id = "btnDecreaseFont")
        private WebElement buttonDecreaseFont;

        public FontSizePage(WebDriver webDriver) {
            super(webDriver);
            PageFactory.initElements(webDriver, this);
        }

        public FontSizePage clickOnButtonIncrease() {
            logger.info("Clicking on button increase font size");
            buttonIncreaseFont.click();
            return this;
        }

        public FontSizePage clickOnButtonDecrease() {
            logger.info("Clicking on button decrease font size");
            buttonDecreaseFont.click();
            return this;
        }
    }

    public class BackgroundColorPage extends BasePage {
        @FindBy(id = "bgColor")
        WebElement inputBackgroundColor;
        @FindBy(id = "btnSetBgColor")
        WebElement buttonSetBackgroundColor;

        public BackgroundColorPage(WebDriver webDriver) {
            super(webDriver);
            PageFactory.initElements(webDriver, this);
        }

        public BackgroundColorPage setInputBackgroundColor(String backgroundColor) {
            logger.info("Setting background color: " + backgroundColor);
            inputBackgroundColor.sendKeys(backgroundColor);
            return this;
        }

        public BackgroundColorPage clickOnButtonSetBackgroundColor() {
            logger.info("Clicking on set background color button");
            buttonSetBackgroundColor.click();
            return this;
        }
    }
}
