package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsConfirmation {

	@FindBy(css="#transfer_funds_content > div > div > div.alert.alert-success")
	private WebElement succMsgBox;
	
	@FindBy(css="#settingsBox > ul > li:nth-child(3) > a")
	private WebElement username;
	
	@FindBy(id="logout_link")
	private WebElement logout;
	
	@FindBy(id="signin_button")
	private WebElement signIn;
	
	public TransferFundsConfirmation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public String getConfMsg() {
		String confMsg = succMsgBox.getText();
		return confMsg;
	}
	
	public void logoutFromApp() {
		username.click();
		logout.click();
		signIn.click();
	}
}
