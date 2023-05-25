package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Page {
    public WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToPage(String pageUrl) {
        driver.get(pageUrl);
    }

    public String getText(WebElement field) {
        return field.getText();
    }

    public void fillField(WebElement input, String inputText) {
        input.sendKeys(inputText);
    }

    public void clickButton(WebElement button){
        button.click();
    }
}
