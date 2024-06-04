package task18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Question1
{
        public static void main(String[] args)
        {
            // Set the path to your ChromeDriver executable
            System.setProperty("web driver.chrome.driver", "/path/to/chromedriver");

            // Initialize the Chrome driver
            WebDriver driver = new ChromeDriver();

            // Navigate to the Facebook website
            driver.get("https://www.facebook.com/");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Verify that the website has been redirected to the Facebook homepage
            if (driver.getTitle().contains("Facebook")) {
                System.out.println("Successfully navigated to Facebook homepage.");
            } else {
                System.out.println("Navigation to Facebook homepage failed.");
                driver.quit();
                return;
            }

            // Click on the "Create new account" button
            WebElement createAccountButton = driver.findElement(By.xpath("//a[@data-testId='open-registration-form-button']"));
            createAccountButton.click();

            // Wait for the sign-up form to appear
            try {
                Thread.sleep(2000);  // Adjust the sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Enter the first name and last name
            WebElement firstNameField = driver.findElement(By.name("firstname"));
            firstNameField.sendKeys("Test");

            WebElement lastNameField = driver.findElement(By.name("lastname"));
            lastNameField.sendKeys("User");

            // Enter the email address
            WebElement emailField = driver.findElement(By.name("reg_email__"));
            emailField.sendKeys("testuser@test.com");

            // Re-enter the email address
            WebElement reenterEmailField = driver.findElement(By.name("reg_email_confirmation__"));
            reenterEmailField.sendKeys("testuser@test.com");

            // Enter the password
            WebElement passwordField = driver.findElement(By.name("reg_passwd__"));
            passwordField.sendKeys("StrongPassword123!");

            // Select the date of birth
            Select dayDropdown = new Select(driver.findElement(By.id("day")));
            dayDropdown.selectByVisibleText("21");

            Select monthDropdown = new Select(driver.findElement(By.id("month")));
            monthDropdown.selectByVisibleText("Nov");

            Select yearDropdown = new Select(driver.findElement(By.id("year")));
            yearDropdown.selectByVisibleText("1996");

            // Select the gender
            WebElement genderRadioButton = driver.findElement(By.xpath("//input[@name='sex' and @value='1']"));
            genderRadioButton.click();

            // Click on the "Sign Up" button
            WebElement signUpButton = driver.findElement(By.name("web submit"));
            signUpButton.click();

            // Wait for the registration process to complete
            try {
                Thread.sleep(5000);  // Adjust the sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Verify that the user is successfully registered and redirected to the Facebook homepage
            if (driver.getTitle().contains("Facebook")) {
                System.out.println("User successfully registered and redirected to Facebook homepage.");
            } else {
                System.out.println("User registration failed.");
            }

            // Close the browser
            driver.quit();
        }
}
