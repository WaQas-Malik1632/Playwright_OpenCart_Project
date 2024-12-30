package com.qa.opencart.testcases;

import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTestClass extends BaseTest {

    @Test(priority = 1)
    public void HomePageUrlVerification() {

        String ActualUrl = home.getHomePageUrl();
        Assert.assertEquals(ActualUrl, prop.getProperty("url"));
    }

    @Test(priority = 2)
    public void HomePageTitle() {

        String ActualTitle = home.getHomePageTitle();
        Assert.assertEquals(ActualTitle, AppConstants.HOME_PAGE_TITLE);
    }

    @DataProvider
    public Object[][] getProductData() {

        return new Object[][]{
                {"Macbook"},
                {"iMac"},
                {"Samsung"},
        };
    }

    @Test(priority = 3, dataProvider = "getProductData")
    public void HomePageSearch(String ProductName) {

        String ActualSearchHeaderName = home.doSearch(ProductName);
        Assert.assertEquals(ActualSearchHeaderName, "Search - " + ProductName);
    }

}