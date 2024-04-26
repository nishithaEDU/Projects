DETAILED DESCRIPTION
====================
Launch the browser using the configuration settings (Chrome/Egde).
Open the BeCognizant website & Capture the user information.
Verify the world clock section is properly displayed on the site or not.
Verify the current date and week displayed on the BeCognizant website in world clock sestion.
Verify the Bangalore location Time zone with the system time.
Verify the London and NewYork Time zone with compairing with the time zone present on the Google.
Verify the TimeZone difference is displayed correctly for London location.
Verify the TimeZone difference is displayed correctly for NewYork location.
Open the oneCognizant Website and browse for View All Apps.
Open the View All Apps section and Verify the A-Z alphabets are  displayed or not.
Select one of the random alphabet and get all detailed apps of that letter.
Close the browser.

KEY AUTOMATION SCOPE
====================
Handling the multiple windows, getText option.
Navigating back to the Home Page.
Extract multiple options and store in collection.
Exception handling.
Locating Elements.
Cross browser testing.
Data Driven testing.

OUTPUT: [Chrome/Edge]
=====================
User info: Edulapuram, Nishitha (Contractor)

current date and week: Tuesday,4/2/2024
System date and week: Tuesday,4/2/2024

Time in Bangalore: 8:16
Time in System: 8:16

London Time : 3:46PM
NewYork time: 10:46AM

London time in google: 3:46PM
NewYork time in google: 10:46AM

TimeZone difference in London: 4h 30m behind
TimeZone difference in NewYork: 9h 30m behind

All alphabets are present 

Total No. of Apps: 517
No of apps in G section: 18

List of Apps after clicking on G: 
Global Business Card
Green Card Status App
GSMS Seat Costing
Global Referral
GM Dashboard
GYM Management
Global Assoc advance
Global Business Card
Green Card Status App
GSMS Seat Costing
Global Referral
GM Dashboard
GYM Management
Global Assoc advance
GM Trac
GoPerform
Global Talent Review
GST Invoices
GBSFinance Analytics
GenC Recruit
Global Assignment
Gartner Research
Guidewire Insurance
GitHub Tech Modernization
GenAie

DEPENDENCIES
============
 <build>
	<plugins>
	<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-compiler-plugin</artifactId>
	<version>3.8.1</version>
	<configuration>
	<source>1.8</source>
	<target>1.8</target>
	</configuration>
	</plugin>
	<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-surefire-plugin</artifactId>
	<version>3.0.0-M1</version>
	<configuration>
	<suiteXmlFiles>
	<suiteXmlFile>src\testng.xml</suiteXmlFile>
	</suiteXmlFiles>
	</configuration>
	</plugin>
	</plugins>
</build>
  <dependencies>
  <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
	<dependency>
    	<groupId>org.seleniumhq.selenium</groupId>
    	<artifactId>selenium-java</artifactId>
    	<version>4.18.1</version>
	</dependency>
	
		<!-- https://mvnrepository.com/artifact/org.testng/testng -->
	<dependency>
	    <groupId>org.testng</groupId>
	    <artifactId>testng</artifactId>
	    <version>7.9.0</version>
	    <scope>test</scope>
	</dependency>
	
		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
	<dependency>
	    <groupId>org.apache.poi</groupId>
	    <artifactId>poi</artifactId>
	    <version>5.2.5</version>
	</dependency>
	<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
	<dependency>
	    <groupId>org.apache.poi</groupId>
	    <artifactId>poi-ooxml</artifactId>
	    <version>5.2.5</version>
	</dependency>
	
	<dependency>
	<groupId>com.aventstack</groupId>
	<artifactId>extentreports</artifactId>
	<version>5.1.1</version>
	</dependency>
	 
			<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
	<dependency>
	<groupId>commons-io</groupId>
	<artifactId>commons-io</artifactId>
	<version>2.15.1</version>
	</dependency>
	 
			<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
	<dependency>
	<groupId>org.apache.commons</groupId>
	<artifactId>commons-lang3</artifactId>
	<version>3.14.0</version>
	</dependency>
	