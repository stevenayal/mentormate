package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtilities {
    private final WebDriverWait wait;

    public WaitUtilities(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void waitForElementToBeVisible(By elementLocator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public void waitForAlertToBePresent() {
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
