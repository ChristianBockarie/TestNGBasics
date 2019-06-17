package com.Class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

@Test
public class Annotations extends CommonMethods {

	/**
	 * TC 1: OrangeHRM Title Validation TC 2: OrangeHRM Successful Login
	 * https://opensource-demo.orangehrmlive.com/ Please make sure to use the
	 * following: annotations:
	 * 
	 * @BeforeMethod
	 * @AfterMethod
	 * @Test
	 * 
	 * 		What would you do if you do not want to execute any specific test case?
	 *       What would you do if you want to execute any specific test case first?
	 */
	@BeforeMethod
	public void setUp() {
		setUpDriver("chrome", "http://opensource-demo.orangehrmlive.com/");
		boolean orangeHrm = driver.findElement(By.xpath("//title[text()='OrangeHRM']")).isDisplayed();
		if (orangeHrm = true) {
			System.out.println("The title : " + driver.getTitle() + " is Correct");
		} else {
			System.out.println("Not the Correct Title");
		}
	}

	@Test(priority = 1)
	public void logIn() {
		sendText(driver.findElement(By.cssSelector("input#txtUsername")), "Admin");
		sendText(driver.findElement(By.cssSelector("input#txtPassword")), "admin123");
		driver.findElement(By.cssSelector("input.button")).click();
	}

	@Test(priority = 2)
	public void mainPageVerification() {
		WebElement logo = driver.findElement(By.xpath("//img[@alt='OrangeHRM']"));
		if (logo.isDisplayed()) {
			System.out.println("OrangeHRM Logo is displayed. LogIn Successful");
		} else {
			System.out.println("Logo not displayed wrong page");
		}
	}

	@AfterMethod
	public void closePage() {
		driver.close();
	}

}
