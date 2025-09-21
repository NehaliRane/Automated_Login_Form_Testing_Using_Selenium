package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By usernameBy = By.id("username");
    private final By passwordBy = By.id("password");
    private final By loginBtnBy = By.cssSelector("button[type='submit']");
    private final By flashBy = By.id("flash");
    private final By headingBy = By.cssSelector("div.example h2");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open(String url) {
        driver.get(url);
    }

    public void setUsername(String username) {
        driver.findElement(usernameBy).clear();
        driver.findElement(usernameBy).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordBy).clear();
        driver.findElement(passwordBy).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginBtnBy).click();
    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLogin();
    }

    public String getFlashMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(flashBy));
        return driver.findElement(flashBy).getText().trim();
    }

    public String getHeadingText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingBy));
        return driver.findElement(headingBy).getText().trim();
    }

    // get browser validation message for an input (HTML5 validation)
    public String getValidationMessage(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object msg = js.executeScript("return arguments[0].validationMessage;", element);
        return msg == null ? "" : msg.toString();
    }

    public WebElement getUsernameElement() { return driver.findElement(usernameBy); }
    public WebElement getPasswordElement() { return driver.findElement(passwordBy); }
}
