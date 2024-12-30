package com.agile.crm.pages;

import org.openqa.selenium.support.PageFactory;

import com.agile.crm.Utils.Webutils;
import com.agile.crm.or.AdminPagesOr;

public class AdminPages extends AdminPagesOr {
	public Webutils wt;

	public AdminPages(Webutils wt) {
		this.wt=wt;
	PageFactory.initElements(wt.getDriver(),this);	
	}
	public void adminAdd() {
		wt.ClickElement(adminclik, "click the admin page");
		wt.Verifytext(tittlematchElement,"User Management");
//		wt.ClickElement(weusermangElement, "usermanagementclick");
		wt.ClickElement(addussersElement, "adduser click");
//		wt.DropDown(selectedtagElement, "ESS", "DropDown click Sucessfully");
//		wt.DropDown(selectedenabledElement, "Enabled", "enable or disable funaction ");
		//wt.ClickElement(selectedenabledElement, "click on successfully");
		//wt.ClickElement(clickOnEnavledElement, "successfully");
	}
	public void addform() {
		wt.DropDown(selectedtagElement, "ESS", "DropDown click Sucessfully");
	    wt.ClickElement(clickOnESSElement, "click on successfully");
		
		wt.DropDown(weusermangElement, "Enabled", "enable or disable funaction ");
		
	    wt.ClickElement(selectedenabledElement, "click on successfully");
	
	
	}
}
