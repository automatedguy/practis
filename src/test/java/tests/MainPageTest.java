package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class MainPageTest extends BaseTest {
    private MainPage mainPage;

    @BeforeMethod
    public void login() {
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.setInputUsername(USERNAME);
        loginPage.setInputPassword(PASSWORD);
        mainPage = loginPage.clickOnButtonLogin();
    }

    @Test
    public void verifyDoButtons() {
        mainPage.doButtonsPage.clickOnButtonDO1();
        mainPage.doButtonsPage.clickOnButtonDO2();
    }

    @Test
    public void verifyChangeFontSizeArrows() {
        mainPage.fontSizePage.clickOnButtonIncrease();
        mainPage.fontSizePage.clickOnButtonDecrease();
    }

    @Test
    public void verifySetBackgroundColorButton() {
        final String backgroundColor = "black";
        mainPage.backgroundColorPage.setInputBackgroundColor(backgroundColor);
        mainPage.backgroundColorPage.clickOnButtonSetBackgroundColor();
    }
}
