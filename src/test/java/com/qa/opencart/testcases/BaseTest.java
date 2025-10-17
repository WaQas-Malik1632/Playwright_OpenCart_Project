package com.qa.opencart.testcases;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.OrderPageClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.Properties;

public class BaseTest
{
    PlaywrightFactory pf;
    Page page;
    Properties prop;
    protected HomePage home;
    protected LoginPage Login;
    protected OrderPageClass Odr;

    @BeforeTest
    public void Setup()
    {
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);
        Login = new LoginPage(page);
        home = new HomePage(page);
        Odr=new OrderPageClass(page);
    }

    @AfterTest
    public void Teardown()
    {
    }

}