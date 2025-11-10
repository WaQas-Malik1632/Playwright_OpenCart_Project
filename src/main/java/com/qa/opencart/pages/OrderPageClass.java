package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class OrderPageClass
{
    private Page page;
    private final String itemMacbook="//div[@class='image']//img[@title='MacBook']";
    private final String ProdImgView="//div[@id='product-product']//li[1]//a[1]//img[1]";
    private final String rightArrow1Click="//button[@title='Next (Right arrow key)']";
    private final String rightArrow2Click="//button[@title='Next (Right arrow key)']";
    private final String rightArrow3Click="//button[@title='Next (Right arrow key)']";
    private final String rightArrow4Click="//button[@title='Next (Right arrow key)']";
    private final String closeImgIcon="//button[@title='Close (Esc)']";

    public OrderPageClass(Page page)
    {
        this.page = page;
    }

    public void viewProductDetailsForOrder()
    {
        page.evaluate("window.scrollBy(0, 500)");
        page.click(itemMacbook);
        page.click(ProdImgView);
        page.click(rightArrow1Click);
        page.click(rightArrow2Click);
        page.click(rightArrow3Click);
        page.click(rightArrow4Click);
        page.click(closeImgIcon);

        page.evaluate("window.scrollBy(0, 500)");

    }
}
