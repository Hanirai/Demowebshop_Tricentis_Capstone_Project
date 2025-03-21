package com.StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Pages.HomePage;
import com.Utility.Base;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStepDef extends Base {

	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	HomePage page = new HomePage(driver, test);

	@Given("I navigate to the home page")
	public void i_navigate_to_the_home_page() {
		boolean actResult = page.validUrl();
		Assert.assertTrue(actResult);
	}

	@Given("I verify the Featured Products")
	public void i_verify_the_featured_products() {
		boolean res = page.verifyFeature();
		Assert.assertTrue(res);
	}

	@Given("I verify the search bar")
	public void i_verify_the_search_bar() {
		boolean res = page.verifySearchBar();
		Assert.assertTrue(res);
	}

	@When("I search for {string}")
	public void i_search_for(String Book) {
		page.searchProduct(Book);
	}

	@When("I click on the search button")
	public void i_click_on_the_search_button() {
		page.clickSearch();
	}

	@When("I verify the search results")
	public void i_verify_the_search_results() {
		boolean res=page.verifySearchResult();
		Assert.assertTrue(res);
	}

	@Given("I navigate to advanced search")
	public void i_navigate_to_advanced_search() {
		System.out.println("advanced search");
	}

	@When("I click on advanced search")
	public void i_click_on_advanced_search() {
		page.advanceSearch();
	}

	@When("I filter the results by category")
	public void i_filter_the_results_by_category() {
		page.Cdropdown();
	}

	@When("I filter the results by price")
	public void i_filter_the_results_by_price() {
		page.filterPrice();
	}

	@When("I filter the results by ratings")
	public void i_filter_the_results_by_ratings() {
		page.aSearchButton();
	}

	@Then("I verify the filtered product displayed")
	public void i_verify_the_filtered_product_displayed() {
		boolean res=page.scrollverifyfilterResult();
		Assert.assertTrue(res);	
	}

}
