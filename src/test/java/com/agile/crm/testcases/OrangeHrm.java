package com.agile.crm.testcases;

import org.testng.annotations.Test;

import com.agile.crm.Utils.Webutils;
import com.agile.crm.pages.AdminPages;
import com.agile.crm.pages.LoginPage;

public class OrangeHrm {
	Webutils wt= new	Webutils();
	@Test(priority = 1)
	public void validBrowserPage() {
		wt.MyExtentReport();
		wt.createExtesntTestReport("agileCrm.test");
		wt.launchBrowser("chrome");
		wt.Openurl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		wt.flushMethod() ;
	}
	@Test(priority = 2)
	public void ValidLoginpage() {
		LoginPage login= new LoginPage(wt);
		login.loginCrendential();
	}
	@Test(priority = 3)
	public void Admintest() {
		AdminPages add =new AdminPages(wt);
		add.adminAdd();

	}
}
