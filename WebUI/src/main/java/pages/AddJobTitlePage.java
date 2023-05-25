package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddJobTitlePage extends Page{

    private WebElement jobTitleField;
    private WebElement jobDescriptionField;
    private WebElement notesField;
    private WebElement saveButton;

    public AddJobTitlePage(WebDriver driver) {
        super(driver);
        this.jobTitleField = driver.findElement(By.xpath("//div[2]/input[@class = 'oxd-input oxd-input--active' ]"));
        this.jobDescriptionField = driver.findElement(By.xpath("//textarea[@placeholder = 'Type description here']"));
        this.notesField = driver.findElement(By.xpath("//textarea[@placeholder = 'Add note']"));
        this.saveButton = driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
    }

    public void fillJobTitle(String jobTitle) {
        fillField(jobTitleField, jobTitle);
    }

    public void fillJobDescription(String jobDescription) {
        fillField(jobDescriptionField, jobDescription);
    }

    public void fillNotes(String notes) {
        fillField(notesField, notes);
    }

    public void saveJob(){
        clickButton(saveButton);
    }


}
