package org.example.stepdefinitions;


import PageObject.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;
import java.util.List;


public class LoginStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    public LoginPage loginPage;

    @Given("I open the browser")
    public void i_open_the_browser() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/Sounds/Downloads/geckodriver-v0.35.0-win64/geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
    }

    @When("I navigate to path {string}")
    public void i_navigate_to_path(String url) {
        driver.get(url);
    }

    @When("I enter a valid username {string}")
    public void i_enter_a_valid_username(String username) {
        loginPage.enterUsername(username);
    }

    @When("I enter a valid password {string}")
    public void i_enter_a_valid_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlContains("/inventory.html"));
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("Highest valued product and add to cart")
    public void highest_valued_product_and_add_to_cart() {
        loginPage.selectMaxValueProd();
    }

    @When("I navigate to cart")
    public void i_navigate_to_cart() {
        loginPage.clickCartButton();
        loginPage.closeTheBrowser();
    }

    @Then("I close the browser")
    public void i_close_the_browser() {
      loginPage.closeTheBrowser();
    }


}