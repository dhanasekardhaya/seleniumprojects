package org.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class RedBus {
	static WebDriver driver;

	private void lanuchBrowser(String browser) {

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"D:\\Java_seleninum\\Seleniumprojects\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"D:\\Java_seleninum\\Seleniumprojects\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid Type");
			break;
		}

	}

	public void getUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public WebElement fromValue() {
		WebElement fromvalue = driver.findElement(By.id("src"));
		return fromvalue;
	}
	
	public WebElement destvalue() {
		WebElement findElement = driver.findElement(By.id("dest"));
		return findElement;

	}
	

	public void sendKeys(WebElement element, String inputValue) {
		element.sendKeys(inputValue);
	}

	public List<WebElement> sourceList() {
		List<WebElement> sourceList = driver.findElements(By.xpath("//ul[contains(@class, 'sc-dn')]//li//text"));
		return sourceList;
	}
	
	public List<WebElement> destList() {
		List<WebElement> destList = driver.findElements(By.xpath("//ul[contains(@class, 'sc-dn')]//li//div//text"));
		return destList;
	}

	public void sourceSuggestions(List<WebElement> element, String dropPoint) {
		for (int i = 0; i < element.size(); i++) {
			if (element.get(i).getText().equalsIgnoreCase(dropPoint)) {
				Actions a = new Actions(driver);
				Actions moveToElement = a.moveToElement(element.get(i));
				moveToElement.click().build().perform();
				break;
			} else {
				System.out.println("Error");
			}
		}
	}
	
	public void destSuggestions(List<WebElement> element, String dropPoint) {
		
		for (int i = 0; i < element.size(); i++) {
			if (element.get(i).getText().equalsIgnoreCase(dropPoint)) {
				Actions a = new Actions(driver);
				Actions moveToElement = a.moveToElement(element.get(i));
				moveToElement.click().build().perform();
				break;
			} else {
				System.out.println("Error");
			}
			
		}
	}

	public static void main(String[] args) throws InterruptedException {
		RedBus redbus = new RedBus();
		redbus.lanuchBrowser("chrome");
		redbus.getUrl("https://www.redbus.in/");
		redbus.sendKeys(redbus.fromValue(), "chennai");
		redbus.sourceSuggestions(redbus.sourceList(), "Chennai");
		redbus.sendKeys(redbus.destvalue(), "salem");
		redbus.destSuggestions(redbus.destList(), "salem");
		
	}

}
