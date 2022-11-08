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

        softAssert.assertTrue(mainPage.doButtonsPage.isButtonDO2IsDisabled());
        softAssert.assertFalse(mainPage.doButtonsPage.isButtonDO1IsDisabled());
        mainPage.doButtonsPage.clickOnButtonDO1();

        softAssert.assertFalse(mainPage.doButtonsPage.isButtonDO2IsDisabled());
        softAssert.assertTrue(mainPage.doButtonsPage.isButtonDO1IsDisabled());
        mainPage.doButtonsPage.clickOnButtonDO2();

        softAssert.assertTrue(mainPage.doButtonsPage.isButtonDO2IsDisabled());
        softAssert.assertFalse(mainPage.doButtonsPage.isButtonDO1IsDisabled());

        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void verifyChangeFontSizeArrows() {
        mainPage.fontSizePage.clickOnButtonIncrease();
        mainPage.fontSizePage.clickOnButtonDecrease();
    }

    @Test(priority = 3)
    public void verifySetBackgroundColorButton() {
        final String backgroundColor = "black";
        mainPage.backgroundColorPage.setInputBackgroundColor(backgroundColor);
        mainPage.backgroundColorPage.clickOnButtonSetBackgroundColor();
    }
}
