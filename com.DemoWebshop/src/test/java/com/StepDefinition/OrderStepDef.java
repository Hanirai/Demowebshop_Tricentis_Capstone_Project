package com.StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Pages.OrderPage;
import com.Utility.Base;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderStepDef extends Base {

	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	OrderPage page4 = new OrderPage(driver, test);

	@Given("I search {string} for adding to cart")
	public void i_search_for_adding_to_cart(String product) {
	    page4.searchfinProduct(product);
	}

	@When("I add the product to cart")
	public void i_add_the_product_to_cart() {
	    page4.addfinProductCart();
	}

	@When("I click on shopping cart link")
	public void i_click_on_shopping_cart_link() {
	    page4.shoppinglink();
	}

	@When("I click on checkout")
	public void i_click_on_checkout() {
	    page4.checkbox();
	}

	@When("I login and proceed to checkout")
	public void i_login_and_proceed_to_checkout() {
	   page4.loginproceed();
	   page4.checkbox();
	}

	@When("I enter billing address")
	public void i_enter_billing_address() {
	    page4.billcontinue();
	}

	@When("I continue with shipping address")
	public void i_continue_with_shipping_address() {
	    page4.shippingContinue();
	}

	@When("I continue with shipping method")
	public void i_continue_with_shipping_method() {
	    page4.shipMethodcon();
	}

	@When("I continue with payment methods")
	public void i_continue_with_payment_methods() {
	    page4.payContinue();
	    page4.payinfoContinue();
	}

	@When("I confirm order")
	public void i_confirm_order() {
	    page4.clickconfirm();
	}

	@Then("I validate the successfully processed order")
	public void i_validate_the_successfully_processed_order() {
	   boolean res= page4.successorderdisplay();
	   Assert.assertTrue(res);
	}

}
