package Tests;

import Pages.HomePage;
import Pages.SendDocumant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TaskTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.levelset.com/?_ga=2.209391826.1557175616.1753274187-349486010.1753274187");
    }

    @Test
    public void FirstTest1(){
        HomePage Home = new HomePage(driver);
        Home.ClickGetPaid();

        SendDocumant documentsPage = new SendDocumant(driver);
        List<String> freeDocs = documentsPage.getFreeDocumentNames();

        for (String name : freeDocs) {
            System.out.println(name);
        }
    }



@AfterMethod
    public void afterMethod() {

        driver.quit();

}


}
