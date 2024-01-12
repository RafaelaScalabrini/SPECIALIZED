package SPECIALIZED;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepsDefinitions {
    protected static WebDriver driver;
    private static final String URL_BASE = "https://sampleapp.tricentis.com/101/app.php";
    private static final String CAMINHO_DRIVER = "src/test/resources/drivers/chrome/chromedriver.exe";

    VehicleDataPage vehicleDataPage = null;
    InsurantDataPage insurantDataPage = null;
    ProductDataPage productDataPage = null;
    PriceOptionPage priceOptionPage = null;
    QuotePage quotePage = null;

    @Before
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    @Given("I enter the Enter vehicle data")
    public void iEnterTheEnterVehicleData() {
        vehicleDataPage = new VehicleDataPage(driver);
    }

    @When("Fill out the form, Enter Vehicle Data tab and if you select the next button")
    public void fillOutTheFormEnterVehicleDataTabAndIfYouSelectTheNextButton() {
        vehicleDataPage.fillOutTheEnterVehicleForm();
    }

    @Then("the system will go to the Enter Insurant Data")
    public void thenTheSystemWillGoToTheEnterInsurantData() {
        assertTrue(vehicleDataPage.ValidateThatTheInsurantDataPageIsActive());
    }

    @Given("that I have the Enter Insurant Data")
    public void iEnterTheInsurantData() {
        insurantDataPage = new InsurantDataPage(driver);
    }

    @When("Fill out the form, Enter Insurant Data tab and if you select the next button")
    public void fillOutTheFormEnterInsurantDataTabAndIfYouSelectTheNextButton() {
        insurantDataPage.fillOutTheInsurantForm();
    }

    @Then("the system will go to the Enter product data")
    public void thenTheSystemWillGoToTheEnterProductData() {
        assertTrue(insurantDataPage.ValidateThatTheEnterProductDataIsActive());
    }

    @Given("that I have the Enter product data")
    public void iEnterTheEnterProductData() {
        productDataPage = new ProductDataPage(driver);
    }

    @When("Fill out the form, Enter product data tab and if you select the next button")
    public void fillOutTheFormEnterProductDataTabAndIfYouSelectTheNextButton() {
        productDataPage.fillOutTheProductForm();
    }

    @Then("the system will go to the Select Price Option")
    public void thenTheSystemWillGoToTheSelectPriceOption() {
        assertTrue(productDataPage.ValidateThatTheSelectPriceOptionIsActive());
    }

    @Given("that I have the Select Price Option")
    public void iEnterTheSelectPriceOption() {
        priceOptionPage = new PriceOptionPage(driver);
    }

    @When("Fill out the form, Select Price Option tab and if you select the next button")
    public void fillOutTheFormSelectPriceOptionTabAndIfYouSelectTheNextButton() throws InterruptedException {
        priceOptionPage.selectPriceOptionForm();
    }

    @Then("the system will go to the  Send Quote")
    public void thenTheSystemWillGoToTheSendQuote() {
        assertTrue(priceOptionPage.ValidateThatTheSendQuoteIsActive());
    }

    @Given("that I have the Send Quote")
    public void iEnterTheSendQuote() {
        quotePage = new QuotePage(driver);
    }

    @When("Fill out the form, Send Quote tab and if you select the next button")
    public void fillOutTheFormSendQuoteTabAndIfYouSelectTheNextButton() {
        quotePage.fillOutTheQuoteForm();
    }

    @Then("the system should display Sending e-mail success!")
    public void thenTheSystemShouldDisplaySendingEMailSuccess() {
        assertTrue(quotePage.ValidateTheSweetAlertMessageHasSuccess());
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
