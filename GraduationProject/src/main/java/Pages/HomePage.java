package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
  private  By regLink =By.linkText("Signup / Login");
  By userName = By.partialLinkText("Logged in as");
  By logoutLink=By.partialLinkText("Logout");
  private WebDriver driver;
  public void  ClickLogout(){driver.findElement(logoutLink).click();}

  public void  clickReg()
  {
      driver.findElement(regLink).click();
  }
  public String isAccountLoggedin() {
    WebElement usernamelabel=driver.findElement(userName);
    return usernamelabel.getText();
  }

  public HomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);

  }

}
