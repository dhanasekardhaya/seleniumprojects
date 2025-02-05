package org.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxs {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "D:\\Java_seleninum\\Seleniumprojects\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.greenstechnologys.com/");

	}

}
