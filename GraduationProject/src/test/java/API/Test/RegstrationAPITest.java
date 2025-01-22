package API.Test;

import Pages.CSVLoader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class RegstrationAPITest {

    public static String generateFakeEmail() {
        // Get the current date and time
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());

        // Generate a random string of 6 characters (letters and digits)
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        // Combine random string and timestamp to create the email
        return randomString.toString() + "_" + timestamp + "@fakeemail.com";
    }

    //Test Case 1: Register User
    @Test(dataProvider = "signupData")
    public void Test_Regetration(String username,String password,String days,String months,String year,String fname,
                                String name,String address,String country,String state,String city,String zip)
    {
        String generatedEmail =generateFakeEmail();
        Response response = RestAssured.given()
                .param(username)
                .param(generatedEmail)
                .param(password)
                .param(days)
                .param(months)
                .param(year)
                .param(fname)
                .param(name)
                .param(address)
                .param(country)
                .param(state)
                .param(city)
                .param(zip)
                .when()
                .post(" https://automationexercise.com/api/createAccount");
//        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.statusCode() == 200 ||response.statusCode() == 201);
    }
    @DataProvider(name = "signupData")
    public Object[][] signupData() {
        // Load data from the CSV file
        CSVLoader loader=new CSVLoader();
        Object[][] data = loader.load_SignupData("signup_data.csv");
        // Load data from the CSV file

        return data;
    }
}
