package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PriceOptionPage extends BasePage {
    public PriceOptionPage(WebDriver driver) {
        super(driver);
        // No assertions, throws an exception if the element is not loaded
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(d -> d.findElement(By.xpath("//li[@class='idealsteps-step-active']//a[@id='selectpriceoption']")));
    }
    //Campos (Locators = XPath)
    protected String SilverRadioInputField = "//table[@id='priceTable']//tfoot//input[@id='selectsilver']/..";
    protected String GoldRadioInputField = "//table[@id='priceTable']//tfoot//input[@id='selectgold']/..";
    protected String PlatinumRadioInputField = "//table[@id='priceTable']//tfoot//input[@id='selectplatinum']/..";
    protected String UltimateRadioInputField = "//table[@id='priceTable']//tfoot//input[@id='selectultimate']/..";

    protected String NextButton = "//button[@id='nextsendquote']";

    //Metodos para executar uma ação em algum campo definido acima
    public void selectPriceOptionForm() throws InterruptedException {
        //click(driver.findElement(By.xpath(SilverRadioInputField)));
        //click(driver.findElement(By.xpath(GoldRadioInputField)));
        //click(driver.findElement(By.xpath(PlatinumRadioInputField)));
        click(driver.findElement(By.xpath(UltimateRadioInputField)));
        click(driver.findElement(By.xpath(NextButton)));
    }
    public boolean ValidateThatTheSendQuoteIsActive() {
        return new WebDriverWait(driver, Duration.ofSeconds(500)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().equalsIgnoreCase("Send Quote");
            }
        });
    }
}





