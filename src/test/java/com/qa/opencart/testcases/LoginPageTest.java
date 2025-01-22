package com.qa.opencart.testcases;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.factory.PlaywrightFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void loginPageNavigationTest() {
        Login = home.navigateToLogin();
        String actualLoginPageTitle = Login.getLoginPageTitle();
        System.out.println("Actual Login Page Title is:" + actualLoginPageTitle);

        Assert.assertEquals(actualLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2 ,enabled=true)
    public void ForgotLinkExistTest() {
        Assert.assertTrue(Login.isForgetPassLinkExists());

    }

    @Test(priority = 3, enabled=true)
    public void appLoginTest() {
        Assert.assertTrue(Login.doLogin(prop.getProperty("username"),prop.getProperty("password")));
    }

    @Test
    public void ArrayOperations() {

        PlaywrightFactory.takeScreenshot();

        Integer[] arr = {223, 100, 856, 3};
        System.out.println("Numbers are:" +Arrays.toString(arr));
      //  Arrays.sort(arr);


        Arrays.sort(arr, Collections.reverseOrder());

        System.out.println("\n"+"Sorted Numbers are:" +Arrays.toString(arr));

        int max = arr[0];
        for (int i = 0; i <arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Maximum number is:" + max);
    }
}
