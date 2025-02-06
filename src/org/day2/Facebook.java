package org.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Facebook {

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

	public void sendKeys(WebElement element, String inputValue) {
		element.sendKeys(inputValue);
	}
	
	public void click(WebElement element) {
		element.click();
	}

	public WebElement userName() {
		WebElement username = driver.findElement(By.id("email"));
		return username;

	}

	public WebElement userpassword() {
		WebElement password = driver.findElement(By.id("pass"));
		return password;

	}
	
	public WebElement loginButton() {
		WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
		return loginButton;
	}

	public static void main(String[] args) {

		Facebook fb = new Facebook();
		fb.lanuchBrowser("firefox");
		fb.getUrl("https://www.facebook.com/");
		fb.sendKeys(fb.userName(), "dhanasekar");
		fb.sendKeys(fb.userpassword(), "dhanasekar");
		fb.click(fb.loginButton());

	}

}
