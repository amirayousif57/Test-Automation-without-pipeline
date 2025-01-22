package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    //locate signupname field
   private By singupName =By.name( "name");
    //locate signupemail field
    By signupEmail=By.cssSelector("[data-qa='signup-email'");
    //locate signupbutton
    By signupBtn=By.cssSelector("[data-qa='signup-button']");

    //Login part GUI
    //locate Loginemail field
    private By loginEmail =By.name( "email");
    //locate Loginpass field
    By loginPass=By.name("password");
    //locate signupbutton
    By loginBtn=By.cssSelector("[data-qa='login-button']");
    By invalidLabel=By.xpath("//p[text()='Your email or password is incorrect!']");
    By invalidRegLabel=By.xpath("//p[text()='Email Address already exist!']");
    public void fillSignupData(String fname,String femail)
    {
        driver.findElement(singupName).sendKeys(fname);
        driver.findElement(signupEmail).sendKeys(femail);

    }
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickReg()
    {
        driver.findElement(signupBtn).click();

    }
    public void fillLogindata(String fname,String femail)
    {
        driver.findElement(loginEmail).sendKeys(fname);
        driver.findElement(loginPass).sendKeys(femail);

    }
    public void clickLogin()
    {
        driver.findElement(loginBtn).click();

    }
    public boolean FindinvalidLabel() {
        WebElement invalidlabel=driver.findElement(invalidLabel);
        return invalidlabel.isDisplayed();
    }

    public boolean FindinvalidregLabel() {
        WebElement invalidreglabel=driver.findElement(invalidRegLabel);
        return invalidreglabel.isDisplayed();
    }
}
