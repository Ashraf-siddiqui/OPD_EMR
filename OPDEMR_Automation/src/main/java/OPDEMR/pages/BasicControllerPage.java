package OPDEMR.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import OPDEMR.base.BasePage;
import OPDEMR.utils.TestUtils;

public class BasicControllerPage extends BasePage{

	public BasicControllerPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By UserNAmeField = By.xpath("//input[@id='username']");
	
	By PasswordField=By.xpath("//input[@id='password']");
	
	By OKButton=By.id("pendingPatientsConfirmOK");
	
	By LoginButton= By.xpath("//form[@id='gid_login_form']//button");
	
	By Dashboard=By.xpath("//div[@id='main_menu']//ul[1]//li[1]//a");
	By OPDPatientHeader=By.xpath("//div[@id='dashboard_data']//h2");
	
	By SearchPatientTab=By.xpath("//div[@id='main_menu']//ul[1]//li[2]//a");
	By MyCalendarTab=By.xpath("//div[@id='main_menu']//ul[1]//li[3]//a");
	By LateAlertTab=By.xpath("//div[@id='main_menu']//ul[1]//li[4]//a");
	By Templates=By.xpath("//div[@id='main_menu']//ul[1]//li[5]//a");
	By OrderSets=By.xpath("//div[@id='main_menu']//ul[1]//li[6]//a");
	By SoapConfiguration=By.xpath("//div[@id='main_menu']//ul[1]//li[7]//a");
	
	By CallNext_Button=By.xpath("//div[@id='call-next-div']");
	
	By PatientNameSearchField=By.id("patient_name");
	
	By PhoneUHIDSearchField=By.id("mobile");
	
	By RoleTabPresentOnCalendarPage=By.xpath("//ul[@role='tablist']");
	
	By UserDropdownButton =By.id("user_dropdown_btn");
	
	By UserProfileImage =By.className("img-fluid profile-image");
	
	By DropdownBox=By.xpath("//a[contains(text(),'Profile')]//parent::div");
	
	By ProfileBUtton=By.xpath("//a[contains(text(),'Profile')]");
	
	By ChangePasswordButton=By.xpath("//a[contains(text(),'Change Password')]");
	
	By ChangePasswordButtonOnChangePasswordScreen=By.xpath("//a[contains(text(),'Change Password')]");
	
	By LogOutButton=By.xpath("//a[contains(text(),'Change Password')]");
	

	By SubjectiveButton=By.xpath("//body/main[@id='main']/div[3]/div[1]//li[position()=1]");
	
	public void ClickOnAnyMainMenuButton(String NameOfTheMenu)
	{
		
		if(NameOfTheMenu.contains("DashBoard"))
		{
			
			javascriptButtonClick(Dashboard);
			waitForElementToBecomeVisible(OPDPatientHeader);
		}
		if(NameOfTheMenu.contains("Search"))
		{
			
			javascriptButtonClick(SearchPatientTab);
			waitForElementToBecomeVisible(PatientNameSearchField, longWait);
			
		}
		
		if(NameOfTheMenu.contains("My Calendar"))
		{
			
			javascriptButtonClick(MyCalendarTab);
			waitForElementToBecomeVisible(RoleTabPresentOnCalendarPage, longWait);
			
			
		}
		
		if(NameOfTheMenu.contains("SOAP"))
		{
			waitForElementToBecomeVisible(SoapConfiguration, longWait);
			javascriptButtonClick(SoapConfiguration);
			waitForElementToBecomeVisible(By.xpath("//select[@id='speciality']"), longWait);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	public void CliCkOnAnyUserDropDownButton(String NameOfTheButton)
	{
		waitForElementToBecomeVisible(UserDropdownButton, longWait);
		if(!isElementPresent(DropdownBox))
		{
			javascriptButtonClick(UserDropdownButton);
		}
		
		
		if(NameOfTheButton.contains("Profile"))
		{
			waitForElementToBecomeVisible(ProfileBUtton, longWait);
			clickAndWait(ProfileBUtton, longWait);
			
		}
		
		
		else if(NameOfTheButton.contains("Change Password"))
		{
			waitForElementToBecomeVisible(ChangePasswordButton, longWait);
			clickAndWait(ChangePasswordButton, longWait);
			//waitForElementToBecomeVisible(ChangePasswordButtonOnChangePasswordScreen, longWait);
			
		}
		
		else if(NameOfTheButton.contains("Logout"))
		{
			waitForElementToBecomeVisible(LogOutButton, longWait);
			clickAndWait(LogOutButton, longWait);
			waitForElementToBecomeVisible(UserNAmeField, longWait);
		}
		
	}
	
	
	public void HandlePendingPatientsDialougeBox()
	{
		waitForElementToBecomeVisible(OKButton, minimalWait);
		if(isElementPresent(OKButton))
		{
		clickAndWait(OKButton, minimalWait);
		
		}
		
	}


	public void ClickOn_CallNext_Button()
	{
		
		
		waitForElementToBecomeVisible(CallNext_Button, longWait);
		clickAndWait(CallNext_Button, longWait);
		waitForElementToBecomeVisible(SubjectiveButton, longWait);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
