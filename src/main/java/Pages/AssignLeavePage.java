package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AssignLeavePage extends PageBase{
    public AssignLeavePage(WebDriver driver) {
        super(driver);
    }


    By usernameField = By.xpath("//input[@placeholder='Type for hints...']");
    By nameOption = By.xpath("(//div[@role='listbox'])[1]");
    By leaveTypeField = By.xpath("(//div[@class=\"oxd-select-text oxd-select-text--active\"])[1]");
    By leaveTypeList =By.xpath("(//div[@role='option'])[2]");
    By fromDateField = By.xpath("(//input[@placeholder=\"yyyy-dd-mm\"])[1]");
    By toDateField = By.xpath("(//input[@placeholder=\"yyyy-dd-mm\"])[2]");
    By commentField = By.xpath("//textarea[contains(@class, oxd-textarea)]");
    By submitBtn = By.xpath("//button[@type='submit']");

    public WebElement dateRangeErrorMessage() {
        return driver.findElement(By.cssSelector(".oxd-input-field-error-message"));
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


   By calender1 = By.xpath("(//i[@class=\"oxd-icon bi-calendar oxd-date-input-icon\"])[1]");
   By calendar2 = By.xpath("(//i[@class=\"oxd-icon bi-calendar oxd-date-input-icon\"])[2]");
   By FromDateDay = By.xpath("//div[@class=\"oxd-calendar-date-wrapper --offset-2\"]");
   By ToDateDay = By.xpath("(//div[@class=\"oxd-calendar-date-wrapper\"])[1]");
   By month = By.xpath("(//button[@class='oxd-icon-button'])[3]");

    List<WebElement> getRequiredErrorMessages() {
        return driver.findElements(By.cssSelector(".oxd-input-field-error-message"));
    }
    public WebElement getEmployeeNameErrorMessage() {
        return getRequiredErrorMessages().get(0);
    }
    public WebElement getLeaveTypeErrorMessage() {
        return getRequiredErrorMessages().get(1);
    }
    public WebElement getFromDateErrorMessage() {
        return getRequiredErrorMessages().get(2);
    }
    public WebElement getToDateErrorMessage() {
        return getRequiredErrorMessages().get(3);
    }


    public void enterEmployeeName(String name)
    {
        sendText(usernameField, name);
    }
    public void selectUsername(String name)
    {
       WebElement usernameElement
         = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(usernameField));
       usernameElement.sendKeys(name);
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnButton(nameOption);
    }
    public void selectLeaveType(String type)
    {
        clickOnButton(leaveTypeField);
        clickOnButton(leaveTypeList);
    }
    public void enterFromDate(String date)
    {
        sendText(fromDateField, date);
    }
    public void enterToDate(String date)
    {
        sendText(toDateField, date);
    }
    public void enterComment(String comment)
    {
        sendText(commentField, comment);
    }
    public void clickOnSubmitBtn()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(submitBtn));
        clickOnButton(submitBtn);
    }
   public void selectFromDate() {
        clickOnButton(calender1);
        clickOnButton(FromDateDay);
   }
   public void selectToDate(){
        clickOnButton(calendar2);
        clickOnButton(ToDateDay);
   }

}



