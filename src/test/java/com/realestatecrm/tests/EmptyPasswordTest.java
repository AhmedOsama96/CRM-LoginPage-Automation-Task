package com.realestatecrm.tests;

import com.realestatecrm.base.BaseTest;
import com.realestatecrm.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmptyPasswordTest extends BaseTest {
    private final String VALID_EMAIL = "mahmoudmaamoun08@gmail.com";
    private final String EMPTY_PASSWORD = "";


    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Verify login fails with empty password")
    @Story("Invalid Login Scenarios")
    public void testEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.enterEmail(VALID_EMAIL);
        loginPage.enterPassword(EMPTY_PASSWORD);
        loginPage.clickSignIn();

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed");
        Assert.assertTrue(loginPage.getErrorMessageText().contains("please fill out this filed"),
                "Error message text is incorrect");

    }
}