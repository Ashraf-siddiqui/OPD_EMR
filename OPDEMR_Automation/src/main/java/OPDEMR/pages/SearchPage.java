package OPDEMR.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import OPDEMR.base.BasePage;

public class SearchPage extends BasePage{

	public SearchPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By FirstUHID = By.xpath("//h5[@class='text-heading']//following-sibling::p[position()=1 and contains(text(),'UHID')]");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
