package com.qa.opencark.factory;

import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlayWrightFActory {
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	Properties prop;
	public Page OpenBrowser(String browserName, String URL) 
	{
		playwright = Playwright.create();
		System.out.println("Browser name is :"+browserName);
		switch (browserName)
		{
		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

		case "chrome":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			break;

		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

		default:
			System.out.println("pleas enter valid browser name.......");
			break;
		}
		browserContext = browser.newContext();
		page = browserContext.newPage();
		page.navigate(URL);
		return page;
	}

}
