package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InsurantDataPage extends BasePage {
    public InsurantDataPage(WebDriver driver) {
        super(driver);
        // No assertions, throws an exception if the element is not loaded
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(d -> d.findElement(By.xpath("//li[@class='idealsteps-step-active']//a[@id='enterinsurantdata']")));
    }
    //Campos (Locators = XPath)
    protected String   FirstNameInputField = "//input[@id='firstname']";
    protected String   LastNameInputField = "//input[@id='lastname']";
    protected String DateOfManufactureDatePickerField = "//input[@id='birthdate']";
    protected String CountrySelectField1 = "//select[@id='country']";
    protected String   ZipCodeInputField = "//input[@id='zipcode']";
    protected String OccupationSelectField1 = "//select[@id='occupation']";
    protected String Speeding1 = "//select[@id='speeding']";
    protected String RightHandDriveYesRadioField = "//input[@id='righthanddriveyes']";
    protected String NextButton1 = "//button[@id='nextenterproductdata']";



    //Metodos para executar uma ação em algum campo definido acima
    public void fillOutTheInsurantForm(){
        driver.findElement(By.xpath(FirstNameInputField)).sendKeys("Rafaela");
        driver.findElement(By.xpath(LastNameInputField )).sendKeys("Scalabrin");
        driver.findElement(By.xpath(DateOfManufactureDatePickerField)).sendKeys("11/01/2000");
        selectOption(driver.findElement(By.xpath(CountrySelectField1)),"Brazil");
        driver.findElement(By.xpath(ZipCodeInputField)).sendKeys("14406600");
        selectOption(driver.findElement(By.xpath(OccupationSelectField1 )),"Employee");
        click(driver.findElement(By.xpath(Speeding1)));
        click(driver.findElement(By.xpath(NextButton1)));
    }
    public boolean ValidateThatTheEnterProductDataIsActive() {
        return new WebDriverWait(driver, Duration.ofSeconds(500)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().equalsIgnoreCase("Enter Product Data");
            }
        });
    }

}

