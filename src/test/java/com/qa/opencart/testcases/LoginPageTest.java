package com.qa.opencart.testcases;

import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest
{
    @Test(priority = 1, enabled = true)
    public void loginPageNavigationTest()
    {
        Login = home.navigateToLogin();
        String actualLoginPageTitle = Login.getLoginPageTitle();
        System.out.println("Actual Login Page Title is:" + actualLoginPageTitle);

        Assert.assertEquals(actualLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2 ,enabled=true)
    public void ForgotLinkExistTest()
    {
        Assert.assertTrue(Login.isForgetPassLinkExists());

    }
    @DataProvider(name = "loginData")
    public Object[][] getUsersData()
    {
        return new Object[][]{
                        {"WebUser@youpmail.com", "Demo@1234"},
                        {"Waqas@gmail.com", "Test@123"},
                        {"User@mail.com", "123@Demo"},
                        {"Testerqaw@youpmail.com", "Playwright@123"}
        };
    }

    @Test(priority = 3, dataProvider = "loginData", enabled = true)
    public void appLoginTest(String userEmail, String pass)
    {
        // if we want to get the user credentials from Config file
       // Assert.assertTrue(Login.doLogin(prop.getProperty("username"),prop.getProperty("password")));

        // Perform login using data provider credentials
        boolean loginStatus = Login.doLogin(userEmail, pass);

        // Validate login
        Assert.assertTrue(loginStatus, "Login failed for user: " + userEmail);
    }
}
