package OPDEMR.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import OPDEMR.base.BasePage;
import OPDEMR.utils.TestUtils;

public class SoapConfiguration_PlanPage extends BasePage {

	public SoapConfiguration_PlanPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

	By OrderSetTab=By.xpath("//ul[contains(@class,'myhealthcare-tabs')]//li//a[contains(text(),'Order Set')]");
	
	By AllViewButton=By.xpath("//a[@class='view_order_set']//i");
	
	By DrugDropdown=By.xpath("//select[@id='drug_id']");
	

	By FirstOrderSet=By.xpath("//div[@id='order-set-tab']//table[contains(@class,'default')][1]//tbody//tr[1]//td[2]");
	
	
	
	
	
	
	
	
	public void ClickOnOrderSetTab()
	{
		waitForElementToBecomeVisible(OrderSetTab, longWait);
		clickAndWait(OrderSetTab, longWait);
		waitForElementToBecomeVisible(AllViewButton, longWait);
		
	}
	
	public void ClickOnViewBUttonOfDesiredElement(String NameOfOrderSet)
	{
		List<WebElement> AllOrderSetName=driver.get().findElements(By.xpath("//div[@id='order-set-tab']//table[contains(@class,'default')][1]//tbody//tr//td[2]"));
		
		System.out.println("Number of view button present "+AllOrderSetName.size());
		loop:
		for(int i=0;i<AllOrderSetName.size();i++)
		{System.out.println("str1------>"+AllOrderSetName.get(i).getText());
		
		System.out.println("str2------>"+NameOfOrderSet);
		
			if(AllOrderSetName.get(i).getText().equalsIgnoreCase(NameOfOrderSet))
			{
				
				By DesiredViewIcon=By.xpath("//div[@id='order-set-tab']//tbody//tr["+(i+1)+"]//td[5]//i");
				By DesiredRow=By.xpath("//div[@id='order-set-tab']//tbody//tr["+(i+1)+"]");
				
				while(!getAttribute(DesiredRow, "class").equals("view-active"))
				{
				javascriptButtonClick(DesiredViewIcon);
				System.out.println("clicked on view icon.");
				TestUtils.sleep(2);
				}
				break loop;
			}
			
		}
		
		
	}
	
	public ArrayList getAllMedicineListFromAOrderSet()
	{
		 ArrayList<String> MedicineList = new ArrayList<String>(); 
		 
		 
		 By NameOfAllMedicine=By.xpath("//tr[@class='view_details']//table[1]//tbody//tr//td[1]");
		 
		 By NameOfAllTests=By.xpath("//tr[@class='view_details']//table[2]//tbody//tr//td[1]");
		 
		 
		 
		 List<WebElement>AllMedicines=driver.get().findElements(NameOfAllMedicine);
		 waitForElementToBecomeVisible(NameOfAllMedicine, longWait);
		 for(WebElement el:AllMedicines)
		 {
			 MedicineList.add(el.getText());
		 }
		 
		
		return MedicineList;
	}
	
	
	public ArrayList getAllTestListFromAOrderSet()
	{
		 ArrayList<String> TestList = new ArrayList<String>(); 
		 
		 
		
		 
		 By NameOfAllTests=By.xpath("//tr[@class='view_details']//table[2]//tbody//tr//td[1]");
		 
		 
		 
		 List<WebElement>AllTest=driver.get().findElements(NameOfAllTests);
		 waitForElementToBecomeVisible(NameOfAllTests, longWait);
		 for(WebElement el:AllTest)
		 {
			 TestList.add(el.getText());
		 }
		 
		
		return TestList;
	}
	
	
	public void ClickOnDesiredOrderSetNameCheckbox(String OrderSetName)
	{
		By OrderSetNameCheckBox=By.xpath("//div[@id='order-set-tab']//table[contains(@class,'default')]//tbody//td[contains(text(),'"+OrderSetName+"')]//preceding-sibling::td//input");
		
		
		
		while(!isElementPresent(DrugDropdown))
		{
			javascriptButtonClick(OrderSetNameCheckBox);
			TestUtils.sleep(5);
		}
	}
	
	public String getFirstOrderSetName()
	{
		return driver.get().findElement(FirstOrderSet).getText();
		
	}
	
	
	
	
	

}
