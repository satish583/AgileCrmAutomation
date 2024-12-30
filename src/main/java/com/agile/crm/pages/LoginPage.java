package com.agile.crm.pages;

import org.openqa.selenium.support.PageFactory;

import com.agile.crm.Utils.Webutils;
import com.agile.crm.or.LoginOr;

public class LoginPage extends LoginOr{
	public Webutils wt;
	public LoginPage(Webutils wt) {
		this.wt=wt;
		PageFactory.initElements(wt.getDriver(), this);
	}
////	public void logincrm() {
//		wt.ClickElement(loginElement,"login button");
//	}
//	public void Domainlog() {
//		wt.sendkeysElement(domaintextboxElement, "expert2024", "domain tax box");
//		wt.ClickElement(wesubmitbuttonElement, "submit button");
//	}
	
	public void loginCrendential() {
		wt.sendkeysElement(usernameTxt, "Admin", "email value taxbox");
		wt.sendkeysElement(passwordtaxtbox, "admin123", "password value");
		wt.ClickElement(submitbutonElement, "submit crendition button");
	}
	
}
