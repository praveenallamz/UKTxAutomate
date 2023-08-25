package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	@Given("^user is on servicing login page$")
	public void user_is_on_servicing_login_page() throws Throwable {
		System.out.println("User is on login page");
	}
	@When("^user enter username$")
	public void user_enter_username() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User is enter username");
	}

	@And("^click on next$")
	public void click_on_next() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User is click in next button");
	}

	@Then("^user is navigate to passcode page$")
	public void user_is_navigate_to_passcode_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User is on passcode page");
	}
}
