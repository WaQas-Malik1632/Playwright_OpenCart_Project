package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;
    private String search = "//*[@id=\"search\"]/input";
    private String searchIcon = "//*[@id=\"search\"]/span/button";
    private String searchPageHeader = "div#content h1";
    private String myAccountLink="//span[normalize-space()='My Account']";
    private String loginLink="a:text('login')";

    public HomePage(Page page) {

        this.page = page;
    }

    public String getHomePageTitle() {

        String title = page.title();
        System.out.println("Page Title is: " + title);
        return title;
    }

    public String getHomePageUrl() {

        String URL = page.url();
        System.out.println("Url is: " + URL);
        return URL;
    }

    public String doSearch(String ProductName) {

        page.fill(search, ProductName);
        page.click(searchIcon);
        String header = page.textContent(searchPageHeader);
        System.out.println("Search product name: " + header);
        return header;
    }
    public LoginPage navigateToLogin(){
        page.click(myAccountLink);
        page.click(loginLink);

        return new LoginPage(page);
    }

}
