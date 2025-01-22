package GUI.Test;

import Pages.*;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest {
    public WebDriver driver;
    public HomePage homePage;
    public Pages.LoginPage LoginPage;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();

        driver.get("https://www.automationexercise.com");

        driver.manage().window().maximize();
        // driver.get("https://www.automationexercise.com");

        homePage = new HomePage(driver);
        LoginPage = new LoginPage(driver);
    //    accountPage = new AccountPage(driver);
    //    reg2Page = new Reg2Page(driver);

    }
    @Test(dataProvider = "signinData")
    @Description("This test case verifies that a user can successfully login with valid credentials.")
public void Test_Sucess_Login_GUI(String email,String pass)
{
    homePage.clickReg();
    //fill in email and name in first regstration page
    LoginPage.fillLogindata(email,pass);
    //click on Register
    LoginPage.clickLogin();

    //assert on logged in lable


    Assert.assertNotNull(homePage.isAccountLoggedin(), "Element text is null!");


}
    //Test Case 3: Login User with incorrect email and password
    @Test(dataProvider = "signin_InvalidData")
    @Description("This test case verifies that a user cannt login with invalid credentials.")
    public void Test_Invalid_Login_GUI(String email,String pass)
    {
        homePage.clickReg();
        //fill in email and name in first regstration page
        LoginPage.fillLogindata(email,pass);
        //click on Register
        LoginPage.clickLogin();

        //assert on invalid login label


        Assert.assertTrue(LoginPage.FindinvalidLabel());


    }
    //Test Case 4: Logout User
    @Test(dataProvider = "signinData")
    @Description("This test case verifies that a user can successfully logout.")
    public void Test_logout(String email,String pass)
    {
        homePage.clickReg();
        LoginPage.fillLogindata(email,pass);
        //click on Login
        LoginPage.clickLogin();
        homePage.ClickLogout();
        String currenturl=driver.getCurrentUrl();
        Assert.assertEquals(currenturl,"https://www.automationexercise.com/login");


    }
    @DataProvider(name = "signin_InvalidData")
    public Object[][] signin_InvalidData() {
        // Load data from the CSV file
        CSVLoader loader=new CSVLoader();
        Object[][] data = loader.loadData("signIN_Invaild_data.csv");

        return data;
    }
    @DataProvider(name = "signinData")
    public Object[][] signinData() {
        CSVLoader loader=new CSVLoader();
        Object[][] data = loader.loadData("signIN_data.csv");
        // Load data from the CSV file

        return data;
    }
    @AfterMethod
    public void Teardown()
    {
        driver.quit();
    }
}
