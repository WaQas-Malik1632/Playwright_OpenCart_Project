package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage
{
    private Page page;

    private final String myAccountLink="//span[normalize-space()='My Account']";
    private final String loginLink="a:text('login')";
    private final String search = "//*[@id=\"search\"]/input";
    private final String searchIcon = "//*[@id=\"search\"]/span/button";
    private final String searchPageHeader = "div#content h1";
    //Product detail page
    private final String ProdCLick="//img[@title=\"Samsung Galaxy Tab 10.1\"]";
    private final String ProdImgView="//ul[@class='thumbnails']//li[1]//a[1]";
    private final String rightArrowClick="//button[@title='Next (Right arrow key)']";
    private final String closeImgIcon="//button[@title='Close (Esc)']";
    private final String productDetailText="//*[@id=\"tab-description\"]/p[1]/text()";


    public HomePage(Page page)
    {
        this.page = page;
    }

    public String getHomePageTitle()
    {
        String title = page.title();
        System.out.println("Page Title is: " + title);
        return title;
    }

    public String getHomePageUrl()
    {
        String URL = page.url();
        System.out.println("Url is: " + URL);
        return URL;
    }

    public String doSearch(String ProductName)
    {
        page.fill(search, ProductName);
        page.click(searchIcon);

        String header = page.textContent(searchPageHeader);
        System.out.println("Search product name: " + header);
      //  page.evaluate("window.scrollBy(0, 600)");
        page.click(ProdCLick);
        return header;

    }
    public void viewProductDetails()
    {
        page.click(ProdImgView);
        page.click(rightArrowClick);
        page.click(closeImgIcon);
        page.evaluate("window.scrollBy(0, 400)");
        System.out.println("Product image closed:");
        String productDescText = page.getByText(productDetailText).textContent();
        System.out.println("Product description: "+productDescText);

    }

    public LoginPage navigateToLogin()
    {
        page.click(myAccountLink);
        page.click(loginLink);

        return new LoginPage(page);
    }


}
