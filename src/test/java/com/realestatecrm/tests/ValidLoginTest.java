package com.realestatecrm.tests;

import com.realestatecrm.base.BaseTest;
import com.realestatecrm.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidLoginTest extends BaseTest {
    private final String VALID_EMAIL = "mahmoudmaamoun08@gmail.com";
    private final String VALID_PASSWORD = "Ss@123456789";
    private final String EMPTY_PASSWORD = "";

    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Verify successful login with valid credentials")
    @Story("Valid Login Scenario")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.enterEmail(VALID_EMAIL);
        loginPage.enterPassword(VALID_PASSWORD);
        loginPage.clickSignIn();

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful");
    }


}