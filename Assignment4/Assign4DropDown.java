package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign4DropDown {

	public static void main(String[] args) {
		// setup driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// prepare browser
		driver.navigate().to("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		System.out.println(driver.getTitle());

		// select by index
		WebElement dd1 = driver.findElement(By.id("dropdown1"));
		Select selectdd1 = new Select(dd1);
		selectdd1.selectByIndex(3);

		// select by text
		WebElement dd2 = driver.findElement(By.xpath("//select[@name='dropdown2']"));
		Select selectdd2 = new Select(dd2);
		selectdd2.selectByVisibleText("Selenium");

		// select by value
		WebElement dd3 = driver.findElement(By.id("dropdown3"));
		Select selectdd3 = new Select(dd3);
		selectdd3.selectByValue("4");

		// number of droplist options
		WebElement dd4 = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select selectdd4 = new Select(dd4);
		List<WebElement> dd4Options = selectdd4.getOptions();
		System.out.println("Number of dropdown options is " + dd4Options.size());

		// send keys to select options
		WebElement dd5 = driver.findElement(By.xpath("(//div[@class='example'])[5]/select"));
		dd5.sendKeys(Keys.CONTROL+"L");

		// select multiple
		WebElement dd6 = driver.findElement(By.xpath("(//div[@class='example'])[6]/select"));
		Select selectdd6 = new Select(dd6);
		selectdd6.selectByVisibleText("Appium");
		dd6.sendKeys(Keys.CONTROL + "U");

	}

}
