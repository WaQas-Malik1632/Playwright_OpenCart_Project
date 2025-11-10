package com.qa.opencart.testcases;

import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTestClass extends BaseTest
{
    @Test(priority = 1, enabled = true)
    public void HomePageUrlVerification()
    {
        String ActualUrl = home.getHomePageUrl();
        Assert.assertEquals(ActualUrl, prop.getProperty("url"));
    }

    @Test(priority = 2, enabled = true)
    public void HomePageTitle()
    {
        String ActualTitle = home.getHomePageTitle();
        Assert.assertEquals(ActualTitle, AppConstants.HOME_PAGE_TITLE);
    }

    @DataProvider
    public Object[] getProductData()
    {
        return new Object[]
                {
                        "Macbook", "iMac", "Samsung"
                };
    }

    @Test(priority = 3, dataProvider = "getProductData", enabled = true)
    public void HomePageSearch(String ProductName)
    {
        String actualSearchHeaderName = home.doSearch(ProductName);
        Assert.assertEquals(actualSearchHeaderName, "Search - " + ProductName);
    }
    @Test(priority = 4, enabled = true)
    public void viewProdDetails()
    {
        home.viewProductDetails();
        String actualProductDesc = home.viewProductDetails();
        String expectedDescText= "Samsung Galaxy Tab 10.1";
        Assert.assertEquals(actualProductDesc,expectedDescText, "Product description does not match!");
    }

    @Test(priority = 5, enabled = true)
    public void addProdReview()
    {
        home.addProductReview();
        Assert.assertTrue(true);
    }
}