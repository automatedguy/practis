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
        doButtonsPage = new DoButtonsPage(webDriver);
        fontSizePage = new FontSizePage(webDriver);
        backgroundColorPage = new BackgroundColorPage(webDriver);
    }

    public class DoButtonsPage extends BasePage {
        @FindBy(id = "do1")
        private WebElement buttonDO1;
        @FindBy(id = "do2")
        private WebElement buttonDO2;

        final String BUTTON_DISABLED = "button disabled";

        public DoButtonsPage(WebDriver webDriver) {
            super(webDriver);
            PageFactory.initElements(webDriver, this);
        }

        public DoButtonsPage clickOnButtonDO1() {
            logger.info("Clicking on button DO1");
            buttonDO1.click();
            return this;
        }

        public boolean isButtonDO1IsDisabled() {
            logger.info("Checking if button DO1 is disabled");
            return buttonDO1.getAttribute("class").equals(BUTTON_DISABLED);
        }

        public DoButtonsPage clickOnButtonDO2() {
            logger.info("Clicking on button DO2");
            buttonDO2.click();
            return this;
        }

        public boolean isButtonDO2IsDisabled() {
            logger.info("Checking if button DO2 is disabled");
            return buttonDO2.getAttribute("class").equals(BUTTON_DISABLED);
        }
    }

    public class FontSizePage extends BasePage {
        @FindBy(id = "btnIncreaseFont")
        private WebElement buttonIncreaseFont;
        @FindBy(id = "btnDecreaseFont")
        private WebElement buttonDecreaseFont;
        @FindBy(id = "textFontSize")
        private WebElement textFontSize;

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

        public boolean isFontSizeCorrect(String expectedFontSize) {
            logger.info("Getting current font size");
            return textFontSize.getAttribute("style").equals("font-size: " + expectedFontSize + "px;");
        }
    }

    public class BackgroundColorPage extends BasePage {
        @FindBy(id = "bgColor")
        WebElement inputBackgroundColor;
        @FindBy(id = "btnSetBgColor")
        WebElement buttonSetBackgroundColor;
        @FindBy(id = "formToColorize")
        WebElement formToColorize;

        public BackgroundColorPage(WebDriver webDriver) {
            super(webDriver);
            PageFactory.initElements(webDriver, this);
        }

        public BackgroundColorPage setInputBackgroundColor(String backgroundColor) {
            logger.info("Setting background color: " + backgroundColor);
            inputBackgroundColor.clear();
            inputBackgroundColor.sendKeys(backgroundColor);
            return this;
        }

        public BackgroundColorPage clickOnButtonSetBackgroundColor() {
            logger.info("Clicking on set background color button");
            buttonSetBackgroundColor.click();
            return this;
        }

        public boolean isBackgroundColorCorrect(String expectedBackgroundColor) {
            logger.info("Checking background color is set correctly");
            return formToColorize.getAttribute("style").equals("background: " + expectedBackgroundColor + ";");
        }
    }
}
