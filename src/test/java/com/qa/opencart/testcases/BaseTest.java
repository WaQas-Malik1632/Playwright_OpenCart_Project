package com.qa.opencart.testcases;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.Properties;

public class BaseTest {

    PlaywrightFactory pf;
    Page page;
    public static Properties prop;

    protected HomePage home;
    protected LoginPage Login;

    @BeforeTest
    public void Setup() {

        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);
        home = new HomePage(page);
    }

    @AfterTest
    public void Teardown() {
        page.context().browser().close();
    }

}