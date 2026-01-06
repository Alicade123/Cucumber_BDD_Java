package scenario_outline;

import base.dependenceInjection.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class ScenarioOutlineTest extends BaseUtil {

    private WebDriver driver;
    private WebDriverWait wait;
    private String websiteUrl = "https://parabank.parasoft.com/parabank/index.htm";
    private BaseUtil baseUtil;
    public ScenarioOutlineTest(BaseUtil baseUtil){
    this.baseUtil = baseUtil;
    }

    @Before
    public void SetUp(){
        driver = new ChromeDriver();
    }

    @Given("I am in the login page of the Para Bank Application")
    public void i_am_in_the_login_page_of_the_Para_Bank_Application(){
        driver.get(websiteUrl);
        driver.manage().window().maximize();
    }
    @When("I enter valid {string} and {string} with {string}")
    public void i_enter_valid_credential(String username, String password, String fullName){


        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='Log In']")).click();
        baseUtil.userFullName = fullName;

    }
    @Then("I should be taken to the OverView Page")
    public void i_should_be_taken_to_the_OverView_Page() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String expectedResult = baseUtil.userFullName;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[class='title']")));

        System.out.println("User logged in successfully \t The Expected user full name is: "+expectedResult);
        String actualResult = driver.findElement(By.cssSelector("#leftPanel .smallText")).getText();
        System.out.println("\t The found user full name is:"+expectedResult);
        assertTrue("Something went wrong",actualResult.contains(expectedResult));
        driver.findElement(By.cssSelector("h1[class='title']")).isDisplayed();
        driver.findElement(By.linkText("Log Out")).click();
    }

    @After
    public void tearDown(){
    if(driver!=null) driver.quit();
    }
}
