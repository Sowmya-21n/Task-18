package task18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Question2
{
        public static void main(String[] args) throws InterruptedException {
            // Set the path to your ChromeDriver executable
            System.setProperty("web driver.chrome.driver", "/path/to/chromedriver");

            // Initialize the Chrome driver
            WebDriver driver = new ChromeDriver();

            // Navigate to the jQueryUI droppable website
            driver.get("https://jqueryui.com/droppable/");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Switch to the frame containing the drag and drop elements
            driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

            // Find the source element with the text "Drag me to my target"
            WebElement sourceElement = driver.findElement(By.id("draggable"));

            // Find the target element with the text "Drop here"
            WebElement targetElement = driver.findElement(By.id("droppable"));

            // Perform the drag and drop operation
            Actions action = new Actions(driver);
            action.dragAndDrop(sourceElement, targetElement).perform();

            // Verify that the drag and drop operation is successful by checking the color property
            String targetElementColor = targetElement.getCssValue("background-color");
            System.out.println("Background color of target element: " + targetElementColor);

            // Verify that the text of the target element has changed to "Dropped!"
            String targetElementText = targetElement.getText();
            System.out.println("Text of target element: " + targetElementText);

            if ("Dropped!".equals(targetElementText)) {
                System.out.println("Drag and drop operation was successful.");
            } else {
                System.out.println("Drag and drop operation failed.");
            }
            Thread.sleep(2000);
            // Close the browser
            driver.quit();
        }
}
