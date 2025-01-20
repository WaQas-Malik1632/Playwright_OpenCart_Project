package com.qa.opencart.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;


    private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    private static ThreadLocal<Page> tlPage = new ThreadLocal<>();

    private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

    public static Playwright getPlaywright() {

        return tlPlaywright.get();
    }

    public static Browser getBrowser() {

        return tlBrowser.get();
    }

    public static BrowserContext getBrowserContext() {

        return tlBrowserContext.get();
    }

    public static Page getPage() {

        return tlPage.get();
    }

    public Properties init_prop() {

        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
            prop = new Properties();
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public Page initBrowser(Properties prop) {

        String browserName = prop.getProperty("browser").trim();
        System.out.println("Launching Browser: " + browserName);
        //Capture screenSize
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        System.out.println("Your screen size is->" + width + ":" + height);

       // playwright = Playwright.create();
        tlPlaywright.set(Playwright.create());

        switch (browserName.toLowerCase()) {
            case "chromium":
                //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000)));
                break;
            case "firefox":
                //  browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
                tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000)));
                break;
            case "safari":
                //  browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
                tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000)));
                break;
            case "chrome":
                // browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(2000));
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(2000)));
                break;
            case "edge":
                // browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setSlowMo(2000));
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setSlowMo(2000)));
                break;
            default:
                System.out.println("You are entering wrong browser name :" + browserName);
                break;
        }
        //You can set any size in 'SetViewportSize' like-> 1500, 768
        // browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
        tlBrowserContext.set(getBrowser().newContext(new Browser.NewContextOptions().setViewportSize(width, height)));
        //  page = browserContext.newPage();
        tlPage.set(getBrowserContext().newPage());
        //  page.navigate(prop.getProperty("url").trim());
        getPage().navigate(prop.getProperty("url").trim());

        return getPage();
    }

}