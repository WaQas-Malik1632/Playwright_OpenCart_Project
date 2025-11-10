package com.qa.opencart.testcases;

import org.testng.annotations.Test;

public class OrderPageTest extends BaseTest
{
    @Test(priority = 1, enabled = true)
    public void CheckOrderPage()
    {
        Odr.viewProductDetailsForOrder();
    }
}