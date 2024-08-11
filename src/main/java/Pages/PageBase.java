package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class PageBase {
    public WebDriver driver;
    public Select select;

    public PageBase(WebDriver driver){
        this.driver = driver;
    }
    public void waitUntilVisibilityOfElement(By by)
    {
         new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void clickOn(By by)
    {
        waitUntilVisibilityOfElement(by);
        driver.findElement(by).click();
    }
    public void sendText(By by, String text)
    {
        waitUntilVisibilityOfElement(by);
       driver.findElement(by).sendKeys(text);
    }
    public void clearText(By by)
    {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
        element.clear();
    }
    public void selectElement(By by, String text)
    {
        select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }
    public void navigateToPage(String url)
    {
        driver.get(url);
    }


}
