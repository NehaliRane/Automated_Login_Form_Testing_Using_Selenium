package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://id.heroku.com/login");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void validLogin() {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("tomsmith"); // Replace with actual valid email
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");       // Replace with actual valid password
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // You must update this with the selector/text that appears on a truly successful login (it may redirect)
        // Example: Assert URL changes, or profile page loads, etc.
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-danger"))));
        Assert.assertFalse(driver.findElements(By.cssSelector("div.alert.alert-danger")).size() > 0,
                "Valid login should not show error message.");
    }

    @Test
    public void invalidLogin() {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("wrong@email.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("wrongpassword");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-danger"))
        );
        Assert.assertTrue(message.getText().contains("There was a problem with your login."),
                "Expected error message for invalid credentials.");
    }

    @Test
    public void emptyFieldsValidation() {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-danger"))
        );
        Assert.assertTrue(message.getText().contains("There was a problem with your login."),
                "Expected error message for empty fields.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
