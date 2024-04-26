package TestCases;


import org.testng.annotations.Test;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import PageObjects.BeCognizantPage;
import PageObjects.GoogleSearch;
import PageObjects.OneCognizant;
import TestBase.BaseClass;
import TestBase.ExcelUtils;

public class WorldClock_tc extends BaseClass {
	BeCognizantPage beCognizant;
	GoogleSearch gSearch;
	OneCognizant oneC;
	ExcelUtils excelUtils = new ExcelUtils();
	
	
	//Capture the user account information
	@Test(priority = 0)
	public void captureUserInfo() throws InterruptedException, IOException {
		String file = System.getProperty("user.dir")+"\\testdata\\CTSH.xlsx";
		beCognizant = new BeCognizantPage(driver);
		Thread.sleep(10000);
		beCognizant.clickAccountLogo();
		Thread.sleep(5000);
		System.out.println("User info: "+beCognizant.captureUserInfo());
		Thread.sleep(2000);
		beCognizant.closeAccountLogo();
		
		excelUtils.setCellData(file, "sheet2", 1, 0,beCognizant.captureUserInfo());
		
	}
	
	//Verify WorldClock is displayed or not!!
	@Test(priority = 1)
	public void validationOfWorldClock() throws InterruptedException {
		beCognizant.scrollDownToWC();
		Thread.sleep(2000);
		assertEquals(beCognizant.worldClock(), true);
	}
	
	
	//Verify the Current Date and Week shown on BeCognizant and System
	@Test(priority = 2)
	public void ValidationofCurretDateAndWeek() throws InterruptedException, IOException {
		String file = System.getProperty("user.dir")+"\\testdata\\CTSH.xlsx";
		System.out.println();
		System.out.println("current date and week: " +beCognizant.currentDateAndWeek());
		System.out.println("System date and week: " +beCognizant.systemDateAndWeek());
		Thread.sleep(4000);
		assertEquals(beCognizant.currentDateAndWeek(),beCognizant.systemDateAndWeek());
		excelUtils.setCellData(file, "sheet2", 2, 0, beCognizant.currentDateAndWeek());
		excelUtils.setCellData(file, "sheet2", 3, 0, beCognizant.systemDateAndWeek());

	}
	
	//Verify the Bangalore time with the system time 
	@Test(priority = 3)
	public void ValidationOfBangaloreTime() throws InterruptedException, IOException {
		String file = System.getProperty("user.dir")+"\\testdata\\CTSH.xlsx";
		System.out.println();
		System.out.println("Time in Bangalore: " +beCognizant.bangaloreTime());
		System.out.println("Time in System: " +beCognizant.currentTimeInSystem());
		Thread.sleep(4000);
		assertEquals(beCognizant.bangaloreTime(), beCognizant.currentTimeInSystem());
		excelUtils.setCellData(file, "sheet2", 4, 0, beCognizant.bangaloreTime());
		excelUtils.setCellData(file, "sheet2", 5, 0, beCognizant.currentTimeInSystem());

		Thread.sleep(3000);
	}
	
	//Validate the time shown of London and NewYork on BeCognizant and on Google 
	@Test(priority = 4)
	public void ValidationOfLondonTimeAndNewYorkTime() throws InterruptedException, IOException {
		String file = System.getProperty("user.dir")+"\\testdata\\CTSH.xlsx";
		gSearch=new GoogleSearch(driver);
		beCognizant = new BeCognizantPage(driver);
		
		//get London time displayed on the BeCognizant site
		System.out.println();
		System.out.println("London Time : "+beCognizant.londonTime());
		String actLondonT = beCognizant.londonTime();
		Thread.sleep(1500);
		
		//get NewYork time displayed on the BeCognizant site
		System.out.println("NewYork time: " +beCognizant.newYorkTime());
		String actNYT = beCognizant.newYorkTime();
		Thread.sleep(1000);
		
		// Switching to the Google Window
		beCognizant.switchTOGoogleWindow();
		Thread.sleep(1500);
		
		//Search the London city time on the Google 
		gSearch.searchLondonTime();
		Thread.sleep(1500);
		
		//Get the London time displayed on the Google page
		System.out.println();
		System.out.println("London time in google: " +gSearch.LondonTimeInGoogle());
		String expLondonT = gSearch.LondonTimeInGoogle();
		Thread.sleep(1500);
		excelUtils.setCellData(file, "sheet2", 8, 0, gSearch.LondonTimeInGoogle());
		
		//Clear the search box
		gSearch.clearSearchBox();
		Thread.sleep(1500);
		
		// Search time for the NewYork city 
		gSearch.SearchNewyorkTime();
		Thread.sleep(1000);
		
		//Get NewYork time that is Displayed on the Google page 
		System.out.println("NewYork time in google: " +gSearch.newYorkTimeInGoogle());
		String expNYT = gSearch.newYorkTimeInGoogle();
		Thread.sleep(2000);
		
		
		excelUtils.setCellData(file, "sheet2", 9, 0, gSearch.newYorkTimeInGoogle());
		// Close the Google Window 
		gSearch.closeWindow();
		
		
		
		// Compare the values of the time to verify the time of London and NewYork
		Thread.sleep(1000);
		Assert.assertEquals(actLondonT, expLondonT,"assertTrue for london");
		Assert.assertEquals(actNYT, expNYT,"assertTrue for NY");
		excelUtils.setCellData(file, "sheet2", 6, 0, beCognizant.londonTime());
		excelUtils.setCellData(file, "sheet2", 7, 0, beCognizant.newYorkTime());
		Thread.sleep(3000);
	}
	
	//Verify the Time Zone difference for the London Location
	@Test(priority = 5)
	public void validationOfTimeZoneDifferenceForLondon() throws IOException {
		String file = System.getProperty("user.dir")+"\\testdata\\CTSH.xlsx";
		String tzDiffLondon = excelUtils.getCellData(file, "Sheet1", 1, 1);
		System.out.println();
		System.out.println("TimeZone difference in London: " +beCognizant.timeZoneDifferenceLondon());
		Assert.assertEquals(tzDiffLondon, beCognizant.timeZoneDifferenceLondon());
		excelUtils.setCellData(file, "Sheet1", 1, 2, "Passed");
		excelUtils.fillGreenColor(file, "sheet1", 1, 2);
		excelUtils.setCellData(file, "sheet2", 10, 0, beCognizant.timeZoneDifferenceLondon());
	}
	
	
	//Verify the TimeZone difference for the NewYork location
	@Test(priority = 6)
	public void validationOfTimeZoneDifferenceForNewYork() throws IOException {
		String file = System.getProperty("user.dir")+"\\testdata\\CTSH.xlsx";
		String tzDiffNY = excelUtils.getCellData(file, "Sheet1", 2, 1);
		System.out.println("TimeZone difference in NewYork: " +beCognizant.timeZoneDifferenceNewYork());	
		Assert.assertEquals(tzDiffNY, beCognizant.timeZoneDifferenceNewYork());
		excelUtils.setCellData(file, "sheet1", 2, 2, "Passed");
		excelUtils.fillGreenColor(file, "sheet1", 2, 2);
		excelUtils.setCellData(file, "sheet2", 11, 0, beCognizant.timeZoneDifferenceNewYork());
	}
	
	
	//Click on OneCognizant element 
	@Test(priority = 7)
	public void clickOnOneCognizant() throws InterruptedException {
		
		beCognizant.goToOneCognizant();
		Thread.sleep(5000);
	}
	
	
	//Click on View hot apps to see the all apps
	@Test(priority = 8)
	public void clickViewAllApps() throws InterruptedException {
		oneC = new OneCognizant(driver);
		oneC.ScrollForViewAllApps();  
		Thread.sleep(5000);
		oneC.clickOnViewAllApps();
		Thread.sleep(5000);
	}
	
	//Verify all the alphabets are displayed or not 
	@Test(priority = 9)
	public void validationOfAtoZAlphabats() throws IOException {
		//System.out.print("A to Z alphabets: "+oneC.headertext());
		String file = System.getProperty("user.dir")+"\\testdata\\CTSH.xlsx";
		String alphabets = excelUtils.getCellData(file, "Sheet1", 3, 1);
		assertEquals(oneC.headertext(), alphabets);
		System.out.println();
		System.out.println("All alphabets are present ");
		excelUtils.setCellData(file, "sheet1", 3, 2, "Passed");
		excelUtils.fillGreenColor(file, "sheet1", 3, 2);
		excelUtils.setCellData(file, "sheet2", 12, 0, "All alphabets are there.");

	}
	
	//get the all apps names by providing the random alphabet
	@Test(priority = 10)
	public void getRandomAlphabatAppDetails() throws IOException {
		String file = System.getProperty("user.dir")+"\\testdata\\CTSH.xlsx";
		System.out.println();
		System.out.println("Total No. of Apps: "+oneC.allAppDetails());
		oneC.clickOnRandomAlphabat();
		oneC.randomAppsDetails();
		excelUtils.setCellData(file, "sheet2", 13, 0, oneC.allAppDetails());
		excelUtils.setCellData(file, "sheet2", 14, 0, oneC.randomAppsDetails());

	}
	
}
