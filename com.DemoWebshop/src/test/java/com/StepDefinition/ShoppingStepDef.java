package com.StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Pages.ShoppingPage;
import com.Utility.Base;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingStepDef {
	
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	ShoppingPage page2 = new ShoppingPage(driver, test);
	
	@Given("Search {string}")
	public void search(String product1) {
		page2.search1(product1);
		page2.phone();
		System.out.println("Search product1");
	}

	@When("Click on add to cart1")
	public void click_on_add_to_cart1() {
		page2.phoneaddtocart();
		System.out.println("product1 added to cart");
	}
	
	@When("Click on shopping cart")
	public void click_on_shopping_cart() {
		page2.shoppincart();
		System.out.println("Clicked on add to cart");
	}

	@When("Click remove product")
	public void click_remove_product() {
		page2.remove();
		System.out.println("Clicked remove product");
	}

	@When("Click update shopping cart")
	public void click_update_shopping_cart() {
		page2.updatecart();
		System.out.println("Updated shopping cart");
	}

	@When("verify shopping cart")
	public void verify_shopping_cart() {
		Assert.assertTrue(page2.removemsg());
		System.out.println("Verified updated shopping cart");
	}
	
	@When("Click update quantity")
	public void click_update_quantity() {
		page2.quantity();
	    System.out.println("Updated quantities");
	}
	@When("verify update shopping cart")
	public void verify_update_shopping_cart() {
		Assert.assertTrue(page2.updatequantitysuccess());
		System.out.println("Verified update quantites");
	}
	@Then("Verify checkout button")
	public void verify_checkout_button() {
		Assert.assertTrue(page2.verifycheckout());
	    System.out.println("Verified checkout button");
	}

}
