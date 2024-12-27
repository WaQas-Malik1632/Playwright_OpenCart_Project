package com.qa.opencart.testcases;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.Properties;

public class BaseTest {

    PlaywrightFactory pf;
    Page page;
    protected Properties prop;
    protected HomePage home;

    @BeforeTest
    public void setup() {

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
