package com.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utility.Reports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ProductPage {

	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;

	public ProductPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;
	}

	By healthBook = By.xpath("//img[@title='Show details for Health Book']");
	By productTitle = By.xpath("//h1[@itemprop='name']");
	By productDescription = By.xpath("//div[@class='short-description']");
	By productPrice = By.xpath("//label[normalize-space()='Price:']");
	By productImage = By.xpath("//img[@id='main-product-img-22']");
    By productInStock = By.xpath("//span[normalize-space()='In stock']");
    By addwishlist = By.xpath("//input[@id='add-to-wishlist-button-22']");
    By addToCart = By.id("add-to-cart-button-22");
    By searchBar=By.xpath("//input[@id='small-searchterms']");
    By searchButton=By.xpath("//input[@value='Search']");
    By wishlistAddnotif=By.xpath("//p[@class='content']");
  
	public void searchHBook() {
		driver.findElement(searchBar).sendKeys("Health Book");
		driver.findElement(searchButton).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		System.out.println("found health book");
	}
	public void ClickHbook() {
		driver.findElement(healthBook).click();
	}
	
	//verifying the product title
	public boolean verifyPtitle() {
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
			Reports.generateReport(driver, test, Status.PASS, "feature product is visible");
		} catch (TimeoutException ee) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "featured product is not visible");
		}
		return actResult;
	}
	
	//verifying the product description
	public boolean verifyPdescription() {
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(productDescription));
			Reports.generateReport(driver, test, Status.PASS, "verified description");
		} catch (TimeoutException ee) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "description is not verified");
		}
		return actResult;
	}
	
	//verifying the product price
	public boolean verifyPprice() {
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
			Reports.generateReport(driver, test, Status.PASS, "price verified");
		} catch (TimeoutException ee) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "price is not verified");
		}
		return actResult;
		}
	public boolean verifyPimage() {
		boolean actResult = true;
		try {	
			wait.until(ExpectedConditions.visibilityOfElementLocated(productImage));
			Reports.generateReport(driver, test, Status.PASS, "image isverified");
		} catch (TimeoutException ee) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "image is not verified");
		}
		return actResult;
	}
	
	//verifying the product availability
	public boolean verifyPavailability() {
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(productInStock));
			Reports.generateReport(driver, test, Status.PASS, "availability verified");
		} catch (TimeoutException ee) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "availability is not verified");
		}
		return actResult;
	}
	public void clickAddWish() {
		driver.findElement(addwishlist).click();
	}
	public void clickAddCart() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(wishlistAddnotif));
  		driver.findElement(addToCart).click();
	}
    	
}
