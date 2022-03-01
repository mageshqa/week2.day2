package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign2DeleteLead {

	public static void main(String[] args) {

		//setup browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//91 91-63547539
		
		//launch url and prep browser
		driver.navigate().to("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// login using credentials
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		// click on crm/sfa
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//click and find Lead
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//ul[@class='shortcuts']//a[text()='Find Leads']")).click();
		
		//find by phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("91");
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("91");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("63547539");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//wait until search elements load
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='x-grid3-body']//a)[1]")));
				
		//capture lead id of 1st resulting lead
		WebElement firstLeadID = driver.findElement(By.xpath("(//div[@class='x-grid3-body']//a)[1]"));
		System.out.println("Lead ID of first resulting is "+firstLeadID.getText());
		String firstID = firstLeadID.getText();
		
		//click first element from result
		firstLeadID.click();
		
		//delete
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Find Leads']")));
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		//search by captured lead id
		driver.findElement(By.xpath("//label[text()='Lead ID:']//following::input")).sendKeys(firstID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//display no records
		System.out.println(driver.findElement(By.xpath("//*[text()='No records to display']")).getText());
		
		//close browser
		driver.quit();
		
	}

}
