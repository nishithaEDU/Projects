package PageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OneCognizant {
	WebDriver driver;
	JavascriptExecutor js=(JavascriptExecutor) driver;


	//constructor 
	public OneCognizant(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Finding the required Elements on the OneCognizant page
	@FindBy(xpath = "//div[normalize-space()='View All Apps']")
	WebElement viewAllApps;
	
	@FindBy(xpath ="//*[@id='divAppstoreContainer']/div[1]/div/div/div[2]/div")
	WebElement headerElement;
	
	@FindBy(css ="div[class='appStoreAppName']")
	List<WebElement> allAppDetailsElements;
	
	@FindBy(xpath="//div[@aria-label='Filter apps starts with alphabet G']")
	WebElement randomAlphabat;
	
	@FindBy (xpath="//div[starts-with(text(), 'G')]/ancestor::div[@class='appStoreColAppHolder']")
	List<WebElement> randomAppsDetailsElement;
	
	//Scroll on hot apps to get the View All Apps element 
	public void ScrollForViewAllApps() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", viewAllApps);
	}
	
	//click on the View All Apps 
	public void clickOnViewAllApps() {
		viewAllApps.click();
	}
	
	//Get the context present on the header
	public String headertext() {
		String header=headerElement.getText().toUpperCase();
		String hdrNoSpace=header.replaceAll("\\s", "");
		return hdrNoSpace;
	}
	
	//Get all the details of the apps present in HOT APPS Section
	public String allAppDetails() {
		return Integer.toString(allAppDetailsElements.size());
	}
	
	//CLick on any random alphabet present on the header
	public void clickOnRandomAlphabat() {
		randomAlphabat.click();
	}
	
	
	//Get the details of the random alphabet apps present in the HOT APPS Section
	public String randomAppsDetails()  {
		try 
		{
			int numberOfApps = randomAppsDetailsElement.size();
			String noOfApps = Integer.toString(numberOfApps);
			System.out.println("No of apps in G section: "+noOfApps);
			System.out.println();
			
			System.out.println("List of Apps after clicking on G: ");
		
			for(WebElement appsDetails : randomAppsDetailsElement) {
				
				System.out.println(appsDetails.getText());
			}
		}
		catch (StaleElementReferenceException e) {
//			for(WebElement appsDetails : randomAppsDetailsElement) {
//				String a=appsDetails.getText();
//				System.out.println(a);
//			}
			System.out.println(e);
		}
		return null;
	}
	
}
