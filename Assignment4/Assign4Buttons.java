package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign4Buttons {

	public static void main(String[] args) {
		//setup driver
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				
				//prep browser
				driver.navigate().to("http://leafground.com/pages/Button.html");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				//find position of button
				WebElement posButton = driver.findElement(By.id("position"));
				System.out.println("Position X - "+posButton.getLocation().getX());
				System.out.println("Position Y - "+posButton.getLocation().getY());
				
				//find color
				System.out.println("Color of Button is "+driver.findElement(By.id("color")).getCssValue("background-color"));
				
				//size of Button
				WebElement sizeButton = driver.findElement(By.id("size"));
				System.out.println("Height of Button is "+sizeButton.getSize().height);
				System.out.println("Length of Button is "+sizeButton.getSize().width);
				
				//click to go home page
				driver.findElement(By.id("home")).click();
				
				//driver.quit();
			
	}

}
