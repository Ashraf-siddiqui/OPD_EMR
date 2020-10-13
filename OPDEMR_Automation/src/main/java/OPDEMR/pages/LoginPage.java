package OPDEMR.pages;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

import OPDEMR.base.BasePage;
import OPDEMR.utils.DataUtils;
import OPDEMR.utils.TestUtils;

public class LoginPage extends BasePage {

	public LoginPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public static final String ACCOUNT_SID = "AC6b88c0d4c5ffb2c254d65eb6a045b9fe";
	public static final String AUTH_TOKEN = "8edea6d225c84ccd4953b0da4a09e0ac";

    By UserNAmeField = By.xpath("//input[@id='username']");
		
	By PasswordField=By.xpath("//input[@id='password']");
		
	By OKButton=By.xpath("//div[@id='pendingPatientsConfirmOK']");
		
	By LoginButton= By.xpath("//form[@id='gid_login_form']//button");
		
	By ClickHereLink = By.xpath("//form[@id='gid_login_form']//a");
	
	By ValidationMessage=By.xpath("//*[contains(text(),'Credentials')]");
	
	By Dashboard=By.xpath("//div[@id='main_menu']//ul[1]//li[1]//a");
	
	By EyeIcon=By.xpath("//input[@id='password']//following-sibling::span");
	
	By TermsAndConditionLink=By.xpath("//a[contains(text(),'Terms and Conditions')]");
	
	By CloseIconOnTermsAndConditionDocument=By.xpath("//div[@id='terms-conditions']//button[@class='close']");
	
	By DocumentOfTermAndCondition= By.xpath("//div[@id='terms-conditions']//div[@class='modal-body py-0']//p");
	
	By LoadingIndicator=By.xpath("//p[contains(text(),'Please hold on for couple of seconds while we sync')]");
	
	By MobileNUmberField=By.id("mobile");
	
	By LoginButtonOnMobileScreen=By.xpath("//div[@class='col-12 my-3']//button[@class='btn btn-primary text-uppercase btn-block'][contains(text(),'Login')]");
	
	
	public void LoadToOPDEMR()
	{
		driver.get().get("https://uat.opdemr.myhealthcare.co/");
		
		waitForElementToBecomeVisible(UserNAmeField, longWait);
	}
	
	
	
	public void LoginToOPDEMRwithCredentials(String UserName,String Password)
	{
		
		
		waitForElementToBecomeVisible(UserNAmeField, longWait);
		
		setText(UserNAmeField, UserName, longWait);
		setText(PasswordField, Password, longWait);
		clickAndWait(LoginButton, longWait);
//		waitForElementToBecomeVisible(OKButton, longWait);
//		clickAndWait(OKButton, shortWait);
		HandlePendingPatientsDialougeBox();
		
	}
	
	public void HandlePendingPatientsDialougeBox() {
		waitForElementToBecomeVisible(OKButton, longWait);
		if(isElementPresent(OKButton))
		{
			
		clickAndWait(OKButton, minimalWait);
		
		}
		
	}

	
	public boolean ValidateInvalidCredentialsAlertMessage()
	{
		waitForElementToBecomeVisible(ValidationMessage, shortWait);
		boolean status=false;
		if(isElementPresent(ValidationMessage))
		{
			return status=true;
		}
		
		
		return status;
	}
	
	
	public boolean ValidateMaskedValueForPasswordField()
	{
		setText(PasswordField, "Password", longWait);
		TestUtils.sleep(2);
		boolean status=false;
		if(getAttribute(PasswordField, "type").equalsIgnoreCase("password"))
		{
			return status=true;
		}
		
		return status;
		
		
	}
	
	
	public boolean ValidateUNMaskedValueForPasswordFieldWhenClickedOnEyeButton()
	{
		setText(PasswordField, "Password", longWait);
		clickAndWait(EyeIcon, longWait);
		TestUtils.sleep(2);
		boolean status=false;
		if(getAttribute(PasswordField, "type").equalsIgnoreCase("text"))
		{
			clickAndWait(EyeIcon, longWait);
			return status=true;
		}
		clickAndWait(EyeIcon, longWait);
		return status;
		
	}
	
	
	
	
	
	
	
	
	
	
	public boolean VerifyUserLoggedINSuccessfully()
	{
		boolean status=false;
		waitForElementToBecomeVisible(OKButton, longWait);
		if(isElementPresent(OKButton))
		{
		javascriptButtonClick(OKButton);
		}
		if(isElementPresent(Dashboard))
		{
			return status=true;
		}
		return status;
	}
	
	public boolean VerifyTheElementsOfLoginPage()
	{ boolean status=false;
		if(isElementPresent(UserNAmeField) && isElementPresent(PasswordField) && isElementPresent(LoginButton) && isElementPresent(ClickHereLink) )
		{
			return status=true;
		}
		
		return status;
	}
   
	

	

	public void getAllPolicyDocumentPrintedInExcel() throws IOException
	{
		clickAndWait(TermsAndConditionLink, minimalWait);
		List<WebElement> el= driver.get().findElements(DocumentOfTermAndCondition);
		for(WebElement element :el)
		{
			System.out.println(element.getText());

		
		}
		System.out.println(getText(DocumentOfTermAndCondition));
		DataUtils.writeDataToExcelInDesiredRowAndColumn(getText(DocumentOfTermAndCondition), 0,0);
		
		clickAndWait(CloseIconOnTermsAndConditionDocument, minimalWait);
	}
	
	public void ClickOnClickHereLink()
	{
		waitForElementToBecomeVisible(ClickHereLink, longWait);
		clickAndWait(ClickHereLink, longWait);
		waitForElementToBecomeVisible(MobileNUmberField, longWait);
	}
	
	public void ClickOnLoginButtonOnLoginMobileScreen()
	{
		waitForElementToBecomeVisible(LoginButtonOnMobileScreen, longWait);
		clickAndWait(LoginButtonOnMobileScreen, longWait);
		
	}
	
	public void SetMobileNUmberFieldwithValues(String MobileNUmber)
	{
		setText(MobileNUmberField, MobileNUmber, longWait);
		
	}
	
	
	
	public String getOtPNumber()
	{
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		String smsBody = getMessage();
		System.out.println(smsBody);
		String OTPNumber = smsBody.replaceAll("[^-?0-9]+", " ");
		System.out.println(OTPNumber);
		return OTPNumber;
	}
	
	public static String getMessage() {
		return getMessages().filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
				.filter(m -> m.getTo().equals("+12563635681")).map(Message::getBody).findFirst()
				.orElseThrow(IllegalStateException::new);
	}

	private static Stream<Message> getMessages() {
		ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
		return StreamSupport.stream(messages.spliterator(), false);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
