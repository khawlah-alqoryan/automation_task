package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SendDocumant {

    WebDriver driver;

    // Constructor
    public SendDocumant(WebDriver driver) {
        this.driver = driver;
    }

    // Return names of free documents
    public List<String> getFreeDocumentNames() {
        List<String> freeDocumentNames = new ArrayList<>();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("price-amount")));

        List<WebElement> priceElements = driver.findElements(By.className("price-amount"));

        for (WebElement priceElement : priceElements) {
            if ("Free".equalsIgnoreCase(priceElement.getText())) {
                try {
                    WebElement labelElement = priceElement.findElement(By.xpath("./../preceding-sibling::*[1]"));
                    freeDocumentNames.add(labelElement.getText().trim());
                } catch (NoSuchElementException e) {
                    // Optionally log this
                }
            }
        }

        return freeDocumentNames;
    }
}
