package OPDEMR.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import OPDEMR.base.BasePage;
import OPDEMR.utils.TestUtils;

public class CalendarPage extends BasePage{

	public CalendarPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	By TodayDate=By.xpath("//*[contains(@class, 'fc-today')]//span");
	
	By PatientTab=By.xpath("//a[@tab-name='patients']");
	
	By Book_Slots_Tab=By.xpath("//a[@tab-name='book-slots']");
	
	By Mark_Leave_Tab=By.xpath("//a[@tab-name='mark-leave']");
	
	By Block_Slots_Tab=By.xpath("//a[@tab-name='block-slots']");
	
	By ConfirmedStatus= By.xpath("//span[@class='patientConfirmed']");
	
	By AvailableSlot=By.xpath("//li[@class='list-inline-item']//a[contains(@class, 'slot')]");
	
	By PhoneNumberField=By.id("existingphone");
	
	By firstName=By.id("first_name");
	
	By lastName=By.id("last_name");
	
	By ContinueButton=By.id("appointment-btn");
	
	By ConfirmButton=By.id("booking_confirm");
	
	By ConfirmPatientNotification=By.className("toast-message");
	
	By RescheduleAppointmentButton=By.xpath("//button[text()='Reschedule Appointment']");
	
	By BlockReasonInputField=By.id("block-reason");
	
	
	By BlockButton=By.id("add_block_slot");
	
	
	public void ClickOnDesiredTab(String TabName)
	{
		if(TabName.equalsIgnoreCase("Patients"))
		{
			waitForElementToBecomeVisible(PatientTab, longWait);
			
			javascriptButtonClick(PatientTab);
			
		}
		
		if(TabName.equalsIgnoreCase("Book Slots"))
		{
			waitForElementToBecomeVisible(Book_Slots_Tab, longWait);
			javascriptButtonClick(Book_Slots_Tab);
			
		}
		
		if(TabName.equalsIgnoreCase("Mark Leave"))
		{
			waitForElementToBecomeVisible(Mark_Leave_Tab, longWait);
			
			javascriptButtonClick(Mark_Leave_Tab);
			
			
		}
		
		if(TabName.equalsIgnoreCase("Block Slots"))
		{
			waitForElementToBecomeVisible(Book_Slots_Tab, longWait);
			System.out.println("-------------------->"+driver.get().findElement(Block_Slots_Tab).getCssValue("color"));
			String hex = Color.fromString(driver.get().findElement(Block_Slots_Tab).getCssValue("color")).asHex();
			System.out.println(hex);
			
			javascriptButtonClick(Block_Slots_Tab);
			
		}
		
		
	}
	
	
	
	public String ClickOnAvailableSlots()
	{
		String str="";
		
		TestUtils.sleep(5);
			str	=	ClickOnTheDesiredNullSlots();
	return str;
	}
	
	
	public void ClickOnABlockedSlot(String Time)
	{
		By BlockedSlot=By.xpath("//a[text()='"+Time+"']");
		
		clickAndWait(BlockedSlot, longWait);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void FillPatientDetailsForm(String PhoneNumber,String FirstName,String LastName)
	{
		waitForElementToBecomeVisible(PhoneNumberField, longWait);
		setText(PhoneNumberField, PhoneNumber, longWait);
		setText(firstName, FirstName, longWait);
		setText(lastName, LastName, longWait);	
		waitForElementToBecomeVisible(ContinueButton, longWait);
	}
	
	public void ConfirmTheSlot()
	{
		waitForElementToBecomeVisible(ContinueButton, longWait);
		clickAndWait(ContinueButton, longWait);
		ClickOnConfirmButton();	
	}
	
	
	
	public String ClickOnTheDesiredNullSlots()
	{
		String str="";
		waitForElementToBecomeVisible(AvailableSlot, longWait);
		List<WebElement> el=driver.get().findElements(AvailableSlot);
		for(WebElement element : el)
		{
			System.out.println("--------------------->"+element.getText());
			if(element.getCssValue("color").equals("rgba(92, 92, 92, 1)"))
			{
				System.out.println("------>>>>>>>>>>>>>>>>>--------------------"+element.getText());
				element.click();
				return str= element.getText();
				
			}
		}
		
		return str;
	}
	
	
	public void ClickOnConfirmButton()
	{
		
		waitForElementToBecomeVisible(ConfirmButton, longWait);
		clickAndWait(ConfirmButton, longWait);
		waitForElementToBecomeVisible(ConfirmPatientNotification, longWait);
	}
	
	
	
	
	
	
	public boolean VerifyPatientNameUnderPatientTab(String PatientName, String Time)
	{
		boolean status=false;
		ClickOnDesiredTab("Patients");
		TestUtils.sleep(10);
		List<WebElement>NameOfPatients= driver.get().findElements(By.xpath("//table[@class='table']//tr"));
		waitForElementToBecomeVisible(By.xpath("//tbody//tr[@class='appointment-content']//td[1]"), longWait);
		System.out.println("Total patients in patients Tab------->" +NameOfPatients.size());
		for(int i=1; i<=NameOfPatients.size();i++)
		{
			System.out.println("------------------>entered the for loop<<<<<<<<<<----------");
			By DesiredName=By.xpath("//tbody//tr[@class='appointment-content']["+i+"]//td[1]//h6");
			System.out.println("Desired Name is ------->    "+getText(DesiredName));
			System.out.println("Pateint Name is ------->    "+PatientName);
			
			if(getText(DesiredName).equalsIgnoreCase(PatientName))
			{
				System.out.println("------------------>entered the first If<<<<<<<<<<----------");
				
				
				By desiredTime=By.xpath("//tbody//tr[@class='appointment-content']["+i+"]//td[2]");
				System.out.println("Desired Time is ------->    "+getText(desiredTime));
				System.out.println("Pateint Time is ------->    "+Time);
				
				
				if(getText(desiredTime).equals(Time))
				{
				
					System.out.println("------------------>entered the second If<<<<<<<<<<----------");
					
				
				
				
				By DesiredConfirmButton=By.xpath("//tbody//tr[@class='appointment-content']["+i+"]//td[3]//*");
				
				if(getText(DesiredConfirmButton).equalsIgnoreCase("Confirmed"))
				{
					System.out.println("------------->>>>>>COnfirmButtonText"+ getText(DesiredConfirmButton));
					
					System.out.println("------------------>entered the third If<<<<<<<<<<----------");
					
					return status=true;
				}
				
				}
			}
			
		}
		
		
		return status;
	}
	
	
	
	
	
	
	
	
	
	
	
	public boolean ClickOnConfirmButtonUnderPatientTab(String PatientName, String Time)
	{
		boolean status=false;
		ClickOnDesiredTab("Patients");
		List<WebElement>NameOfPatients= driver.get().findElements(By.xpath("//table[@class='table']//tr"));
		waitForElementToBecomeVisible(By.xpath("//tbody//tr[@class='appointment-content']//td[1]"), longWait);
		for(int i=1; i<=NameOfPatients.size();i++)
		{
			System.out.println("------------------>entered the for loop<<<<<<<<<<----------");
			By DesiredName=By.xpath("//tbody//tr[@class='appointment-content']["+i+"]//td[1]//h6");
			By desiredTime=By.xpath("//tbody//tr[@class='appointment-content']["+i+"]//td[2]");
			System.out.println("Name under PatientTab ------->    "+getText(DesiredName));
			System.out.println("Pateint Name is ------->    "+PatientName);
			System.out.println("Time under PatientTab ------->    "+getText(desiredTime));
			System.out.println("Pateint Time is ------->    "+Time);
			
			if(getText(DesiredName).equalsIgnoreCase(PatientName)&& getText(desiredTime).equals(Time) )
			{
			
				
				
				By DesiredConfirmButton=By.xpath("//tbody//tr[@class='appointment-content']["+i+"]//td[3]//*");
				
				if(getText(DesiredConfirmButton).equalsIgnoreCase("Confirmed"))
				{
//					while(isElementPresent(DesiredConfirmButton))
//					{
						System.out.println("------------------>Clicked on Confirmed Button<<<<<<<<<<----------");
						
						javascriptButtonClick(DesiredConfirmButton);
					//}
						
					return status=true;
				}
				
				}
			}
		return status;
		}
		
		
		
	
	
	
	
	
	public void ClickOnRescheduleButton()
	{
		waitForElementToBecomeVisible(RescheduleAppointmentButton, longWait);
		clickAndWait(RescheduleAppointmentButton, longWait);
		
	}
	
	
	
	
	public void EnterReasonForBlock(String TextToBeEntered)
	{
		TestUtils.sleep(3);
		waitForElementToBeClickable(BlockReasonInputField, longWait);
		setText(BlockReasonInputField, TextToBeEntered, longWait);
		
	}
	
	
	
	
	public void ClickOnBlockButton()
	{
		
		clickAndWait(BlockButton, longWait);
		waitForElementToBecomeVisible(ConfirmPatientNotification, longWait);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
