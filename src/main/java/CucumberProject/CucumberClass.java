package CucumberProject;

import io.cucumber.java.en.*;

public class CucumberClass {

	@Given("Browser is open")
	public void browser_is_open() {
		System.out.println("Browser is open");
		throw new io.cucumber.java.PendingException();
	}

	@And("user is on log in page")
	public void user_is_on_log_in_page() {
		System.out.println("User log in");
		throw new io.cucumber.java.PendingException();
	}

	@And("hits enter")
	public void hits_enter() {
		System.out.println("Hit enter");
		throw new io.cucumber.java.PendingException();
	}

	@Then("user should navigate to the home page")
	public void user_should_navigate_to_the_home_page() {
		System.out.println("User in Home page");
		throw new io.cucumber.java.PendingException();
	}


}
