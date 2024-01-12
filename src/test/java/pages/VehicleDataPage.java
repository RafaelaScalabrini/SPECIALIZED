package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VehicleDataPage extends BasePage {
    public VehicleDataPage(WebDriver driver) {
        super(driver);
        // No assertions, throws an exception if the element is not loaded
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(d -> d.findElement(By.id("entervehicledata")));
    }
    protected String MakeSelectField = "//select[@id='make']";
    protected String ModelSelectField = "//select[@id='model']";
    protected String CylinderCapacityInputField = "//input[@id='cylindercapacity']";
    protected String EnginePerformanceInputField = "//input[@id='engineperformance']";
    protected String DateOfManufactureDatePickerField = "//input[@id='dateofmanufacture']";
    protected String NumberOfSeatsSelectField1 = "//select[@id='numberofseats']";
   // protected String RightHandDriveYesRadioField = "//input[@id='righthanddriveyes']";
   // protected String RightHandDriveNoRadioField = "//input[@id='righthanddriveyno']";
    protected String NumberOfSeatsSelectField2 = "//select[@id='numberofseatsmotorcycle']";
    protected String FuelTypeSelectField = "//select[@id='fuel']";
    protected String PayloadInputField = "//input[@id='payload']";
    protected String TotalWeightInputField = "//input[@id='totalweight']";
    protected String ListPriceInputField = "//input[@id='listprice']";
    protected String LicensePlateNumberInputField = "//input[@id='licenseplatenumber']";
    protected String AnnualMileageInputField = "//input[@id='annualmileage']";
    protected String NextButton = "//button[@id='nextenterinsurantdata']";

    public void fillOutTheEnterVehicleForm() {

        selectOption(driver.findElement(By.xpath(MakeSelectField)), "BMW");
        selectOption(driver.findElement(By.xpath(ModelSelectField)), "Motorcycle");
        driver.findElement(By.xpath(CylinderCapacityInputField)).sendKeys("1000");
        driver.findElement(By.xpath(EnginePerformanceInputField)).sendKeys("1000");
        driver.findElement(By.xpath(DateOfManufactureDatePickerField)).sendKeys("11/01/2000");
        selectOption(driver.findElement(By.xpath(NumberOfSeatsSelectField1)),"1");
       // click(driver.findElement(By.xpath(RightHandDriveYesRadioField)));
        selectOption(driver.findElement(By.xpath(NumberOfSeatsSelectField2)),"1");
        selectOption( driver.findElement(By.xpath(FuelTypeSelectField)), "Gas");
        driver.findElement(By.xpath(PayloadInputField)).sendKeys("1000");
        driver.findElement(By.xpath(TotalWeightInputField)).sendKeys("3500");
        driver.findElement(By.xpath(ListPriceInputField)).sendKeys("2000");
        driver.findElement(By.xpath(LicensePlateNumberInputField)).sendKeys("123456789");
        driver.findElement(By.xpath(AnnualMileageInputField)).sendKeys("2023");
        click(driver.findElement(By.xpath(NextButton)));
    }

    public boolean ValidateThatTheInsurantDataPageIsActive() {
        return new WebDriverWait(driver, Duration.ofSeconds(500)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().equalsIgnoreCase("Enter Insurant Data");
            }});

}
}