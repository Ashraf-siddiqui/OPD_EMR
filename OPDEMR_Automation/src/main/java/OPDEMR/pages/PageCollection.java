package OPDEMR.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

// TODO: Auto-generated Javadoc
/**
 * Created By : Ashraf.
 */

public class PageCollection {

	/** The Log. */
	private static Logger Log = LogManager.getLogger(PageCollection.class.getName());

	/** The driver. */
	protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	/** The login page. */
	private LoginPage loginPage;
	private ChangePasswordPage changePasswordPage;

	private DashBoardPage dashBoardPage;
	
	private SearchPatientPage searchPatientPage;
	
	private BasicControllerPage innoCircPage;
	
	private CalendarPage calendarPage;
	
	private TemplatesPages templatesPages;
	
	private OrderSetPage orderSetPage;
	
	private SoapConfiguration_AssesmentPage soapConfiguration_AssesmentPage;
	/**
	 * Instantiates a new page collection.
	 *
	 * @param driver the driver
	 */
	public PageCollection(ThreadLocal<WebDriver> driver) {
		this.driver = driver;
		Log.info("Initialized Page Collection Class");
	}

	/**
	 * Gets the login page.
	 *
	 * @return the login page
	 */

	
	public BasicControllerPage getBasicControllerPage() {
		return (innoCircPage == null) ? innoCircPage = new BasicControllerPage(driver) : innoCircPage;
	}
	
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

	
	public DashBoardPage getDashBoardPage() {
		return (dashBoardPage == null) ? dashBoardPage = new DashBoardPage(driver) : dashBoardPage;
	}

	
	public ChangePasswordPage getChangePasswordPage() {
		return (changePasswordPage == null) ? changePasswordPage = new ChangePasswordPage(driver) : changePasswordPage;
	}
	
	public SearchPatientPage getSearchPatientPage() {
		return (searchPatientPage == null) ? searchPatientPage = new SearchPatientPage(driver) : searchPatientPage;
	}
	
	
	public CalendarPage getCalendarPage() {
		return (calendarPage == null) ? calendarPage = new CalendarPage(driver) : calendarPage;
	}
	
	public TemplatesPages getTemplatesPages() {
		return (templatesPages == null) ? templatesPages = new TemplatesPages(driver) : templatesPages;
	}
	
	public OrderSetPage getOrderSetPage() {
		return (orderSetPage == null) ? orderSetPage = new OrderSetPage(driver) : orderSetPage;
	}
	
	
	public SoapConfiguration_AssesmentPage getSoapConfiguration_AssesmentPage() {
		return (soapConfiguration_AssesmentPage == null) ? soapConfiguration_AssesmentPage = new SoapConfiguration_AssesmentPage(driver) : soapConfiguration_AssesmentPage;
	}
	
}