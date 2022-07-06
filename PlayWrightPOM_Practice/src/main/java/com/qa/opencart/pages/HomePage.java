package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

private	Page page;
//	1.Locator

	private	String Searchbox="div#search input";
	private	String Searchicon="div#search button";
	private	String SeachResultHeader="div#content h1";


//	2.Constructor
	public HomePage (Page page) 
	{
		this.page=page;
	}

	public String GetPageTitle() 
	{
		String title = page.title();
		System.out.println("Page title is :"+title);
		return title;
	}
	public String GetPageUrl() {
		String url = page.url();
		System.out.println("Page Url is:"+url);
		return url;
	}
	
	public String DoSearch(String ProductName) {
		page.fill(Searchbox,ProductName );
		page.click(Searchicon);
		String ResultHeader = page.textContent(SeachResultHeader);
		System.out.println("result header :"+ResultHeader);
		return ResultHeader;
		
	}
}
