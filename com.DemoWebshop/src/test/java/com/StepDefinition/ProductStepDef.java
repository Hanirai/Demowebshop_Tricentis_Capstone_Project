package com.StepDefinition;

import org.openqa.selenium.WebDriver;

import com.Pages.HomePage;
import com.Pages.ProductPage;
import com.Utility.Base;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStepDef {
	
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	ProductPage page1 = new ProductPage(driver, test);
	
	@Given("I search for Health Book")
	public void i_search_for_health_book() {
	    page1.searchHBook();
	}

	@When("I click on the product")
	public void i_click_on_the_product() {
	   page1.ClickHbook();
	}

	@Then("I see the product title")
	public void i_see_the_product_title() {
	    page1.verifyPtitle();
	}

	@Then("I see the product description")
	public void i_see_the_product_description() {
	   page1.verifyPdescription();
	}

	@Then("I see the product price")
	public void i_see_the_product_price() {
	   page1.verifyPprice();
	}

	@Then("I see the product images")
	public void i_see_the_product_images() {
	    page1.verifyPimage();
	}

	@Then("I see the product availabity")
	public void i_see_the_product_availabity() {
	    page1.verifyPavailability();
	}

	@Then("I click on add to wishlist")
	public void i_click_on_add_to_wishlist() {
	    page1.clickAddWish();
	}

	@When("I click on add to cart")
	public void i_click_on_add_to_cart() {
	    page1.clickAddCart();
	}

	@Then("product is added")
	public void product_is_added() {
	    System.out.println("product is added to wishlist and cart");
	}
}
