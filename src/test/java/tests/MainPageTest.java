package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.MainPage;

public class MainPageTest extends BaseTest {
    private MainPage mainPage;

    @BeforeMethod
    public void login() {
        openBaseUrl();
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.setInputUsername(USERNAME);
        loginPage.setInputPassword(PASSWORD);
        mainPage = loginPage.clickOnButtonLogin();
    }

    @Test(priority = 1)
    public void verifyDoButtons() {
        SoftAssert softAssert = new SoftAssert();

        // Assert buttons default states
        softAssert.assertTrue(mainPage.doButtonsPage.isButtonDO2IsDisabled());
        softAssert.assertFalse(mainPage.doButtonsPage.isButtonDO1IsDisabled());

        // Click on button DO1 and assert buttons new state
        mainPage.doButtonsPage.clickOnButtonDO1();
        softAssert.assertFalse(mainPage.doButtonsPage.isButtonDO2IsDisabled());
        softAssert.assertTrue(mainPage.doButtonsPage.isButtonDO1IsDisabled());

        // Click on button DO2 and assert buttons state is back to default
        mainPage.doButtonsPage.clickOnButtonDO2();
        softAssert.assertTrue(mainPage.doButtonsPage.isButtonDO2IsDisabled());
        softAssert.assertFalse(mainPage.doButtonsPage.isButtonDO1IsDisabled());

        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void verifyChangeFontSizeArrows() {
        SoftAssert softAssert = new SoftAssert();
        final String FONT_SIZE_DEFAULT = "20";
        final String FONT_SIZE_INCREASED = "23";

        // Assert default font size
        softAssert.assertTrue(mainPage.fontSizePage.isFontSizeCorrect(FONT_SIZE_DEFAULT));

        // Click on increase size button and assert font size increased
        mainPage.fontSizePage.clickOnButtonIncrease();
        softAssert.assertTrue(mainPage.fontSizePage.isFontSizeCorrect(FONT_SIZE_INCREASED));

        // Click on decrease size button and assert font size decreased
        mainPage.fontSizePage.clickOnButtonDecrease();
        softAssert.assertTrue(mainPage.fontSizePage.isFontSizeCorrect(FONT_SIZE_DEFAULT));

        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void verifySetBackgroundColorButton() {
        SoftAssert softAssert = new SoftAssert();
        final String BACKGROUND_COLOR_GREEN = "green";
        final String BACKGROUND_COLOR_BLACK = "black";

        // Set background color to green and assert the change
        mainPage.backgroundColorPage.setInputBackgroundColor(BACKGROUND_COLOR_GREEN);
        mainPage.backgroundColorPage.clickOnButtonSetBackgroundColor();
        softAssert.assertTrue(mainPage.backgroundColorPage.isBackgroundColorCorrect(BACKGROUND_COLOR_GREEN));

        // Set background color to black and assert the change
        mainPage.backgroundColorPage.setInputBackgroundColor(BACKGROUND_COLOR_BLACK);
        mainPage.backgroundColorPage.clickOnButtonSetBackgroundColor();
        softAssert.assertTrue(mainPage.backgroundColorPage.isBackgroundColorCorrect(BACKGROUND_COLOR_BLACK));

        softAssert.assertAll();
    }
}
