package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDataPage extends BasePage {



    public ProductDataPage(WebDriver driver) {
        super(driver);
        // No assertions, throws an exception if the element is not loaded
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(d -> d.findElement(By.xpath("//li[@class='idealsteps-step-active']//a[@id='enterproductdata']")));
    }

    //Campos (Locators = XPath)
    protected String StartDateDatePickerInputField = "//input[@id='startdate']";
    protected String InsuranceSumSelectField = "//select[@id='insurancesum']";
    protected String MeritRatingSelectField = "//select[@id='meritrating']";
    protected String DamageInsuranceSelectField = "//select[@id='damageinsurance']";
    protected String OptionalProductsEuroProtectionRadioField = "//label[input[@id='EuroProtection']]";
    protected String OptionalProductsLegalDefenseInsuranceRadioField = "//label[input[@id='LegalDefenseInsurance']]";
    protected String CourtesyCarSelectField = "//select[@id='courtesycar']";
    protected String NextButton = "//button[@id='nextselectpriceoption']";


    //Metodos para executar uma ação em algum campo definido acima
    public void fillOutTheProductForm() {
        driver.findElement(By.xpath(StartDateDatePickerInputField)).sendKeys("11/01/2025");
        selectOption(driver.findElement(By.xpath(InsuranceSumSelectField)), " 3.000.000,00");
        selectOption(driver.findElement(By.xpath(MeritRatingSelectField)), "Super Bonus");
        selectOption(driver.findElement(By.xpath(DamageInsuranceSelectField)), "No Coverage");
        click(driver.findElement(By.xpath(OptionalProductsEuroProtectionRadioField)));
        click(driver.findElement(By.xpath(OptionalProductsLegalDefenseInsuranceRadioField)));
        selectOption(driver.findElement(By.xpath(CourtesyCarSelectField)), " Yes");
        click(driver.findElement(By.xpath(NextButton)));
    }

    public boolean ValidateThatTheSelectPriceOptionIsActive() {
        return new WebDriverWait(driver, Duration.ofSeconds(500)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().equalsIgnoreCase("Select Price Option");
            }
        });
    }
}
