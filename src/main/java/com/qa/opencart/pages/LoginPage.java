package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage
{
    private Page page;

    private final String emailId = "//input[@id='input-email']";
    private final String pass = "//input[@id='input-password']";
    private final String loginBtnClick = "//input[@value='Login']";
    private final String clickForgotPassword = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
    private final String logoutBtn = "//a[@class='list-group-item'][normalize-space()='Logout']";

    public LoginPage(Page page)
    {
        this.page = page;
    }

    public String getLoginPageTitle()
    {
        return page.title();
    }

    public boolean isForgetPassLinkExists()
    {
        return page.isVisible(clickForgotPassword);
    }


    public boolean doLogin(String appUserName, String appPassword)
    {
        System.out.println("App Credentials: " + appUserName + " : " + appPassword);

        // Fill in login fields
        page.fill(emailId, appUserName);
        page.fill(pass, appPassword);

        // Click on login button
        page.click(loginBtnClick);

        if (page.isVisible(logoutBtn))
        {
            System.out.println("User is logged in successfully->" + appUserName);
            return true;
        }
        return false;
    }
}

