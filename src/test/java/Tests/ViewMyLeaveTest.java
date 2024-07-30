package Tests;

import Pages.LoginPage;
import Pages.ViewMyLeavePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ViewMyLeaveTest extends TestBase{
    LoginPage login;
    ViewMyLeavePage viewMyLeave;



    @BeforeMethod
    public void setUpData()
    {
        setUpDatsasa();
        login.navigateToLoginPage();
        login.loginForm("Admin", "admin123");
        viewMyLeave.navigateToMyLeavePage();
    }

    @Test
    public void VerifyEnteringAnIncorrectDateFormat()
    {
        viewMyLeave.enterFromDate("2024-31-13");
        viewMyLeave.enterToDate("2024-31-13");
        viewMyLeave.removeTheSelectedStatus();

        Assert.assertEquals(viewMyLeave.ErrorMessage1Format().getText(),"Should be a valid date in yyyy-dd-mm format");
        Assert.assertEquals(viewMyLeave.ErrorMessage2Format().getText(),"Should be a valid date in yyyy-dd-mm format");
    }
    @Test
    public void verifyEnteringFromDateAfterToDate()
    {
        viewMyLeave.selectInvalidFromDate();
        viewMyLeave.selectInvalidToDate();
        Assert.assertEquals(viewMyLeave.dateRangeErrorMessage().getText(), "To date should be after from date");

    }
    @Test
    public void VerifyRequiredFieldsErrorMessage()
    {
        viewMyLeave.removeAllSelectedStatus();
        Assert.assertEquals(viewMyLeave.leaveStatusRequiredMessage().getText(),"Required");
    }
    @Test
    public void VerifyTheSelectedFromDate()
    {
        String expectedDate = viewMyLeave.getTheSelectedFromDate();
        System.out.println(expectedDate);
        Assert.assertEquals(expectedDate, "2024-01-01");
    }
    @Test
    public void SearchAboutLeave() throws InterruptedException {
        viewMyLeave.selectFromDate();
        Thread.sleep(2000);
        viewMyLeave.selectToDate();
        Thread.sleep(2000);
        viewMyLeave.removeAllSelectedStatus();
        viewMyLeave.selectLeaveStatus();
        viewMyLeave.selectLeaveType();
        viewMyLeave.clickOnSubmitBtn();
    }
    @Test
    public void VerifyClickingOnResetBtn() throws InterruptedException {
        viewMyLeave = new ViewMyLeavePage(driver);
        viewMyLeave.selectFromDate();
        viewMyLeave.selectToDate();
        viewMyLeave.selectLeaveStatus();
        viewMyLeave.selectLeaveType();
        viewMyLeave.clickOnResetBtn();

    }
    @Test
    public void displayAndHideForm()
    {
        viewMyLeave = new ViewMyLeavePage(driver);
        viewMyLeave.clickOnUpDownToggle();
        viewMyLeave.clickOnUpDownToggle();
    }
    @Test
    public void VerifySearchResults() throws InterruptedException {
        viewMyLeave = new ViewMyLeavePage(driver);
        viewMyLeave.selectFromDate();
        Thread.sleep(2000);
        viewMyLeave.selectToDate();
        Thread.sleep(2000);
        viewMyLeave.removeAllSelectedStatus();
        viewMyLeave.selectLeaveStatus();
        viewMyLeave.selectLeaveType();
        viewMyLeave.clickOnSubmitBtn();

        Assert.assertEquals(viewMyLeave.selectedLeaveStatus().getText(),"Pending Approval");
    }
    @Test
    public void verifyThatTheSelectedStatusDimmed() throws InterruptedException {
        viewMyLeave = new ViewMyLeavePage(driver);
        Thread.sleep(2000);
        viewMyLeave.removeAllSelectedStatus();
        viewMyLeave.selectLeaveStatus();
        viewMyLeave.elementIsNotClickable();
    }

    public void setUpDatsasa()
    {
        login = new LoginPage(driver);
        viewMyLeave = new ViewMyLeavePage(driver);
    }

}
