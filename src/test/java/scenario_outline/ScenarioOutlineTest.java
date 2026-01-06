package draft;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepsParameter {
    private WebDriver driver;
    private WebDriverWait wait;
    private String websiteUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Given("I am in the login page of the Para Bank Application")
    public void i_am_in_the_login_page_of_the_Para_Bank_Application(){
        System.out.println("User is on login page");
        driver = new ChromeDriver();
        driver.get(websiteUrl);
        driver.manage().window().maximize();
    }
    @When("I enter valid {string} and {string}")
    public void i_enter_valid_credential(String username, String password){
        System.out.println("User enters valid credentials");
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='Log In']")).click();

    }
    @Then("I should be taken to the OverView Page")
    public void i_should_be_taken_to_the_OverView_Page() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[class='title']")));
        System.out.println("User logged in successfully");
        driver.findElement(By.cssSelector("h1[class='title']")).isDisplayed();
        driver.findElement(By.linkText("Log Out")).click();
        System.out.println("User logged out successfully \nThank you.");
    }
}
