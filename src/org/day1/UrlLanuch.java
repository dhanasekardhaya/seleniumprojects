package org.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UrlLanuch {

	public static void main(String[] args) {
		//System.setProperty("webdriver.gecko.driver", "D:\\Java_seleninum\\Seleniumprojects\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.greenstechnologys.com/");

	}

}
