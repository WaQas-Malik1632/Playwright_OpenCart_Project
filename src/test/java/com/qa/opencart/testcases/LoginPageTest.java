package com.qa.opencart.testcases;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.factory.PlaywrightFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LoginPageTest extends BaseTest {

    @Test(priority = 3, enabled = false)
    public void loginPageNavigationTest() {
        Login = home.navigateToLogin();
        String actualLoginPageTitle = Login.getLoginPageTitle();
        System.out.println("Actual Login Page Title is:" + actualLoginPageTitle);

        Assert.assertEquals(actualLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 4 ,enabled=false)
    public void ForgotLinkExistTest() {
        Assert.assertTrue(Login.isForgetPassLinkExists());

    }

    @Test(priority = 2, enabled=false)
    public void appLoginTest() {
        Assert.assertTrue(Login.doLogin(prop.getProperty("username"),prop.getProperty("password")));
    }

    @Test(priority = -1, enabled=true)
    public void ArrayOperations() {

        PlaywrightFactory.takeScreenshot();

        Integer[] arr = {223, 100, 856, 3};
        System.out.println("Numbers are:" +Arrays.toString(arr));

         Arrays.sort(arr);  //Sort array in Ascending order

       // Arrays.sort(arr, Collections.reverseOrder()); //Sort array in reverse order

        System.out.println("\n"+"Sorted Numbers are:" +Arrays.toString(arr));

        int max = arr[0];
        for (int i = 0; i <arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Maximum number is:" + max);

        String originalString="civic";
        System.out.println("Original String is:" +originalString);
/*
        String ReversedName=new StringBuilder(originalString).reverse().toString();
        System.out.println("Reverse Name is:" + ReversedName);
    */

      //  Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
       // System.out.print("Enter a string: ");    // Prompt the user to enter a string
      //  String originalString = scanner.nextLine();   // Read the input string

        String reversedString = "";                   // Initialize an empty string to store the reversed result
        for (int i = originalString.length() - 1; i >= 0; i--) { // Loop from the end of the string to the beginning
            reversedString = reversedString + originalString.charAt(i);   // Append each character in reverse order
        }

        System.out.println("Reversed String is-> " + reversedString); // Output the reversed string
    }
}
