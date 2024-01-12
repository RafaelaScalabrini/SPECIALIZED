package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QuotePage extends BasePage {
    public QuotePage(WebDriver driver) {
        super(driver);
        // No assertions, throws an exception if the element is not loaded
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(d -> d.findElement(By.xpath("//li[@class='idealsteps-step-active']//a[@id='enterinsurantdata']")));
    }
    //Campos (Locators = XPath)
    protected String EmailInputField = "//input['@id='email']";
    protected String PhoneInputField = "//input['@id='phone']";
    protected String UserNameInputField = "//input[id='username']";
    protected String PasswordInputField = "//input[id='password']";
    protected String ConfirmPasswordInputField = "//input[@id='confirmpassword']";
    protected String CommentsTextAreaField = "//input[@id='Comments']";
    protected String SendButton = "//button[@id='sendemail']";


    //Metodos para executar uma ação em algum campo definido acima
    public void fillOutTheQuoteForm() {
        driver.findElement(By.xpath(EmailInputField)).sendKeys("rafaelascalabrinioliveira@gmail.com");
        driver.findElement(By.xpath(PhoneInputField)).sendKeys("016991712523");
        driver.findElement(By.xpath(UserNameInputField)).sendKeys("rafaelaoliveira");
        driver.findElement(By.xpath(PasswordInputField)).sendKeys("teste");
        driver.findElement(By.xpath(ConfirmPasswordInputField)).sendKeys("Rambo2024");
        driver.findElement(By.xpath(CommentsTextAreaField)).sendKeys("Rambo2024");
        click(driver.findElement(By.xpath(SendButton)));

    }

    public boolean ValidateTheSweetAlertMessageHasSuccess(){
        return new WebDriverWait(driver, Duration.ofSeconds(500)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.xpath("//div[@class='sweet-alert showSweetAlert visible']//h2")).getText().equalsIgnoreCase("Sending e-mail success!");
            }
        });
    }
}
