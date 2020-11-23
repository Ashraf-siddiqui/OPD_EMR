package OPDEMR.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import OPDEMR.base.BasePage;

public class DashBoardPage extends BasePage {

	public DashBoardPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By HospitalCard=By.xpath("//div[@class='card-body']");
	By NameOfHospital=By.xpath("//div[@class='text-center']/*[1]");
	By Timings=By.xpath("//div[@class='text-center']/*[2]");
	
	By Appointments=By.xpath("//div[@class='text-center']/div[1]/div[1]/div");
	
	By ArrivedPatientCount=By.xpath("//div[@class='text-center']/div[1]/div[2]/div");
	
	By FirstUHID=By.xpath("//div[@id='patient-queue-pending']//div[@class='float-left']//span[position()=3 and contains(text(),'UHID')]");
	
	By OKButton=By.xpath("//div[@id='pendingPatientsConfirmOK']");
	
	
	public List VerifyHospitalInfo()
	{
		List<String> listOfHospitalCardInformation = new ArrayList<>();
		listOfHospitalCardInformation.add(getText(NameOfHospital));
		listOfHospitalCardInformation.add(getText(Timings));
		listOfHospitalCardInformation.add(getText(Appointments));
		listOfHospitalCardInformation.add(getText(ArrivedPatientCount));
		return listOfHospitalCardInformation;
		
	}
	
	public void ClickOnHospitalCard()
	{
		//clickAndWaitTillAnotherElementIsVisible(HospitalCard, OKButton);
		waitForElementToBecomeVisible(HospitalCard, longWait);
		clickAndWait(HospitalCard, longWait);
	}
	
	
	
	
	public String getFirstUHID()
	{
		waitForElementToBecomeVisible(FirstUHID, longWait);
		String UHID=getText(FirstUHID);
	//	By NameFromParticularUHid=By.xpath("//div[@class='float-left']//span[position()=3 and contains(text(),'"+UHID+"')]//preceding-sibling::span[2]");
		return UHID;
	}
	
	
	public String getFirstUHIDName()
	{
		waitForElementToBecomeVisible(FirstUHID, longWait);
		
		String UHID=getText(FirstUHID);
		
		By NameFromParticularUHid=By.xpath("//div[@id='patient-queue-pending']//div[@class='float-left']//span[position()=3 and contains(text(),'"+UHID+"')]//preceding-sibling::span[2]");
		
		return getText(NameFromParticularUHid);
		
	}
	
	
	
	
	
	
	
	
}
