package Tests;

import Pages.AssignLeavePage;
import Pages.LoginPage;
import Pages.PageBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AssignLeaveTest extends TestBase{
    AssignLeavePage assignLeave;
    LoginPage login;
    PageBase page;
    String assignPageURL = "https://opensource-demo.orangehrmlive.com/web/index.php/leave/assignLeave";

    @BeforeMethod
    public void loginTest()
    {
        page.navigateToPage(assignPageURL);
        login = new LoginPage(driver);
        login.loginForm("Admin", "admin123");
    }
    @Test
    public void assignLeaveWithoutFillingRequiredFields()
    {
        assignLeave = new AssignLeavePage(driver);
        assignLeave.clickOnSubmitBtn();

        Assert.assertEquals(assignLeave.getEmployeeNameErrorMessage().getText(), "Required");
        Assert.assertEquals(assignLeave.getLeaveTypeErrorMessage().getText(), "Required");
        Assert.assertEquals(assignLeave.getFromDateErrorMessage().getText(), "Required");
        Assert.assertEquals(assignLeave.getToDateErrorMessage().getText(), "Required");

    }
    @Test
    public void enterNameWithoutSelectingItFromTheList()
    {
        assignLeave = new AssignLeavePage(driver);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assignLeave.enterEmployeeName("a");
        assignLeave.clickOnSubmitBtn();
        Assert.assertEquals(assignLeave.getEmployeeNameErrorMessage().getText(),"Invalid");
    }
    @Test
    public void enterFromDateAfterToDate()
    {
        assignLeave = new AssignLeavePage(driver);

        assignLeave.enterFromDate("2024-12-12");
        assignLeave.selectToDate();
        Assert.assertEquals(assignLeave.dateRangeErrorMessage().getText(), "To date should be after from date");
    }
    @Test
    public void enterAnIncorrectDateFormat()
    {
        assignLeave = new AssignLeavePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assignLeave.enterFromDate("2024-31-13");
        assignLeave.enterToDate("2024-31-13");
        assignLeave.enterComment("Blam Blam");
        Assert.assertEquals(assignLeave.ErrorMessage1Format().getText(),"Should be a valid date in yyyy-dd-mm format");
        Assert.assertEquals(assignLeave.ErrorMessage2Format().getText(),"Should be a valid date in yyyy-dd-mm format");

    }
    @Test
    public void testSelectingDateFromCalender()
    {
        assignLeave = new AssignLeavePage(driver);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assignLeave.selectFromDate();
        assignLeave.selectToDate();

    }
    @Test
    public void userCanAssignLeave()
        {
        assignLeave = new AssignLeavePage(driver);

        assignLeave.selectUsername("a");
        assignLeave.selectLeaveType("CAN - FMLA");
        assignLeave.selectFromDate();
        assignLeave.selectToDate();
        assignLeave.enterComment("blam blam");
        assignLeave.clickOnSubmitBtn();
    }


}
