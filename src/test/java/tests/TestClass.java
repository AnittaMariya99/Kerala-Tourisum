package tests;

import basescript.BaseClass;
import basescript.PageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestClass extends BaseClass {
    PageObjectModel pom;

    @BeforeClass
    public void setup() {
        setupBaseClass();  // Initialize WebDriver and related setup
        pom = new PageObjectModel(driver);  // Create an instance of the PageObjectModel
    }

    @Test(priority = 1)
    public void signUpTest() throws InterruptedException {
        driver.get("https://hashirakb.github.io/Kerala-Tourism-Website/signup.html");

        pom.enterName("AnittaMariyaVS");
        pom.enterEmail("anitta123@gmail.com");
        pom.enterPhone("8976547639");
        pom.enterPassword("Anitta@123");
        pom.clickSignup();
        System.out.println("Signup Successful!");

        waitForAlertAndAccept();  // Handle alert after signup
    }

    @Test(priority = 2)
    public void loginTest() throws InterruptedException {
        driver.get("https://hashirakb.github.io/Kerala-Tourism-Website/login.html");

        pom.enterLoginEmail("anitta123@gmail.com");
        pom.enterLoginPassword("Anitta@123");
        pom.clickLogin();
        System.out.println("Login Successful!");

        waitForAlertAndAccept();  // Handle alert after login
    }

    @Test(priority = 3)
    public void explorePagesTest() throws InterruptedException {
        // Navigate to Home page
        driver.get("https://hashirakb.github.io/Kerala-Tourism-Website/index.html");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@data-id='0']"))); // Wait for page elements to be available

        // Click on menu items
        driver.findElement(By.xpath("//li[@data-id='0']")).click();
        Thread.sleep(1000);
        waitForElementAndClick("//li[@data-id='1']");
        Thread.sleep(1000);
        waitForElementAndClick("//li[@data-id='2']");
        Thread.sleep(1000);
        System.out.println("Home Page successfully opened!");

        // Navigate to Explore page
        driver.get("https://hashirakb.github.io/Kerala-Tourism-Website/about.html");
        scrollPage(50);
        Thread.sleep(3000);

        // Scroll to a button and click it
        WebElement buttonElement = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        scrollPage(driver, buttonElement);
        Thread.sleep(1000);
        buttonElement.click();
        System.out.println("Explore page successful!");

        // Scroll down and wait
        scrollPage(1500);
        Thread.sleep(5000);
        System.out.println("Place to visit page successful!");
    }

    private void scrollPage(WebDriver driver, WebElement buttonElement) {
		// TODO Auto-generated method stub
		
	}

	@Test(priority = 4)
    public void viewPlaceDetailsTest() throws InterruptedException {
        driver.findElement(By.xpath("//img[@src='img/Ernakulam.jpg']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@href='ernakulam.html']")).click();
        Thread.sleep(3000);
        scrollPage(1500);
        Thread.sleep(3000);
        System.out.println("Place details view successful!");
    }

    @Test(priority = 5)
    public void reLoginTest() throws InterruptedException {
        driver.get("https://hashirakb.github.io/Kerala-Tourism-Website/signup.html");
        Thread.sleep(3000);
        scrollPage(1500);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@class=\"mb-85\"]")).click();
        Thread.sleep(3000);

        pom.enterLoginEmail("anitta3@gmail.com");
        pom.enterLoginPassword("Anitta@1234");
        pom.clickLogin();
        Thread.sleep(2000);

        System.out.println("Login again with existing credentials successful!");
    }

    @AfterClass
    public void tearDown() {
        teardown();  // Close the browser
        System.out.println("Test Completed Successfully!");
    }
}

    