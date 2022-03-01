package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign2EditLead {

	public static void main(String[] args) {

		// setup browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// prepare browser
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

		// click and find Lead
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//ul[@class='shortcuts']//a[text()='Find Leads']")).click();

		// search by firstname
		driver.findElement(By.xpath("(//label[text()='First name:'])[3]//following::input")).sendKeys("Test");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		// select first resulting lead
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='x-grid3-body']//a)[1]")));
		driver.findElement(By.xpath("(//div[@class='x-grid3-body']//a)[1]")).click();

		System.out.println("Page Title is " + driver.getTitle());

		// click edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();

		// update company name
		driver.findElement(By.xpath("(//span[text()='Company Name']//following::input)[1]")).clear();
		driver.findElement(By.xpath("(//span[text()='Company Name']//following::input)[1]")).sendKeys("NASA");
		driver.findElement(By.xpath("//input[@value='Update']")).click();

		// verify new company name
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[text()='Company Name']//following::span)[1]")));
		System.out.println("Updated company name is "
				+ driver.findElement(By.xpath("(//span[text()='Company Name']//following::span)[1]")).getText());

		// close browser
		// driver.quit();

	}

}
