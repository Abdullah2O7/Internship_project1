package Tests;

import Pages.AddAdmin;
import Pages.LoginPage;
import Pages.PageBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddAdminTest extends TestBase{
    LoginPage login;
    AddAdmin addAdmin;
    PageBase pageBase;
    String adminPageURL = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
    String userName = "Mokhaled";
    String password = "acd1234";
    @BeforeMethod
    public void setUpData()
    {
        setDrivers();
        pageBase.navigateToPage(adminPageURL);
        login.loginForm("Admin", "admin123");
    }
    @Test
    public void AddNewAdmin()
    {
        addAdmin.clickAddBtn();
        addAdmin.selectUserRole();
        addAdmin.selectStatus();
        addAdmin.selectEmployeeName("a");
        addAdmin.enterUsername(userName);
        addAdmin.enterPasswords(password);
        addAdmin.clickOnSaveBtn();

//        Assert.assertEquals(addAdmin.displayedUsername(), userName);
    }






    public void setDrivers()
    {
        pageBase = new PageBase(driver);
        login = new LoginPage(driver);
        addAdmin = new AddAdmin(driver);
    }
}
