package com.qa.opencart.text;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.opencark.factory.PlayWrightFActory;
import com.qa.opencart.pages.HomePage;

public class HomePageTest {
	PlayWrightFActory pf;
	HomePage homePage;
	Page page;

	@BeforeTest
	void SetUp() 
	{
		pf =new PlayWrightFActory();
		page =pf.OpenBrowser("chrome","https://naveenautomationlabs.com/opencart/");// mention page object "page" r null point exception hit
		homePage = new HomePage(page);
	}
	@Test
	void GetPageTitle()
	{
		String getPageTitle = homePage.GetPageTitle();
		Assert.assertEquals(getPageTitle, "Your Store");
	}
	@Test
	void GetPageUrl() 
	{
		String getPageUrl = homePage.GetPageUrl();
		Assert.assertEquals(getPageUrl, "https://naveenautomationlabs.com/opencart/");
	}
	
	@DataProvider
	public Object[][] GetProductDataPr() 
	{
		return new Object[][] {{"macbook"},{"iphone"},{"Apple"},{"Canon"}};
	};
	
	@Test(dataProvider="GetProductDataPr")
	void SearchTest(String ProuctName) 
	{
		String doSearch = homePage.DoSearch(ProuctName);
		Assert.assertEquals(doSearch, "Search - "+ProuctName);
	}
	@AfterTest
	void TearDown() 
	{
		page.context().browser().close();
	}
}
