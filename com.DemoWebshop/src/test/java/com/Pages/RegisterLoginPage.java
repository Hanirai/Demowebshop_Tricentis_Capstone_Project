package com.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Utility.Base;
import com.Utility.Reports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class RegisterLoginPage {
		
		private WebDriver driver;
		private WebDriverWait wait;
		ExtentTest test;

		public RegisterLoginPage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			this.test = test;
		}
		
		By register = By.linkText("Register");
		By gender = By.id("gender-female");
		By firstname = By.id("FirstName");
		By lastname = By.id("LastName");
		By email = By.id("Email");
		By password = By.id("Password");
		By confirmpassword = By.id("ConfirmPassword");
		By registerbtn = By.id("register-button");
		By successmsg = By.xpath("//div[@class='result']");
		By continuebtn = By.xpath("//input[@value='Continue']");
		By invalidmsg = By.xpath("//li[normalize-space()='The specified email already exists']");
		By logoutlink = By.linkText("Log out");
		By loginlink = By.linkText("Log in");
		By Loginbtn = By.xpath("//input[@value='Log in']");
		By logininvalid = By.xpath("//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]");
		By forgotpass = By.linkText("Forgot password?");
		By recoverbtn = By.xpath("//input[@name='send-email']");
		By emailsentmsg = By.xpath("//div[@class='result']");
		By emailnotexistmsg = By.xpath("//div[@class='result']");
		
		public void registerlink() {
			Base.driver.findElement(register).click();
		}
		public void genderselect() {
			Base.driver.findElement(gender).click();
		}
		public void enterfirstname(String fn) {
			Base.driver.findElement(firstname).sendKeys(fn);
		}
		public void enterlastname(String ln) {
			Base.driver.findElement(lastname).sendKeys(ln);
		}
		public void enteremail(String em) {
			Base.driver.findElement(email).sendKeys(em);
		}
		public void enterpass(String pass) {
			Base.driver.findElement(password).sendKeys(pass);
		}
		public void enterconfirmpass(String cnfrmpass) {
			Base.driver.findElement(confirmpassword).sendKeys(cnfrmpass);
		}
		public void registerbutton() {
			Base.driver.findElement(registerbtn).click();
		}
		
		//Registration with valid credentials
		public boolean successmsgdisplay() {
			try {
				Assert.assertEquals(Base.driver.findElement(successmsg).getText(), "Your registration completed");
				Reports.generateReport(driver, test, Status.PASS, "registration succusfull");
				Reports.captureScreenshot(driver, "registration success");
				return true;
			}catch(Exception e) {
				Reports.generateReport(driver, test, Status.FAIL, "registration not succusfull");
				return false;
			}
		}
		public void clickcontinue() {
			Base.driver.findElement(continuebtn).click();
		}
		public void logoutbtn() {
			Base.driver.findElement(logoutlink).click();
		}
		
		//registration with invalid credentials
		public boolean invalidmsgdisplay() {
			try {
				Assert.assertEquals(Base.driver.findElement(invalidmsg).getText(), "The specified email already exists");
				Reports.generateReport(driver, test, Status.PASS, "email exist message displayed");
				return true;
			}
			catch(Exception e) {
				Reports.generateReport(driver, test, Status.FAIL, "email exist message not displayed");
				return false;
			}
		}
		public void clicklogin() {
			Base.driver.findElement(loginlink).click();
		}
		public void loginbutton() {
			Base.driver.findElement(Loginbtn).click();
		}
		public boolean loginsuccess() {
			try {
				return Base.driver.findElement(logoutlink).isDisplayed();
			}
			catch(Exception e) {
				return false;
			}
		}
		
		//login with valid credentials
		public boolean invalidlogin() {
			try {
				Assert.assertEquals(Base.driver.findElement(logininvalid).getText(), "Login was unsuccessful. Please correct the errors and try again.");
				Reports.generateReport(driver, test, Status.PASS, "login succusfull");
				return true;
			}
			catch(Exception e) {
				Reports.generateReport(driver, test, Status.FAIL, "login not succusfull");
				return false;
			}
		}
		public void forgotpassword() {
			Base.driver.findElement(forgotpass).click();
		}
		public void recoverybtn() {
			Base.driver.findElement(recoverbtn).click();
		}
		
		//recovering the password with valid credentials
		public boolean emailsent() {
			try {
				Assert.assertEquals(Base.driver.findElement(emailsentmsg).getText(), "Email with instructions has been sent to you.");
				Reports.generateReport(driver, test, Status.PASS, "email sent message displayed");
				return true;
				}
			catch(Exception e) {
				Reports.generateReport(driver, test, Status.FAIL, "email sent message not displayed");
				return false;
			}
		}
		
		//recovering password with invalid credentials
		public boolean emailnotexist() {
			try {
				Assert.assertEquals(Base.driver.findElement(emailnotexistmsg).getText(), "Email not found.");
				Reports.generateReport(driver, test, Status.PASS, "email not found message displayed");
				return true;
			}
			catch(Exception e) {
				Reports.generateReport(driver, test, Status.FAIL, "email not found message is not displayed");
				return false;
			}
		}
	}
