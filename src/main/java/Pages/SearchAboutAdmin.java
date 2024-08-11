package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchAboutAdmin extends PageBase{
    public SearchAboutAdmin(WebDriver driver) {
        super(driver);
    }
    By userRoleField = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
    By role = By.xpath("(//div[@role='option'])[2]");
    By usernameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By employeeNameField = By.xpath("//input[@placeholder='Type for hints...']");
    By employeeName= By.xpath("(//div[@role='listbox'])[1]");
    By statusField = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
    By status = By.xpath("(//div[@role='option'])[2]");
    By searchBtn = By.xpath("//button[@type='submit']");

    public void enterUsername(String username)
    {
        sendText(usernameField, username);
    }
    public void selectUserRole()
    {
        clickOn(userRoleField);
        clickOn(role);
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
    public void selectStatus()
    {
        clickOn(statusField);
        clickOn(status);
    }
    public void clickOnSearchBtn()
    {
        clickOn(searchBtn);
    }
    public WebElement displayedUsername ()  {

        return driver.findElement(By.xpath("(//div[@class='oxd-table-cell oxd-padding-cell'])[2]"));
    }
}
