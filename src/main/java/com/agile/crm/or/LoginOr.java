package com.agile.crm.or;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginOr {
	//loginnbutton
	@FindBy(xpath = "//a[text()='LOGIN']")
	protected WebElement loginElement;
	//	login Domain
	@FindBy(xpath = "//input[@placeholder=\"Domain\"]")
	protected WebElement domaintextboxElement;
	//	loginsubmit
	@FindBy(xpath = "//form[@id='choose_domain']//input[@type='submit']")
	protected WebElement wesubmitbuttonElement;
	//	logincrendial
	@FindBy(xpath = "//input[@name='username']")
	protected WebElement usernameTxt;

	@FindBy(xpath = "//input[@name='password']")
	protected WebElement passwordtaxtbox;

	@FindBy(xpath = "//button[@type='submit']")
	protected WebElement submitbutonElement;
}
