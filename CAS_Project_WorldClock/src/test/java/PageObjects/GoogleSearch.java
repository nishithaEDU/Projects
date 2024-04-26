package PageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearch {
	WebDriver driver;
	
	
	//constructor
	public GoogleSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Finding the required element on the Google page
	@FindBy(xpath = "//*[@id='APjFqb']")
	WebElement searchBox;
	
	@FindBy(xpath = "//*[@id='rso']/div[1]/div/div/div/div/div/div[1]")
	WebElement londonTimeElement;
	
	@FindBy (xpath = "(//*[name()='svg'][@focusable='false'])[2]")
	WebElement clearBtn;
	
	@FindBy (xpath = "//*[@id='APjFqb']")
	WebElement searchboxElement;
	
	@FindBy (xpath = "//*[@id='rso']/div[1]/div/div/div/div/div/div[1]")
	WebElement newYorkElement;
	
	
	//Search for the London time on Google page
	public void searchLondonTime() {
		searchBox.sendKeys("current time in london");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.ENTER).perform();
	}
	
	//Get the current time in London from the Google page 
	public String LondonTimeInGoogle() {
		String londonTime = londonTimeElement.getText();
        String noSpacesText1 = londonTime.replaceAll(" ", "");
		return noSpacesText1.toUpperCase();
	}
	
	//Clear the search box for new entry 
	public void clearSearchBox() {
		clearBtn.click();
	}
	
	//search for the NewYork time on the Google
	public void SearchNewyorkTime() {
		searchBox.sendKeys("current time in new york");
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.ENTER).perform();
	}
	
	
	//Get the current time of the NewYork city from the Google page 
	public String newYorkTimeInGoogle() {
		String newYorkTime = newYorkElement.getText();
        String noSpacesText2 = newYorkTime.replaceAll(" ", "");
        return noSpacesText2.toUpperCase();
	}
	

	// Close the Google tab 
	public void closeWindow() throws InterruptedException {
		Set<String>winId = driver.getWindowHandles();
		List<String>winList=new ArrayList<String>(winId);
		Thread.sleep(2000);
		String parentWinId = winList.get(0);
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(parentWinId);
		Thread.sleep(2000);
		
		
	}
}
