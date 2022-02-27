package week2.day2;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathExcercise {

	public static void main(String[] args) {

		// initiate chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		System.out.println("Driver Initiated");

		// open testleaf site
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

		System.out.println("URL Opened");

		// login credentials
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("Demosalesmanager");

		System.out.println("User Name Entered");

		WebElement userPassword = driver.findElement(By.id("password"));
		userPassword.sendKeys("crmsfa");

		System.out.println("Password Entered");

		// click submit
		WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));
		loginButton.click();

		System.out.println("Login Clicked");

		// click CRM/SFA app
		WebElement crmsfaButton = driver.findElement(By.linkText("CRM/SFA"));
		crmsfaButton.click();

		System.out.println("Entered into CRM/SFA app");

		// click Leads tab
		WebElement leadsTab = driver.findElement(By.linkText("Leads"));
		leadsTab.click();

		System.out.println("Clicked Leads Tab");

		// click Find Leads tab
		WebElement findLeadsTab = driver.findElement(By.xpath("(//ul[@class='shortcuts']//a)[3]"));
		findLeadsTab.click();

		System.out.println("Clicked Find Leads Tab");

		// search by firstname
		WebElement searchFirstName = driver.findElement(By.xpath("(//input[@name='firstName'])[3]"));
		searchFirstName.sendKeys("Test");

		System.out.println("Types Test as First Name");

		// click find lead button
		WebElement findLead = driver.findElement(By.xpath("(//em[@unselectable='on'])[7]/button"));
		findLead.click();

		System.out.println("Clicked Find Lead Button");

		/*
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //select
		 * first result returned driver.findElement(By.
		 * xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		 * 
		 * //firstResult.click();
		 */		
		
		//explicitly wait until find lead button is enabled
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")));
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		System.out.println("Clicked first result with name Test");
		
		//verify page title of current page
		System.out.println("Title of page after selecting first result "+driver.getTitle());
		
		//click Edit button
		driver.findElement(By.xpath("(//div[@class='frameSectionExtra']/a)[3]")).click();
		
		//change company name
		driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys("Cypress");
		
		//save
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		//confirm new company name
		WebElement newCompName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']"));
		System.out.println("New Company Name entered is "+newCompName.getText());
		
		// close browser 
		//driver.quit();
		
	}

}
