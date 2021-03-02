package com.quinbay.cucumber.steps;


import com.quinbay.cucumber.CucumberHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class LoginSteps {
    CucumberHooks ch=new CucumberHooks();
    WebDriver driver=ch.getDriver();
    @Given("^I am on Facebook login page$")
    public void iAmOnFacebookLoginPage() {


    }

    @When("^I enter username as \"(.*)\"$")
    public void iEnterUsernameAs(String username) {
        WebElement user=driver.findElement(By.xpath("//input[@id='email']"));
        user.sendKeys(username);
    }

    @And("^I enter password as \"(.*)\"$")
    public void iEnterPasswordAs(String password) {
        WebElement pass=driver.findElement(By.xpath("//input[@id='pass']"));
        pass.sendKeys(password);
    }

    @Then("Login should fail")
    public void loginShouldFail() {
        WebElement login_btn= driver.findElement(By.xpath("//button[@id='loginbutton']"));
        login_btn.click();
    try {
        WebElement check_login = driver.findElement(By.xpath("//div[@id='error_box']"));

        if (check_login.isDisplayed()) {
            System.out.println("Successfully login failed");
        } else {
            System.out.println("TestCase Failed");
        }
    }
    catch (Exception e)
    {
        System.out.println(e);
    }
        }


    @And("this is a test")
    public void thisIsATest() {


    }
}
