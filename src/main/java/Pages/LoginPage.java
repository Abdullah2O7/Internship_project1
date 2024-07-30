package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginBtn = By.xpath("//button[@type='submit']");
    String loginURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    public void loginForm(String username, String password)
    {
        sendText(usernameField, username);
        sendText(passwordField, password);
        clickOnButton(loginBtn);
    }
    public void navigateToLoginPage()
    {
        driver.get(loginURL);
    }
}
