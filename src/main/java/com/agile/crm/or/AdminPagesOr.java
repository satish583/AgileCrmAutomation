package com.agile.crm.or;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPagesOr {

	@FindBy(xpath = "//span[text()='Admin']")
	protected WebElement adminclik;
	
	@FindBy(xpath = "//h6[text()='User Management']")
	protected WebElement tittlematchElement;
	
	@FindBy(xpath = "//span[text()='User Management ']")
	protected WebElement weusermangElement;
	
	@FindBy(xpath ="//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]//child::i" )
	protected WebElement addussersElement;
	
//	crm form
	@FindBy(xpath = "//label[text()='User Role']//ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//i")
	protected WebElement selectedtagElement;
	
	@FindBy(xpath = "//div[text()='ESS']")
	protected WebElement clickOnESSElement;
	
	@FindBy(xpath = "//label[text()='Status']//ancestor::div[@class='oxd-grid-item oxd-grid-item--gutters']//following-sibling::div[@class=\"oxd-select-wrapper\"]")
	protected WebElement selectedenabledElement;
	
	@FindBy(xpath = "//div[text()='Enabled']")
	protected WebElement clickOnEnavledElement;
}
