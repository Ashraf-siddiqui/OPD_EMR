package OPDEMR.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import OPDEMR.base.BasePage;
import OPDEMR.utils.TestUtils;

public class OrderSetPage extends BasePage {

	public OrderSetPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	
	By OrderSetMenu=By.xpath("//a[@id='orderset_menu']");
	
	By OrderSetList=By.xpath("//a[contains(text(),'Order Set List')]");
	
	By SearchOrderSetField=By.xpath("//input[@id='search-orderSet']");
	
	
	By CreateOrderSetButton=By.xpath("//a[contains(text(),'Create Order Set') and @type='button']");
	
	By firstOrderSetNameOnOrderSetTable=By.xpath("//tbody[@id='orderSet-list']//tr[1]//td[1]");
	
	By firstMedicineNameOnOrderSetTable=By.xpath("//tbody[@id='orderSet-list']//tr[1]//td[2]");
	
	
	By DeleteDialogBox=By.xpath("//div[@id='modalConfirm']");
	
	By DeleteConfirm=By.xpath("//div[@tabindex='2']");
//--------------------------------------------------Create Order Set-----------------------------------------------------------
	
	By OrderSetField=By.xpath("//input[@id='orderSet-name']");
	
	
	By SaveOrderSetButton=By.xpath("//button[contains(text(),'Save Order Set')]");
	
	
	
	
	
	
	
	public void HoverOnOrderSetsAndClickOnSpecifiedButton()
	{
		waitForElementToBecomeVisible(OrderSetMenu, longWait);
		scrollToElement(OrderSetMenu);
		
//		new Actions(driver.get()).moveToElement(driver.get().findElement(OrderSet)).moveToElement(driver.get().findElement(OrderSetListButton)).click().build().perform();

		Actions	act=new Actions(driver.get());
		act.moveToElement(driver.get().findElement(OrderSetMenu)).perform();
		waitForElementToBecomeVisible(OrderSetList, longWait);
		act.moveToElement(driver.get().findElement(OrderSetList)).click().perform();
//		TestUtils.sleep(3);
		
		waitForElementToBecomeVisible(SearchOrderSetField, longWait);
	}

	
	public String GetFirstOrderSetFromOrderSetsTable()
	{
		String Name="Not found anything";
		
		waitForElementToBecomeVisible(firstOrderSetNameOnOrderSetTable, longWait);
		Name=getText(firstOrderSetNameOnOrderSetTable);
		System.out.println("firstOrderSetNameOnOrderSetTable----------> "+Name);
		return Name;
		
		
		
	}
	
	
	public String GetFirstMedicineFromOrderSetsTable()
	{
		String Name="Not found anything";
		
		waitForElementToBecomeVisible(firstMedicineNameOnOrderSetTable, longWait);
		TestUtils.sleep(4);
		return Name=getText(firstMedicineNameOnOrderSetTable);
		
	}
	
	
	public void SearchForOrderSetOrMedicine(String NameOfOrderSetOrMedicines)
	{
		
		setText(SearchOrderSetField, NameOfOrderSetOrMedicines, longWait);
	//	String firstTemplateName = getText(firstTemplateNameOnTemplateTable);
		
	}
	
	
	public String GetclassNameofDesiredOrderSet(String NameOfOrderSet)
	{
		By DesiredStarIconOfTemplateNameOnTemplateTable=By.xpath("//tbody[@id='orderSet-list']//tr//td[text()='"+NameOfOrderSet+"']//following-sibling::td[position()=4]//i");
		
		System.out.println("--------------------------first tym "+getAttribute(DesiredStarIconOfTemplateNameOnTemplateTable, "class"));
		
		return getAttribute(DesiredStarIconOfTemplateNameOnTemplateTable, "class");
		
		
		
		
		
	}
	
	
	public String ClickOnStarIconAndReturnClassOfDesiredOrderSetName(String NameOfOrderSet)
	{
		
		By DesiredStarIconOfOrderSetOnOderSetTable=By.xpath("//tbody[@id='orderSet-list']//tr//td[text()='"+NameOfOrderSet+"']//following-sibling::td[position()=4]//i");
		String Status= getAttribute(DesiredStarIconOfOrderSetOnOderSetTable, "class");
		String Cache=Status;
		
		while(Status.equals(Cache))
		{
		javascriptButtonClick(DesiredStarIconOfOrderSetOnOderSetTable);
		TestUtils.sleep(4);
		Status= getAttribute(DesiredStarIconOfOrderSetOnOderSetTable, "class");
		}
	//TestUtils.sleep(10);
	//	System.out.println("--------------------------------class of star icon second tym "+ getAttribute(DesiredStarIconOfOrderSetOnOderSetTable, "class"));
		return Status;
		
	}
	
	
	public boolean VerifyTheCreatedOrderSet(String NameOfOrderSet)
	{
		boolean status=false;
		By OrderSetName=By.xpath("//tbody[@id='orderSet-list']//tr//td[1]");
		waitForElementToBecomeVisible(OrderSetName, longWait);
		
		List<WebElement>AllNames = driver.get().findElements(OrderSetName);
		
		
		for(int i=0;i<AllNames.size();i++)
		{
			
			if(AllNames.get(i).getText().equals(NameOfOrderSet))
			{
				System.out.println("In if------------------>"+AllNames.get(i).getText());
				
				return status=true;
			}
			
			
			
			
		}
		
		System.out.println(OrderSetName +" not found at template table. ");
		return status;
			
		
	}
	
	
	public boolean VerifyAndDeleteTheOrderSetIfAlreadyPresent(String NameOfOrderSet)
	{
		boolean status=false;
		By OrderSetName=By.xpath("//tbody[@id='orderSet-list']//tr//td[1]");
		waitForElementToBecomeVisible(OrderSetName, longWait);
		
		List<WebElement>AllNames = driver.get().findElements(OrderSetName);
		
		System.out.println("No of OrderSet available------------------>"+AllNames.size());
		
		for(int i=0;i<AllNames.size();i++)
		{
			
			if(AllNames.get(i).getText().equals(NameOfOrderSet))
			{
				System.out.println("OrderSet Already Exist------------------>"+AllNames.get(i).getText() +" So Deleting");
				By DeleteButton=By.xpath("//tbody[@id='orderSet-list']//tr["+(i+1)+"]//td[6]//a[2]//i");
				while(getAttribute(DeleteDialogBox, "class").equals("modal"))
				{
					javascriptButtonClick(DeleteButton);
					TestUtils.sleep(3);
					
				}
			
				
				
				
				while(getAttribute(DeleteDialogBox, "class").equals("modal show"))
				{
					javascriptButtonClick(DeleteConfirm);
					
				}
				
			
			
			
			
			return status=true;
			
			
			
			
			
			
			}
			
			
			
			
		}
	
		return status;
	
	
	}
	
	
	
	public void ClickOnCreateOrderSetButton()
	{
		
		waitForElementToBecomeVisible(CreateOrderSetButton, longWait);
		clickAndWait(CreateOrderSetButton, longWait);
		waitForElementToBecomeVisible(OrderSetField, longWait);
		
	}
	
	
	public void SetOrderSetName(String NameOfOrderSet)
	{
		
		waitForElementToBecomeVisible(OrderSetField, longWait);
		setText(OrderSetField, NameOfOrderSet, longWait);

		
		
	}
	
	
	
	public void clickOnSaveOrderSetButton()
	{
		waitForElementToBeClickable(SaveOrderSetButton, longWait);
		clickAndWait(SaveOrderSetButton, longWait);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
