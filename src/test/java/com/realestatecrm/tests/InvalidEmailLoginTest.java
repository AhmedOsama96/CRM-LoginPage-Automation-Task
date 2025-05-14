package com.realestatecrm.tests;

import com.realestatecrm.base.BaseTest;
import com.realestatecrm.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.Assert;


public class InvalidEmailLoginTest extends BaseTest {
    private final String VALID_PASSWORD = "Ss@123456789";
    private final String INVALID_EMAIL = "invalid@email.com";

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Verify login fails with invalid email")
    @Story("Invalid Login Scenarios")
    public void testInvalidEmail() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.enterEmail(INVALID_EMAIL);
        loginPage.enterPassword(VALID_PASSWORD);
        loginPage.clickSignIn();

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed");
        Assert.assertTrue(loginPage.getErrorMessageText()
                        .contains("These credentials do not match our records."),
                "Error message text is incorrect");
    }
}