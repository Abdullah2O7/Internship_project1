package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddAdmin extends PageBase{
    public AddAdmin(WebDriver driver) {
        super(driver);
    }

    By addBtn = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    By userRoleField = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
    By role = By.xpath("(//div[@role='option'])[2]");
    By statusField = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
    By status = By.xpath("(//div[@role='option'])[2]");
    By employeeNameField = By.xpath("//input[@placeholder='Type for hints...']");
    By employeeName= By.xpath("(//div[@role='listbox'])[1]");
    By usernameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By passwordField = By.xpath("(//input[@type='password'])[1]");
    By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");
    By saveBtn = By.xpath("//button[@type='submit']");
    By cancelBtn = By.xpath("(//button[@type='button'])[4]");

    By disname = By.xpath("(//div[@class='oxd-table-cell oxd-padding-cell'])[8]\")");


    public void clickAddBtn()
    {
        clickOn(addBtn);
    }
    public void selectUserRole()
    {
        clickOn(userRoleField);
        clickOn(role);
    }
    public void selectStatus()
    {
        clickOn(statusField);
        clickOn(status);
    }
    public void selectEmployeeName(String name)
    {
        sendText(employeeNameField, name);
//        waitUntilVisibilityOfElement(employeeName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOn(employeeName);
    }
    public void enterUsername(String username)
    {
        sendText(usernameField, username);
    }
    public void enterPasswords(String password)
    {
        sendText(passwordField, password);
        sendText(confirmPasswordField, password);
    }
    public void clickOnSaveBtn()
    {
        clickOn(saveBtn);
    }
//    public WebElement displayedUsername ()
//    {
//        waitUntilVisibilityOfElement(disname);
//        return driver.findElement(By.xpath("(//div[@class='oxd-table-cell oxd-padding-cell'])[8]\")"));
//    }

}
