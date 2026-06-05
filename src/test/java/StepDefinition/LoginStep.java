package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class LoginStep {

    WebDriver driver;
    WebDriverWait wait;

    @Given("user open TutorialsNinja homepage")
    public void user_open_tutorials_ninja_homepage() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
    }

    @Given("user open TutorialNinja registration page")
    public void user_open_tutorial_ninja_registration_page() {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register"))).click();
    }

    @When("user enter firstname {string}")
    public void user_enter_firstname(String firstname) {
        driver.findElement(By.id("input-firstname")).sendKeys(firstname);
    }

    @When("user enter lastname {string}")
    public void user_enter_lastname(String lastname) {
        driver.findElement(By.id("input-lastname")).sendKeys(lastname);
    }

    @When("user enter registration email {string}")
    public void user_enter_registration_email(String email) {
        driver.findElement(By.id("input-email")).sendKeys(email);
    }

    @When("user enter telephone {string}")
    public void user_enter_telephone(String telephone) {
        driver.findElement(By.id("input-telephone")).sendKeys(telephone);
    }

    @When("user enter registration password {string}")
    public void user_enter_registration_password(String password) {
        driver.findElement(By.id("input-password")).sendKeys(password);
    }

    @When("user enter confirm password {string}")
    public void user_enter_confirm_password(String confirmPassword) {
        driver.findElement(By.id("input-confirm")).sendKeys(confirmPassword);
    }

    @When("user click on privacy policy checkbox")
    public void user_click_on_privacy_policy_checkbox() {
        driver.findElement(By.name("agree")).click();
    }

    @When("user Click on continue button")
    public void user_click_on_continue_button() {
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }

    @Then("registration execute successfully")
    public void registration_execute_successfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Your Account Has Been Created!']")));
        System.out.println("Registration Successful");
        driver.quit();
    }
}