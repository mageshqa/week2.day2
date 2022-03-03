package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign4Links {

	public static void main(String[] args) {

		//setup driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//prepare browser
		driver.navigate().to("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		System.out.println(driver.getTitle());
		
		//get url of link
		WebElement linkUrl = driver.findElement(By.xpath("//a[contains(text(),'supposed to go')]"));
		System.out.println("Link routes to "+linkUrl.getAttribute("href"));
		
		//broken link
		WebElement brokenLink = driver.findElement(By.xpath("//a[contains(text(),'broken')]"));
		
		if(brokenLink.getAttribute("href")== "error.html")
			System.out.println("Link is Broken");
		
		
		//number of links in page
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		System.out.println("Total Links in page is "+allLinks.size());
		
		//close browser
		driver.quit();
		
	}

}
