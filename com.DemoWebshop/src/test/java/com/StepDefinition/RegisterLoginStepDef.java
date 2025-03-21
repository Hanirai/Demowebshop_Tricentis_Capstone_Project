package com.StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Pages.RegisterLoginPage;
import com.Utility.Base;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterLoginStepDef {
	
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	RegisterLoginPage page3 = new RegisterLoginPage(driver, test);
	
	@Given("Home page of website")
	public void home_page_of_website() {
	    System.out.println("Visited homepage");
	}

	@When("click on register")
	public void click_on_register() {
		page3.registerlink();
		 System.out.println("Clicked on register");
	}

	@When("Choose gender")
	public void choose_gender() {
		page3.genderselect();
		 System.out.println("Gender choosen");
	}

	@When("Enter {string} in first name field")
	public void enter_in_first_name_field(String fn) {
		page3.enterfirstname(fn);
		 System.out.println("Firstname entered");
	}

	@When("Enter {string} in second name field")
	public void enter_in_second_name_field(String ln) {
		page3.enterlastname(ln);
		 System.out.println("Lastname entered");
	}

	@When("Enter {string} in email field")
	public void enter_in_email_field(String em) {
		page3.enteremail(em);
		System.out.println("Email entered");
	}

	@When("Enter {string} in password field")
	public void enter_in_password_field(String pass) {
		page3.enterpass(pass);
		System.out.println("Password entered");
	}

	@When("Enter {string} in confirm password field")
	public void enter_in_confirm_password_field(String cnfrmpass) {
		page3.enterconfirmpass(cnfrmpass);
		System.out.println("Confirmpassword entered");
	}

	@When("click on register button")
	public void click_on_register_button() {
		page3.registerbutton();
		System.out.println("Clicked register button");
	}

	@Then("Registered successfuly")
	public void registered_successfuly() {
		Assert.assertTrue(page3.successmsgdisplay());
		page3.clickcontinue();
		System.out.println("Registeration successful");
	}
	@When("Click on logout")
	public void click_on_logout() {
		page3.logoutbtn();
	    System.out.println("Logged out");
	}
	@Then("Invalid email")
	public void invalid_email() {
	    Assert.assertTrue(page3.invalidmsgdisplay());
	    System.out.println("Invalid email");
	}
	@When("Click on login")
	public void click_on_login() {
		page3.clicklogin();
	    System.out.println("Clicked login");
	}

	@When("Click on login button")
	public void click_on_login_button() {
		page3.loginbutton();
	    System.out.println("Clicked login button");
	}

	@Then("Logged in successfully")
	public void logged_in_successfully() {
		Assert.assertTrue(page3.loginsuccess());
	    System.out.println("Login successful");
	}
	@Then("invalid login credentials")
	public void invalid_login_credentials() {
		Assert.assertTrue(page3.invalidlogin());
	   System.out.println("invalid login credentials");
	}
	@When("Click on Forgot password")
	public void click_on_forgot_password() {
		page3.forgotpassword();
	    System.out.println("Clicked on forgot password");
	}

	@When("Click on recover button")
	public void click_on_recover_button() {
		page3.recoverybtn();
	    System.out.println("Clicked on recover button");
	}

	@Then("Email sent message displayed")
	public void email_sent_message_displayed() {
		Assert.assertTrue(page3.emailsent());
	   System.out.println("Email sent successfully");
	}

	@Then("Email does not exist  message displayed")
	public void email_does_not_exist_message_displayed() {
		Assert.assertTrue(page3.emailnotexist());
	    System.out.println("Email does not exist");
	}
}

