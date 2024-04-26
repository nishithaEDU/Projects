package PageObjects;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestBase.BaseClass;

public class BeCognizantPage extends BaseClass {
	WebDriver driver;
	
	// constructor 
	public BeCognizantPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Finding the elements present on the BeCognizant page 
	@FindBy (xpath="//div[@class='_8ZYZKvxC8bvw1xgQGSkvvA==']")
	WebElement img_accountLogo;
	
	@FindBy (xpath = "//*[@id=\'mectrl_currentAccount_primary\']")
	WebElement userinfoElement;
	
	@FindBy (xpath = "//*[@id=\'mectrl_headerPicture\']")
	WebElement closeAccountLogo;
	
	@FindBy(xpath = "(//div[@class='CanvasComponent'])/div/div/div[2]")
	WebElement ScrworldClockElement;
	
	@FindBy (xpath = "(//span[@id='CaptionElementView'])[4]")
	WebElement worldclockElement;
	
	@FindBy (xpath = "(//div[@class=\"n_b_816e1fa6\"])[1]//div[2]")
	WebElement currentDateElement;
	
	@FindBy (xpath = "(//div[@class='m_b_816e1fa6'])[1]//div[1]/span")
	WebElement bangloreTimeElement;
	
	@FindBy (xpath = "(//div[@class='m_b_816e1fa6'])[2]//div[1]")
	WebElement londonTimeElement;

	@FindBy (xpath = "(//div[@class='m_b_816e1fa6'])[3]//div[1]")
	WebElement newYorkTimeElement;
	
	@FindBy(css = "div[title='4h 30m behind']")
	WebElement tzDiffLondon;
	
	@FindBy(css = "div[title='9h 30m behind']")
	WebElement tzDiffNY;
	
	@FindBy(linkText = "OneCognizant")
	WebElement OneCognizant;
	
	
	
	
	//method creation for performing action on the particular element 
	//Click on the account logo to get the user info
	public void clickAccountLogo() {
		img_accountLogo.click();	
	}
	
	//get the user information
	public String captureUserInfo() {
		return userinfoElement.getText();	
	}
	
	//Close the user account details 
	public void closeAccountLogo() {
		closeAccountLogo.click();
	}
	
	//Scroll down to a particular webelement 
	public void scrollDownToWC() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",ScrworldClockElement);	
	}
	
	//check weather the World Clock is displayed or not
	public boolean worldClock() {
		return worldclockElement.isDisplayed();	
	}
	
	//get the current date and week displayed on the BeCognizant site
	public String currentDateAndWeek() {
		String dt = currentDateElement.getText();
		String dtNoSpace = dt.replaceAll("\\s", "");
		return dtNoSpace;
	}
	
	//get the current date and week from the system
	public String systemDateAndWeek() {
		
		LocalDate currentDate = LocalDate.now();
		String weekday = currentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        String formatDate = now.format(formatter);
		String dateWeek = weekday+","+formatDate;
		return dateWeek;
	}
	
	//get bangalore city time 
	public String bangaloreTime() {
		return bangloreTimeElement.getText();	
	}
	
	//Get the currrent time of the system 
	public String currentTimeInSystem() {
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("h:mm");
		LocalDateTime now = LocalDateTime.now();
		String formatDateTime = now.format(formatter2);
		return formatDateTime;
	}
	
	// get the time of London city shown on the BeCognizant
	public String londonTime() {
		return londonTimeElement.getText();	
	}
	
	//get the time of the NewYork city shown on the BeCognizant 
	public String newYorkTime() {
		return newYorkTimeElement.getText();	
	}
	
	//Switch to a Google Window
	public void switchTOGoogleWindow() throws InterruptedException {
		
		driver.switchTo().newWindow(WindowType.TAB);
	
		Thread.sleep(5000);
        driver.get("https://www.google.com/");
	}
	
	//get time zone difference for London city 
	public String timeZoneDifferenceLondon() {
		return tzDiffLondon.getText();  
	}
	
	
	// get TimeZone difference for NewYork city 
	public String timeZoneDifferenceNewYork() {
		return tzDiffNY.getText();  
	}
	
	//Navigate to the OneCognizant WebSite 
	public void goToOneCognizant() {
		OneCognizant.click();
		Set<String> winIDSet = driver.getWindowHandles();
		List<String> winIDList = new ArrayList<String>(winIDSet);
		String parentWinID = winIDList.get(0);
		String childWinID = winIDList.get(1);
		driver.switchTo().window(childWinID);
	}
}
	
