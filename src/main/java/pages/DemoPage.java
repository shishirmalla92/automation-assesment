package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.TestUtils;

public class DemoPage {

    private WebDriver driver;
    private By demoHeader = By.xpath("/html/body/div[2]/div[2]/div/div[3]/div/div[3]/div/div[1]/h2");
    private By firstNameInput = By.id("210502_557063pi_210502_557063");
    private By firstName = By.id("210502_557063pi_210502_557063");
    private By lastName = By.id("210502_557065pi_210502_557065");
    private By businessEmail = By.id("210502_557067pi_210502_557067");
    private By company = By.id("210502_557069pi_210502_557069");
    private By phone = By.id("210502_557071pi_210502_557071");
    private By country = By.id("210502_567594pi_210502_567594");
    private By channelToImprove = By.id("210502_559150pi_210502_559150");
    private By numberOfResources = By.id("210502_568316pi_210502_568316");
    private By requestDemoBtn = By.className("submit");

    public DemoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstNameValue) {
        WebElement firstNameElement = driver.findElement(firstNameInput);
        firstNameElement.clear();
        firstNameElement.sendKeys(firstNameValue);
    }

    public void enterLastName(String lastNameValue) {
        WebElement lastNameElement = driver.findElement(lastName);
        lastNameElement.clear();
        lastNameElement.sendKeys(lastNameValue);
    }

    public void enterBusinessEmail(String businessEmailValue) {
        WebElement businessEmailElement = driver.findElement(businessEmail);
        businessEmailElement.clear();
        businessEmailElement.sendKeys(businessEmailValue);
    }

    public void enterCompany(String companyValue) {
        WebElement companyElement = driver.findElement(company);
        companyElement.clear();
        companyElement.sendKeys(companyValue);
    }

    public void enterPhone(String phoneNumberValue) {
        WebElement phoneElement = driver.findElement(phone);
        phoneElement.clear();
        phoneElement.sendKeys(phoneNumberValue);
    }

    public void selectCountry(String countryValue) {
        Select countryDropdown = new Select(driver.findElement(country));
        countryDropdown.selectByVisibleText(countryValue);
    }

    public void selectChannels(int channelValue) {
        Select channelDropdown = new Select(driver.findElement(channelToImprove));
        channelDropdown.selectByIndex(channelValue);
    }

    public void selectNumberOfResources(int resourcesValue) {
        Select resourceDropdown = new Select(driver.findElement(numberOfResources));
        resourceDropdown.selectByIndex(resourcesValue);
    }

    public void clickDemoBtn() throws InterruptedException {
        TestUtils.scrollToElement(driver.findElement(phone), driver);
        Thread.sleep(2000);
        WebElement demoBtnElement = driver.findElement(requestDemoBtn);
        demoBtnElement.click();
    }
}
