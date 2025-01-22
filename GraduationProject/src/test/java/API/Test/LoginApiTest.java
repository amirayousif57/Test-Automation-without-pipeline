package API.Test;
import Pages.CSVLoader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.*;

import java.util.List;

public class LoginApiTest {
    @BeforeMethod
    public void setUp() {
        // Set up Rest Assured base URI or any pre-test configuration
        RestAssured.baseURI = "https://automationexercise.com/api";
        // Any other common setup like authentication or headers
    }
    // Test Case 2: Login User with correct email and password

    @Description("This test case verifies that a user can successfully login with valid credentials.")
    @Test(dataProvider = "signinData")
    public void Test_Success_Login_Api(String email,String password) {
        Response response = RestAssured.given()
                .param(email)
                .param(password)
                .when()
                .post("/verifyLogin");
        Assert.assertEquals(response.statusCode(), 200);
        //System.out.println(response.then().statusCode(200));
    }

    //Test Case 3: Login User with incorrect email and password

    @Test(dataProvider = "signin_InvalidData")
    @Description("This test case verifies that a user cannot  login with invalid credentials.")
    public void Test_Invaid_Login_Api(String email,String pass) {
        Response response = RestAssured.given()
                .param("email", email)
                .param("password", pass)
                .when()
                .post("/verifyLogin");
         Assert.assertEquals(response.statusCode(),404);

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
}