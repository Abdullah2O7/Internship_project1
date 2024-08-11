package Tests;

import Pages.AddAdmin;
import Pages.LoginPage;
import Pages.PageBase;
import Pages.SearchAboutAdmin;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchAboutAdminTest extends TestBase{
    LoginPage login;
    PageBase pageBase;
    SearchAboutAdmin searchAboutAdmin;
    String searchPageURL ="https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
    String userName = "Mokhaled";

    @BeforeMethod
    public void setUpData()
    {
        setDrivers();
        pageBase.navigateToPage(searchPageURL);
        login.loginForm("Admin", "admin123");
    }
    @Test
    public void searchAboutExistingAdmin() throws InterruptedException {
        searchAboutAdmin.enterUsername(userName);
        searchAboutAdmin.selectUserRole();
        searchAboutAdmin.selectEmployeeName("manda Bahadur Shrestha");
        searchAboutAdmin.selectStatus();
        searchAboutAdmin.clickOnSearchBtn();
        Thread.sleep(2000);
        Assert.assertEquals(searchAboutAdmin.displayedUsername().getText(),userName);
    }


    public void setDrivers()
    {
        pageBase = new PageBase(driver);
        login = new LoginPage(driver);
        searchAboutAdmin = new SearchAboutAdmin(driver);
    }
}
