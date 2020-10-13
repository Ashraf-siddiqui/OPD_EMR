package OPDEMR.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import OPDEMR.base.BasePage;

public class ChangePasswordPage extends BasePage {

	public ChangePasswordPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By OldPAsswordField=By.id("old-password");
	
	By NewPAsswordField=By.id("new-password");
	 
	By ConfirmPasswordField=By.id("confirm-new-password");
		
	By ChangePAsswordButton =By.id("submit");
	
	By ValidationAlertOnPasswordsField =By.id("js-flash-msg");
	
	
	public void CLickOnChangePAsswordButton()
	{
		
		waitForElementToBecomeVisible(ChangePAsswordButton, longWait);
		clickAndWait(ChangePAsswordButton, longWait);
	}
	
	public boolean VerifyValidationONPasswordFields()
	{
		boolean status=false;
		waitForElementToBecomeVisible(ValidationAlertOnPasswordsField, longWait);
		if(isElementPresent(ValidationAlertOnPasswordsField))
		{
			return status=true;
		}
		return status;
		
	}
	
	public void SetPasswordsField(String OldPAsswordText,String NewPAsswordText,String ConfirmPasswordText)
	{
		setText(OldPAsswordField, OldPAsswordText, longWait);
		setText(NewPAsswordField, NewPAsswordText, longWait);
		setText(ConfirmPasswordField, ConfirmPasswordText, longWait);
		
		
	}
	
	
}
