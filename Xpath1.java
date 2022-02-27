package week2.day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath1 {

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
		WebElement userName = driver.findElement(By.xpath("//input[@name='USERNAME']"));
		userName.sendKeys("Demosalesmanager");

		System.out.println("User Name Entered");

		WebElement userPassword = driver.findElement(By.xpath("//input[@type='password']"));
		userPassword.sendKeys("crmsfa");

		System.out.println("Password Entered");

		// click submit
		WebElement loginButton = driver.findElement(By.xpath("//input[@class='decorativeSubmit']"));
		loginButton.click();

		System.out.println("Login Clicked");

		// click CRM/SFA app
		WebElement crmsfaButton = driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]"));
		crmsfaButton.click();

		System.out.println("Entered into CRM/SFA app");

		// click Leads tab
		WebElement leadsTab = driver.findElement(By.xpath("//a[(text()='Leads')]"));
		leadsTab.click();

		System.out.println("Clicked Leads Tab");

		
		
		// click create new Leads
		WebElement createLeadLink = driver.findElement(By.xpath("(//ul[@class='shortcuts']//a)[2]"));
		createLeadLink.click();

		System.out.println("Clicked Create Leads");

		// enter mandatory fields in Leads page
		WebElement companyName = driver.findElement(By.xpath("(//input[@name='companyName'])[2]"));
		companyName.sendKeys("Wipro");

		System.out.println("Company Name Entered");

		WebElement foreName = driver.findElement(By.xpath("(//input[contains(@id,'firstName')])[1]"));
		foreName.sendKeys("Magesh");

		System.out.println("Fore Name Entered");

		WebElement surName = driver.findElement(By.xpath("(//input[contains(@id,'lastName')])[1]"));
		surName.sendKeys("Rajan");

		System.out.println("Sur Name Entered");

		// choose source droplist
		WebElement sourceDropList = driver.findElement(By.xpath("//select[@name='dataSourceId']"));
		Select sourceList = new Select(sourceDropList);

		// Select sourceList = new Select();

		sourceList.selectByIndex(4);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		sourceList.selectByValue("LEAD_PARTNER");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		sourceList.selectByVisibleText("Conference");

		List<WebElement> listOptions = sourceList.getOptions();
		// display all options from droplist
		for (WebElement opt : listOptions) {
			System.out.println(opt.getText());
		}
		System.out.println("Total number of options in DropList is - " + listOptions.size());

		// enter Dept
		WebElement department = driver.findElement(By.xpath("//input[contains(@id,'departmentName')]"));
		department.sendKeys("Food & Beverages");

		// enter description
		WebElement description = driver.findElement(By.xpath("//textarea[@name='description']"));
		description.sendKeys("I work in food & beverages department");

		// enter email
		WebElement email = driver.findElement(By.xpath("//textarea[@name='description']"));
		email.sendKeys("abc@gmail.com");

		// select NY state
		WebElement stateProvince = driver.findElement(By.xpath("//select[contains(@name,\"generalState\")]"));
		Select stateList = new Select(stateProvince);
		stateList.selectByVisibleText("New York");

		// submit form
		WebElement submitForm = driver.findElement(By.xpath("//input[contains(@name,\"submit\")]"));
		submitForm.click();

		System.out.println("Form Created");

		// get text of resulting page
		//WebElement createPageTitle = driver.findElement(By.id("sectionHeaderTitle_leads"));
		//System.out.println("Page Title of resulting page after creating Lead is " + createPageTitle.getText());
		System.out.println("Page Title is "+driver.getTitle());
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		// close browser
		//driver.quit();

	}

}
