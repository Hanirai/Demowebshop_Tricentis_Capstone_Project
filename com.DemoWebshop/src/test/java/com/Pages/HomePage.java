package com.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utility.Reports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class HomePage {

	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;

	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;
	}
	
	By featurePro = By.xpath("//strong[text()='Featured products']");
    By searchBar=By.xpath("//input[@id='small-searchterms']");
    By searchButton=By.xpath("//input[@value='Search']");
    By advance=By.xpath("//input[@id='As']");
    By categoryDrop=By.xpath("//select[@id='Cid']");
    By priceFrom=By.xpath("//input[@id='Pf']");
    By priceTo=By.xpath("//input[@id='Pt']");
    By advanceSearchB=By.xpath("//input[@class='button-1 search-button']");
    By asearchBar=By.xpath("//input[@id='Q']");
    By categoryCheckbox=By.xpath("//input[@id='Isc']");
    By descripCheckbox=By.xpath("//input[@id='Sid']");
    By healthBook = By.xpath("//img[@title='Show details for Health Book']");
	
    //validating the URL
    public boolean validUrl() {
		String currUrl =driver.getCurrentUrl();		
		boolean actResult;
		if (currUrl.equals("https://demowebshop.tricentis.com/")) {
			actResult = true;
			Reports.generateReport(driver, test, Status.PASS, "demo webshop is launched Successful");
		} else {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "demo webshop is launched failure");
		}
		return actResult;
    }
    
    //verifying the feature
    public boolean verifyFeature() {
    	boolean actResult=true;
    	try {    		
    		wait.until(ExpectedConditions.visibilityOfElementLocated(featurePro));
    		Reports.generateReport(driver, test, Status.PASS, "feature product is visible");
    	}catch(TimeoutException ee) {
    		actResult=false;
    		Reports.generateReport(driver, test, Status.FAIL, "featured product is not visible");
    	}
    	return actResult;
    }
    
    //verifying the search bar
	public boolean verifySearchBar() {
		boolean actResult=true;
    	try {
    		wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
    		Reports.generateReport(driver, test, Status.PASS, "search bar is available");
    	}catch(TimeoutException ee) {
    		actResult=false;
    		Reports.generateReport(driver, test, Status.FAIL, "search bar is not available");
    	}
    	return actResult;
    }
	
	//verifying search result 
	public boolean verifySearchResult() {
		boolean actResult=true;
    	try {
    		wait.until(ExpectedConditions.visibilityOfElementLocated(asearchBar));
    		Reports.generateReport(driver, test, Status.PASS, "Advance search option is available");
    	}catch(TimeoutException ee) {
    		actResult=false;
    		Reports.generateReport(driver, test, Status.FAIL, "Advance search option is available");
    	}
    	return actResult;
	}
	public void searchProduct(String Book) {
		driver.findElement(searchBar).sendKeys(Book);
	}
	public void clickSearch() {
		driver.findElement(searchButton).click();
	}
	public void advanceSearch() {
		driver.findElement(advance).click();
	}
	public void Cdropdown() {
		WebElement CdropdownEle=driver.findElement(categoryDrop);
		Select select=new Select(CdropdownEle);
		select.selectByVisibleText("Books");
	}
	public void filterPrice() {
		driver.findElement(priceFrom).sendKeys("0");
		driver.findElement(priceTo).sendKeys("50");
	}
	public void aSearchButton() {
		driver.findElement(categoryCheckbox).click();
		driver.findElement(descripCheckbox).click();
		driver.findElement(advanceSearchB).click();
	}	
	
	//verifying the filtered result after scrolling
	public boolean scrollverifyfilterResult() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		boolean actResult=true;
    	try {
    		wait.until(ExpectedConditions.visibilityOfElementLocated(healthBook));
    		Reports.generateReport(driver, test, Status.PASS, "Filtered results are displayed");
    	}catch(TimeoutException ee) {
    		actResult=false;
    		Reports.generateReport(driver, test, Status.FAIL, "Filtered results are not displayed");
    	}
    	return actResult;
	}
}
