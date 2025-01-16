package basescript;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseClass {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Setup WebDriver
    public void setupBaseClass() {
        System.setProperty("webdriver.chrome.driver", "C://Tools//chromedriver-win64//chromedriver.exe");
    
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Close the browser
    public void teardown() {
        driver.quit();
    }

    // Method for scrolling the page by pixel
    public void scrollPage(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }

    // Wait for alert and accept
    public void waitForAlertAndAccept() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println("No alert appeared: " + e.getMessage());
        }
    }

    // Wait for an element and click it
    public void waitForElementAndClick(String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }
}

