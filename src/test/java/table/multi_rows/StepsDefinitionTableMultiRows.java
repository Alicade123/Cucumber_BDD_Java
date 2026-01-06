package table.multi_rows;

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
import java.util.Map;

public class StepsDefinitionTableMultiRows {
    private WebDriver driver;
    private WebDriverWait wait;
    private String websiteUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Given("I am in the login page of the Para Bank Application")
    public void i_am_in_the_login_page() {
        driver = new ChromeDriver();
        driver.get(websiteUrl);
        driver.manage().window().maximize();
    }

    @When("I enter valid credential")
    public void i_enter_valid_credential(DataTable table) {
        /*
        Todo: Multi-row, multi-col	table.asMaps(String.class, String.class) or POJO
         */
        List<Map<String,String>> loginData = table.asMaps(String.class, String.class);
        for(Map<String, String> dataRow:loginData){
        String username = dataRow.get("username");
        String password = dataRow.get("password");
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='Log In']")).click();

            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.title")));
            driver.findElement(By.linkText("Log Out")).click();
        }
    }

    @Then("I should be taken to the LoginPage")
    public void i_should_be_taken_to_the_LoginPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#leftPanel h2")));
    }
}
