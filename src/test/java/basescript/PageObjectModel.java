package basescript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectModel {
    WebDriver driver;

    // Constructor
    public PageObjectModel(WebDriver driver) {
        this.driver = driver;
    }

    // Web Elements for Signup
    By nameField = By.name("name");
    By emailField = By.id("semail");
    By phoneField = By.id("phone");
    By password1Field = By.id("password1");
    By password2Field = By.id("password2");
    By signupButton = By.xpath("//button[@class='btn btn-big btn-primary']");

    // Web Elements for Login
    By loginEmailField = By.id("email");
    By loginPasswordField = By.id("password");
    By loginButton = By.xpath("//button[@class='btn btn-big btn-primary']");

    // Signup Methods
    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void enterPassword(String password) {
        driver.findElement(password1Field).sendKeys(password);
        driver.findElement(password2Field).sendKeys(password);
    }

    public void clickSignup() {
        driver.findElement(signupButton).click();
    }

    // Login Methods
    public void enterLoginEmail(String email) {
        driver.findElement(loginEmailField).sendKeys(email);
    }

    public void enterLoginPassword(String password) {
        driver.findElement(loginPasswordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}

