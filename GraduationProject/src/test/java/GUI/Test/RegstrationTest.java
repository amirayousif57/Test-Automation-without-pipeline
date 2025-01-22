package GUI.Test;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.*;

import java.util.List;
import java.util.UUID;

public class RegstrationTest {
    public WebDriver driver;
    public HomePage homePage;
    public LoginPage LoginPage;
  //  public Reg2Page reg2Page;
   // public AccountPage accountPage;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();

        driver.get("https://www.automationexercise.com");

        driver.manage().window().maximize();
       // driver.get("https://www.automationexercise.com");

        homePage = new HomePage(driver);
        LoginPage = new LoginPage(driver);
       // accountPage = new AccountPage(driver);
        //reg2Page = new Reg2Page(driver);

    }



    //Test Case 5: Register User with existing email

    @Test
    @Description("This test case verifies that a user cannt register with existing email.")
    public void Test_Regstire_existing_email_GUI()
    {
        //open loginpage
        homePage.clickReg();
        //fill in email and name in first regstration page
        LoginPage.fillSignupData("amira","amirayousif@gmail.com");
        //click on Register
        LoginPage.clickReg();
        Assert.assertTrue(LoginPage.FindinvalidregLabel());
    }


    @AfterMethod
    public void Teardown()
    {
        driver.quit();
    }
}
