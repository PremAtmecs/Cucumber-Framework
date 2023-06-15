package stepDefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import pageObject.LoginPage;

@RunWith(Cucumber.class)
public class LoginSteps {


    public static LoginPage loginPage = new LoginPage();

    @Given("^Launch the Application$")
    public void launchApplication() {
        loginPage.launchBrowser();
        System.out.println("launch the browser");
    }

    @When("click login button with credentials {string} and {string}")
    public void click_login_button_with_credentials(String email, String password) {
        loginPage.clickLogin(email, password);
    }

    @Then("^Validating user can navigate to homepage$")
    public void validating_user_can_navigate_to_homepage() {
        loginPage.validateProductPage();
    }

    @When("^Click logout button")
    public void clickLogout() throws InterruptedException {
        loginPage.clickLogout();
    }

    @Then("^Validating user can navigate to Loginpage")
    public void validateLoginPage(){
        loginPage.validateLoginPage();
    }

    @And("^Close the browser$")
    public void close_the_browser() {
        loginPage.quitBrowser();
    }
}
