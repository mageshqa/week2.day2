package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign2DupLead {

	public static void main(String[] args) {


		// browser setup
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();

				// load url and prepare
				driver.navigate().to("http://leaftaps.com/opentaps/control/login");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

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
				
				//click email tab and enter email
				driver.findElement(By.xpath("//span[text()='Email']")).click();
				driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("abc@gmail.com");
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Lead List']")));
				
				//select first result
				WebElement firstResult = driver.findElement(By.xpath("(//td[contains(@class,'firstName')])[2]//a"));
				//String firstResultName = firstResult.getText();
				System.out.println("First Name is "+firstResult.getText());
				firstResult.click();
				
				//click dup lead
				driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
				
				WebElement dupLead = driver.findElement(By.xpath("//div[text()='Duplicate Lead']"));
				
				System.out.println("Page Title is "+dupLead.getText());
				
				//click create lead
				driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
				
				String firstDupName = driver.findElement(By.xpath("//span[contains(@id,'firstName')]")).getText();
				
				System.out.println("Duplicate First Name is "+firstDupName);
				
				/*
				 * if(firstResultName==firstDupName)
				 * System.out.println("Duplicate names have same First Name of "+firstDupName);
				 * 
				 * else System.out.
				 * println("First Name of resultant and currently open is not Duplicate");
				 */
				//close browser
				//driver.quit();

	}

}
