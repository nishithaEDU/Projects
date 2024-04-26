package TestBase;

 
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
 
public class BaseClass {
	public static WebDriver driver;
	
	//Create a driver setup to initiate the browser
	@BeforeTest
	@Parameters({ "browser" })
	public void setup(String br) throws InterruptedException {
 
		if (br.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();	
		} 
		else if (br.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
		Thread.sleep(20000);
	}
 
	//closing the browser after all tests
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
 
 
}