package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;
    private String search = "//*[@id=\"search\"]/input";
    private String searchIcon = "//*[@id=\"search\"]/span/button";
    private String SearchPageHeader = "div#content h1";

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
        String header = page.textContent(SearchPageHeader);
        System.out.println("Search product name: " + header);
        return header;
    }

}
