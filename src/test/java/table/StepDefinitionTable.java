package table;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StepDefinitionTable {
    private WebDriver driver;
    private WebDriverWait wait;
    private String websiteUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Given("I am in the login page of the Para Bank Application")
    public void i_am_in_the_login_page() {
        driver = new ChromeDriver();
        driver.get(websiteUrl);
        driver.manage().window().maximize();
    }
    //Without Heading :: |john|demo|
    //Todo: Single-column	table.asList()
    //Todo: Single-row, multi-col	table.asLists()
    @When("I enter valid credential")
    public void i_enter_valid_credential(DataTable table) {
        List<List<String>> loginData = table.asLists();
        driver.findElement(By.name("username")).sendKeys(loginData.getFirst().get(0));
        driver.findElement(By.name("password")).sendKeys(loginData.getFirst().get(1));
        driver.findElement(By.cssSelector("input[value='Log In']")).click();
    }

//    //with Heading ::
//         Todo               |username|password|
//         Todo               |john|demo|
//    @When("I enter valid credential")
//    public void i_enter_valid_credential(DataTable table) {
//        Map<String, String> loginData = table.asMaps().getFirst();
//
//        driver.findElement(By.name("username")).sendKeys(loginData.get("username"));
//        driver.findElement(By.name("password")).sendKeys(loginData.get("password"));
//        driver.findElement(By.cssSelector("input[value='Log In']")).click();
//    }

    @Then("I should be taken to the OverView Page")
    public void i_should_be_taken_to_the_overview_page() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.title")));
        driver.findElement(By.linkText("Log Out")).click();
    }
}
