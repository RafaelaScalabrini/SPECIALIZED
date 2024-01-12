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
    protected String FirstNameInputField = "//input[@id='firstname']";
    protected String LastNameInputField = "//input[@id='lastname']";
    protected String DateOfBirthDatePickerField = "//input[@id='birthdate']";
    protected String GenderMaleRadioField = "//label[input[@id='gendermale']]";
    protected String GenderFemRadioField = "//label[input[@id='genderfemale']]";
    protected String StreetAddressInputField = "//input[@id='streetaddress']";
    protected String CountrySelectField = "//select[@id='country']";
    protected String ZipCodeInputField = "//input[@id='zipcode']";
    protected String CityInputField = "//input[@id='city']";
    protected String OccupationSelectField = "//select[@id='occupation']";
    protected String SpeedingCheckboxField = "//label[input[@id='speeding']]";
    protected String BungeeJumpingCheckboxField = "//label[input[@id='bungeejumping']]";
    protected String CliffDivingCheckboxField = "//label[input[@id='cliffdiving']]";
    protected String SkydivingCheckboxField = "//label[input[@id='skydiving']]";
    protected String OtherCheckboxField = "//label[input[@id='other']]";
    protected String NextButton = "//button[@id='nextenterproductdata']";



    //Metodos para executar uma ação em algum campo definido acima
    public void fillOutTheInsurantForm(){
        driver.findElement(By.xpath(FirstNameInputField)).sendKeys("Rafaela");
        driver.findElement(By.xpath(LastNameInputField )).sendKeys("Scalabrin");
        driver.findElement(By.xpath(DateOfBirthDatePickerField)).sendKeys("11/01/2000");
        click(driver.findElement(By.xpath(GenderFemRadioField)));
        selectOption(driver.findElement(By.xpath(CountrySelectField)),"Brazil");
        driver.findElement(By.xpath(ZipCodeInputField)).sendKeys("14406600");
        selectOption(driver.findElement(By.xpath(OccupationSelectField)),"Employee");
        click(driver.findElement(By.xpath(SpeedingCheckboxField)));
        click(driver.findElement(By.xpath(BungeeJumpingCheckboxField)));
        click(driver.findElement(By.xpath(CliffDivingCheckboxField)));
        click(driver.findElement(By.xpath(SkydivingCheckboxField)));
        click(driver.findElement(By.xpath(OtherCheckboxField)));
        click(driver.findElement(By.xpath(NextButton)));
    }
    public boolean ValidateThatTheEnterProductDataIsActive() {
        return new WebDriverWait(driver, Duration.ofSeconds(500)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().equalsIgnoreCase("Enter Product Data");
            }
        });
    }

}

