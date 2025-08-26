package com.QA.Fast;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FastAutomation {

	public static void main(String[] args) {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		WebDriver wd = new ChromeDriver(chromeOptions);
		wd.get("https://fast.com/");

		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(20));

		By speedValueLocator = By.id("speed-value");
		By speedUnitLocator = By.id("speed-units");

		String className;

		while (true) {
			WebElement SpeedValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedValueLocator));
			WebElement speedUnitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedUnitLocator));

			System.out.println(SpeedValueElement.getText() + " " + speedUnitElement.getText());
			className = SpeedValueElement.getAttribute("class");

			if (className != null && className.contains("succeeded")) {
				break;
			}

		}
		WebElement SpeedValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedValueLocator));
		WebElement speedUnitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedUnitLocator));
		System.out.println("-----------------------Final Speed-----------------------");
		System.out.println(SpeedValueElement.getText() + " " + speedUnitElement.getText());

	}

}
