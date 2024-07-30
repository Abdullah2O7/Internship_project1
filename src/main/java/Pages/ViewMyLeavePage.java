package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ViewMyLeavePage extends PageBase {
    public ViewMyLeavePage(WebDriver driver) {
        super(driver);
    }

    String myLeaveURL = "https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewMyLeaveList";

    // Make all private
    By fromDateField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By toDateField = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]");
    By leaveStatusField = By.xpath("//div[@class=\"oxd-select-text oxd-select-text--active oxd-select-text--error\"]");
    By leaveStatusList = By.xpath("(//div[@class=\"oxd-select-text oxd-select-text--active\"])[1]");
    By leaveStatus = By.xpath("(//div[@role='option'])[3]");
    By leaveTypeField = By.xpath("(//div[@Class='oxd-select-text oxd-select-text--active'])[2]");
    By leaveTypeOption = By.xpath("(//div[@role='option'])[3]");
    By submitBtn = By.xpath("//button[@type='submit']");
    By resetBtn = By.xpath("//button[@type='reset']");
    By displayAndHideToggle = By.xpath("(//button[@class='oxd-icon-button'])[2]");
    By calendar1 = By.xpath("(//i[@class=\"oxd-icon bi-calendar oxd-date-input-icon\"])[1]");
    By calendar2 = By.xpath("(//i[@class='oxd-icon bi-calendar oxd-date-input-icon'])[2]");

    By FromDateDay = By.xpath("(//div[@class='oxd-calendar-date-wrapper'])[7]");
    By ToDateDay = By.xpath("(//div[@class=\"oxd-calendar-date-wrapper\"])[2]");


    By months = By.xpath("//li[@class='oxd-calendar-selector-month']");
    By nextMonth = By.xpath("(//button[@class='oxd-icon-button'])[4]");
    By removeStatusIcon = By.xpath("(//i[@class=\"oxd-icon bi-x --clear\"])[1]");

    public WebElement selectedLeaveStatus() {
        return driver.findElement(By.xpath("//span[@class='oxd-chip oxd-chip--default oxd-multiselect-chips-selected']"));
    }


    public WebElement leaveStatusRequiredMessage(){
        return driver.findElement(By.xpath("//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]"));
    }

    List<WebElement> formatErrorMessages() {
        return driver.findElements(By.cssSelector(".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message"));
    }
    public WebElement ErrorMessage1Format() {
        return formatErrorMessages().get(0);
    }
    public WebElement ErrorMessage2Format() {
        return formatErrorMessages().get(1);
    }
    public WebElement dateRangeErrorMessage() {
        return driver.findElement(By.cssSelector(".oxd-input-field-error-message"));
    }
    List<WebElement> monthsList(){
        return driver.findElements(By.xpath("//ul[@role='menu']"));
    }
    WebElement selectMonth(){
        return driver.findElement((By.xpath("(//li[@class='oxd-calendar-dropdown--option'])[1]")));
    }

    public void enterFromDate(String fromDate){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(fromDateField));
        sendText(fromDateField, fromDate);
    }
    public void enterToDate(String toDate){
        sendText(toDateField, toDate);
    }
    public void removeTheSelectedStatus()
    {
        clickOnButton(removeStatusIcon);
    }
    public void selectLeaveStatus()
    {
        clickOnButton(leaveStatusField);
        clickOnButton(leaveStatus);
    }
    public void selectLeaveType()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnButton(leaveTypeField);
        clickOnButton(leaveTypeOption);
    }
    public void clickOnSubmitBtn()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.visibilityOfElementLocated(submitBtn));
        clickOnButton(submitBtn);
    }
    public void selectInvalidFromDate()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(fromDateField));
        clickOnButton(calendar1);
        clickOnButton(months);
        selectMonth().click();
        clickOnButton(FromDateDay);
    }
    public void selectFromDate()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(fromDateField));
        clickOnButton(calendar1);
        clickOnButton(months);
        selectMonth().click();
        driver.findElement(By.xpath(getDay(2))).click();
    }
    public void selectInvalidToDate()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(toDateField));
        clickOnButton(calendar2);
       clickOnButton(months);
       selectMonth().click();
       driver.findElement(By.xpath(getDay(31))).click();
    }
    public void selectToDate()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(toDateField));
        clickOnButton(calendar2);
        clickOnButton(months);
        selectMonth().click();
        driver.findElement(By.xpath(getDay(7))).click();
    }
    public void clearFromDate()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(fromDateField));
        WebElement defaultDate = driver.findElement(fromDateField);
        defaultDate.clear();
    }
    public void clearToDate()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(toDateField));
        WebElement defaultDate = driver.findElement(toDateField);
        defaultDate.clear();
    }
    public void removeAllSelectedStatus()
    {

        clickOnButton(removeStatusIcon);
        clickOnButton(removeStatusIcon);
        clickOnButton(removeStatusIcon);
        clickOnButton(removeStatusIcon);
        clickOnButton(removeStatusIcon);

    }
    public String getTheSelectedFromDate(){
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(fromDateField));
        return element.getText();
    }
    public void clickOnResetBtn()
    {
        clickOnButton(resetBtn);
    }
    public void clickOnUpDownToggle()
    {
         new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(displayAndHideToggle));
        clickOnButton(displayAndHideToggle);
    }
    public void printDates()
    {
        System.out.println(FromDateDay);
        System.out.println(ToDateDay);
    }
    public void elementIsNotClickable()
    {
        clickOnButton(leaveStatusList);
        try {
            clickOnButton(leaveStatus);
            System.out.println("Selected option is still clickable in the list.");
        } catch (Exception e) {
            System.out.println("Selected option is not clickable in the list as expected.");
        }
    }
    public String getDay(int day) {
        return String.format("(//div[@class=\"oxd-calendar-date-wrapper\"])[%d]", day);
    }
    public void navigateToMyLeavePage(){
        driver.get(myLeaveURL);
    }

}
