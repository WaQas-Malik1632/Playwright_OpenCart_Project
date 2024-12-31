package com.qa.opencart.testcases;

import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void loginPageNavigationTest() {
        Login = home.navigateToLogin();
        String actualLoginPageTitle = Login.getLoginPageTitle();
        System.out.println("Actual Login Page Title is:" + actualLoginPageTitle);

        Assert.assertEquals(actualLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void ForgotLinkExistTest() {
        Assert.assertTrue(Login.isForgetPassLinkExists());

    }

    @Test(priority = 3)
    public void appLoginTest() {
        Assert.assertTrue(Login.doLogin(prop.getProperty("username"),prop.getProperty("password")));
    }
}
