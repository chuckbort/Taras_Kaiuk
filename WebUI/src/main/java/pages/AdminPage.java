package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class AdminPage extends Page {

    public AdminPage(WebDriver driver){
        super(driver);
    }

    public void selectJobTitle(String jobTitle){
        WebElement neededJob = driver.findElement(By.xpath("//div[text() = '"+ jobTitle + "']/parent::div/preceding-sibling::div/child::div/child::div/child::label"));
        clickButton(neededJob);
    }

    public void deleteSelectedTitle(){
        WebElement deleteButton = driver.findElement(By.xpath("//button[text() = ' Delete Selected ']"));
        Actions action = new Actions(driver);
        action.scrollToElement(deleteButton).perform();
        clickButton(deleteButton);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement confirmDeleteButton = driver.findElement(By.xpath("//button[text() = ' Yes, Delete ']"));
        clickButton(confirmDeleteButton);
    }

    public boolean isJobExist(String jobTitle){
        try {
            WebElement neededJob = driver.findElement(By.xpath("//div[text() = '"+ jobTitle + "']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
