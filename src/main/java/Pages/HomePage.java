package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {

WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Locatores

    By GetPaidButton = By.xpath("//a[@class='btn btn-info btn-outline mob-dropdown-btn']");


     public void ClickGetPaid () {

         new WebDriverWait( driver, Duration.ofSeconds(30));

         driver.findElement(GetPaidButton).click();


     }
}
