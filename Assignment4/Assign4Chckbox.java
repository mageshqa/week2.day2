package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign4Chckbox {

	public static void main(String[] args) {

		// setup driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// prepare browser
		driver.navigate().to("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		System.out.println(driver.getTitle());
		
		//select lang known
		driver.findElement(By.xpath("//label[text()='Select the languages that you know?']//following-sibling::div/input")).click();
		
		//isselected
		WebElement isSelected = driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']//following-sibling::div/input"));
		System.out.println("Selenium checkbox selected is "+isSelected.isSelected());

		
	}

}
